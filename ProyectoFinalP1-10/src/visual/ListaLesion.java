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
import javax.swing.border.EmptyBorder;
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

public class ListaLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private JButton btnModificar;
	private JButton btnEliminar;
	private String name;

	Equipo equipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Liga.getInstance().loadData();
		
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
		setTitle("Listado de Lesiones");
		setBounds(100, 100, 640, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Listado de Lesiones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 604, 206);
			contentPanel.add(panel);
			panel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 22, 584, 173);
			panel.add(scrollPane);

			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					/*String country;
					int delivery;*/
					if(table.getSelectedRow()>=0){
						btnEliminar.setEnabled(true);
						btnModificar.setEnabled(true);
						int index = table.getSelectedRow();
						name = (String)table.getModel().getValueAt(index, 1);
					}
				}
			});
			tableModel = new DefaultTableModel();
			String[] columnNames = {"Jugador","Equipo", "Categoria", "Finaliza"};
			tableModel.setColumnIdentifiers(columnNames);
			loadLesion();
			scrollPane.setViewportView(table);
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
			btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegistrarLesion mod = null;
					try {
						mod = new RegistrarLesion();
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

						int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar la Lesion de: " + aux.getNombre(), null, JOptionPane.YES_NO_OPTION);
						if (delete == JOptionPane.YES_OPTION)
						{

							//Jugador.getMisLesiones(aux);
							
							loadLesion();
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
	public static void loadLesion() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];

		/*for (Lesion aux : Jugador.getMisLesiones()) {
			fila[0] = aux.getJugador();
			fila[1] = aux.getEquipo();
			fila[2] = aux.getCategoria();
			fila[3] = aux.getFinaliza;

			tableModel.addRow(fila);
		}*/


		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(200);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(111);
		//columnModel.getColumn(4).setPreferredWidth(101);

		/*if(tableModel.getRowCount()==0){
			btnEliminar.setEnabled(false);
			btnModificar.setEnabled(false);
		}*/


	}

}
