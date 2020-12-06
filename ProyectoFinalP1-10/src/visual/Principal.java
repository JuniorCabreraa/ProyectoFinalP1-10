package visual;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import logical.Jugador;
import logical.Liga;
import logical.Partido;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.awt.event.WindowFocusListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel lbl1;
	private static JLabel lbl2;
	private JMenuBar menuBar;
	private static JLabel lbl3;
	private static JLabel lbl4;
	private static JLabel lbl5;
	private JMenu mnUsuario;
	private JMenuItem mntmRegistrarUsuario;
	private JMenuItem mntmGuardarDatos;
	private JMenu mnPartidos;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenu mnEquipos;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_6;
	private JMenu mntJugadores;
	private JMenuItem mntmNewMenuItem_7;
	private JMenu mnNewMenu_5;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JMenuItem mntmNewMenuItem_12;
	private JMenu mnEstadisticas;
	private JMenu mnNewMenu_7;
	private JMenuItem mntmNewMenuItem_13;
	private JMenuItem mntmNewMenuItem_14;
	private JMenuItem mntmNewMenuItem_15;
	private JMenuItem mntmNewMenuItem_16;
	private JPanel panelCalendario;
	private JScrollPane scrollPane;
	private static JTable table;
	private static DefaultTableModel model;
	private static Object[] filas;
	private JComboBox<String> cbxDate;
	private JLabel lblMostrarPartidos;
	private JButton btnIniciar;
	private JButton btnEsconder;
	private Partido game = null;
	private String letsPlay = null;
	private JButton btnRepro;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				cbxDate.setSelectedIndex(0);
				calendarioPartidos(0);
			}
			public void windowLostFocus(WindowEvent arg0) {
				cbxDate.setSelectedIndex(0);
				calendarioPartidos(0);
			}
		});
		setBackground(Color.BLACK);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Wallpaper wp = new Wallpaper();
				wp.start();
				calendarioPartidos(0);
				if (!Liga.getInstance().getLoginUser().getType().equalsIgnoreCase("Administrador")) {
					mnUsuario.setEnabled(false);
					mnPartidos.setEnabled(false);
					mnEquipos.setEnabled(false);
					mntJugadores.setEnabled(false);
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "¿Desea Guardar los Datos?", null, JOptionPane.YES_NO_CANCEL_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					Liga.getInstance().saveData();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else if (option == JOptionPane.CANCEL_OPTION) {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				} else {
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});
		getContentPane().setForeground(Color.RED);
		setForeground(Color.BLACK);
		setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		setTitle("NATIONAL BASEBALL MANAGER");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagenes/Pelota_de_B\u00E9isbol_icono.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Dimension dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-40));
		setLocationRelativeTo(null);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnUsuario = new JMenu("Usuario");
				mnUsuario.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/User.png")));
				menuBar.add(mnUsuario);
				{
					mntmRegistrarUsuario = new JMenuItem("Registrar Nuevo Usuario");
					mntmRegistrarUsuario.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegistrarUsuario regUser = new RegistrarUsuario();
							regUser.setVisible(true);
						}
					});
					mntmRegistrarUsuario.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
					mnUsuario.add(mntmRegistrarUsuario);
				}
				{
					mntmGuardarDatos = new JMenuItem("Guardar Datos");
					mntmGuardarDatos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Liga.getInstance().saveData();
						}
					});
					mntmGuardarDatos.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/save.png")));
					mnUsuario.add(mntmGuardarDatos);
				}
			}
			{
				mnPartidos = new JMenu("Partidos");
				mnPartidos.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/MLB-logo.jpg")));
				menuBar.add(mnPartidos);
				{
					mnNewMenu_2 = new JMenu("Mostrar Partidos");
					mnNewMenu_2.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/bateador.png")));
					mnPartidos.add(mnNewMenu_2);
					{
						mntmNewMenuItem = new JMenuItem("Calendario de Juego");
						mntmNewMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								panelCalendario.setVisible(true);
							}
						});
						mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/list.png")));
						mnNewMenu_2.add(mntmNewMenuItem);
					}
					{
						mntmNewMenuItem_3 = new JMenuItem("Terminados");
						mntmNewMenuItem_3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									ListaPartidos listPart = new ListaPartidos();
									listPart.setVisible(true);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
						mntmNewMenuItem_3.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/list.png")));
						mnNewMenu_2.add(mntmNewMenuItem_3);
					}
				}
				{
					mntmNewMenuItem_2 = new JMenuItem("Programar Partidos");
					mntmNewMenuItem_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegistrarPartido regGame;
							try {
								regGame = new RegistrarPartido();
								regGame.setVisible(true);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					});
					mntmNewMenuItem_2.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
					mnPartidos.add(mntmNewMenuItem_2);
				}
			}
			{
				mnEquipos = new JMenu("Equipos");
				mnEquipos.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/team.png")));
				menuBar.add(mnEquipos);
				{
					mntmNewMenuItem_4 = new JMenuItem("Crear Equipo");
					mntmNewMenuItem_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegistrarEquipo regTeam;
							try {
								regTeam = new RegistrarEquipo();
								regTeam.setVisible(true);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					mntmNewMenuItem_4.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
					mnEquipos.add(mntmNewMenuItem_4);
				}
				{
					mntmNewMenuItem_6 = new JMenuItem("Mostrar Equipos");
					mntmNewMenuItem_6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								ListaEquipos listTeam = new ListaEquipos();
								listTeam.setVisible(true);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					mntmNewMenuItem_6.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/list.png")));
					mnEquipos.add(mntmNewMenuItem_6);
				}
			}
			{
				mntJugadores = new JMenu("Jugadores");
				mntJugadores.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/players.png")));
				menuBar.add(mntJugadores);
				{
					mntmNewMenuItem_7 = new JMenuItem("Crear Jugador");
					mntmNewMenuItem_7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegistrarJugador regPlayer;
							try {
								regPlayer = new RegistrarJugador();
								regPlayer.setVisible(true);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					mntmNewMenuItem_7.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
					mntJugadores.add(mntmNewMenuItem_7);
				}
				{
					mnNewMenu_5 = new JMenu("Manejar Jugador");
					mnNewMenu_5.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/modify.png")));
					mntJugadores.add(mnNewMenu_5);
					{
						mntmNewMenuItem_8 = new JMenuItem("Insertar Lesi\u00F3n");
						mntmNewMenuItem_8.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								RegistrarLesion regBroken;
								try {
									regBroken = new RegistrarLesion();
									regBroken.setVisible(true);
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						mntmNewMenuItem_8.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
						mnNewMenu_5.add(mntmNewMenuItem_8);
					}
					{
						mntmNewMenuItem_9 = new JMenuItem("Verificar Lesi\u00F3n");
						mntmNewMenuItem_9.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								verificacionlesiones();
								try {
									ListaLesion listBroken = new ListaLesion();
									listBroken.setVisible(true);
								} catch (ParseException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						mntmNewMenuItem_9.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/Search.png")));
						mnNewMenu_5.add(mntmNewMenuItem_9);
					}
					{
						mntmNewMenuItem_10 = new JMenuItem("Cambiar Equipo");
						mntmNewMenuItem_10.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								CambiarEquipo cbE = new CambiarEquipo();
								cbE.setVisible(true);
							}
						});
						mntmNewMenuItem_10.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/change.png")));
						mnNewMenu_5.add(mntmNewMenuItem_10);
					}
				}
				{
					mntmNewMenuItem_11 = new JMenuItem("Mostrar Jugadores");
					mntmNewMenuItem_11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								ListaJugadores listPlayers = new ListaJugadores();
								listPlayers.setVisible(true);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					mntmNewMenuItem_11.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/list.png")));
					mntJugadores.add(mntmNewMenuItem_11);
				}
				{
					mntmNewMenuItem_12 = new JMenuItem("Gr\u00E1fico Lesionados");
					mntmNewMenuItem_12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							GraficoLesion gles = new GraficoLesion();
							gles.setVisible(true);
						}
					});
					mntmNewMenuItem_12.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/barsgraphic.png")));
					mntJugadores.add(mntmNewMenuItem_12);
				}
			}
			{
				mnEstadisticas = new JMenu("Estad\u00EDsticas");
				mnEstadisticas.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/barsgraphic.png")));
				menuBar.add(mnEstadisticas);
				{
					mnNewMenu_7 = new JMenu("Jugadores");
					mnNewMenu_7.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/team.png")));
					mnEstadisticas.add(mnNewMenu_7);
					{
						mntmNewMenuItem_13 = new JMenuItem("Top 10 Bateadores");
						mntmNewMenuItem_13.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									Lista10Bateadores list10B = new Lista10Bateadores();
									list10B.setVisible(true);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}							}
						});
						mntmNewMenuItem_13.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/bateador.png")));
						mnNewMenu_7.add(mntmNewMenuItem_13);
					}
					{
						mntmNewMenuItem_14 = new JMenuItem("Top 10 Lanzadores");
						mntmNewMenuItem_14.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									Lista10Lanzadores list10L = new Lista10Lanzadores();
									list10L.setVisible(true);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
						mntmNewMenuItem_14.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/pitcher.png")));
						mnNewMenu_7.add(mntmNewMenuItem_14);
					}
					{
						mntmNewMenuItem_15 = new JMenuItem("Todos los Jugadores");
						mntmNewMenuItem_15.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									ListaEstadisticasJugadores listEsta = new ListaEstadisticasJugadores();
									listEsta.setVisible(true);
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
						mntmNewMenuItem_15.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/players.png")));
						mnNewMenu_7.add(mntmNewMenuItem_15);
					}
				}
				{
					mntmNewMenuItem_16 = new JMenuItem("Equipos");
					mntmNewMenuItem_16.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								ListaEstadisticasEquipos listEstEq = new ListaEstadisticasEquipos();
								listEstEq.setVisible(true);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					mntmNewMenuItem_16.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/estadioteam.png")));
					mnEstadisticas.add(mntmNewMenuItem_16);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panelCalendario = new JPanel();
			panelCalendario.setVisible(false);
			panelCalendario.setOpaque(false);
			panelCalendario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calendario de Juegos", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
			panelCalendario.setBounds(696, 28, 644, 240);
			contentPane.add(panelCalendario);
			panelCalendario.setLayout(null);
			{
				scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(10, 56, 624, 127);
				scrollPane.getViewport().setBackground(Color.white);
				panelCalendario.add(scrollPane);
				{
					model = new DefaultTableModel();
					String[] headers = {"No Partido", "Fecha de Juego", "Equipo Local", "Equipo Visitante", "Estadio"};
					model.setColumnIdentifiers(headers);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int seleccion = table.getSelectedRow();
							if (seleccion != -1) {
								btnIniciar.setEnabled(true);
								btnEliminar.setEnabled(true);
								btnRepro.setEnabled(true);
								game = Liga.getInstance().buscarPartidoPorNumero((int)model.getValueAt(seleccion, 0));
								letsPlay = (String) model.getValueAt(seleccion, 1);
							}
						}
					});
					table.setGridColor(new Color(204, 204, 204));
					table.setForeground(Color.BLACK);
					table.setFont(new Font("Tahoma", Font.PLAIN, 13));
					table.setModel(model);
					table.getTableHeader().setBackground(Color.WHITE);
					table.getTableHeader().setForeground(Color.BLACK);
					table.setBackground(Color.WHITE);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
			{
				cbxDate = new JComboBox<String>();
				cbxDate.setBackground(Color.WHITE);
				cbxDate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (cbxDate.getSelectedIndex() > 0) {
							int i = 1;
							calendarioPartidos(i);
						} else {
							int i = 0;
							calendarioPartidos(i);
						}
					}
				});
				cbxDate.setFont(new Font("Tahoma", Font.BOLD, 11));
				cbxDate.setModel(new DefaultComboBoxModel<String>(new String[] {"<Todos>", "Hoy"}));
				cbxDate.setBounds(135, 19, 93, 26);
				panelCalendario.add(cbxDate);
			}
			{
				lblMostrarPartidos = new JLabel("Mostrar Partidos:");
				lblMostrarPartidos.setForeground(Color.WHITE);
				lblMostrarPartidos.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMostrarPartidos.setBounds(10, 25, 107, 15);
				panelCalendario.add(lblMostrarPartidos);
			}
			{
				btnIniciar = new JButton("  Jugar Partido!");
				btnIniciar.setEnabled(false);
				btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnIniciar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Date last = parseFecha(letsPlay);
				        Date ahora = new Date();
				        if (ahora.after(last)) {
							btnEliminar.setEnabled(false);
							btnRepro.setEnabled(false);
							btnIniciar.setEnabled(false);
				        	panelCalendario.setVisible(false);
				        	AlineacionJuego aliJue = new AlineacionJuego(game);
				        	aliJue.setVisible(true);
				        } else {
				         	JOptionPane.showMessageDialog(null, "Debe esperar la fecha del partido", "Partido No: "+game.getNoPartido()+" - "+game.getLocal().getNombre()+" vs "+game.getVisitante().getNombre(), JOptionPane.INFORMATION_MESSAGE);
				         	btnEliminar.setEnabled(false);
							btnRepro.setEnabled(false);
							btnIniciar.setEnabled(false);
				        }
				        
					}
				});
				btnIniciar.setBackground(Color.WHITE);
				btnIniciar.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/pitcher.png")));
				btnIniciar.setBounds(455, 198, 179, 31);
				panelCalendario.add(btnIniciar);
			}
			{
				btnEsconder = new JButton("");
				btnEsconder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelCalendario.setVisible(false);
					}
				});
				btnEsconder.setToolTipText("Ocultar Calendario de Juegos");
				btnEsconder.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/Minimizar.png")));
				btnEsconder.setBackground(Color.WHITE);
				btnEsconder.setBounds(591, 12, 43, 33);
				panelCalendario.add(btnEsconder);
			}
			{
				btnRepro = new JButton("Reprogramar Partido");
				btnRepro.setEnabled(false);
				btnRepro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea reprogramar este partido?", "Partido No: "+game.getNoPartido()+" - "+game.getLocal().getNombre()+" vs "+game.getVisitante().getNombre(), JOptionPane.WARNING_MESSAGE);
						if (option == JOptionPane.OK_OPTION) {
							try {
								ReprogramarPartido reproPart = new ReprogramarPartido(game);
								reproPart.setVisible(true);
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							//calendarioPartidos(0);
							//cbxDate.setSelectedIndex(0);
							btnEliminar.setEnabled(false);
							btnRepro.setEnabled(false);
							btnIniciar.setEnabled(false);
							game = null;
							letsPlay = null;
						} else {
							btnEliminar.setEnabled(false);
							btnRepro.setEnabled(false);
							btnIniciar.setEnabled(false);
						}
					}
				});
				btnRepro.setBackground(Color.WHITE);
				btnRepro.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnRepro.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/change.png")));
				btnRepro.setBounds(231, 198, 179, 31);
				panelCalendario.add(btnRepro);
			}
			{
				btnEliminar = new JButton("  Eliminar Partido");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este partido?", "Partido No: "+game.getNoPartido()+" - "+game.getLocal().getNombre()+" vs "+game.getVisitante().getNombre(), JOptionPane.WARNING_MESSAGE);
						if (option == JOptionPane.OK_OPTION) {
							Liga.getInstance().eliminarPartido(game);
							calendarioPartidos(0);
							cbxDate.setSelectedIndex(0);
							btnEliminar.setEnabled(false);
							btnRepro.setEnabled(false);
							btnIniciar.setEnabled(false);
							game = null;
							letsPlay = null;
						} else {
							btnEliminar.setEnabled(false);
							btnRepro.setEnabled(false);
							btnIniciar.setEnabled(false);
						}
					}
				});
				btnEliminar.setBackground(Color.WHITE);
				btnEliminar.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/eliminar.png")));
				btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnEliminar.setBounds(10, 198, 179, 31);
				panelCalendario.add(btnEliminar);
			}
		}
		{
			lbl1 = new JLabel("");
			lbl1.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/estadio.jpg")));
			lbl1.setBounds(0, -50, 1366, 768);
			lbl1.setFont(new Font("Tahoma", Font.PLAIN, 67));
			contentPane.add(lbl1);
		}
		{
			lbl2 = new JLabel("");
			lbl2.setVisible(false);
			lbl2.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/baseballWallpepar.jpg")));
			lbl2.setBounds(0, -83, 1370, 856);
			contentPane.add(lbl2);
		}
		{
			lbl3 = new JLabel("");
			lbl3.setVisible(false);
			lbl3.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/hitterWallpaper.jpg")));
			lbl3.setBounds(-25, 1, 1400, 700);
			contentPane.add(lbl3);
		}
		{
			lbl4 = new JLabel("");
			lbl4.setVisible(false);
			lbl4.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/DRGamr.jpg")));
			lbl4.setBounds(-5, -45, 1370, 771);
			contentPane.add(lbl4);
		}
		{
			lbl5 = new JLabel("");
			lbl5.setVisible(false);
			lbl5.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/anotherballWallpaper.jpg")));
			lbl5.setBounds(-3, -122, 1370, 913);
			contentPane.add(lbl5);
		}
	}

	public static void wallpaperone() {
		lbl1.setVisible(true);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
	}
	public static void wallpapertwo() {
		lbl1.setVisible(false);
		lbl2.setVisible(true);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
	}
	public static void wallpaperthree() {
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(true);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
	}
	public static void wallpaperfour() {
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(true);
		lbl5.setVisible(false);
	}
	public static void wallpaperfive() {
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(true);
	}
	
	public void verificacionlesiones() {
		for (Jugador player : Liga.getInstance().getListaJugadores()) {
			player.verificarLesion();
		}
	}
	
	public void calendarioPartidos(int caso) {
		model.setRowCount(0);
		filas = new Object[model.getColumnCount()];
		String df = "dd-MM-yyyy"; 
        SimpleDateFormat form = new SimpleDateFormat(df);
        DateFormat dateFormat = new SimpleDateFormat(df);
        String diaHoy = dateFormat.format(new Date());
        
        switch (caso) {
		case 0:
			for (Partido game : Liga.getInstance().getListaPartidos()) {
				if (!game.isTerminado()) {
					filas[0] = game.getNoPartido();
					filas[1] = form.format(game.getFechaJuego())+" "+game.getHoraJuego();
					filas[2] = game.getLocal().getNombre();
					filas[3] = game.getVisitante().getNombre();
					filas[4] = game.getEstadio();
					model.addRow(filas);
				}
			}
			break;
		case 1:
			for (Partido game : Liga.getInstance().getListaPartidos()) {
				if (!game.isTerminado() && diaHoy.equals(form.format(game.getFechaJuego()))) {
					filas[0] = game.getNoPartido();
					filas[1] = form.format(game.getFechaJuego())+" "+game.getHoraJuego();
					filas[2] = game.getLocal().getNombre();
					filas[3] = game.getVisitante().getNombre();
					filas[4] = game.getEstadio();
					model.addRow(filas);
				}
			}
			break;
		default:
			break;
		}

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(23);
		columnModel.getColumn(4).setPreferredWidth(50);
		
	}
	
	public static Date parseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
}
