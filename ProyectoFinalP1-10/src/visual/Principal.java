package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import logical.Liga;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings({ "unused", "serial" })
public class Principal extends JFrame {

	private JPanel contentPane;
	private static JLabel lbl1;
	private static JLabel lbl2;
	private JMenuBar menuBar;
	private static JLabel lbl3;
	private static JLabel lbl4;
	private static JLabel lbl5;
	private JMenu mnNewMenu;
	private JMenuItem mntmRegistrarUsuario;
	private JMenuItem mntmGuardarDatos;
	private JMenuItem mntmModificarUsuario;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem_7;
	private JMenu mnNewMenu_5;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;
	private JMenuItem mntmNewMenuItem_11;
	private JMenuItem mntmNewMenuItem_12;
	private JMenu mnNewMenu_6;
	private JMenu mnNewMenu_7;
	private JMenuItem mntmNewMenuItem_13;
	private JMenuItem mntmNewMenuItem_14;
	private JMenuItem mntmNewMenuItem_15;
	private JMenuItem mntmNewMenuItem_16;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Principal() {
		setBackground(Color.BLACK);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Wallpaper wp = new Wallpaper();
				wp.start();
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
				mnNewMenu = new JMenu("Usuario");
				mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/User.png")));
				menuBar.add(mnNewMenu);
				{
					mntmRegistrarUsuario = new JMenuItem("Registrar Nuevo Usuario");
					mntmRegistrarUsuario.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
					mnNewMenu.add(mntmRegistrarUsuario);
				}
				{
					mntmModificarUsuario = new JMenuItem("Modificar Usuario");
					mntmModificarUsuario.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/modify.png")));
					mnNewMenu.add(mntmModificarUsuario);
				}
				{
					mntmGuardarDatos = new JMenuItem("Guardar Datos");
					mntmGuardarDatos.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/save.png")));
					mnNewMenu.add(mntmGuardarDatos);
				}
			}
			{
				mnNewMenu_1 = new JMenu("Partidos");
				mnNewMenu_1.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/MLB-logo.jpg")));
				menuBar.add(mnNewMenu_1);
				{
					mnNewMenu_2 = new JMenu("Mostrar Partidos");
					mnNewMenu_2.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/bateador.png")));
					mnNewMenu_1.add(mnNewMenu_2);
					{
						mntmNewMenuItem = new JMenuItem("Por Jugar");
						mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/list.png")));
						mnNewMenu_2.add(mntmNewMenuItem);
					}
					{
						mntmNewMenuItem_1 = new JMenuItem("Terminados");
						mntmNewMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/list.png")));
						mnNewMenu_2.add(mntmNewMenuItem_1);
					}
					{
						mntmNewMenuItem_3 = new JMenuItem("Todos");
						mntmNewMenuItem_3.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/list.png")));
						mnNewMenu_2.add(mntmNewMenuItem_3);
					}
				}
				{
					mntmNewMenuItem_2 = new JMenuItem("Programar Partidos");
					mntmNewMenuItem_2.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
					mnNewMenu_1.add(mntmNewMenuItem_2);
				}
			}
			{
				mnNewMenu_3 = new JMenu("Equipos");
				mnNewMenu_3.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/team.png")));
				menuBar.add(mnNewMenu_3);
				{
					mntmNewMenuItem_4 = new JMenuItem("Crear Equipo");
					mntmNewMenuItem_4.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
					mnNewMenu_3.add(mntmNewMenuItem_4);
				}
				{
					mntmNewMenuItem_5 = new JMenuItem("Manejar Equipo");
					mntmNewMenuItem_5.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/modify.png")));
					mnNewMenu_3.add(mntmNewMenuItem_5);
				}
				{
					mntmNewMenuItem_6 = new JMenuItem("Mostrar Equipos");
					mntmNewMenuItem_6.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/list.png")));
					mnNewMenu_3.add(mntmNewMenuItem_6);
				}
			}
			{
				mnNewMenu_4 = new JMenu("Jugadores");
				mnNewMenu_4.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/players.png")));
				menuBar.add(mnNewMenu_4);
				{
					mntmNewMenuItem_7 = new JMenuItem("Crear Jugador");
					mntmNewMenuItem_7.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
					mnNewMenu_4.add(mntmNewMenuItem_7);
				}
				{
					mnNewMenu_5 = new JMenu("Manejar Jugador");
					mnNewMenu_5.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/modify.png")));
					mnNewMenu_4.add(mnNewMenu_5);
					{
						mntmNewMenuItem_8 = new JMenuItem("Insertar Lesi\u00F3n");
						mntmNewMenuItem_8.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/add.png")));
						mnNewMenu_5.add(mntmNewMenuItem_8);
					}
					{
						mntmNewMenuItem_9 = new JMenuItem("Verificar Lesi\u00F3n");
						mntmNewMenuItem_9.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/Search.png")));
						mnNewMenu_5.add(mntmNewMenuItem_9);
					}
					{
						mntmNewMenuItem_10 = new JMenuItem("Cambiar Equipo");
						mntmNewMenuItem_10.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/change.png")));
						mnNewMenu_5.add(mntmNewMenuItem_10);
					}
				}
				{
					mntmNewMenuItem_11 = new JMenuItem("Mostrar Jugadores");
					mntmNewMenuItem_11.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/list.png")));
					mnNewMenu_4.add(mntmNewMenuItem_11);
				}
				{
					mntmNewMenuItem_12 = new JMenuItem("Gr\u00E1fico Lesionados");
					mntmNewMenuItem_12.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/barsgraphic.png")));
					mnNewMenu_4.add(mntmNewMenuItem_12);
				}
			}
			{
				mnNewMenu_6 = new JMenu("Estad\u00EDsticas");
				mnNewMenu_6.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/barsgraphic.png")));
				menuBar.add(mnNewMenu_6);
				{
					mnNewMenu_7 = new JMenu("Jugadores");
					mnNewMenu_7.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/team.png")));
					mnNewMenu_6.add(mnNewMenu_7);
					{
						mntmNewMenuItem_13 = new JMenuItem("Top 10 Bateadores");
						mntmNewMenuItem_13.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/bateador.png")));
						mnNewMenu_7.add(mntmNewMenuItem_13);
					}
					{
						mntmNewMenuItem_14 = new JMenuItem("Top 10 Lanzadores");
						mntmNewMenuItem_14.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/pitcher.png")));
						mnNewMenu_7.add(mntmNewMenuItem_14);
					}
					{
						mntmNewMenuItem_15 = new JMenuItem("Todos los Jugadores");
						mntmNewMenuItem_15.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/players.png")));
						mnNewMenu_7.add(mntmNewMenuItem_15);
					}
				}
				{
					mntmNewMenuItem_16 = new JMenuItem("Equipos");
					mntmNewMenuItem_16.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/estadioteam.png")));
					mnNewMenu_6.add(mntmNewMenuItem_16);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
}
