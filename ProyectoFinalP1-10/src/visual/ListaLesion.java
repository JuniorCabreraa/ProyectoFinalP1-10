package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowFocusListener;

@SuppressWarnings("serial")
public class ListaLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private JLabel lblMostrarPorEquipo;
	private JComboBox<String> cbxEquipo;
	private JButton btnEliminar;
	private Equipo team = null;
	private Jugador player = null;
	private String lesion = null;

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
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				loadLesion(0);
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
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
		setBounds(100, 100, 826, 375);
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
			panel.setBounds(10, 11, 784, 265);
			contentPanel.add(panel);
			panel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 61, 764, 193);
			panel.add(scrollPane);

			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					player = null;
					lesion = null;
					int seleccion = table.getSelectedRow();
					if (seleccion != -1) {
						btnEliminar.setEnabled(true);
						player = Liga.getInstance().buscarJugadorPorNombre((String) tableModel.getValueAt(seleccion, 0));
						lesion = (String) tableModel.getValueAt(seleccion, 4);
					}
				}
			});
			table.setForeground(new Color(0, 0, 0));
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			table.setBackground(Color.WHITE);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableModel = new DefaultTableModel();
			String[] columnNames = {"Jugador","Equipo", "Categoria", "Estado", "Diagnostico"};
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
						} else {
							int i = 0;
							loadLesion(i);
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
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setIcon(new ImageIcon(ListaLesion.class.getResource("/Imagenes/Salir.png")));
				cancelButton.setBackground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnEliminar = new JButton("Eliminar");
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int delete = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar la lesion de: " + player.getNombre(), null, JOptionPane.YES_NO_OPTION);
							if (delete == JOptionPane.YES_OPTION){
								player.eliminarLesion(lesion);
								btnEliminar.setEnabled(false);
								loadLesion(0);
							}
							btnEliminar.setEnabled(false);
						}
					});
					btnEliminar.setEnabled(false);
					btnEliminar.setBackground(Color.WHITE);
					btnEliminar.setIcon(new ImageIcon(ListaLesion.class.getResource("/Imagenes/change.png")));
					buttonPane.add(btnEliminar);
				}
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
					fila[4] = aux.getDiagnostico();
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
					fila[4] = aux.getDiagnostico();
					tableModel.addRow(fila);
				}
			}
			break;
		default:
			break;
		}

		table.setModel(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(4).setPreferredWidth(210);

	}
}
