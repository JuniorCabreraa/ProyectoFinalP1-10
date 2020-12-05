package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import logical.Equipo;
import logical.Liga;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class RegistrarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNombre;
	private JLabel lblEstadio;
	private JLabel lblFundacin;
	private JLabel lblCiudad;
	private JLabel lblManager;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtEstadio;
	private JTextField txtCiudad;
	private JTextField txtManager;
	private JFormattedTextField txtFundacion;
	private JLabel lblNewLabel_2;
	private JButton btnSave;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarEquipo dialog = new RegistrarEquipo();
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
	public RegistrarEquipo() throws ParseException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtFundacion.grabFocus();
			}
		});
		setModal(true);
		setResizable(false);
		setUndecorated(true);
		setBounds(100, 100, 508, 410);
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
				lblNewLabel = new JLabel("INSERTAR EQUIPO");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNewLabel.setBounds(45, 11, 155, 20);
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
				lblNewLabel_2.setIcon(new ImageIcon(RegistrarEquipo.class.getResource("/Imagenes/Salir.png")));
				lblNewLabel_2.setBounds(473, 11, 25, 25);
				panel.add(lblNewLabel_2);
			}
			{
				lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(RegistrarEquipo.class.getResource("/Imagenes/team.png")));
				lblNewLabel_3.setBounds(10, 8, 25, 25);
				panel.add(lblNewLabel_3);
			}
		}
		{
			lblNewLabel_1 = new JLabel("C\u00F3digo:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setBounds(31, 80, 47, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNombre.setBounds(31, 131, 51, 15);
			contentPanel.add(lblNombre);
		}
		{
			lblEstadio = new JLabel("Estadio:");
			lblEstadio.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEstadio.setBounds(31, 185, 49, 15);
			contentPanel.add(lblEstadio);
		}
		{
			lblFundacin = new JLabel("Fundaci\u00F3n:");
			lblFundacin.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblFundacin.setBounds(267, 80, 66, 15);
			contentPanel.add(lblFundacin);
		}
		{
			lblCiudad = new JLabel("Ciudad:");
			lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCiudad.setBounds(31, 244, 46, 15);
			contentPanel.add(lblCiudad);
		}
		{
			lblManager = new JLabel("Manager:");
			lblManager.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblManager.setBounds(31, 300, 57, 15);
			contentPanel.add(lblManager);
		}
		{
			txtCodigo = new JTextField();
			txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCodigo.setText("LD-00"+(Liga.getInstance().getListaEquipos().size()+1));
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(93, 76, 101, 24);
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombre.setBounds(93, 127, 351, 24);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtEstadio = new JTextField();
			txtEstadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtEstadio.setBounds(93, 180, 351, 24);
			contentPanel.add(txtEstadio);
			txtEstadio.setColumns(10);
		}
		{
			txtCiudad = new JTextField();
			txtCiudad.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtCiudad.setBounds(93, 239, 351, 24);
			contentPanel.add(txtCiudad);
			txtCiudad.setColumns(10);
		}
		{
			txtManager = new JTextField();
			txtManager.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtManager.setBounds(93, 295, 351, 24);
			contentPanel.add(txtManager);
			txtManager.setColumns(10);
		}
		{
			MaskFormatter aux = new MaskFormatter("##/##/####");
			aux.setPlaceholderCharacter(' ');
			txtFundacion = new JFormattedTextField(aux);
			txtFundacion.setToolTipText("DD/MM/AAAA");
			txtFundacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtFundacion.setBounds(343, 75, 101, 24);
			contentPanel.add(txtFundacion);
		}
		{
			btnSave = new JButton("Guardar");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Equipo team = null;
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			        Date fund = null;
			        
					if (txtCiudad.getText().isEmpty() || txtCodigo.getText().isEmpty() || txtEstadio.getText().isEmpty() || txtFundacion.getText().isEmpty() || txtManager.getText().isEmpty() || txtNombre.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por Favor Completar Campos", null, JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							fund = formato.parse(txtFundacion.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1, "Error Parseando Fecha", JOptionPane.ERROR_MESSAGE);
						}
						team = new Equipo(txtCodigo.getText(), txtNombre.getText(), txtEstadio.getText(), fund, txtCiudad.getText(), txtManager.getText());
						Liga.getInstance().insertarEquipo(team);
						JOptionPane.showMessageDialog(null, "Agregado Satisfactoriamente", null, JOptionPane.WARNING_MESSAGE);
						clean();
					}
				}
			});
			btnSave.setBackground(new Color(255, 255, 255));
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSave.setIcon(new ImageIcon(RegistrarEquipo.class.getResource("/Imagenes/add.png")));
			btnSave.setBounds(196, 344, 126, 31);
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
		txtCodigo.setText("LD-00"+(Liga.getInstance().getListaEquipos().size()+1));
		txtEstadio.setText(null);
		txtFundacion.setText(null);
		txtManager.setText(null);
		txtNombre.setText(null);
		txtNombre.grabFocus();
	}
}
