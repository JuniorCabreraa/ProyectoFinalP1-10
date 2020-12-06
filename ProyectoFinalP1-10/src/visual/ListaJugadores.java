package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Bateador;
import logical.Equipo;
import logical.Jugador;
import logical.Lanzador;
import logical.Liga;


import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.ScrollPaneConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ListaJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private JButton btnModificar;
	private JButton btnEliminar;
	private String name;
	private JComboBox<String> cbxTipoDeJugador;
	private JComboBox<String> cbxEquipo;
	private static Equipo team = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaJugadores dialog = new ListaJugadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaJugadores() throws ParseException{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				llenarCBXEquipo();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaJugadores.class.getResource("/Imagenes/bateador.png")));
		setModal(true);
		setTitle("Listado de Jugadores");
		setBounds(100, 100, 660, 408);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new LineBorder(new Color(204, 204, 204)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 624, 293);
		contentPanel.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 54, 604, 228);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if(table.getSelectedRow()>=0){
					btnEliminar.setEnabled(true);
					btnModificar.setEnabled(true);
					int index = table.getSelectedRow();
					name = (String)table.getModel().getValueAt(index, 1);

				}
			}
		});
		tableModel = new DefaultTableModel();
		String[] columnNames = {"No Camiseta","Nombre", "Posicion", "Equipo", "Tipo De Jugador"};
		tableModel.setColumnIdentifiers(columnNames);
		loadJugador(0);
		scrollPane.setViewportView(table);

		JLabel lblTipoDeJugador = new JLabel("Tipo de Jugador:");
		lblTipoDeJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDeJugador.setBounds(10, 20, 116, 14);
		panel.add(lblTipoDeJugador);

		cbxTipoDeJugador = new JComboBox<String>();
		cbxTipoDeJugador.setBackground(new Color(255, 255, 255));
		cbxTipoDeJugador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbxTipoDeJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxTipoDeJugador.getSelectedIndex() == 0 || cbxTipoDeJugador.getSelectedIndex() == 1 || cbxTipoDeJugador.getSelectedIndex() == 2) {
					int selection = cbxTipoDeJugador.getSelectedIndex();
					loadJugador(selection);
					cbxEquipo.setEnabled(false);
				} else if (cbxTipoDeJugador.getSelectedIndex() == 3) {
					cbxEquipo.setEnabled(true);
					cbxEquipo.setSelectedIndex(0);
					loadJugador(0);
				} else {
					cbxEquipo.setEnabled(false);
				}
			}
		});
		cbxTipoDeJugador.setModel(new DefaultComboBoxModel<String>(new String[] {"<Todos>", "Bateador", "Lanzador", "Por Equipo"}));
		cbxTipoDeJugador.setBounds(127, 15, 157, 24);
		panel.add(cbxTipoDeJugador);
		
		JLabel label = new JLabel("Mostrar por Equipo:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(327, 20, 123, 15);
		panel.add(label);
		
		cbxEquipo = new JComboBox<String>();
		cbxEquipo.setEnabled(false);
		cbxEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxTipoDeJugador.getSelectedIndex() == 3 && cbxEquipo.getSelectedIndex() > 0) {
					int i = 3;
					team = Liga.getInstance().buscarEquipoPorNombre(cbxEquipo.getSelectedItem().toString());
					loadJugador(i);
				} else {
					int i = 0;
					loadJugador(i);
				}
			}
		});
		cbxEquipo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Todos>"}));
		cbxEquipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cbxEquipo.setBackground(Color.WHITE);
		cbxEquipo.setBounds(457, 15, 157, 24);
		panel.add(cbxEquipo);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnModificar = new JButton("Modificar");
			btnModificar.setIcon(new ImageIcon(ListaJugadores.class.getResource("/Imagenes/modify.png")));
			btnModificar.setBackground(Color.WHITE);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegistrarJugador mod = null;
					try {
						mod = new RegistrarJugador();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mod.setVisible(true);
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
				}
			});
			btnModificar.setActionCommand("OK");
			buttonPane.add(btnModificar);
			getRootPane().setDefaultButton(btnModificar);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBackground(Color.WHITE);
				btnEliminar.setIcon(new ImageIcon(ListaJugadores.class.getResource("/Imagenes/change.png")));
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Jugador aux = Liga.getInstance().buscarJugadorPorNombre(name);
						Equipo equip = null;

						int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar al Jugador: " + aux.getNombre(), null, JOptionPane.YES_NO_OPTION);
						if (delete == JOptionPane.YES_OPTION)
						{
							equip = aux.getEquipo();
							equip.eliminarJugador(aux);
							Liga.getInstance().eliminarJugador(aux);
							loadJugador(0);
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
						}
					}
				});
				buttonPane.add(btnEliminar);
				btnModificar.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setIcon(new ImageIcon(ListaJugadores.class.getResource("/Imagenes/Salir.png")));
				cancelButton.setBackground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}



	public static void loadJugador(int selection) {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		switch (selection) {
		case 0:
			for (Jugador aux : Liga.getInstance().getListaJugadores()) {
				fila[0] = aux.getNoCamiseta();
				fila[1] = aux.getNombre();
				fila[2] = aux.getPosicion();
				fila[3] = aux.getEquipo().getNombre();
				if(aux instanceof Bateador)
					fila[4] = "Bateador";
				if(aux instanceof Lanzador)
					fila[4] = "Lanzador";

				tableModel.addRow(fila);
			}
			break;
		case 1:
			for (Jugador aux : Liga.getInstance().getListaJugadores()) {
				if(aux instanceof Bateador){
				fila[0] = aux.getNoCamiseta();
				fila[1] = aux.getNombre();
				fila[2] = aux.getPosicion();
				fila[3] = aux.getEquipo().getNombre();
				fila[4] = "Bateador";

				tableModel.addRow(fila);
				}
			}
			break;
		case 2:
			for (Jugador aux : Liga.getInstance().getListaJugadores()) {
				if(aux instanceof Lanzador){
				fila[0] = aux.getNoCamiseta();
				fila[1] = aux.getNombre();
				fila[2] = aux.getPosicion();
				fila[3] = aux.getEquipo().getNombre();
				fila[4] = "Lanzador";

				tableModel.addRow(fila);
				}
			}
			break;
		case 3:
			for (Jugador aux : team.getMisJugadores()) {
				fila[0] = aux.getNoCamiseta();
				fila[1] = aux.getNombre();
				fila[2] = aux.getPosicion();
				fila[3] = aux.getEquipo().getNombre();
				if(aux instanceof Bateador)
					fila[4] = "Bateador";
				if(aux instanceof Lanzador)
					fila[4] = "Lanzador";

				tableModel.addRow(fila);
			}
			break;
		}


		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(130);
		columnModel.getColumn(4).setPreferredWidth(111);
		/*if(tableModel.getRowCount()==0){
			btnEliminar.setEnabled(false);
			btnModificar.setEnabled(false);
		}*/


	}
	
	public void llenarCBXEquipo() {
		for (Equipo tea : Liga.getInstance().getListaEquipos()) {
			cbxEquipo.addItem(tea.getNombre());
		}
	}
}


