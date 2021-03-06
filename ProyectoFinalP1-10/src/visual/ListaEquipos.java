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
import logical.Liga;


import javax.swing.JScrollPane;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.ScrollPaneConstants;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ListaEquipos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private JButton btnEliminar;
	private JButton btnModificar;
	private Equipo team = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaEquipos dialog = new ListaEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaEquipos() throws ParseException{
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				loadEquipo();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaEquipos.class.getResource("/Imagenes/team.png")));
		setResizable(false);
		setModal(true);
		setTitle("Listado de Equipos");
		setBounds(100, 100, 693, 371);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(new Color(204, 204, 204)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 657, 262);
			contentPanel.add(panel);
			panel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 11, 637, 240);
			panel.add(scrollPane);

			tableModel = new DefaultTableModel();
			String[] columnNames = {"Codigo","Nombre", "Estadio", "Manager"};
			tableModel.setColumnIdentifiers(columnNames);
			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					team = null;
					int seleccion = table.getSelectedRow();
					if (seleccion != -1) {
						btnEliminar.setEnabled(true);
						btnModificar.setEnabled(true);
						team = Liga.getInstance().buscarEquipoPorNombre((String) tableModel.getValueAt(seleccion, 1));
					}
				}
			});
			loadEquipo();
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setIcon(new ImageIcon(ListaEquipos.class.getResource("/Imagenes/change.png")));
				btnEliminar.setBackground(Color.WHITE);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar al Equipo: " + team.getNombre(), null, JOptionPane.YES_NO_OPTION);
						if (delete == JOptionPane.YES_OPTION){
							Liga.getInstance().eliminarEquipo(team);
							loadEquipo();
							btnEliminar.setEnabled(false);
							btnModificar.setEnabled(false);
						}
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				});
				{
					btnModificar = new JButton("Modificar");
					btnModificar.setBackground(Color.WHITE);
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Modificar al Equipo: " + team.getNombre(), null, JOptionPane.YES_NO_OPTION);
							if (delete == JOptionPane.YES_OPTION){
								ModificarEquipo modiTeam = new ModificarEquipo(team);
								modiTeam.setVisible(true);
								btnEliminar.setEnabled(false);
								btnModificar.setEnabled(false);
							}
							btnEliminar.setEnabled(false);
							btnModificar.setEnabled(false);
						}
					});
					btnModificar.setEnabled(false);
					btnModificar.setIcon(new ImageIcon(ListaEquipos.class.getResource("/Imagenes/modify.png")));
					buttonPane.add(btnModificar);
				}
				buttonPane.add(btnEliminar);
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setIcon(new ImageIcon(ListaEquipos.class.getResource("/Imagenes/Salir.png")));
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
	public static void loadEquipo() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];

		for (Equipo aux : Liga.getInstance().getListaEquipos()) {
			fila[0] = aux.getCodigo();
			fila[1] = aux.getNombre();
			fila[2] = aux.getEstadio();
			fila[3] = aux.getManager();

			tableModel.addRow(fila);
		}


		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(120);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(151);
		columnModel.getColumn(3).setPreferredWidth(163);
	}

}
