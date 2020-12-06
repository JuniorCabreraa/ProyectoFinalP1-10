package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
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
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ListaEstadisticasEquipos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaEstadisticasEquipos dialog = new ListaEstadisticasEquipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaEstadisticasEquipos() throws ParseException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaEstadisticasEquipos.class.getResource("/Imagenes/estadioteam.png")));
		setResizable(false);
		setModal(true);
		setTitle("Estad\u00EDsticas de Equipos");
		setBounds(100, 100, 900, 371);
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
			panel.setBounds(10, 11, 862, 262);
			contentPanel.add(panel);
			panel.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 11, 842, 240);
			panel.add(scrollPane);

			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableModel = new DefaultTableModel();
			String[] columnNames = {"Codigo","Nombre", "JJ","JG","JP", "TB" ,"C","H", "2B","3B","HR","CI","BB","P","AVG"};
			tableModel.setColumnIdentifiers(columnNames);
			table.setRowHeight(20);
			loadEquipo();
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setIcon(new ImageIcon(ListaEstadisticasEquipos.class.getResource("/Imagenes/Salir.png")));
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
			BigDecimal avg = null;
			try {
				avg = new BigDecimal(aux.promedioBateo()).setScale(3, RoundingMode.HALF_UP);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			fila[0] = aux.getCodigo();
			fila[1] = aux.getNombre();
			fila[2] = aux.getPartidosJugados();
			fila[3] = aux.getPartidosGanados();
			fila[4] = aux.getPartidosPerdidos();
			fila[5] = aux.getTurnosBate();
			fila[6] = aux.getCarreras();
			fila[7] = aux.getHits();
			fila[8] = aux.getDobles();
			fila[9] = aux.getTriples();
			fila[10] = aux.getHomeruns();
			fila[11] = aux.getCarrerasImpulsadas();
			fila[12] = aux.getBoletosBase();
			fila[13] = aux.getPonches();
			if (aux.getTurnosBate() > 0 && aux.getHits() > 0) {
				fila[14] = avg;
			} else {
				fila[14] = 0;
			}
			tableModel.addRow(fila);
		}


		table.setModel(tableModel);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setPreferredWidth(200);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table.getColumnModel().getColumn(4).setCellRenderer(tcr);
		table.getColumnModel().getColumn(5).setCellRenderer(tcr);
		table.getColumnModel().getColumn(6).setCellRenderer(tcr);
		table.getColumnModel().getColumn(7).setCellRenderer(tcr);
		table.getColumnModel().getColumn(8).setCellRenderer(tcr);
		table.getColumnModel().getColumn(9).setCellRenderer(tcr);
		table.getColumnModel().getColumn(10).setCellRenderer(tcr);
		table.getColumnModel().getColumn(11).setCellRenderer(tcr);
		table.getColumnModel().getColumn(12).setCellRenderer(tcr);
		table.getColumnModel().getColumn(13).setCellRenderer(tcr);
		table.getColumnModel().getColumn(14).setCellRenderer(tcr);
	}

}
