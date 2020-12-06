package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Equipo;
import logical.Jugador;
import logical.Lesion;
import logical.Liga;

import javax.swing.JScrollPane;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class ListaLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private JButton btnModificar;
	private JButton btnEliminar;
	private String name;
	private JLabel lblMostrarPorEquipo;
	private JComboBox<String> cbxEquipo;
	private Equipo team = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaLesion dialog = new ListaLesion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaLesion() throws ParseException{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				llenarCBXEquipo();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaLesion.class.getResource("/Imagenes/med.png")));
		setResizable(false);
		setModal(true);
		setTitle("Listado de Lesiones");
		setBounds(100, 100, 640, 375);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 604, 265);
			contentPanel.add(panel);
			panel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 61, 584, 193);
			panel.add(scrollPane);

			table = new JTable();
			table.setForeground(new Color(0, 0, 0));
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			table.setBackground(Color.WHITE);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					if(table.getSelectedRow()!=-1){
						btnEliminar.setEnabled(true);
						btnModificar.setEnabled(true);
						int index = table.getSelectedRow();
						name = (String)table.getModel().getValueAt(index, 0);
					}
				}
			});
			tableModel = new DefaultTableModel();
			String[] columnNames = {"Jugador","Equipo", "Categoria", "Estado"};
			tableModel.setColumnIdentifiers(columnNames);
			loadLesion(0);
			scrollPane.setViewportView(table);
			{
				lblMostrarPorEquipo = new JLabel("Mostrar por Equipo:");
				lblMostrarPorEquipo.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMostrarPorEquipo.setBounds(10, 23, 123, 15);
				panel.add(lblMostrarPorEquipo);
			}
			{
				cbxEquipo = new JComboBox<String>();
				cbxEquipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cbxEquipo.getSelectedIndex() > 0) {
							int i = 1;
							team = Liga.getInstance().buscarEquipoPorNombre(cbxEquipo.getSelectedItem().toString());
							loadLesion(i);
							btnEliminar.setEnabled(false);
						} else {
							int i = 0;
							loadLesion(i);
							btnEliminar.setEnabled(false);
						}
					}
				});
				cbxEquipo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Todos>"}));
				cbxEquipo.setBackground(Color.WHITE);
				cbxEquipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
				cbxEquipo.setBounds(140, 18, 157, 24);
				panel.add(cbxEquipo);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegistrarLesion mod = null;
					try {
						mod = new RegistrarLesion();
						mod.setVisible(true);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btnModificar.setEnabled(false);
					btnEliminar.setEnabled(false);
				}
			});
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setIcon(new ImageIcon(ListaLesion.class.getResource("/Imagenes/change.png")));
				btnEliminar.setBackground(Color.WHITE);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, name, null, JOptionPane.ERROR_MESSAGE);
						Jugador aux = Liga.getInstance().buscarJugadorPorNombre(name);

						int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar la Lesion de: " + aux.getNombre(), null, JOptionPane.YES_NO_OPTION);
						if (delete == JOptionPane.YES_OPTION)
						{
							loadLesion(0);
							cbxEquipo.setSelectedIndex(0);
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
						}
					}
				});
				buttonPane.add(btnEliminar);
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setIcon(new ImageIcon(ListaLesion.class.getResource("/Imagenes/Salir.png")));
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
	public void llenarCBXEquipo() {
		for (Equipo tea : Liga.getInstance().getListaEquipos()) {
			cbxEquipo.addItem(tea.getNombre());
		}
	}

	public void loadLesion(int caso) {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		switch (caso) {
		case 0:
			for (Jugador player : Liga.getInstance().getListaJugadores()) {
				for (Lesion aux : player.getMisLesiones()) {
					fila[0] = aux.getJugador().getNombre();
					fila[1] = aux.getEquipo().getNombre();
					fila[2] = aux.getCategoria();
					if (aux.isActiva()) {
						fila[3] = "En curso";
					} else {
						fila[3] = "Completada";
					}
					tableModel.addRow(fila);
				}
			}
			break;
		case 1:
			for (Jugador player : team.getMisJugadores()) {
				for (Lesion aux : player.getMisLesiones()) {
					fila[0] = aux.getJugador().getNombre();
					fila[1] = aux.getEquipo().getNombre();
					fila[2] = aux.getCategoria();
					if (aux.isActiva()) {
						fila[3] = "En curso";
					} else {
						fila[3] = "Completada";
					}
					tableModel.addRow(fila);
				}
			}
			break;
		default:
			break;
		}

		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(200);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(111);

	}
}
