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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import logical.Liga;
import logical.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings("serial")
public class RegistrarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtPassRepeat;
	private JComboBox<String> cbxTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarUsuario dialog = new RegistrarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarUsuario() {
		setModal(true);
		setResizable(false);
		setUndecorated(true);
		setBounds(100, 100, 450, 263);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 51));
		contentPanel.setBorder(new LineBorder(new Color(204, 204, 204)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 51, 51)));
			panel.setBackground(SystemColor.window);
			panel.setBounds(0, 0, 450, 46);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblRegistrarUsuario = new JLabel("REGISTRAR USUARIO");
				lblRegistrarUsuario.setForeground(new Color(0, 0, 0));
				lblRegistrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblRegistrarUsuario.setBounds(37, 12, 180, 20);
				panel.add(lblRegistrarUsuario);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				lblNewLabel.setIcon(new ImageIcon(RegistrarUsuario.class.getResource("/Imagenes/Salir.png")));
				lblNewLabel.setBounds(415, 11, 25, 25);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon(RegistrarUsuario.class.getResource("/Imagenes/User.png")));
				lblNewLabel_1.setBounds(10, 11, 22, 22);
				panel.add(lblNewLabel_1);
			}
		}
		{
			JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
			lblNombreDeUsuario.setForeground(new Color(255, 255, 255));
			lblNombreDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNombreDeUsuario.setBounds(31, 68, 119, 15);
			contentPanel.add(lblNombreDeUsuario);
		}
		{
			JLabel lblTipoDeUsuario = new JLabel("Tipo de Usuario:");
			lblTipoDeUsuario.setForeground(new Color(255, 255, 255));
			lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTipoDeUsuario.setBounds(31, 141, 98, 15);
			contentPanel.add(lblTipoDeUsuario);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setForeground(new Color(255, 255, 255));
			lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblContrasea.setBounds(264, 68, 74, 15);
			contentPanel.add(lblContrasea);
		}
		{
			JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a:");
			lblConfirmarContrasea.setForeground(new Color(255, 255, 255));
			lblConfirmarContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblConfirmarContrasea.setBounds(264, 141, 138, 15);
			contentPanel.add(lblConfirmarContrasea);
		}
		{
			txtUser = new JTextField();
			txtUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtUser.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					if (txtUser.getText().length() >= 10) {
				         arg0.consume(); 
				    } 
				}
			});
			txtUser.setBounds(31, 94, 143, 24);
			contentPanel.add(txtUser);
			txtUser.setColumns(10);
		}
		{
			txtPass = new JTextField();
			txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPass.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (txtPass.getText().length() >= 8) {
				         e.consume(); 
				    } 
				}
			});
			txtPass.setBounds(264, 94, 143, 24);
			contentPanel.add(txtPass);
			txtPass.setColumns(10);
		}
		{
			txtPassRepeat = new JTextField();
			txtPassRepeat.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtPassRepeat.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (txtPassRepeat.getText().length() >= 8) {
				         e.consume(); 
				    } 
				}
			});
			txtPassRepeat.setBounds(264, 168, 143, 24);
			contentPanel.add(txtPassRepeat);
			txtPassRepeat.setColumns(10);
		}
		{
			cbxTipo = new JComboBox<String>();
			cbxTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
			cbxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Administrador", "Invitado"}));
			cbxTipo.setBounds(31, 168, 143, 24);
			contentPanel.add(cbxTipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(204, 204, 204)));
			buttonPane.setBackground(new Color(0, 51, 51));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGuardar = new JButton("    Guardar    ");
				btnGuardar.setBackground(new Color(255, 255, 255));
				btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnGuardar.setIcon(new ImageIcon(RegistrarUsuario.class.getResource("/Imagenes/add.png")));
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario user = null;
						String aux = null;
						for (Usuario i : Liga.getInstance().getListaUsuarios()) {
							if (i.getUsername().equalsIgnoreCase(txtUser.getText())) {
								aux = i.getUsername();
							}
						}
						
						if (txtUser.getText().isEmpty() || txtPass.getText().isEmpty() || txtPassRepeat.getText().isEmpty() || cbxTipo.getSelectedIndex() == 0) {
							JOptionPane.showMessageDialog(null, "Por Favor Completar Campos", null, JOptionPane.ERROR_MESSAGE);
						} else {
							if ((txtPass.getText().equals(txtPassRepeat.getText())) && (aux == null)) {
								user = new Usuario(txtUser.getText(), txtPassRepeat.getText(), cbxTipo.getSelectedItem().toString());
								Liga.getInstance().insertarUsuario(user);
								JOptionPane.showMessageDialog(null, "Agregado Satisfactoriamente", null, JOptionPane.WARNING_MESSAGE);
								clean();
							}
						}
					}
				});
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(30);
				buttonPane.add(horizontalStrut);
			}
		}
	}

	public void clean() {
		txtUser.setText(null);
		txtPass.setText(null);
		txtPassRepeat.setText(null);
		cbxTipo.setSelectedIndex(0);
		txtUser.grabFocus();
	}

}
