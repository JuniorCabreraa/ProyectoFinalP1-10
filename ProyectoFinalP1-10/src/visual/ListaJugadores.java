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
import javax.swing.border.EmptyBorder;
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
import javax.swing.border.BevelBorder;

public class ListaJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	//private static JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnEliminar;

	private String name;
	JComboBox cbxTipoDeJugador;

	Jugador jugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Liga.getInstance().loadData();
		
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
		setTitle("Listado de Jugadores");

		setBounds(100, 100, 650, 376);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de Jugadores:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 624, 293);
		contentPanel.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 604, 228);
		panel.add(scrollPane);

		table = new JTable();
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
		String[] columnNames = {"No Camiseta","Nombre", "Posicion", "Equipo","Tipo De Jugador"};
		tableModel.setColumnIdentifiers(columnNames);
		loadJugador(0);
		scrollPane.setViewportView(table);

		JLabel lblTipoDeJugador = new JLabel("Tipo de Jugador:");
		lblTipoDeJugador.setBounds(10, 29, 116, 14);
		panel.add(lblTipoDeJugador);

		cbxTipoDeJugador = new JComboBox();
		cbxTipoDeJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = cbxTipoDeJugador.getSelectedIndex();
				loadJugador(selection);
			}
		});
		cbxTipoDeJugador.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Bateador", "Lanzador"}));
		cbxTipoDeJugador.setBounds(127, 26, 157, 20);
		panel.add(cbxTipoDeJugador);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegistrarJugador mod = null;
					try {
						mod = new RegistrarJugador();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mod.setModal(true);
					mod.setLocationRelativeTo(null);
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
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Jugador aux = Liga.getInstance().buscarJugadorPorNombre(name);

						int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar al Jugador: " + aux.getNombre(), null, JOptionPane.YES_NO_OPTION);
						if (delete == JOptionPane.YES_OPTION)
						{

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
				JButton cancelButton = new JButton("Cancel");
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
				fila[3] = aux.getEquipo();
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
				fila[3] = aux.getEquipo();
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
				fila[3] = aux.getEquipo();
				fila[4] = "Lanzador";

				tableModel.addRow(fila);
				}
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
}


