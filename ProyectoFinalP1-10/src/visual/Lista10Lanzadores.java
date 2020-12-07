package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Jugador;
import logical.Lanzador;
import logical.Liga;

import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Lista10Lanzadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private ArrayList<Lanzador> lanzadores = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Lista10Lanzadores dialog = new Lista10Lanzadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Lista10Lanzadores() throws ParseException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista10Lanzadores.class.getResource("/Imagenes/pitcher.png")));
		setModal(true);
		setTitle("10 Mejores Lanzadores");
		setBounds(100, 100, 660, 379);
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
		panel.setBounds(10, 11, 624, 274);
		contentPanel.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 37, 604, 223);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel = new DefaultTableModel();
		String[] columnNames = {"No","Nombre", "Posicion", "Equipo", "PCL", "IL", "CL"};
		tableModel.setColumnIdentifiers(columnNames);
		table.setModel(tableModel);
		table.setRowHeight(20);
		scrollPane.setViewportView(table);

		JLabel lblTipoDeJugador = new JLabel("10 MEJORES LANZADORES POR SU PCL");
		lblTipoDeJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDeJugador.setBounds(178, 11, 242, 15);
		panel.add(lblTipoDeJugador);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setIcon(new ImageIcon(Lista10Lanzadores.class.getResource("/Imagenes/Salir.png")));
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
		lanzadoresCargar();
		try {
			Collections.sort(lanzadores, new Comparator<Lanzador>() {
				@Override
				public int compare(Lanzador o1, Lanzador o2) {
					// TODO Auto-generated method stub
					return new Integer((int) (o1.porcentajeCarrerasLimpias()*100)).compareTo(new Integer((int) (o2.porcentajeCarrerasLimpias()*100)));
				}
			});
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		loadJugador();
	}
	
	public void lanzadoresCargar(){
		for (Jugador player : Liga.getInstance().getListaJugadores()) {
			if (player instanceof Lanzador) {
				lanzadores.add((Lanzador) player);
			}
		}
	}

	public void loadJugador() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		int x = 0;
		
		for (Lanzador aux : lanzadores) {
			if (x<10) {
				BigDecimal pcl = null;
				BigDecimal il = null;
				try {
					pcl = new BigDecimal(aux.porcentajeCarrerasLimpias()).setScale(2, RoundingMode.HALF_UP);
					il = new BigDecimal(aux.entradasLanzadas()).setScale(1, RoundingMode.HALF_UP);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				fila[0] = aux.getNoCamiseta();
				fila[1] = aux.getNombre();
				fila[2] = aux.getPosicion();
				fila[3] = aux.getEquipo().getNombre();
				if (aux.getCarrerasLimpiasPermitidas() > 0 && aux.getOuts() > 0) {
					fila[4] = pcl;
					fila[5] = il;
				} else {
					fila[4] = "0.00";
					fila[5] = "0.0";
				}
				fila[6] = aux.getCarrerasLimpiasPermitidas();

				tableModel.addRow(fila);
			}
			x++;
		}
	
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(120);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(4).setCellRenderer(tcr);
		table.getColumnModel().getColumn(5).setCellRenderer(tcr);
		table.getColumnModel().getColumn(6).setCellRenderer(tcr);
	}
}