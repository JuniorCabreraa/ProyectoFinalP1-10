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

import logical.Bateador;
import logical.Jugador;
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
public class Lista10Bateadores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel tableModel;
	private ArrayList<Bateador> bateadores = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Lista10Bateadores dialog = new Lista10Bateadores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Lista10Bateadores() throws ParseException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista10Bateadores.class.getResource("/Imagenes/bateador.png")));
		setModal(true);
		setTitle("10 Mejores Bateadores");
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
		String[] columnNames = {"No","Nombre", "Posicion", "Equipo","AVG", "Hits", "TB"};
		tableModel.setColumnIdentifiers(columnNames);
		table.setModel(tableModel);
		table.setRowHeight(20);
		scrollPane.setViewportView(table);

		JLabel lblTipoDeJugador = new JLabel("10 MEJORES BATEADORES POR SU AVG");
		lblTipoDeJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDeJugador.setBounds(178, 11, 242, 15);
		panel.add(lblTipoDeJugador);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setIcon(new ImageIcon(Lista10Bateadores.class.getResource("/Imagenes/Salir.png")));
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
		bateadoresCargar();
		
		Collections.sort(bateadores, new Comparator<Bateador>() {
			@Override
			public int compare(Bateador o1, Bateador o2) {
				// TODO Auto-generated method stub
				return new Integer((int) (o2.promedioBateo()*1000)).compareTo(new Integer((int) (o1.promedioBateo()*1000)));
			}
		});
		
		loadJugador();
	}
	
	public void bateadoresCargar(){
		for (Jugador player : Liga.getInstance().getListaJugadores()) {
			if (player instanceof Bateador) {
				bateadores.add((Bateador) player);
			}
		}
	}

	public void loadJugador() {
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		int x = 0;
		
		for (Bateador aux : bateadores) {
			if (x<10) {
				BigDecimal avg = new BigDecimal(aux.promedioBateo()).setScale(3, RoundingMode.HALF_UP);
				fila[0] = aux.getNoCamiseta();
				fila[1] = aux.getNombre();
				fila[2] = aux.getPosicion();
				fila[3] = aux.getEquipo().getNombre();
				fila[4] = avg;
				fila[5] = aux.getHits();
				fila[6] = aux.getTurnosBate();
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
