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

import logical.Liga;
import logical.Partido;

import javax.swing.JScrollPane;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class ListaPartidos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private JButton btnModificar;
	private JButton btnEliminar;
	private int numero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaPartidos dialog = new ListaPartidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaPartidos() throws ParseException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaPartidos.class.getResource("/Imagenes/estadioteam.png")));
		setModal(true);
		setResizable(false);
		setTitle("Listado de Partidos");
		setBounds(100, 100, 640, 368);
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
			panel.setBounds(10, 11, 604, 257);
			contentPanel.add(panel);
			panel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 11, 584, 235);
			panel.add(scrollPane);

			table = new JTable();
			table.setBackground(Color.WHITE);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(table.getSelectedRow()>=0){
						btnEliminar.setEnabled(true);
						btnModificar.setEnabled(true);
						int index = table.getSelectedRow();
						numero = (int) table.getModel().getValueAt(index, 0);
					}
				}
			});
			tableModel = new DefaultTableModel();
			String[] columnNames = {"No Partido","Fecha De Juego", "Equipo Local", "Equipo Visitante"};
			tableModel.setColumnIdentifiers(columnNames);
			loadPartido();
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnModificar = new JButton("Modificar");
			btnModificar.setIcon(new ImageIcon(ListaPartidos.class.getResource("/Imagenes/modify.png")));
			btnModificar.setBackground(Color.WHITE);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegistrarPartido mod = null;
					try {
						mod = new RegistrarPartido();
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
				btnEliminar.setIcon(new ImageIcon(ListaPartidos.class.getResource("/Imagenes/change.png")));
				btnEliminar.setBackground(Color.WHITE);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						Partido aux = Liga.getInstance().buscarPartidoPorNumero(numero);

						int delete = JOptionPane.showConfirmDialog(null, "Realmente desea Eliminar el Partido: " + aux.getNoPartido(), null, JOptionPane.YES_NO_OPTION);
						if (delete == JOptionPane.YES_OPTION)
						{

							Liga.getInstance().eliminarPartido(aux);
							loadPartido();
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
				cancelButton.setIcon(new ImageIcon(ListaPartidos.class.getResource("/Imagenes/Salir.png")));
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
	public static void loadPartido() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];

		for (Partido aux : Liga.getInstance().getListaPartidos()) {
			fila[0] = aux.getNoPartido();
			fila[1] = aux.getFechaJuego();
			fila[2] = aux.getLocal().getNombre();
			fila[3] = aux.getVisitante().getNombre();
			tableModel.addRow(fila);
		}


		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(115);
		columnModel.getColumn(1).setPreferredWidth(140);
		columnModel.getColumn(2).setPreferredWidth(163);
		columnModel.getColumn(3).setPreferredWidth(163);


	}
}
