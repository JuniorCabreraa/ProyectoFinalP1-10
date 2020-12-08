package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import logical.Equipo;
import logical.Liga;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ModificarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblEstadio;
	private JLabel lblCiudad;
	private JLabel lblManager;
	private JTextField txtNombre;
	private JTextField txtEstadio;
	private JTextField txtCiudad;
	private JTextField txtManager;
	private JLabel lblNewLabel_2;
	private JButton btnSave;
	private JLabel lblNewLabel_3;
	private Equipo team = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarEquipo dialog = new ModificarEquipo(null);
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
	public ModificarEquipo(Equipo equip) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtEstadio.grabFocus();
				txtNombre.setText(equip.getNombre());
				txtCiudad.setText(equip.getCiudad());
				txtEstadio.setText(equip.getEstadio());
				txtManager.setText(equip.getManager());
			}
		});
		team = equip;
		setModal(true);
		setResizable(false);
		setUndecorated(true);
		setBounds(100, 100, 508, 354);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new LineBorder(new Color(204, 204, 204)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(64, 64, 64));
			panel.setBounds(0, 0, 508, 47);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("MODIFICAR EQUIPO");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNewLabel.setBounds(45, 11, 165, 20);
				panel.add(lblNewLabel);
			}
			{
				lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				lblNewLabel_2.setIcon(new ImageIcon(ModificarEquipo.class.getResource("/Imagenes/Salir.png")));
				lblNewLabel_2.setBounds(473, 11, 25, 25);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(ModificarEquipo.class.getResource("/Imagenes/team.png")));
				lblNewLabel_3.setBounds(10, 8, 25, 25);
				panel.add(lblNewLabel_3);
			}
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNombre.setBounds(32, 76, 51, 15);
			contentPanel.add(lblNombre);
		}
		{
			lblEstadio = new JLabel("Estadio:");
			lblEstadio.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEstadio.setBounds(32, 130, 49, 15);
			contentPanel.add(lblEstadio);
		}
		{
			lblCiudad = new JLabel("Ciudad:");
			lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCiudad.setBounds(32, 189, 46, 15);
			contentPanel.add(lblCiudad);
		}
		{
			lblManager = new JLabel("Manager:");
			lblManager.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblManager.setBounds(32, 245, 57, 15);
			contentPanel.add(lblManager);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setForeground(Color.BLACK);
			txtNombre.setEnabled(false);
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtNombre.setBounds(94, 72, 351, 24);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtEstadio = new JTextField();
			txtEstadio.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtEstadio.setBounds(94, 125, 351, 24);
			contentPanel.add(txtEstadio);
			txtEstadio.setColumns(10);
		}
		{
			txtCiudad = new JTextField();
			txtCiudad.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtCiudad.setBounds(94, 184, 351, 24);
			contentPanel.add(txtCiudad);
			txtCiudad.setColumns(10);
		}
		{
			txtManager = new JTextField();
			txtManager.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtManager.setBounds(94, 240, 351, 24);
			contentPanel.add(txtManager);
			txtManager.setColumns(10);
		}
		{
			btnSave = new JButton("Modificar");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Equipo aux = null;
			        
					if (txtCiudad.getText().isEmpty() || txtEstadio.getText().isEmpty() || txtManager.getText().isEmpty() || txtNombre.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por Favor Completar Campos", null, JOptionPane.ERROR_MESSAGE);
					} else {
						aux = new Equipo(team.getCodigo(), team.getNombre(), txtEstadio.getText(), team.getFundacion(), txtCiudad.getText(), txtManager.getText());
						Liga.getInstance().insertarEquipo(aux);
						aux.getMisJugadores().addAll(team.getMisJugadores());
						aux.getMisLanzadores().addAll(team.getMisLanzadores());
						Liga.getInstance().eliminarEquipo(team);
						JOptionPane.showMessageDialog(null, "Modificado Satisfactoriamente", null, JOptionPane.WARNING_MESSAGE);
						clean();
						dispose();
					}
				}
			});
			btnSave.setBackground(new Color(255, 255, 255));
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSave.setIcon(new ImageIcon(ModificarEquipo.class.getResource("/Imagenes/add.png")));
			btnSave.setBounds(205, 291, 126, 31);
			contentPanel.add(btnSave);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(204, 204, 204)));
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	public void clean() {
		txtCiudad.setText(null);
		txtEstadio.setText(null);
		txtManager.setText(null);
		txtNombre.setText(null);
		txtEstadio.grabFocus();
	}
}