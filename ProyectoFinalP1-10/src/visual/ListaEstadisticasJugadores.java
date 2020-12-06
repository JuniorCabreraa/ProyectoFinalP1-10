package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Bateador;
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
import javax.swing.SwingConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SuppressWarnings("serial")
public class ListaEstadisticasJugadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private JComboBox<String> cbxTipoDeJugador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaEstadisticasJugadores dialog = new ListaEstadisticasJugadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaEstadisticasJugadores() throws ParseException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaEstadisticasJugadores.class.getResource("/Imagenes/team.png")));
		setModal(true);
		setTitle("Estad\u00EDsticas Jugadores");
		setBounds(100, 100, 1022, 408);
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
		panel.setBounds(10, 11, 985, 293);
		contentPanel.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 54, 965, 228);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(20);
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
				if (cbxTipoDeJugador.getSelectedIndex() != -1) {
					int selection = cbxTipoDeJugador.getSelectedIndex();
					loadJugador(selection);
				} 
			}
		});
		cbxTipoDeJugador.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Bateador", "Lanzador"}));
		cbxTipoDeJugador.setBounds(127, 15, 157, 24);
		panel.add(cbxTipoDeJugador);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setIcon(new ImageIcon(ListaEstadisticasJugadores.class.getResource("/Imagenes/Salir.png")));
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
		loadJugador(0);
	}

	public static void loadJugador(int selection) {
		tableModel = new DefaultTableModel();
		switch (selection) {
		case 0:
			String[] columnNames = {"No Camiseta","Nombre", "Posicion", "Equipo", "Tipo De Jugador"};
			tableModel.setColumnIdentifiers(columnNames);
			table.setModel(tableModel);
			tableModel.setRowCount(0);
			fila = new Object[tableModel.getColumnCount()];
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
			String[] columnNames1 = {"No","Nombre","Posicion","Equipo","C","H", "2B","3B","HR","CI","AVG","OBP","SLG","OPS", "FP", "RF"};
			tableModel.setColumnIdentifiers(columnNames1);
			table.setModel(tableModel);
			tableModel.setRowCount(0);
			fila = new Object[tableModel.getColumnCount()];
			for (Jugador aux : Liga.getInstance().getListaJugadores()) {
				if(aux instanceof Bateador){
					BigDecimal avg = null;
					BigDecimal obp = null;
					BigDecimal slg = null;
					BigDecimal ops = null;
					BigDecimal f = null;
					BigDecimal rf = null;
					try {
						avg = new BigDecimal(((Bateador) aux).promedioBateo()).setScale(3, RoundingMode.HALF_UP);
						obp = new BigDecimal(((Bateador) aux).porcentajeAlcanceBases()).setScale(3, RoundingMode.HALF_UP);
						slg = new BigDecimal(((Bateador) aux).slugging()).setScale(3, RoundingMode.HALF_UP);
						ops = new BigDecimal(((Bateador) aux).porcentajeAlcanceBasesPorSlugging()).setScale(3, RoundingMode.HALF_UP);
						f = new BigDecimal(((Bateador) aux).porcentajeFildeo()).setScale(3, RoundingMode.HALF_UP);
						rf = new BigDecimal(((Bateador) aux).factorAlcance()).setScale(2, RoundingMode.HALF_UP);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					fila[0] = aux.getNoCamiseta();
					fila[1] = aux.getNombre();
					fila[2] = aux.getPosicion();
					fila[3] = aux.getEquipo().getNombre();
					fila[4] = ((Bateador) aux).getCarreras();
					fila[5] = ((Bateador) aux).getHits();
					fila[6] = ((Bateador) aux).getDobles();
					fila[7] = ((Bateador) aux).getTriples();
					fila[8] = ((Bateador) aux).getHomeruns();
					fila[9] = ((Bateador) aux).getCarrerasImpulsadas();
					if (((Bateador) aux).getTurnosBate() > 0 && ((Bateador) aux).getHits() > 0) {
						fila[10] = avg;
					} else {
						fila[10] = "0.000";
					}
					if (((Bateador) aux).getHits() > 0) {
						fila[11] = obp;
					} else {
						fila[11] = "0.000";
					}
					if (((Bateador) aux).getTurnosBate() > 0 && ((Bateador) aux).getHits() > 0) {
						fila[12] = slg;
					} else {
						fila[12] = "0.000";
					}
					if (((Bateador) aux).getTurnosBate() > 0 && ((Bateador) aux).getHits() > 0) {
						fila[13] = ops;
					} else {
						fila[13] = "0.000";
					}
					if (((Bateador) aux).getOutsRealizados() > 0 || ((Bateador) aux).getAsistencias() > 0) {
						fila[14] = f;
					} else {
						fila[14] = "0.000";
					}
					if (((Bateador) aux).getOutsRealizados() > 0 || ((Bateador) aux).getAsistencias() > 0) {
						fila[15] = rf;
					} else {
						fila[15] = "0.00";
					}

					tableModel.addRow(fila);
					DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
					tcr.setHorizontalAlignment(SwingConstants.CENTER);
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
					table.getColumnModel().getColumn(15).setCellRenderer(tcr);
				}
			}
			break;
		case 2:
			String[] columnNames11 = {"No","Nombre", "Posicion", "Equipo", "A","CL", "CS","H","GP", "BB", "P", "PCL", "IL", "WHIP"};
			tableModel.setColumnIdentifiers(columnNames11);
			table.setModel(tableModel);
			tableModel.setRowCount(0);
			fila = new Object[tableModel.getColumnCount()];
			for (Jugador aux : Liga.getInstance().getListaJugadores()) {
				if(aux instanceof Lanzador){
					BigDecimal pcl = null;
					BigDecimal il = null;
					BigDecimal whip = null;
					try {
						pcl = new BigDecimal(((Lanzador) aux).porcentajeCarrerasLimpias()).setScale(2, RoundingMode.HALF_UP);
						il = new BigDecimal(((Lanzador) aux).entradasLanzadas()).setScale(1, RoundingMode.HALF_UP);
						whip = new BigDecimal(((Lanzador) aux).boletosYhits()).setScale(2, RoundingMode.HALF_UP);
					} catch (NumberFormatException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					fila[0] = aux.getNoCamiseta();
					fila[1] = aux.getNombre();
					fila[2] = aux.getPosicion();
					fila[3] = aux.getEquipo().getNombre();
					fila[4] = ((Lanzador) aux).getAperturas();
					fila[5] = ((Lanzador) aux).getCarrerasLimpiasPermitidas();
					fila[6] = ((Lanzador) aux).getCarrerasSuciasPermitidas();
					fila[7] = ((Lanzador) aux).getHitsPermitidos();
					fila[8] = ((Lanzador) aux).getBateadoresGolpeados();
					fila[9] = ((Lanzador) aux).getBoletosBase();
					fila[10] = ((Lanzador) aux).getPonches();
					if (((Lanzador) aux).getCarrerasLimpiasPermitidas() > 0 && ((Lanzador) aux).getOuts() > 0) {
						fila[11] = pcl;
						fila[12] = il;
					} else {
						fila[11] = "0.00";
						fila[12] = "0.0";
					}
					if ( ((Lanzador) aux).getOuts() > 0 &&  ((Lanzador) aux).getBoletosBase() > 0 &&  ((Lanzador) aux).getHitsPermitidos() > 0) {
						fila[13] = whip;
					} else {
						fila[13] = "0.00";
					}

					tableModel.addRow(fila);
					DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
					tcr.setHorizontalAlignment(SwingConstants.CENTER);
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
				}
			}
			break;
		}

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(45);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(170);
	}
}