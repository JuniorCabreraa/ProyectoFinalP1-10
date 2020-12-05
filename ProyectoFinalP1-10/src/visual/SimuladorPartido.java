package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import logical.Bateador;
import logical.Jugador;
import logical.Lanzador;
import logical.Liga;
import logical.Partido;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.text.ParseException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class SimuladorPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private static Object[] filas;
	private static DefaultTableModel model;
	private JPanel panelLocal;
	private JLabel lblNewLabel;
	private JFormattedTextField txtCarrerasVisi;
	private JComboBox<String> cbxBateadorVisitante;
	private JTextField txtCatcherLocal;
	private JTextField txtPitcherLocal;
	private JTextField txt1BLocal;
	private JTextField txt2BLocal;
	private JTextField txtSSLocal;
	private JTextField txt3BLocal;
	private JTextField txtLFLocal;
	private JTextField txtCFLocal;
	private JTextField txtRFLocal;
	private JButton btnA_LFLocal;
	private JButton btnE_LFLocal;
	private JButton btnO_LFLocal;
	private JButton btnA_CFLocal;
	private JButton btnE_CFLocal;
	private JButton btnO_CFLocal;
	private JButton btnA_RFLocal;
	private JButton btnE_RFLocal;
	private JButton btnO_RFLocal;
	private JButton btnA_1BLocal;
	private JButton btnE_1BLocal;
	private JButton btnO_1BLocal;
	private JButton btnA_2BLocal;
	private JButton btnE_2BLocal;
	private JButton btnO_2BLocal;
	private JButton btnA_SSLocal;
	private JButton btnE_SSLocal;
	private JButton btnO_SSLocal;
	private JButton btnA_3BLocal;
	private JButton btnE_3BLocal;
	private JButton btnO_3BLocal;
	private JButton btnA_CatcherLocal;
	private JButton btnE_CatcherLocal;
	private JButton btnO_CatcherLocal;
	private JButton btnH_BateadorVisitante;
	private JButton btn2B_BateadorVis;
	private JButton btnHR_BateadorVis;
	private JButton btn3B_BateadorVis;
	private JButton btnCI_BateadorVis;
	private JButton btnES_BateadorVis;
	private JButton btnPonche_PitcherLocal;
	private JButton btnBB_PitcherLocal;
	private JButton btnGP_PitcherLocal;
	private JButton btnCS_PitcherLocal;
	private JPanel panelCarrerasVisitante;
	private JComboBox<String> cbxCarreraVis;
	private JButton btnCarreraVis;
	private JButton btnCambioEntradaVis;
	private JPanel panelCarrerasLocal;
	private JComboBox<String> cbxCarrerasLocal;
	private JButton btnCarreraLocal;
	private JButton btnCambioEntradaLocal;
	private JPanel panelTerminarPartido;
	private JButton btnTerminarPartido;
	private JFormattedTextField txtCarrerasLocal;
	private JFormattedTextField txtHitsVisi;
	private JFormattedTextField txtHistLocal;
	private JFormattedTextField txtErrorVis;
	private JFormattedTextField txtErrorLocal;
	private JPanel panelVisitante;
	private JButton btnCS_PitcherVis;
	private JButton btnGP_PitcherVis;
	private JButton btnBB_PitcherVis;
	private JButton btnP_PitcherVis;
	private JButton btnES_BateadorLocal;
	private JButton btnCI_BateadorLocal;
	private JButton btn3B_BateadorLocal;
	private JButton btnHR_BateadorLocal;
	private JButton btn2B_BateadorLocal;
	private JButton btnH_BateadorLocal;
	private JButton btnA_CatcherVis;
	private JButton btnE_CatcherVis;
	private JButton btnO_CatcherVis;
	private JButton btnE_3BVis;
	private JButton btnA_3BVis;
	private JButton btnO_3BVis;
	private JButton btnA_SSVis;
	private JButton btnE_SSVis;
	private JButton btnO_SSVis;
	private JButton btnE_2BVis;
	private JButton btnO_2BVis;
	private JButton btnA_2bVis;
	private JButton btnA_1BVis;
	private JButton btnE_1BVis;
	private JButton btnO_1BVis;
	private JButton btnO_RFVis;
	private JButton btnE_RFVis;
	private JButton btnA_RFVis;
	private JButton btnE_CFVis;
	private JButton btnO_CFVis;
	private JButton btnA_CFVis;
	private JButton btnO_LFVis;
	private JButton btnE_LFVis;
	private JButton btnA_LFVis;
	private JTextField txtRF_Vis;
	private JTextField txtCFVis;
	private JTextField txtLFVis;
	private JTextField txt3BVis;
	private JTextField txtSSVis;
	private JTextField txt2BVis;
	private JTextField txt1BVis;
	private JTextField txtPitcherVis;
	private JTextField txtCatcherVis;
	private JComboBox<String> cbxBateadorLocal;
	private JLabel lblklk;
	private Partido gamePlay = null;
	private JLabel lblPartido;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblSalir;
	private JLabel lblNewLabel_2;
	private JLabel lblFondaso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SimuladorPartido dialog = new SimuladorPartido(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws ParseException 
	 */
	public SimuladorPartido(Partido juego){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				llenarPizarraVisitante();
				llenarVisitante();
				llenarPizarraLocal();
				llenarLocal();
				llenarBateadoresLocal();
				llenarBateadoresVisitante();
				lblPartido.setText(""+gamePlay.getLocal().getNombre()+" a la Defensiva vs "+gamePlay.getVisitante().getNombre()+" a la Ofensiva");
			}
		});
		gamePlay = juego;
		setUndecorated(true);
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 1163, 685);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(Color.BLACK));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panelVisitante = new JPanel();
			panelVisitante.setVisible(false);
			{
				lblPartido = new JLabel("");
				lblPartido.setForeground(Color.WHITE);
				lblPartido.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblPartido.setBounds(275, 161, 517, 23);
				contentPanel.add(lblPartido);
			}
			{
				panelLocal = new JPanel();
				panelLocal.setBackground(new Color(255, 255, 255));
				panelLocal.setBorder(new LineBorder(new Color(0, 0, 0)));
				panelLocal.setBounds(15, 191, 907, 477);
				contentPanel.add(panelLocal);
				panelLocal.setLayout(null);
				{
					btnCS_PitcherLocal = new JButton("CS");
					btnCS_PitcherLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Lanzador player2 = null;
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player2.setCarrerasSuciasPermitidas(player2.getCarrerasSuciasPermitidas()+1);
							player2.setCarrerasLimpiasPermitidas(player2.getCarrerasLimpiasPermitidas()-1);
						}
					});
					btnCS_PitcherLocal.setForeground(Color.WHITE);
					btnCS_PitcherLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
					btnCS_PitcherLocal.setBackground(Color.DARK_GRAY);
					btnCS_PitcherLocal.setBounds(482, 260, 48, 27);
					panelLocal.add(btnCS_PitcherLocal);
				}
				{
					btnGP_PitcherLocal = new JButton("GP");
					btnGP_PitcherLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player2.setBateadoresGolpeados(player2.getBateadoresGolpeados()+1);
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
							player.setGolpeado(player.getGolpeado()+1);
						}
					});
					btnGP_PitcherLocal.setForeground(Color.WHITE);
					btnGP_PitcherLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
					btnGP_PitcherLocal.setBackground(Color.DARK_GRAY);
					btnGP_PitcherLocal.setBounds(375, 260, 49, 27);
					panelLocal.add(btnGP_PitcherLocal);
				}
				{
					btnBB_PitcherLocal = new JButton("B");
					btnBB_PitcherLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player2.setBoletosBase(player2.getBoletosBase()+1);
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
							player.setBoletosBase(player.getBoletosBase()+1);
							gamePlay.getVisitante().setBoletosBase(gamePlay.getVisitante().getBoletosBase()+1);
						}
					});
					btnBB_PitcherLocal.setForeground(Color.WHITE);
					btnBB_PitcherLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnBB_PitcherLocal.setBackground(Color.DARK_GRAY);
					btnBB_PitcherLocal.setBounds(521, 302, 43, 27);
					panelLocal.add(btnBB_PitcherLocal);
				}
				{
					btnPonche_PitcherLocal = new JButton("P");
					btnPonche_PitcherLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player2.setOuts(player2.getOuts()+1);
							player2.setPonches(player2.getPonches()+1);
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
							player.setPonches(player.getPonches()+1);
							gamePlay.getVisitante().setPonches(gamePlay.getVisitante().getPonches()+1);
						}
					});
					btnPonche_PitcherLocal.setForeground(Color.WHITE);
					btnPonche_PitcherLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnPonche_PitcherLocal.setBackground(Color.DARK_GRAY);
					btnPonche_PitcherLocal.setBounds(335, 302, 43, 27);
					panelLocal.add(btnPonche_PitcherLocal);
				}
				{
					btnES_BateadorVis = new JButton("ES");
					btnES_BateadorVis.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							if (cbxBateadorVisitante.getSelectedIndex() > 0) {
								player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
								player.setElevadosSacrificios(player.getElevadosSacrificios()+1);
							}
						}
					});
					btnES_BateadorVis.setForeground(Color.WHITE);
					btnES_BateadorVis.setFont(new Font("Tahoma", Font.BOLD, 10));
					btnES_BateadorVis.setBackground(Color.DARK_GRAY);
					btnES_BateadorVis.setBounds(185, 430, 49, 27);
					panelLocal.add(btnES_BateadorVis);
				}
				{
					btnCI_BateadorVis = new JButton("CI");
					btnCI_BateadorVis.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							if (cbxBateadorVisitante.getSelectedIndex() > 0) {
								player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
								player.setCarrerasImpulsadas(player.getCarrerasImpulsadas()+1);
								gamePlay.getVisitante().setCarrerasImpulsadas(gamePlay.getVisitante().getCarrerasImpulsadas()+1);
							}
						}
					});
					btnCI_BateadorVis.setForeground(Color.WHITE);
					btnCI_BateadorVis.setFont(new Font("Tahoma", Font.BOLD, 10));
					btnCI_BateadorVis.setBackground(Color.DARK_GRAY);
					btnCI_BateadorVis.setBounds(131, 430, 49, 27);
					panelLocal.add(btnCI_BateadorVis);
				}
				{
					btn3B_BateadorVis = new JButton("3B");
					btn3B_BateadorVis.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							if (cbxBateadorVisitante.getSelectedIndex() > 0) {
								player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
								player.setTriples(player.getTriples()+1);
								gamePlay.getVisitante().setTriples(gamePlay.getVisitante().getTriples()+1);
								
								i = Integer.parseInt(txtHitsVisi.getText().trim());
								i = i + 1;
								txtHitsVisi.setText(""+i);
							}
						}
					});
					btn3B_BateadorVis.setForeground(Color.WHITE);
					btn3B_BateadorVis.setFont(new Font("Tahoma", Font.BOLD, 10));
					btn3B_BateadorVis.setBackground(Color.DARK_GRAY);
					btn3B_BateadorVis.setBounds(132, 395, 48, 27);
					panelLocal.add(btn3B_BateadorVis);
				}
				{
					btnHR_BateadorVis = new JButton("HR");
					btnHR_BateadorVis.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							int i = 0;
							int x = 0;
							if (cbxBateadorVisitante.getSelectedIndex() > 0) {
								player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
								player.setHomeruns(player.getHomeruns()+1);
								gamePlay.getVisitante().setHomeruns(gamePlay.getVisitante().getHomeruns()+1);
								player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
								player2.setHomerunsPermitidos(player2.getHomerunsPermitidos()+1);
								
								player.setCarreras(player.getCarreras()+1);
								gamePlay.getVisitante().setCarreras(gamePlay.getVisitante().getCarreras()+1);
								i = Integer.parseInt(txtCarrerasVisi.getText().trim());
								i = i+1;
								txtCarrerasVisi.setText(""+i);

								//player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
								player2.setCarrerasLimpiasPermitidas(player2.getCarrerasLimpiasPermitidas()+1);
								
								x = Integer.parseInt(txtHitsVisi.getText().trim());
								x = x + 1;
								txtHitsVisi.setText(""+x);
								gamePlay.carrerasPorEntrada(0, 1, gamePlay.getVisitante());
								llenarPizarraVisitante();
								llenarPizarraLocal();
							}
						}
					});
					btnHR_BateadorVis.setForeground(Color.WHITE);
					btnHR_BateadorVis.setFont(new Font("Tahoma", Font.BOLD, 10));
					btnHR_BateadorVis.setBackground(Color.DARK_GRAY);
					btnHR_BateadorVis.setBounds(80, 395, 49, 27);
					panelLocal.add(btnHR_BateadorVis);
				}
				{
					btn2B_BateadorVis = new JButton("2B");
					btn2B_BateadorVis.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							if (cbxBateadorVisitante.getSelectedIndex() > 0) {
								player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
								player.setDobles(player.getDobles()+1);
								gamePlay.getVisitante().setDobles(gamePlay.getVisitante().getDobles()+1);
								
								i = Integer.parseInt(txtHitsVisi.getText().trim());
								i = i + 1;
								txtHitsVisi.setText(""+i);
							}
						}
					});
					btn2B_BateadorVis.setForeground(Color.WHITE);
					btn2B_BateadorVis.setFont(new Font("Tahoma", Font.BOLD, 10));
					btn2B_BateadorVis.setBackground(Color.DARK_GRAY);
					btn2B_BateadorVis.setBounds(183, 395, 48, 27);
					panelLocal.add(btn2B_BateadorVis);
				}
				{
					btnH_BateadorVisitante = new JButton("H");
					btnH_BateadorVisitante.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							int i = 0;
							if (cbxBateadorVisitante.getSelectedIndex() > 0) {
								player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
								player.setHits(player.getHits()+1);
								gamePlay.getVisitante().setHits(gamePlay.getVisitante().getHits()+1);
								player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
								player2.setHitsPermitidos(player2.getHitsPermitidos()+1);
								
								i = Integer.parseInt(txtHitsVisi.getText().trim());
								i = i + 1;
								txtHitsVisi.setText(""+i);
							}
						}
					});
					btnH_BateadorVisitante.setForeground(Color.WHITE);
					btnH_BateadorVisitante.setFont(new Font("Tahoma", Font.BOLD, 10));
					btnH_BateadorVisitante.setBackground(Color.DARK_GRAY);
					btnH_BateadorVisitante.setBounds(233, 395, 43, 27);
					panelLocal.add(btnH_BateadorVisitante);
				}
				{
					btnA_CatcherLocal = new JButton("A");
					btnA_CatcherLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCatcherLocal.getText());
							player.setAsistencias(player.getAsistencias()+1);
						}
					});
					btnA_CatcherLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnA_CatcherLocal.setBackground(Color.GREEN);
					btnA_CatcherLocal.setBounds(619, 424, 43, 27);
					panelLocal.add(btnA_CatcherLocal);
				}
				{
					btnE_CatcherLocal = new JButton("E");
					btnE_CatcherLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCatcherLocal.getText());
							player.setErrores(player.getErrores()+1);
							i = Integer.parseInt(txtErrorLocal.getText().trim());
							i = i + 1;
							txtErrorLocal.setText(""+i);
						}
					});
					btnE_CatcherLocal.setForeground(Color.WHITE);
					btnE_CatcherLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnE_CatcherLocal.setBackground(Color.RED);
					btnE_CatcherLocal.setBounds(666, 424, 43, 27);
					panelLocal.add(btnE_CatcherLocal);
				}
				{
					btnO_CatcherLocal = new JButton("O");
					btnO_CatcherLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCatcherLocal.getText());
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player.setOutsRealizados(player.getOutsRealizados()+1);
							player2.setOuts(player2.getOuts()+1);
						}
					});
					btnO_CatcherLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnO_CatcherLocal.setBackground(Color.ORANGE);
					btnO_CatcherLocal.setBounds(712, 424, 43, 27);
					panelLocal.add(btnO_CatcherLocal);
				}
				{
					btnE_3BLocal = new JButton("E");
					btnE_3BLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt3BLocal.getText());
							player.setErrores(player.getErrores()+1);
							i = Integer.parseInt(txtErrorLocal.getText().trim());
							i = i + 1;
							txtErrorLocal.setText(""+i);
						}
					});
					btnE_3BLocal.setForeground(Color.WHITE);
					btnE_3BLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnE_3BLocal.setBackground(Color.RED);
					btnE_3BLocal.setBounds(140, 240, 43, 27);
					panelLocal.add(btnE_3BLocal);
				}
				{
					btnA_3BLocal = new JButton("A");
					btnA_3BLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt3BLocal.getText());
							player.setAsistencias(player.getAsistencias()+1);
						}
					});
					btnA_3BLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnA_3BLocal.setBackground(Color.GREEN);
					btnA_3BLocal.setBounds(93, 240, 43, 27);
					panelLocal.add(btnA_3BLocal);
				}
				{
					btnO_3BLocal = new JButton("O");
					btnO_3BLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt3BLocal.getText());
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player.setOutsRealizados(player.getOutsRealizados()+1);
							player2.setOuts(player2.getOuts()+1);
						}
					});
					btnO_3BLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnO_3BLocal.setBackground(Color.ORANGE);
					btnO_3BLocal.setBounds(186, 240, 43, 27);
					panelLocal.add(btnO_3BLocal);
				}
				{
					btnA_SSLocal = new JButton("A");
					btnA_SSLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtSSLocal.getText());
							player.setAsistencias(player.getAsistencias()+1);
						}
					});
					btnA_SSLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnA_SSLocal.setBackground(Color.GREEN);
					btnA_SSLocal.setBounds(173, 153, 43, 27);
					panelLocal.add(btnA_SSLocal);
				}
				{
					btnE_SSLocal = new JButton("E");
					btnE_SSLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtSSLocal.getText());
							player.setErrores(player.getErrores()+1);
							i = Integer.parseInt(txtErrorLocal.getText().trim());
							i = i + 1;
							txtErrorLocal.setText(""+i);
						}
					});
					btnE_SSLocal.setForeground(Color.WHITE);
					btnE_SSLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnE_SSLocal.setBackground(Color.RED);
					btnE_SSLocal.setBounds(220, 153, 43, 27);
					panelLocal.add(btnE_SSLocal);
				}
				{
					btnO_SSLocal = new JButton("O");
					btnO_SSLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtSSLocal.getText());
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player.setOutsRealizados(player.getOutsRealizados()+1);
							player2.setOuts(player2.getOuts()+1);
						}
					});
					btnO_SSLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnO_SSLocal.setBackground(Color.ORANGE);
					btnO_SSLocal.setBounds(266, 153, 43, 27);
					panelLocal.add(btnO_SSLocal);
				}
				{
					btnE_2BLocal = new JButton("E");
					btnE_2BLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt2BLocal.getText());
							player.setErrores(player.getErrores()+1);
							i = Integer.parseInt(txtErrorLocal.getText().trim());
							i = i + 1;
							txtErrorLocal.setText(""+i);
						}
					});
					btnE_2BLocal.setForeground(Color.WHITE);
					btnE_2BLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnE_2BLocal.setBackground(Color.RED);
					btnE_2BLocal.setBounds(475, 108, 43, 27);
					panelLocal.add(btnE_2BLocal);
				}
				{
					btnO_2BLocal = new JButton("O");
					btnO_2BLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt2BLocal.getText());
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player.setOutsRealizados(player.getOutsRealizados()+1);
							player2.setOuts(player2.getOuts()+1);
						}
					});
					btnO_2BLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnO_2BLocal.setBackground(Color.ORANGE);
					btnO_2BLocal.setBounds(521, 108, 43, 27);
					panelLocal.add(btnO_2BLocal);
				}
				{
					btnA_2BLocal = new JButton("A");
					btnA_2BLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt2BLocal.getText());
							player.setAsistencias(player.getAsistencias()+1);
						}
					});
					btnA_2BLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnA_2BLocal.setBackground(Color.GREEN);
					btnA_2BLocal.setBounds(428, 108, 43, 27);
					panelLocal.add(btnA_2BLocal);
				}
				{
					btnA_1BLocal = new JButton("A");
					btnA_1BLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt1BLocal.getText());
							player.setAsistencias(player.getAsistencias()+1);
						}
					});
					btnA_1BLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnA_1BLocal.setBackground(Color.GREEN);
					btnA_1BLocal.setBounds(665, 229, 43, 27);
					panelLocal.add(btnA_1BLocal);
				}
				{
					btnE_1BLocal = new JButton("E");
					btnE_1BLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt1BLocal.getText());
							player.setErrores(player.getErrores()+1);
							i = Integer.parseInt(txtErrorLocal.getText().trim());
							i = i + 1;
							txtErrorLocal.setText(""+i);
						}
					});
					btnE_1BLocal.setForeground(Color.WHITE);
					btnE_1BLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnE_1BLocal.setBackground(Color.RED);
					btnE_1BLocal.setBounds(712, 229, 43, 27);
					panelLocal.add(btnE_1BLocal);
				}
				{
					btnO_1BLocal = new JButton("O");
					btnO_1BLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt1BLocal.getText());
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player.setOutsRealizados(player.getOutsRealizados()+1);
							player2.setOuts(player2.getOuts()+1);
						}
					});
					btnO_1BLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnO_1BLocal.setBackground(Color.ORANGE);
					btnO_1BLocal.setBounds(758, 229, 43, 27);
					panelLocal.add(btnO_1BLocal);
				}
				{
					btnO_RFLocal = new JButton("O");
					btnO_RFLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtRFLocal.getText());
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player.setOutsRealizados(player.getOutsRealizados()+1);
							player2.setOuts(player2.getOuts()+1);
						}
					});
					btnO_RFLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnO_RFLocal.setBackground(Color.ORANGE);
					btnO_RFLocal.setBounds(824, 57, 43, 27);
					panelLocal.add(btnO_RFLocal);
				}
				{
					btnE_RFLocal = new JButton("E");
					btnE_RFLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtRFLocal.getText());
							player.setErrores(player.getErrores()+1);
							i = Integer.parseInt(txtErrorLocal.getText().trim());
							i = i + 1;
							txtErrorLocal.setText(""+i);
						}
					});
					btnE_RFLocal.setForeground(Color.WHITE);
					btnE_RFLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnE_RFLocal.setBackground(Color.RED);
					btnE_RFLocal.setBounds(778, 57, 43, 27);
					panelLocal.add(btnE_RFLocal);
				}
				{
					btnA_RFLocal = new JButton("A");
					btnA_RFLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtRFLocal.getText());
							player.setAsistencias(player.getAsistencias()+1);
						}
					});
					btnA_RFLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnA_RFLocal.setBackground(Color.GREEN);
					btnA_RFLocal.setBounds(731, 57, 43, 27);
					panelLocal.add(btnA_RFLocal);
				}
				{
					btnE_CFLocal = new JButton("E");
					btnE_CFLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCFLocal.getText());
							player.setErrores(player.getErrores()+1);
							i = Integer.parseInt(txtErrorLocal.getText().trim());
							i = i + 1;
							txtErrorLocal.setText(""+i);
						}
					});
					btnE_CFLocal.setForeground(Color.WHITE);
					btnE_CFLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnE_CFLocal.setBackground(Color.RED);
					btnE_CFLocal.setBounds(360, 11, 43, 27);
					panelLocal.add(btnE_CFLocal);
				}
				{
					btnO_CFLocal = new JButton("O");
					btnO_CFLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCFLocal.getText());
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player.setOutsRealizados(player.getOutsRealizados()+1);
							player2.setOuts(player2.getOuts()+1);
						}
					});
					btnO_CFLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnO_CFLocal.setBackground(Color.ORANGE);
					btnO_CFLocal.setBounds(406, 11, 43, 27);
					panelLocal.add(btnO_CFLocal);
				}
				{
					btnA_CFLocal = new JButton("A");
					btnA_CFLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCFLocal.getText());
							player.setAsistencias(player.getAsistencias()+1);
						}
					});
					btnA_CFLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnA_CFLocal.setBackground(Color.GREEN);
					btnA_CFLocal.setBounds(313, 11, 43, 27);
					panelLocal.add(btnA_CFLocal);
				}
				{
					btnO_LFLocal = new JButton("O");
					btnO_LFLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							Lanzador player2 = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtLFLocal.getText());
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player.setOutsRealizados(player.getOutsRealizados()+1);
							player2.setOuts(player2.getOuts()+1);
						}
					});
					btnO_LFLocal.setBackground(Color.ORANGE);
					btnO_LFLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnO_LFLocal.setBounds(126, 57, 43, 27);
					panelLocal.add(btnO_LFLocal);
				}
				{
					btnE_LFLocal = new JButton("E");
					btnE_LFLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							int i = 0;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtLFLocal.getText());
							player.setErrores(player.getErrores()+1);
							i = Integer.parseInt(txtErrorLocal.getText().trim());
							i = i+1;
							txtErrorLocal.setText(""+i);
							
						}
					});
					btnE_LFLocal.setForeground(Color.WHITE);
					btnE_LFLocal.setBackground(Color.RED);
					btnE_LFLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnE_LFLocal.setBounds(80, 57, 43, 27);
					panelLocal.add(btnE_LFLocal);
				}
				{
					btnA_LFLocal = new JButton("A");
					btnA_LFLocal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Bateador player = null;
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtLFLocal.getText());
							player.setAsistencias(player.getAsistencias()+1);
						}
					});
					btnA_LFLocal.setBackground(Color.GREEN);
					btnA_LFLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnA_LFLocal.setBounds(34, 57, 43, 27);
					panelLocal.add(btnA_LFLocal);
				}
				{
					txtRFLocal = new JTextField();
					txtRFLocal.setBackground(Color.WHITE);
					txtRFLocal.setEditable(false);
					txtRFLocal.setBounds(740, 95, 127, 20);
					panelLocal.add(txtRFLocal);
					txtRFLocal.setColumns(10);
				}
				{
					txtCFLocal = new JTextField();
					txtCFLocal.setBackground(Color.WHITE);
					txtCFLocal.setEditable(false);
					txtCFLocal.setBounds(313, 49, 136, 20);
					panelLocal.add(txtCFLocal);
					txtCFLocal.setColumns(10);
				}
				{
					txtLFLocal = new JTextField();
					txtLFLocal.setBackground(Color.WHITE);
					txtLFLocal.setEditable(false);
					txtLFLocal.setBounds(34, 95, 127, 20);
					panelLocal.add(txtLFLocal);
					txtLFLocal.setColumns(10);
				}
				{
					txt3BLocal = new JTextField();
					txt3BLocal.setBackground(Color.WHITE);
					txt3BLocal.setEditable(false);
					txt3BLocal.setBounds(93, 280, 137, 20);
					panelLocal.add(txt3BLocal);
					txt3BLocal.setColumns(10);
				}
				{
					txtSSLocal = new JTextField();
					txtSSLocal.setBackground(Color.WHITE);
					txtSSLocal.setEditable(false);
					txtSSLocal.setBounds(172, 191, 137, 20);
					panelLocal.add(txtSSLocal);
					txtSSLocal.setColumns(10);
				}
				{
					txt2BLocal = new JTextField();
					txt2BLocal.setBackground(Color.WHITE);
					txt2BLocal.setEditable(false);
					txt2BLocal.setBounds(428, 146, 127, 20);
					panelLocal.add(txt2BLocal);
					txt2BLocal.setColumns(10);
				}
				{
					txt1BLocal = new JTextField();
					txt1BLocal.setBackground(Color.WHITE);
					txt1BLocal.setEditable(false);
					txt1BLocal.setBounds(665, 267, 136, 20);
					panelLocal.add(txt1BLocal);
					txt1BLocal.setColumns(10);
				}
				{
					txtPitcherLocal = new JTextField();
					txtPitcherLocal.setBackground(Color.WHITE);
					txtPitcherLocal.setEditable(false);
					txtPitcherLocal.setBounds(382, 306, 135, 20);
					panelLocal.add(txtPitcherLocal);
					txtPitcherLocal.setColumns(10);
				}
				{
					txtCatcherLocal = new JTextField();
					txtCatcherLocal.setBackground(Color.WHITE);
					txtCatcherLocal.setEditable(false);
					txtCatcherLocal.setBounds(482, 431, 127, 20);
					panelLocal.add(txtCatcherLocal);
					txtCatcherLocal.setColumns(10);
				}
				{
					cbxBateadorVisitante = new JComboBox<String>();
					cbxBateadorVisitante.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Bateador player = null;
							if (cbxBateadorVisitante.getSelectedIndex() > 0) {
								player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorVisitante.getSelectedItem().toString());
								player.setTurnosBate(player.getTurnosBate()+1);
								gamePlay.getVisitante().setTurnosBate(gamePlay.getVisitante().getTurnosBate()+1);
							}
						}
					});
					cbxBateadorVisitante.setForeground(Color.WHITE);
					cbxBateadorVisitante.setBackground(Color.DARK_GRAY);
					cbxBateadorVisitante.setModel(new DefaultComboBoxModel<String>(new String[] {"<Batea>", "1", "2", "3", "4"}));
					cbxBateadorVisitante.setBounds(286, 398, 138, 23);
					panelLocal.add(cbxBateadorVisitante);
				}
				{
					lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon(SimuladorPartido.class.getResource("/Imagenes/field.jpg")));
					lblNewLabel.setBounds(1, 1, 905, 475);
					panelLocal.add(lblNewLabel);
				}
			}
			panelVisitante.setLayout(null);
			panelVisitante.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelVisitante.setBackground(Color.WHITE);
			panelVisitante.setBounds(15, 191, 907, 477);
			contentPanel.add(panelVisitante);
			{
				btnCS_PitcherVis = new JButton("CS");
				btnCS_PitcherVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Lanzador player2 = null;
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player2.setCarrerasSuciasPermitidas(player2.getCarrerasSuciasPermitidas()+1);
						player2.setCarrerasLimpiasPermitidas(player2.getCarrerasLimpiasPermitidas()-1);
					}
				});
				btnCS_PitcherVis.setForeground(Color.WHITE);
				btnCS_PitcherVis.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnCS_PitcherVis.setBackground(Color.DARK_GRAY);
				btnCS_PitcherVis.setBounds(482, 260, 48, 27);
				panelVisitante.add(btnCS_PitcherVis);
			}
			{
				btnGP_PitcherVis = new JButton("GP");
				btnGP_PitcherVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player2.setBateadoresGolpeados(player2.getBateadoresGolpeados()+1);
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
						player.setGolpeado(player.getGolpeado()+1);
					}
				});
				btnGP_PitcherVis.setForeground(Color.WHITE);
				btnGP_PitcherVis.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnGP_PitcherVis.setBackground(Color.DARK_GRAY);
				btnGP_PitcherVis.setBounds(375, 260, 49, 27);
				panelVisitante.add(btnGP_PitcherVis);
			}
			{
				btnBB_PitcherVis = new JButton("B");
				btnBB_PitcherVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player2.setBoletosBase(player2.getBoletosBase()+1);
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
						player.setBoletosBase(player.getBoletosBase()+1);
						gamePlay.getLocal().setBoletosBase(gamePlay.getLocal().getBoletosBase()+1);
					}
				});
				btnBB_PitcherVis.setForeground(Color.WHITE);
				btnBB_PitcherVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnBB_PitcherVis.setBackground(Color.DARK_GRAY);
				btnBB_PitcherVis.setBounds(521, 302, 43, 27);
				panelVisitante.add(btnBB_PitcherVis);
			}
			{
				btnP_PitcherVis = new JButton("P");
				btnP_PitcherVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player2.setOuts(player2.getOuts()+1);
						player2.setPonches(player2.getPonches()+1);
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
						player.setPonches(player.getPonches()+1);
						gamePlay.getLocal().setPonches(gamePlay.getLocal().getPonches()+1);
					}
				});
				btnP_PitcherVis.setForeground(Color.WHITE);
				btnP_PitcherVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnP_PitcherVis.setBackground(Color.DARK_GRAY);
				btnP_PitcherVis.setBounds(335, 302, 43, 27);
				panelVisitante.add(btnP_PitcherVis);
			}
			{
				btnES_BateadorLocal = new JButton("ES");
				btnES_BateadorLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						if (cbxBateadorLocal.getSelectedIndex() > 0) {
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
							player.setElevadosSacrificios(player.getElevadosSacrificios()+1);
						}
					}
				});
				btnES_BateadorLocal.setForeground(Color.WHITE);
				btnES_BateadorLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnES_BateadorLocal.setBackground(Color.DARK_GRAY);
				btnES_BateadorLocal.setBounds(185, 430, 49, 27);
				panelVisitante.add(btnES_BateadorLocal);
			}
			{
				btnCI_BateadorLocal = new JButton("CI");
				btnCI_BateadorLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						if (cbxBateadorLocal.getSelectedIndex() > 0) {
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
							player.setCarrerasImpulsadas(player.getCarrerasImpulsadas()+1);
							gamePlay.getLocal().setCarrerasImpulsadas(gamePlay.getLocal().getCarrerasImpulsadas()+1);
						}
					}
				});
				btnCI_BateadorLocal.setForeground(Color.WHITE);
				btnCI_BateadorLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnCI_BateadorLocal.setBackground(Color.DARK_GRAY);
				btnCI_BateadorLocal.setBounds(131, 430, 49, 27);
				panelVisitante.add(btnCI_BateadorLocal);
			}
			{
				btn3B_BateadorLocal = new JButton("3B");
				btn3B_BateadorLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						if (cbxBateadorLocal.getSelectedIndex() > 0) {
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
							player.setTriples(player.getTriples()+1);
							gamePlay.getLocal().setTriples(gamePlay.getLocal().getTriples()+1);
							
							i = Integer.parseInt(txtHitsVisi.getText().trim());
							i = i + 1;
							txtHitsVisi.setText(""+i);
						}
					}
				});
				btn3B_BateadorLocal.setForeground(Color.WHITE);
				btn3B_BateadorLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
				btn3B_BateadorLocal.setBackground(Color.DARK_GRAY);
				btn3B_BateadorLocal.setBounds(132, 395, 48, 27);
				panelVisitante.add(btn3B_BateadorLocal);
			}
			{
				btnHR_BateadorLocal = new JButton("HR");
				btnHR_BateadorLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						int i = 0;
						int x = 0;
						if (cbxBateadorLocal.getSelectedIndex() > 0) {
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
							player.setHomeruns(player.getHomeruns()+1);
							gamePlay.getLocal().setHomeruns(gamePlay.getLocal().getHomeruns()+1);
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
							player2.setHomerunsPermitidos(player2.getHomerunsPermitidos()+1);
							
							player.setCarreras(player.getCarreras()+1);
							gamePlay.getLocal().setCarreras(gamePlay.getLocal().getCarreras()+1);
							i = Integer.parseInt(txtCarrerasLocal.getText().trim());
							i = i+1;
							txtCarrerasLocal.setText(""+i);

							//player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
							player2.setCarrerasLimpiasPermitidas(player2.getCarrerasLimpiasPermitidas()+1);
							
							x = Integer.parseInt(txtHistLocal.getText().trim());
							x = x + 1;
							txtHistLocal.setText(""+x);
							gamePlay.carrerasPorEntrada(1, 0, gamePlay.getLocal());
							llenarPizarraVisitante();
							llenarPizarraLocal();
						}
					}
				});
				btnHR_BateadorLocal.setForeground(Color.WHITE);
				btnHR_BateadorLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnHR_BateadorLocal.setBackground(Color.DARK_GRAY);
				btnHR_BateadorLocal.setBounds(80, 395, 49, 27);
				panelVisitante.add(btnHR_BateadorLocal);
			}
			{
				btn2B_BateadorLocal = new JButton("2B");
				btn2B_BateadorLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						if (cbxBateadorLocal.getSelectedIndex() > 0) {
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
							player.setDobles(player.getDobles()+1);
							gamePlay.getLocal().setDobles(gamePlay.getLocal().getDobles()+1);
							
							i = Integer.parseInt(txtHistLocal.getText().trim());
							i = i + 1;
							txtHistLocal.setText(""+i);
						}
					}
				});
				btn2B_BateadorLocal.setForeground(Color.WHITE);
				btn2B_BateadorLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
				btn2B_BateadorLocal.setBackground(Color.DARK_GRAY);
				btn2B_BateadorLocal.setBounds(183, 395, 48, 27);
				panelVisitante.add(btn2B_BateadorLocal);
			}
			{
				btnH_BateadorLocal = new JButton("H");
				btnH_BateadorLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						int i = 0;
						if (cbxBateadorLocal.getSelectedIndex() > 0) {
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
							player.setHits(player.getHits()+1);
							gamePlay.getLocal().setHits(gamePlay.getLocal().getHits()+1);
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
							player2.setHitsPermitidos(player2.getHitsPermitidos()+1);
							
							i = Integer.parseInt(txtHistLocal.getText().trim());
							i = i + 1;
							txtHistLocal.setText(""+i);
						}
					}
				});
				btnH_BateadorLocal.setForeground(Color.WHITE);
				btnH_BateadorLocal.setFont(new Font("Tahoma", Font.BOLD, 10));
				btnH_BateadorLocal.setBackground(Color.DARK_GRAY);
				btnH_BateadorLocal.setBounds(233, 395, 43, 27);
				panelVisitante.add(btnH_BateadorLocal);
			}
			{
				btnA_CatcherVis = new JButton("A");
				btnA_CatcherVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCatcherVis.getText());
						player.setAsistencias(player.getAsistencias()+1);
					}
				});
				btnA_CatcherVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnA_CatcherVis.setBackground(Color.GREEN);
				btnA_CatcherVis.setBounds(619, 424, 43, 27);
				panelVisitante.add(btnA_CatcherVis);
			}
			{
				btnE_CatcherVis = new JButton("E");
				btnE_CatcherVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCatcherVis.getText());
						player.setErrores(player.getErrores()+1);
						i = Integer.parseInt(txtErrorVis.getText().trim());
						i = i + 1;
						txtErrorVis.setText(""+i);
					}
				});
				btnE_CatcherVis.setForeground(Color.WHITE);
				btnE_CatcherVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnE_CatcherVis.setBackground(Color.RED);
				btnE_CatcherVis.setBounds(666, 424, 43, 27);
				panelVisitante.add(btnE_CatcherVis);
			}
			{
				btnO_CatcherVis = new JButton("O");
				btnO_CatcherVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCatcherVis.getText());
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player.setOutsRealizados(player.getOutsRealizados()+1);
						player2.setOuts(player2.getOuts()+1);
					}
				});
				btnO_CatcherVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnO_CatcherVis.setBackground(Color.ORANGE);
				btnO_CatcherVis.setBounds(712, 424, 43, 27);
				panelVisitante.add(btnO_CatcherVis);
			}
			{
				btnE_3BVis = new JButton("E");
				btnE_3BVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt3BVis.getText());
						player.setErrores(player.getErrores()+1);
						i = Integer.parseInt(txtErrorVis.getText().trim());
						i = i + 1;
						txtErrorVis.setText(""+i);
					}
				});
				btnE_3BVis.setForeground(Color.WHITE);
				btnE_3BVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnE_3BVis.setBackground(Color.RED);
				btnE_3BVis.setBounds(140, 240, 43, 27);
				panelVisitante.add(btnE_3BVis);
			}
			{
				btnA_3BVis = new JButton("A");
				btnA_3BVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt3BVis.getText());
						player.setAsistencias(player.getAsistencias()+1);
					}
				});
				btnA_3BVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnA_3BVis.setBackground(Color.GREEN);
				btnA_3BVis.setBounds(93, 240, 43, 27);
				panelVisitante.add(btnA_3BVis);
			}
			{
				btnO_3BVis = new JButton("O");
				btnO_3BVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt3BVis.getText());
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player.setOutsRealizados(player.getOutsRealizados()+1);
						player2.setOuts(player2.getOuts()+1);
					}
				});
				btnO_3BVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnO_3BVis.setBackground(Color.ORANGE);
				btnO_3BVis.setBounds(186, 240, 43, 27);
				panelVisitante.add(btnO_3BVis);
			}
			{
				btnA_SSVis = new JButton("A");
				btnA_SSVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtSSVis.getText());
						player.setAsistencias(player.getAsistencias()+1);
					}
				});
				btnA_SSVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnA_SSVis.setBackground(Color.GREEN);
				btnA_SSVis.setBounds(173, 153, 43, 27);
				panelVisitante.add(btnA_SSVis);
			}
			{
				btnE_SSVis = new JButton("E");
				btnE_SSVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtSSVis.getText());
						player.setErrores(player.getErrores()+1);
						i = Integer.parseInt(txtErrorVis.getText().trim());
						i = i + 1;
						txtErrorVis.setText(""+i);
					}
				});
				btnE_SSVis.setForeground(Color.WHITE);
				btnE_SSVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnE_SSVis.setBackground(Color.RED);
				btnE_SSVis.setBounds(220, 153, 43, 27);
				panelVisitante.add(btnE_SSVis);
			}
			{
				btnO_SSVis = new JButton("O");
				btnO_SSVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtSSVis.getText());
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player.setOutsRealizados(player.getOutsRealizados()+1);
						player2.setOuts(player2.getOuts()+1);
					}
				});
				btnO_SSVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnO_SSVis.setBackground(Color.ORANGE);
				btnO_SSVis.setBounds(266, 153, 43, 27);
				panelVisitante.add(btnO_SSVis);
			}
			{
				btnE_2BVis = new JButton("E");
				btnE_2BVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt2BVis.getText());
						player.setErrores(player.getErrores()+1);
						i = Integer.parseInt(txtErrorVis.getText().trim());
						i = i + 1;
						txtErrorVis.setText(""+i);
					}
				});
				btnE_2BVis.setForeground(Color.WHITE);
				btnE_2BVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnE_2BVis.setBackground(Color.RED);
				btnE_2BVis.setBounds(475, 108, 43, 27);
				panelVisitante.add(btnE_2BVis);
			}
			{
				btnO_2BVis = new JButton("O");
				btnO_2BVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt2BVis.getText());
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player.setOutsRealizados(player.getOutsRealizados()+1);
						player2.setOuts(player2.getOuts()+1);
					}
				});
				btnO_2BVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnO_2BVis.setBackground(Color.ORANGE);
				btnO_2BVis.setBounds(521, 108, 43, 27);
				panelVisitante.add(btnO_2BVis);
			}
			{
				btnA_2bVis = new JButton("A");
				btnA_2bVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt2BVis.getText());
						player.setAsistencias(player.getAsistencias()+1);
					}
				});
				btnA_2bVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnA_2bVis.setBackground(Color.GREEN);
				btnA_2bVis.setBounds(428, 108, 43, 27);
				panelVisitante.add(btnA_2bVis);
			}
			{
				btnA_1BVis = new JButton("A");
				btnA_1BVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt1BVis.getText());
						player.setAsistencias(player.getAsistencias()+1);
					}
				});
				btnA_1BVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnA_1BVis.setBackground(Color.GREEN);
				btnA_1BVis.setBounds(665, 229, 43, 27);
				panelVisitante.add(btnA_1BVis);
			}
			{
				btnE_1BVis = new JButton("E");
				btnE_1BVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt1BVis.getText());
						player.setErrores(player.getErrores()+1);
						i = Integer.parseInt(txtErrorVis.getText().trim());
						i = i + 1;
						txtErrorVis.setText(""+i);
					}
				});
				btnE_1BVis.setForeground(Color.WHITE);
				btnE_1BVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnE_1BVis.setBackground(Color.RED);
				btnE_1BVis.setBounds(712, 229, 43, 27);
				panelVisitante.add(btnE_1BVis);
			}
			{
				btnO_1BVis = new JButton("O");
				btnO_1BVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txt1BVis.getText());
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player.setOutsRealizados(player.getOutsRealizados()+1);
						player2.setOuts(player2.getOuts()+1);
					}
				});
				btnO_1BVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnO_1BVis.setBackground(Color.ORANGE);
				btnO_1BVis.setBounds(758, 229, 43, 27);
				panelVisitante.add(btnO_1BVis);
			}
			{
				btnO_RFVis = new JButton("O");
				btnO_RFVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtRF_Vis.getText());
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player.setOutsRealizados(player.getOutsRealizados()+1);
						player2.setOuts(player2.getOuts()+1);
					}
				});
				btnO_RFVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnO_RFVis.setBackground(Color.ORANGE);
				btnO_RFVis.setBounds(824, 57, 43, 27);
				panelVisitante.add(btnO_RFVis);
			}
			{
				btnE_RFVis = new JButton("E");
				btnE_RFVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtRF_Vis.getText());
						player.setErrores(player.getErrores()+1);
						i = Integer.parseInt(txtErrorVis.getText().trim());
						i = i + 1;
						txtErrorVis.setText(""+i);
					}
				});
				btnE_RFVis.setForeground(Color.WHITE);
				btnE_RFVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnE_RFVis.setBackground(Color.RED);
				btnE_RFVis.setBounds(778, 57, 43, 27);
				panelVisitante.add(btnE_RFVis);
			}
			{
				btnA_RFVis = new JButton("A");
				btnA_RFVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtRF_Vis.getText());
						player.setAsistencias(player.getAsistencias()+1);
					}
				});
				btnA_RFVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnA_RFVis.setBackground(Color.GREEN);
				btnA_RFVis.setBounds(731, 57, 43, 27);
				panelVisitante.add(btnA_RFVis);
			}
			{
				btnE_CFVis = new JButton("E");
				btnE_CFVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCFVis.getText());
						player.setErrores(player.getErrores()+1);
						i = Integer.parseInt(txtErrorVis.getText().trim());
						i = i + 1;
						txtErrorVis.setText(""+i);
					}
				});
				btnE_CFVis.setForeground(Color.WHITE);
				btnE_CFVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnE_CFVis.setBackground(Color.RED);
				btnE_CFVis.setBounds(360, 11, 43, 27);
				panelVisitante.add(btnE_CFVis);
			}
			{
				btnO_CFVis = new JButton("O");
				btnO_CFVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCFVis.getText());
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player.setOutsRealizados(player.getOutsRealizados()+1);
						player2.setOuts(player2.getOuts()+1);
					}
				});
				btnO_CFVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnO_CFVis.setBackground(Color.ORANGE);
				btnO_CFVis.setBounds(406, 11, 43, 27);
				panelVisitante.add(btnO_CFVis);
			}
			{
				btnA_CFVis = new JButton("A");
				btnA_CFVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtCFVis.getText());
						player.setAsistencias(player.getAsistencias()+1);
					}
				});
				btnA_CFVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnA_CFVis.setBackground(Color.GREEN);
				btnA_CFVis.setBounds(313, 11, 43, 27);
				panelVisitante.add(btnA_CFVis);
			}
			{
				btnO_LFVis = new JButton("O");
				btnO_LFVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtLFVis.getText());
						player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
						player.setOutsRealizados(player.getOutsRealizados()+1);
						player2.setOuts(player2.getOuts()+1);
					}
				});
				btnO_LFVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnO_LFVis.setBackground(Color.ORANGE);
				btnO_LFVis.setBounds(126, 57, 43, 27);
				panelVisitante.add(btnO_LFVis);
			}
			{
				btnE_LFVis = new JButton("E");
				btnE_LFVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						int i = 0;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtLFVis.getText());
						player.setErrores(player.getErrores()+1);
						i = Integer.parseInt(txtErrorVis.getText().trim());
						i = i+1;
						txtErrorVis.setText(""+i);
					}
				});
				btnE_LFVis.setForeground(Color.WHITE);
				btnE_LFVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnE_LFVis.setBackground(Color.RED);
				btnE_LFVis.setBounds(80, 57, 43, 27);
				panelVisitante.add(btnE_LFVis);
			}
			{
				btnA_LFVis = new JButton("A");
				btnA_LFVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(txtLFVis.getText());
						player.setAsistencias(player.getAsistencias()+1);
					}
				});
				btnA_LFVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnA_LFVis.setBackground(Color.GREEN);
				btnA_LFVis.setBounds(34, 57, 43, 27);
				panelVisitante.add(btnA_LFVis);
			}
			{
				txtRF_Vis = new JTextField();
				txtRF_Vis.setEditable(false);
				txtRF_Vis.setColumns(10);
				txtRF_Vis.setBackground(Color.WHITE);
				txtRF_Vis.setBounds(740, 95, 127, 20);
				panelVisitante.add(txtRF_Vis);
			}
			{
				txtCFVis = new JTextField();
				txtCFVis.setEditable(false);
				txtCFVis.setColumns(10);
				txtCFVis.setBackground(Color.WHITE);
				txtCFVis.setBounds(313, 49, 136, 20);
				panelVisitante.add(txtCFVis);
			}
			{
				txtLFVis = new JTextField();
				txtLFVis.setEditable(false);
				txtLFVis.setColumns(10);
				txtLFVis.setBackground(Color.WHITE);
				txtLFVis.setBounds(34, 95, 127, 20);
				panelVisitante.add(txtLFVis);
			}
			{
				txt3BVis = new JTextField();
				txt3BVis.setEditable(false);
				txt3BVis.setColumns(10);
				txt3BVis.setBackground(Color.WHITE);
				txt3BVis.setBounds(93, 280, 137, 20);
				panelVisitante.add(txt3BVis);
			}
			{
				txtSSVis = new JTextField();
				txtSSVis.setEditable(false);
				txtSSVis.setColumns(10);
				txtSSVis.setBackground(Color.WHITE);
				txtSSVis.setBounds(172, 191, 137, 20);
				panelVisitante.add(txtSSVis);
			}
			{
				txt2BVis = new JTextField();
				txt2BVis.setEditable(false);
				txt2BVis.setColumns(10);
				txt2BVis.setBackground(Color.WHITE);
				txt2BVis.setBounds(428, 146, 127, 20);
				panelVisitante.add(txt2BVis);
			}
			{
				txt1BVis = new JTextField();
				txt1BVis.setEditable(false);
				txt1BVis.setColumns(10);
				txt1BVis.setBackground(Color.WHITE);
				txt1BVis.setBounds(665, 267, 136, 20);
				panelVisitante.add(txt1BVis);
			}
			{
				txtPitcherVis = new JTextField();
				txtPitcherVis.setEditable(false);
				txtPitcherVis.setColumns(10);
				txtPitcherVis.setBackground(Color.WHITE);
				txtPitcherVis.setBounds(382, 306, 135, 20);
				panelVisitante.add(txtPitcherVis);
			}
			{
				txtCatcherVis = new JTextField();
				txtCatcherVis.setEditable(false);
				txtCatcherVis.setColumns(10);
				txtCatcherVis.setBackground(Color.WHITE);
				txtCatcherVis.setBounds(482, 431, 127, 20);
				panelVisitante.add(txtCatcherVis);
			}
			{
				cbxBateadorLocal = new JComboBox<String>();
				cbxBateadorLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						if (cbxBateadorLocal.getSelectedIndex() > 0) {
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxBateadorLocal.getSelectedItem().toString());
							player.setTurnosBate(player.getTurnosBate()+1);
							gamePlay.getLocal().setTurnosBate(gamePlay.getLocal().getTurnosBate()+1);
						}
					}
				});
				cbxBateadorLocal.setModel(new DefaultComboBoxModel<String>(new String[] {"<Batea>"}));
				cbxBateadorLocal.setForeground(Color.WHITE);
				cbxBateadorLocal.setBackground(Color.DARK_GRAY);
				cbxBateadorLocal.setBounds(286, 397, 138, 24);
				panelVisitante.add(cbxBateadorLocal);
			}
			{
				lblklk = new JLabel("");
				lblklk.setIcon(new ImageIcon(SimuladorPartido.class.getResource("/Imagenes/field.jpg")));
				lblklk.setBounds(1, 1, 905, 475);
				panelVisitante.add(lblklk);
			}
		}
		{
			JPanel panelTitulo = new JPanel();
			panelTitulo.setBackground(new Color(0, 0, 0));
			panelTitulo.setBounds(0, 0, 1163, 32);
			contentPanel.add(panelTitulo);
			panelTitulo.setLayout(null);
			{
				lblSalir = new JLabel("");
				lblSalir.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				lblSalir.setIcon(new ImageIcon(SimuladorPartido.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
				lblSalir.setBounds(1125, 2, 32, 32);
				panelTitulo.add(lblSalir);
			}
			{
				lblNewLabel_2 = new JLabel("PARTIDO EN CURSO");
				lblNewLabel_2.setForeground(Color.WHITE);
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_2.setBounds(10, 7, 153, 19);
				panelTitulo.add(lblNewLabel_2);
			}
		}
		{
			JPanel panelBoard = new JPanel();
			panelBoard.setOpaque(false);
			panelBoard.setBackground(Color.WHITE);
			panelBoard.setBorder(new LineBorder(Color.BLACK));
			panelBoard.setBounds(0, 29, 1163, 109);
			contentPanel.add(panelBoard);
			panelBoard.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(8, 11, 965, 88);
				scrollPane.getViewport().setBackground(Color.BLACK);
				panelBoard.add(scrollPane);
				{
					model = new DefaultTableModel();
					String[] headers = {"Equipos","1","2","3","4","5","6","7","8","9","10","11","12"};
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.setForeground(Color.WHITE);
					table.setModel(model);
					Font fuente = new Font("Tahoma", Font.BOLD, 18);
					table.getTableHeader().setFont(fuente);
					table.getTableHeader().setBackground(Color.BLACK);
					table.getTableHeader().setForeground(Color.WHITE);
					table.setBackground(Color.BLACK);
					table.setFont(new Font("Tahoma", Font.PLAIN, 18));
					scrollPane.setViewportView(table);
				}
			}
			{
				panel = new JPanel();
				panel.setBackground(Color.BLACK);
				panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.setBounds(983, 11, 173, 88);
				panelBoard.add(panel);
				panel.setLayout(null);
				{
					separator_3 = new JSeparator();
					separator_3.setBackground(Color.WHITE);
					separator_3.setForeground(Color.WHITE);
					separator_3.setBounds(1, 57, 171, 2);
					panel.add(separator_3);
				}
				{
					separator_1 = new JSeparator();
					separator_1.setBackground(Color.WHITE);
					separator_1.setForeground(Color.WHITE);
					separator_1.setBounds(1, 26, 171, 2);
					panel.add(separator_1);
				}
				{
					separator_2 = new JSeparator();
					separator_2.setBackground(Color.WHITE);
					separator_2.setForeground(Color.WHITE);
					separator_2.setOrientation(SwingConstants.VERTICAL);
					separator_2.setBounds(113, 3, 2, 90);
					panel.add(separator_2);
				}
				{
					separator = new JSeparator();
					separator.setBackground(Color.WHITE);
					separator.setForeground(Color.WHITE);
					separator.setOrientation(SwingConstants.VERTICAL);
					separator.setBounds(59, 3, 2, 90);
					panel.add(separator);
				}
				{
					label = new JLabel("C");
					label.setForeground(Color.WHITE);
					label.setFont(new Font("Tahoma", Font.BOLD, 21));
					label.setBounds(25, 0, 24, 32);
					panel.add(label);
				}
				{
					label_1 = new JLabel("H");
					label_1.setForeground(Color.WHITE);
					label_1.setFont(new Font("Tahoma", Font.BOLD, 21));
					label_1.setBounds(78, 0, 24, 32);
					panel.add(label_1);
				}
				{
					label_2 = new JLabel("E");
					label_2.setForeground(Color.WHITE);
					label_2.setFont(new Font("Tahoma", Font.BOLD, 21));
					label_2.setBounds(130, 0, 24, 32);
					panel.add(label_2);
				}
				{
					
					MaskFormatter aux = null;
					try {
						aux = new MaskFormatter("##");
						aux.setPlaceholder("00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					txtCarrerasVisi = new JFormattedTextField(aux);
					txtCarrerasVisi.setBorder(null);
					txtCarrerasVisi.setFont(new Font("Tahoma", Font.PLAIN, 15));
					txtCarrerasVisi.setEditable(false);
					txtCarrerasVisi.setForeground(Color.WHITE);
					txtCarrerasVisi.setBackground(Color.BLACK);
					txtCarrerasVisi.setBounds(23, 32, 34, 20);
					panel.add(txtCarrerasVisi);
				}
				{
					MaskFormatter aux = null;
					try {
						aux = new MaskFormatter("##");
						aux.setPlaceholder("00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					txtCarrerasLocal = new JFormattedTextField(aux);
					txtCarrerasLocal.setForeground(Color.WHITE);
					txtCarrerasLocal.setBorder(null);
					txtCarrerasLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
					txtCarrerasLocal.setEditable(false);
					txtCarrerasLocal.setBackground(Color.BLACK);
					txtCarrerasLocal.setBounds(23, 61, 34, 20);
					panel.add(txtCarrerasLocal);
				}
				{
					MaskFormatter aux = null;
					try {
						aux = new MaskFormatter("##");
						aux.setPlaceholder("00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					txtHitsVisi = new JFormattedTextField(aux);
					txtHitsVisi.setForeground(Color.WHITE);
					txtHitsVisi.setBorder(null);
					txtHitsVisi.setFont(new Font("Tahoma", Font.PLAIN, 15));
					txtHitsVisi.setEditable(false);
					txtHitsVisi.setBackground(Color.BLACK);
					txtHitsVisi.setBounds(77, 32, 34, 20);
					panel.add(txtHitsVisi);
				}
				{
					MaskFormatter aux = null;
					try {
						aux = new MaskFormatter("##");
						aux.setPlaceholder("00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					txtHistLocal = new JFormattedTextField(aux);
					txtHistLocal.setForeground(Color.WHITE);
					txtHistLocal.setBorder(null);
					txtHistLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
					txtHistLocal.setEditable(false);
					txtHistLocal.setBackground(Color.BLACK);
					txtHistLocal.setBounds(77, 61, 34, 20);
					panel.add(txtHistLocal);
				}
				{
					MaskFormatter aux = null;
					try {
						aux = new MaskFormatter("##");
						aux.setPlaceholder("00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					txtErrorVis = new JFormattedTextField(aux);
					txtErrorVis.setForeground(Color.WHITE);
					txtErrorVis.setBorder(null);
					txtErrorVis.setFont(new Font("Tahoma", Font.PLAIN, 15));
					txtErrorVis.setEditable(false);
					txtErrorVis.setBackground(Color.BLACK);
					txtErrorVis.setBounds(129, 32, 34, 20);
					panel.add(txtErrorVis);
				}
				{
					MaskFormatter aux = null;
					try {
						aux = new MaskFormatter("##");
						aux.setPlaceholder("00");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					txtErrorLocal = new JFormattedTextField(aux);
					txtErrorLocal.setForeground(Color.WHITE);
					txtErrorLocal.setBorder(null);
					txtErrorLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
					txtErrorLocal.setEditable(false);
					txtErrorLocal.setBackground(Color.BLACK);
					txtErrorLocal.setBounds(129, 61, 34, 20);
					panel.add(txtErrorLocal);
				}
			}
		}
		{
			panelCarrerasVisitante = new JPanel();
			panelCarrerasVisitante.setOpaque(false);
			panelCarrerasVisitante.setBackground(Color.WHITE);
			panelCarrerasVisitante.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Carreras Visitante", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
			panelCarrerasVisitante.setBounds(932, 191, 217, 165);
			contentPanel.add(panelCarrerasVisitante);
			panelCarrerasVisitante.setLayout(null);
			{
				cbxCarreraVis = new JComboBox<String>();
				cbxCarreraVis.setBackground(Color.WHITE);
				cbxCarreraVis.setFont(new Font("Tahoma", Font.PLAIN, 12));
				cbxCarreraVis.setModel(new DefaultComboBoxModel<String>(new String[] {"<Anotador>"}));
				cbxCarreraVis.setBounds(10, 22, 197, 25);
				panelCarrerasVisitante.add(cbxCarreraVis);
			}
			{
				btnCarreraVis = new JButton("Anotar Carrera");
				btnCarreraVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						int i = 0;
						if (cbxCarreraVis.getSelectedIndex() > 0) {
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxCarreraVis.getSelectedItem().toString());
							player.setCarreras(player.getCarreras()+1);
							gamePlay.getVisitante().setCarreras(gamePlay.getVisitante().getCarreras()+1);
							i = Integer.parseInt(txtCarrerasVisi.getText().trim());
							i = i+1;
							txtCarrerasVisi.setText(""+i);

							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							player2.setCarrerasLimpiasPermitidas(player2.getCarrerasLimpiasPermitidas()+1);
							gamePlay.carrerasPorEntrada(0, 1, gamePlay.getVisitante());
							llenarPizarraVisitante();
							llenarPizarraLocal();
						}
					}
				});
				btnCarreraVis.setBackground(Color.WHITE);
				btnCarreraVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnCarreraVis.setBounds(34, 72, 149, 23);
				panelCarrerasVisitante.add(btnCarreraVis);
			}
			{
				btnCambioEntradaVis = new JButton("Cambio de Entrada");
				btnCambioEntradaVis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cbxCarreraVis.setEnabled(false);
						btnCarreraVis.setEnabled(false);
						btnCambioEntradaVis.setEnabled(false);
						cbxCarrerasLocal.setEnabled(true);
						btnCarreraLocal.setEnabled(true);
						btnCambioEntradaLocal.setEnabled(true);
						lblPartido.setText(""+gamePlay.getVisitante().getNombre()+" a la Defensiva vs "+gamePlay.getLocal().getNombre()+" a la Ofensiva");
						panelLocal.setVisible(false);
						panelVisitante.setVisible(true);
					}
				});
				btnCambioEntradaVis.setBackground(Color.WHITE);
				btnCambioEntradaVis.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnCambioEntradaVis.setBounds(28, 119, 161, 23);
				panelCarrerasVisitante.add(btnCambioEntradaVis);
			}
		}
		{
			panelCarrerasLocal = new JPanel();
			panelCarrerasLocal.setOpaque(false);
			panelCarrerasLocal.setBackground(Color.WHITE);
			panelCarrerasLocal.setLayout(null);
			panelCarrerasLocal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Carreras Local", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
			panelCarrerasLocal.setBounds(932, 371, 217, 165);
			contentPanel.add(panelCarrerasLocal);
			{
				cbxCarrerasLocal = new JComboBox<String>();
				cbxCarrerasLocal.setEnabled(false);
				cbxCarrerasLocal.setBackground(Color.WHITE);
				cbxCarrerasLocal.setModel(new DefaultComboBoxModel<String>(new String[] {"<Anotador>"}));
				cbxCarrerasLocal.setFont(new Font("Tahoma", Font.PLAIN, 12));
				cbxCarrerasLocal.setBounds(10, 22, 197, 25);
				panelCarrerasLocal.add(cbxCarrerasLocal);
			}
			{
				btnCarreraLocal = new JButton("Anotar Carrera");
				btnCarreraLocal.setEnabled(false);
				btnCarreraLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bateador player = null;
						Lanzador player2 = null;
						int i = 0;
						if (cbxCarrerasLocal.getSelectedIndex() > 0) {
							player = (Bateador) Liga.getInstance().buscarJugadorPorNombre(cbxCarrerasLocal.getSelectedItem().toString());
							player.setCarreras(player.getCarreras()+1);
							gamePlay.getVisitante().setCarreras(gamePlay.getVisitante().getCarreras()+1);
							i = Integer.parseInt(txtCarrerasLocal.getText().trim());
							i = i+1;
							txtCarrerasLocal.setText(""+i);
							
							player2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
							player2.setCarrerasLimpiasPermitidas(player2.getCarrerasLimpiasPermitidas()+1);
							gamePlay.carrerasPorEntrada(1, 0, gamePlay.getLocal());
							llenarPizarraVisitante();
							llenarPizarraLocal();
						}
					}
				});
				btnCarreraLocal.setBackground(Color.WHITE);
				btnCarreraLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnCarreraLocal.setBounds(34, 72, 149, 23);
				panelCarrerasLocal.add(btnCarreraLocal);
			}
			{
				btnCambioEntradaLocal = new JButton("Cambio de Entrada");
				btnCambioEntradaLocal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cbxCarreraVis.setEnabled(true);
						btnCarreraVis.setEnabled(true);
						btnCambioEntradaVis.setEnabled(true);
						cbxCarrerasLocal.setEnabled(false);
						btnCarreraLocal.setEnabled(false);
						btnCambioEntradaLocal.setEnabled(false);
						gamePlay.setEntradas(gamePlay.getEntradas()+1);
						if (gamePlay.getEntradas()>=9) {
							btnTerminarPartido.setEnabled(true);
						}
						lblPartido.setText(""+gamePlay.getLocal().getNombre()+" a la Defensiva vs "+gamePlay.getVisitante().getNombre()+" a la Ofensiva");
						panelLocal.setVisible(true);
						panelVisitante.setVisible(false);
					}
				});
				btnCambioEntradaLocal.setEnabled(false);
				btnCambioEntradaLocal.setBackground(Color.WHITE);
				btnCambioEntradaLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnCambioEntradaLocal.setBounds(28, 119, 161, 23);
				panelCarrerasLocal.add(btnCambioEntradaLocal);
			}
		}
		{
			panelTerminarPartido = new JPanel();
			panelTerminarPartido.setOpaque(false);
			panelTerminarPartido.setBackground(Color.WHITE);
			panelTerminarPartido.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Terminar Partido", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
			panelTerminarPartido.setBounds(932, 548, 217, 114);
			contentPanel.add(panelTerminarPartido);
			panelTerminarPartido.setLayout(null);
			{
				btnTerminarPartido = new JButton("TERMINADO");
				btnTerminarPartido.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Lanzador p1 = null;
						Lanzador p2 = null;
						int i = 0;
						int iz = 0;
						int x = 0;
						int xz = 0;
						gamePlay.terminarPartido();
						if (gamePlay.isTerminado()) {
							gamePlay.getVisitante().setPartidosJugados(gamePlay.getVisitante().getPartidosJugados()+1);
							gamePlay.getLocal().setPartidosJugados(gamePlay.getLocal().getPartidosJugados()+1);
							p1 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherVis.getText());
							p2 = (Lanzador) Liga.getInstance().buscarJugadorPorNombre(txtPitcherLocal.getText());
							
							p1.setCarrerasPermitidas(p1.getCarrerasLimpiasPermitidas()+p1.getCarrerasSuciasPermitidas());
							p2.setCarrerasPermitidas(p1.getCarrerasLimpiasPermitidas()+p1.getCarrerasSuciasPermitidas());
							p1.setJuegosLanzados(p1.getJuegosLanzados()+1);
							p2.setJuegosLanzados(p1.getJuegosLanzados()+1);
							p1.setAperturas(p1.getAperturas()+1);
							p2.setAperturas(p1.getAperturas()+1);
							
							i = Integer.parseInt(txtErrorVis.getText().trim());
							gamePlay.setErroresVisitante(i);
							iz = Integer.parseInt(txtErrorLocal.getText().trim());
							gamePlay.setErroresLocal(iz);
							
							x = Integer.parseInt(txtHitsVisi.getText().trim());
							gamePlay.setErroresVisitante(x);
							xz = Integer.parseInt(txtHistLocal.getText().trim());
							gamePlay.setErroresLocal(xz);
							
							
							if (gamePlay.ganador().equals(gamePlay.getVisitante())) {
								gamePlay.getVisitante().setPartidosGanados(gamePlay.getVisitante().getPartidosGanados()+1);
								gamePlay.getLocal().setPartidosPerdidos(gamePlay.getLocal().getPartidosPerdidos()+1);
								p1.setJuegosGanados(p1.getJuegosGanados()+1);
								p2.setJuegosPerdidos(p2.getJuegosPerdidos()+1);
								JOptionPane.showMessageDialog(null, "Los Ganadores Son: "+gamePlay.getVisitante().getNombre(), null, JOptionPane.INFORMATION_MESSAGE);
							} else if (gamePlay.ganador().equals(gamePlay.getLocal())) {
								gamePlay.getLocal().setPartidosGanados(gamePlay.getLocal().getPartidosGanados()+1);
								gamePlay.getVisitante().setPartidosPerdidos(gamePlay.getVisitante().getPartidosPerdidos()+1);
								p2.setJuegosGanados(p2.getJuegosGanados()+1);
								p1.setJuegosPerdidos(p1.getJuegosPerdidos()+1);
								JOptionPane.showMessageDialog(null, "Los Ganadores Son: "+gamePlay.getLocal().getNombre(), null, JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				});
				btnTerminarPartido.setEnabled(false);
				btnTerminarPartido.setBackground(Color.WHITE);
				btnTerminarPartido.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnTerminarPartido.setBounds(53, 47, 113, 30);
				panelTerminarPartido.add(btnTerminarPartido);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setOpaque(false);
			panel_1.setBackground(Color.WHITE);
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.setBounds(15, 149, 907, 45);
			contentPanel.add(panel_1);
		}
		{
			panel_2 = new JPanel();
			panel_2.setOpaque(false);
			panel_2.setBackground(Color.WHITE);
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_2.setBounds(925, 149, 230, 519);
			contentPanel.add(panel_2);
			panel_2.setLayout(null);
			{
				lblNewLabel_1 = new JLabel("Eventos");
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(86, 5, 58, 14);
				panel_2.add(lblNewLabel_1);
			}
		}
		{
			lblFondaso = new JLabel("");
			lblFondaso.setIcon(new ImageIcon(SimuladorPartido.class.getResource("/Imagenes/anotherballWallpaper.jpg")));
			lblFondaso.setBounds(-68, 0, 1229, 768);
			contentPanel.add(lblFondaso);
		}
	}

	public void llenarBateadoresLocal() {
		for (Jugador x : gamePlay.getAlineacionLocal()) {
			cbxBateadorLocal.addItem(x.getNombre());
			cbxCarrerasLocal.addItem(x.getNombre());
		}
	}

	public void llenarBateadoresVisitante() {
		for (Jugador x : gamePlay.getAlineacionVisitante()) {
			cbxBateadorVisitante.addItem(x.getNombre());
			cbxCarreraVis.addItem(x.getNombre());
		}
	}

	public void llenarLocal() {
		for (Jugador x : gamePlay.getAlineacionLocal()) {
			if (x.getPosicion().equals("Pitcher")) {
				txtPitcherLocal.setText(x.getNombre());
			}
			if (x.getPosicion().equals("Catcher")) {
				txtCatcherLocal.setText(x.getNombre());
			}
			if (x.getPosicion().equals("1B")) {
				txt1BLocal.setText(x.getNombre());
			}
			if (x.getPosicion().equals("2B")) {
				txt2BLocal.setText(x.getNombre());
			}
			if (x.getPosicion().equals("3B")) {
				txt3BLocal.setText(x.getNombre());
			}
			if (x.getPosicion().equals("SS")) {
				txtSSLocal.setText(x.getNombre());
			}
			if (x.getPosicion().equals("LF")) {
				txtLFLocal.setText(x.getNombre());
			}
			if (x.getPosicion().equals("CF")) {
				txtCFLocal.setText(x.getNombre());
			}
			if (x.getPosicion().equals("RF")) {
				txtRFLocal.setText(x.getNombre());
			}
		}
	}

	public void llenarVisitante() {
		for (Jugador x : gamePlay.getAlineacionVisitante()) {
			if (x.getPosicion().equals("Pitcher")) {
				txtPitcherVis.setText(x.getNombre());
			}
			if (x.getPosicion().equals("Catcher")) {
				txtCatcherVis.setText(x.getNombre());
			}
			if (x.getPosicion().equals("1B")) {
				txt1BVis.setText(x.getNombre());
			}
			if (x.getPosicion().equals("2B")) {
				txt2BVis.setText(x.getNombre());
			}
			if (x.getPosicion().equals("3B")) {
				txt3BVis.setText(x.getNombre());
			}
			if (x.getPosicion().equals("SS")) {
				txtSSVis.setText(x.getNombre());
			}
			if (x.getPosicion().equals("LF")) {
				txtLFVis.setText(x.getNombre());
			}
			if (x.getPosicion().equals("CF")) {
				txtCFVis.setText(x.getNombre());
			}
			if (x.getPosicion().equals("RF")) {
				txtRF_Vis.setText(x.getNombre());
			}
		}
	}

	public void llenarPizarraVisitante() {
		model.setRowCount(0);
		filas = new Object[model.getColumnCount()];
		int[] x = new int[11]; 
		x = gamePlay.getEntradasVisitante();
		
		filas[0] = gamePlay.getVisitante().getNombre();
		filas[1] = x[0];
		filas[2] = x[1];
		filas[3] = x[2];
		filas[4] = x[3];
		filas[5] = x[4];
		filas[6] = x[5];
		filas[7] = x[6];
		filas[8] = x[7];
		filas[9] = x[8];
		filas[10] = x[9];
		filas[11] = x[10];
		model.addRow(filas);
	}
	
	public void llenarPizarraLocal() {
		model.setRowCount(1);
		filas = new Object[model.getColumnCount()];
		int[] x = new int[11]; 
		x = gamePlay.getEntradasLocal();
		
		filas[0] = gamePlay.getLocal().getNombre();
		filas[1] = x[0];
		filas[2] = x[1];
		filas[3] = x[2];
		filas[4] = x[3];
		filas[5] = x[4];
		filas[6] = x[5];
		filas[7] = x[6];
		filas[8] = x[7];
		filas[9] = x[8];
		filas[10] = x[9];
		filas[11] = x[10];
		model.addRow(filas);	
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(300);
		table.setRowHeight(30);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
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
	}
	
}
