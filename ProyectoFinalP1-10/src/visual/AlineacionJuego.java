package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logical.Jugador;
import logical.Partido;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings("serial")
public class AlineacionJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableLocal;
	private JTable tableRosterLocal;
	private JButton btnAgregarLocal;
	private Partido game = null;
	private static Object[] filas;
	private static Object[] filasLocalRoster;
	private static DefaultTableModel modelLocal;
	private static DefaultTableModel modelLocalRoster;
	private static Object[] filas_2;
	private static Object[] filasVisitanteRoster;
	private static DefaultTableModel modelVisitante;
	private static DefaultTableModel modelVisitanteRoster;
	private Jugador playerLocal = null;
	private Jugador playerVisitante = null;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JButton btnAgregarVisitante;
	private JTable tableVisitante;
	private JTable tableVisitanteRoster;
	private JButton btnEliminarLocal;
	private JButton btnEliminarVisitante;
	private JLabel lblPartido;
	private JLabel lblNewLabel_1;
	private Component horizontalStrut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlineacionJuego dialog = new AlineacionJuego(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlineacionJuego(Partido juego) {
		game = juego;
		setModal(true);
		setResizable(false);
		setUndecorated(true);
		setBounds(100, 100, 791, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(204, 204, 204)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel_1 = new JPanel();
			panel_1.setOpaque(false);
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Equipo Visitante", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 300, 771, 207);
			contentPanel.add(panel_1);
			{
				scrollPane_1 = new JScrollPane();
				scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane_1.setBounds(10, 22, 340, 174);
				scrollPane_1.getViewport().setBackground(Color.white);
				panel_1.add(scrollPane_1);
				{
					modelVisitante = new DefaultTableModel();
					String[] headers = {"No Camiseta","Nombre", "Posicion"};;
					modelVisitante.setColumnIdentifiers(headers);
					tableVisitante = new JTable();
					tableVisitante.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int seleccion = tableVisitante.getSelectedRow();
							if (seleccion != -1) {
								btnAgregarVisitante.setEnabled(true);
								playerVisitante = game.getVisitante().buscarJugadorNoCamiseta((int) modelVisitante.getValueAt(seleccion, 0));
							}
						}
					});
					tableVisitante.setModel(modelVisitante);
					tableVisitante.getTableHeader().setBackground(Color.WHITE);
					tableVisitante.getTableHeader().setForeground(Color.BLACK);
					tableVisitante.setBackground(Color.WHITE);
					tableVisitante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane_1.setViewportView(tableVisitante);
				}
			}
			{
				scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(421, 22, 340, 174);
				scrollPane_2.getViewport().setBackground(Color.white);
				panel_1.add(scrollPane_2);
				{
					modelVisitanteRoster = new DefaultTableModel();
					String[] headers = {"No Camiseta","Nombre", "Posicion"};;
					modelVisitanteRoster.setColumnIdentifiers(headers);
					tableVisitanteRoster = new JTable();
					tableVisitanteRoster.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = tableVisitanteRoster.getSelectedRow();
							if (seleccion != -1) {
								btnEliminarVisitante.setEnabled(true);
								playerVisitante = game.getVisitante().buscarJugadorNoCamiseta((int) modelVisitanteRoster.getValueAt(seleccion, 0));
							}
						}
					});
					tableVisitanteRoster.setModel(modelVisitanteRoster);
					tableVisitanteRoster.getTableHeader().setBackground(Color.WHITE);
					tableVisitanteRoster.getTableHeader().setForeground(Color.BLACK);
					tableVisitanteRoster.setBackground(Color.WHITE);
					tableVisitanteRoster.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane_2.setViewportView(tableVisitanteRoster);
				}
			}
			{
				btnAgregarVisitante = new JButton("");
				btnAgregarVisitante.setBackground(Color.WHITE);
				btnAgregarVisitante.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean encontrado = false;
						for (Jugador x : game.getVisitante().getAlineacion()) {
							if (playerVisitante.equals(x)) {
								JOptionPane.showMessageDialog(null, "Jugador Pertenece a la Alineacion", null, JOptionPane.ERROR_MESSAGE);
								encontrado = true;
								break;
							}
						}
						if (!encontrado) {
							game.getVisitante().insertarJugadorAlineacion(playerVisitante);
							llenarVisitanteRoster();
						}
						if (game.getVisitante().getAlineacion().size() >= 9) {
							JOptionPane.showMessageDialog(null, "Alineación Visitante Completa", null, JOptionPane.INFORMATION_MESSAGE);
						}
						btnAgregarVisitante.setEnabled(false);
					}
				});
				btnAgregarVisitante.setIcon(new ImageIcon(AlineacionJuego.class.getResource("/Imagenes/IniciarSesion.png")));
				btnAgregarVisitante.setEnabled(false);
				btnAgregarVisitante.setBounds(360, 49, 51, 43);
				panel_1.add(btnAgregarVisitante);
			}
			{
				btnEliminarVisitante = new JButton("");
				btnEliminarVisitante.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						game.getVisitante().eliminarJugadorAlineacion(playerVisitante);
						btnEliminarVisitante.setEnabled(false);
						llenarVisitanteRoster();
					}
				});
				btnEliminarVisitante.setIcon(new ImageIcon(AlineacionJuego.class.getResource("/Imagenes/change.png")));
				btnEliminarVisitante.setEnabled(false);
				btnEliminarVisitante.setBackground(Color.WHITE);
				btnEliminarVisitante.setBounds(360, 126, 51, 43);
				panel_1.add(btnEliminarVisitante);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Equipo Local", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 58, 771, 207);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(10, 22, 340, 174);
				scrollPane.getViewport().setBackground(Color.white);
				panel.add(scrollPane);
				{
					modelLocal = new DefaultTableModel();
					String[] headers = {"No Camiseta","Nombre", "Posicion"};;
					modelLocal.setColumnIdentifiers(headers);
					tableLocal = new JTable();
					tableLocal.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int seleccion = tableLocal.getSelectedRow();
							if (seleccion != -1) {
								btnAgregarLocal.setEnabled(true);
								playerLocal = game.getLocal().buscarJugadorNoCamiseta((int) modelLocal.getValueAt(seleccion, 0));
							}
						}
					});
					tableLocal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tableLocal.setModel(modelLocal);
					tableLocal.getTableHeader().setBackground(Color.WHITE);
					tableLocal.getTableHeader().setForeground(Color.BLACK);
					tableLocal.setBackground(Color.WHITE);
					scrollPane.setViewportView(tableLocal);
				}
			}
			{
				JScrollPane scrollPane_3 = new JScrollPane();
				scrollPane_3.setBounds(421, 22, 340, 174);
				scrollPane_3.getViewport().setBackground(Color.white);
				panel.add(scrollPane_3);
				{
					modelLocalRoster = new DefaultTableModel();
					String[] headers = {"No Camiseta","Nombre", "Posicion"};;
					modelLocalRoster.setColumnIdentifiers(headers);
					tableRosterLocal = new JTable();
					tableRosterLocal.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							int seleccion = tableRosterLocal.getSelectedRow();
							if (seleccion != -1) {
								btnEliminarLocal.setEnabled(true);
								playerLocal = game.getLocal().buscarJugadorNoCamiseta((int) modelLocalRoster.getValueAt(seleccion, 0));
							}
						}
					});
					tableRosterLocal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tableRosterLocal.setModel(modelLocalRoster);
					tableRosterLocal.getTableHeader().setBackground(Color.WHITE);
					tableRosterLocal.getTableHeader().setForeground(Color.BLACK);
					tableRosterLocal.setBackground(Color.WHITE);
					scrollPane_3.setViewportView(tableRosterLocal);
				}
			}
			{
				btnAgregarLocal = new JButton("");
				btnAgregarLocal.setBackground(Color.WHITE);
				btnAgregarLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean encontrado = false;
						for (Jugador x : game.getLocal().getAlineacion()) {
							if (playerLocal.equals(x)) {
								JOptionPane.showMessageDialog(null, "Jugador Pertenece a la Alineacion", null, JOptionPane.INFORMATION_MESSAGE);
								encontrado = true;
								break;
							}
						}
						if (!encontrado) {
							game.getLocal().insertarJugadorAlineacion(playerLocal);
							llenarLocalRoster();
						}
						if (game.getLocal().getAlineacion().size() >= 9) {
							JOptionPane.showMessageDialog(null, "Alineación Local Completa", null, JOptionPane.INFORMATION_MESSAGE);
						}
						btnAgregarLocal.setEnabled(false);
					}
				});
				btnAgregarLocal.setEnabled(false);
				btnAgregarLocal.setIcon(new ImageIcon(AlineacionJuego.class.getResource("/Imagenes/IniciarSesion.png")));
				btnAgregarLocal.setBounds(360, 49, 51, 43);
				panel.add(btnAgregarLocal);
			}
			{
				btnEliminarLocal = new JButton("");
				btnEliminarLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						game.getLocal().eliminarJugadorAlineacion(playerLocal);
						btnEliminarLocal.setEnabled(false);
						llenarLocalRoster();
					}
				});
				btnEliminarLocal.setIcon(new ImageIcon(AlineacionJuego.class.getResource("/Imagenes/change.png")));
				btnEliminarLocal.setEnabled(false);
				btnEliminarLocal.setBackground(Color.WHITE);
				btnEliminarLocal.setBounds(360, 125, 51, 43);
				panel.add(btnEliminarLocal);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 791, 47);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblAlineacionesDelPartido = new JLabel("ALINEACIONES DEL PARTIDO");
				lblAlineacionesDelPartido.setForeground(Color.BLACK);
				lblAlineacionesDelPartido.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblAlineacionesDelPartido.setBounds(42, 13, 242, 20);
				panel.add(lblAlineacionesDelPartido);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(AlineacionJuego.class.getResource("/Imagenes/team.png")));
				lblNewLabel.setBounds(12, 10, 25, 25);
				panel.add(lblNewLabel);
			}
			{
				lblPartido = new JLabel("");
				lblPartido.setForeground(Color.BLACK);
				lblPartido.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblPartido.setBounds(318, 13, 388, 20);
				panel.add(lblPartido);
			}
			{
				lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				lblNewLabel_1.setIcon(new ImageIcon(AlineacionJuego.class.getResource("/Imagenes/Salir.png")));
				lblNewLabel_1.setBounds(755, 11, 25, 25);
				panel.add(lblNewLabel_1);
			}
		}
		{
			JLabel lblFondo = new JLabel("");
			lblFondo.setIcon(new ImageIcon(AlineacionJuego.class.getResource("/Imagenes/hittedInTheHead.gif")));
			lblFondo.setBounds(-5, 34, 800, 600);
			contentPanel.add(lblFondo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("A JUGAR!");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (game.getLocal().getAlineacion().size() == 9 && game.getVisitante().getAlineacion().size() == 9) {
							if (game.getAlineacionLocal().isEmpty() && game.getAlineacionVisitante().isEmpty()) {
								game.getAlineacionLocal().addAll(game.getLocal().getAlineacion());
								game.getAlineacionVisitante().addAll(game.getVisitante().getAlineacion());
							}
							dispose();
							SimuladorPartido simuPart = new SimuladorPartido(game);
							simuPart.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Debe completar las Alineaciones", null, JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				okButton.setBackground(Color.WHITE);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				horizontalStrut = Box.createHorizontalStrut(338);
				buttonPane.add(horizontalStrut);
			}
		}
		llenarLocal();
		llenarLocalRoster();
		llenarVisitante();
		llenarVisitanteRoster();
		lblPartido.setText("No: "+game.getNoPartido()+" - "+game.getLocal().getNombre()+" vs "+game.getVisitante().getNombre());
	}
	
	private void llenarLocal() {
		modelLocal.setRowCount(0);
		filas = new Object[modelLocal.getColumnCount()];
		
		for (Jugador aux : game.getLocal().getMisJugadores()) {
			filas[0] = aux.getNoCamiseta();
			filas[1] = aux.getNombre();
			filas[2] = aux.getPosicion();
			
			modelLocal.addRow(filas);
		}
	}
	
	private void llenarLocalRoster() {
		modelLocalRoster.setRowCount(0);
		filasLocalRoster = new Object[modelLocalRoster.getColumnCount()];
		
		for (Jugador aux : game.getLocal().getAlineacion()) {
			filasLocalRoster[0] = aux.getNoCamiseta();
			filasLocalRoster[1] = aux.getNombre();
			filasLocalRoster[2] = aux.getPosicion();
			
			modelLocalRoster.addRow(filasLocalRoster);
		}
	}
	
	private void llenarVisitante() {
		modelVisitante.setRowCount(0);
		filas_2 = new Object[modelVisitante.getColumnCount()];
		
		for (Jugador aux : game.getVisitante().getMisJugadores()) {
			filas_2[0] = aux.getNoCamiseta();
			filas_2[1] = aux.getNombre();
			filas_2[2] = aux.getPosicion();
			
			modelVisitante.addRow(filas_2);
		}
	}
	
	private void llenarVisitanteRoster() {
		modelVisitanteRoster.setRowCount(0);
		filasVisitanteRoster = new Object[modelVisitanteRoster.getColumnCount()];
		
		for (Jugador aux : game.getVisitante().getAlineacion()) {
			filasVisitanteRoster[0] = aux.getNoCamiseta();
			filasVisitanteRoster[1] = aux.getNombre();
			filasVisitanteRoster[2] = aux.getPosicion();
			
			modelVisitanteRoster.addRow(filasVisitanteRoster);
		}
	}
}
