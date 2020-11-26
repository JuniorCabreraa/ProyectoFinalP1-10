package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Liga;
import logical.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Sesion extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JSeparator separator;
	private JButton btnSalir;
	private JButton btnMinimizar;
	private JLabel lblNewLabel_2;
	private JTextField textUser;
	private JLabel lblNewLabel_3;
	private JPasswordField txtPassword;
	private JButton btnIngresar;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream data;
				ObjectInputStream dataObj;
				
				try {
					data = new FileInputStream("Data.dat");
					dataObj = new ObjectInputStream(data);
					Liga aux = (Liga) dataObj.readObject();
					Liga.setLeague(aux);
					data.close();
					dataObj.close();
					
				} catch (FileNotFoundException e) {
					try {
						Usuario user = new Usuario("Admin", "Admin", "Administrador");
						Liga.getInstance().insertarUsuario(user);
						Liga.getInstance().saveData();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2, "Login Admin", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Sesion frame = new Sesion();
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
	public Sesion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sesion.class.getResource("/Imagenes/Llave.png")));
		setUndecorated(true);
		setFont(new Font("Times New Roman", Font.PLAIN, 14));
		setBackground(new Color(0, 0, 51));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 398);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnIngresar = new JButton("Iniciar Sesi\u00F3n");
			btnIngresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String user = textUser.getText();
					String password = new String(txtPassword.getPassword());
					if (Liga.getInstance().confirmLogin(user, password)) {
						Principal main = new Principal();
						main.setVisible(true);
						Liga.getInstance().reproducirSonido("src/Sonidos/trompeta.wav");
						dispose();
					} else {
						Liga.getInstance().reproducirSonido("src/Sonidos/error.wav");
						lblError.setText("Usuario o Contraseña Incorrecto");
						textUser.setText(null);
						txtPassword.setText(null);
					}
				}
			});
			{
				lblError = new JLabel("");
				lblError.setForeground(Color.RED);
				lblError.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblError.setBounds(414, 373, 177, 15);
				contentPane.add(lblError);
			}
			btnIngresar.setBackground(Color.WHITE);
			btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnIngresar.setIcon(new ImageIcon(Sesion.class.getResource("/Imagenes/IniciarSesion.png")));
			btnIngresar.setBounds(426, 319, 153, 43);
			contentPane.add(btnIngresar);
		}
		{
			txtPassword = new JPasswordField();
			txtPassword.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
			txtPassword.setBounds(407, 263, 190, 23);
			contentPane.add(txtPassword);
		}
		{
			lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_3.setBounds(450, 232, 99, 20);
			contentPane.add(lblNewLabel_3);
		}
		{
			textUser = new JTextField();
			textUser.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
			textUser.setBounds(407, 186, 190, 23);
			contentPane.add(textUser);
			textUser.setColumns(10);
		}
		{
			lblNewLabel_2 = new JLabel("Usuario:");
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_2.setBounds(465, 155, 68, 20);
			contentPane.add(lblNewLabel_2);
		}
		{
			btnMinimizar = new JButton("");
			btnMinimizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setExtendedState(JFrame.ICONIFIED);
				}
			});
			btnMinimizar.setBackground(new Color(255, 255, 255));
			btnMinimizar.setIcon(new ImageIcon(Sesion.class.getResource("/Imagenes/Minimizar.png")));
			btnMinimizar.setBounds(546, 11, 39, 33);
			contentPane.add(btnMinimizar);
		}
		{
			btnSalir = new JButton("");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setForeground(Color.WHITE);
			btnSalir.setBackground(new Color(255, 255, 255));
			btnSalir.setIcon(new ImageIcon(Sesion.class.getResource("/Imagenes/Salir.png")));
			btnSalir.setBounds(595, 11, 39, 33);
			contentPane.add(btnSalir);
		}
		{
			separator = new JSeparator();
			separator.setForeground(Color.WHITE);
			separator.setBackground(Color.WHITE);
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(340, 0, 2, 400);
			contentPane.add(separator);
		}
		{
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Sesion.class.getResource("/Imagenes/Login User.png")));
			lblNewLabel_1.setBounds(330, 0, 337, 400);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Sesion.class.getResource("/Imagenes/LOGIN LIGA.jpg")));
			lblNewLabel.setBounds(0, 0, 332, 400);
			contentPane.add(lblNewLabel);
		}
	}
}
