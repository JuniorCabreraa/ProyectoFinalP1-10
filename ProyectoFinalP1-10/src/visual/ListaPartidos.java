package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
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
		setBounds(100, 100, 763, 368);
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
			panel.setBounds(10, 11, 721, 257);
			contentPanel.add(panel);
			panel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 11, 701, 235);
			panel.add(scrollPane);


			tableModel = new DefaultTableModel();
			String[] columnNames = {"No Partido","Fecha De Juego", "Equipo Local", "Equipo Visitante", "Ganador"};
			tableModel.setColumnIdentifiers(columnNames);
			table = new JTable();
			table.setBackground(Color.WHITE);
			table.setModel(tableModel);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			loadPartido();
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
		String df = "dd-MM-yyyy"; 
        SimpleDateFormat form = new SimpleDateFormat(df);

		for (Partido aux : Liga.getInstance().getListaPartidos()) {
			if (aux.isTerminado()) {
				fila[0] = aux.getNoPartido();
				fila[1] = form.format(aux.getFechaJuego())+" "+aux.getHoraJuego();
				fila[2] = aux.getLocal().getNombre();
				fila[3] = aux.getVisitante().getNombre();
				fila[4] = aux.ganador().getNombre();
				tableModel.addRow(fila);
			}
		}


		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(82);
		columnModel.getColumn(1).setPreferredWidth(182);
		columnModel.getColumn(2).setPreferredWidth(145);
		columnModel.getColumn(3).setPreferredWidth(145);
		columnModel.getColumn(4).setPreferredWidth(145);

	}
}
