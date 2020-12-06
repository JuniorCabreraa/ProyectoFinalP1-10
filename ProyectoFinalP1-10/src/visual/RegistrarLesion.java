package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import logical.Equipo;
import logical.Jugador;
import logical.Lesion;
import logical.Liga;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class RegistrarLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> cbxEquipo;
	private JComboBox<String> cbxCategoria;
	private JComboBox<String> cbxJugador;
	private JTextArea txtDiag;
	private JFormattedTextField txtFecha;
	private Equipo team = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarLesion dialog = new RegistrarLesion();
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
	public RegistrarLesion() throws ParseException {
		setResizable(false);
		setModal(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				llenarCbxEquipos();
				txtFecha.grabFocus();
			}
		});
		setUndecorated(true);
		setBounds(100, 100, 507, 363);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 51, 51));
		contentPanel.setBorder(new LineBorder(new Color(204, 204, 204)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 102, 0));
			panel.setBounds(0, 0, 507, 47);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblInsertarLes = new JLabel("INSERTAR LESI\u00D3N");
				lblInsertarLes.setForeground(new Color(0, 0, 0));
				lblInsertarLes.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblInsertarLes.setBounds(37, 13, 155, 20);
				panel.add(lblInsertarLes);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				lblNewLabel.setIcon(new ImageIcon(RegistrarLesion.class.getResource("/Imagenes/Salir.png")));
				lblNewLabel.setBounds(472, 11, 25, 25);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon(RegistrarLesion.class.getResource("/Imagenes/med.png")));
				lblNewLabel_1.setBounds(10, 11, 25, 25);
				panel.add(lblNewLabel_1);
			}
		}
		{
			JLabel lblEquipo = new JLabel("Equipo:");
			lblEquipo.setForeground(new Color(255, 255, 255));
			lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEquipo.setBounds(32, 76, 47, 15);
			contentPanel.add(lblEquipo);
		}
		{
			JLabel lblJugador = new JLabel("Jugador:");
			lblJugador.setForeground(new Color(255, 255, 255));
			lblJugador.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblJugador.setBounds(32, 132, 54, 15);
			contentPanel.add(lblJugador);
		}
		{
			JLabel lblCategora = new JLabel("Categor\u00EDa:");
			lblCategora.setForeground(new Color(255, 255, 255));
			lblCategora.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCategora.setBounds(32, 188, 63, 15);
			contentPanel.add(lblCategora);
		}
		{
			JLabel lblDianstico = new JLabel("Dian\u00F3stico:");
			lblDianstico.setForeground(new Color(255, 255, 255));
			lblDianstico.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDianstico.setBounds(346, 76, 68, 15);
			contentPanel.add(lblDianstico);
		}
		{
			JLabel lblCulminacin = new JLabel("Culminaci\u00F3n:");
			lblCulminacin.setForeground(new Color(255, 255, 255));
			lblCulminacin.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCulminacin.setBounds(32, 246, 77, 15);
			contentPanel.add(lblCulminacin);
		}
		{
			MaskFormatter aux = new MaskFormatter("##/##/####");
			aux.setPlaceholderCharacter(' ');
			txtFecha = new JFormattedTextField(aux);
			txtFecha.setToolTipText("DD/MM/AAAA");
			txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtFecha.setBounds(119, 241, 122, 24);
			contentPanel.add(txtFecha);
		}
		{
			cbxEquipo = new JComboBox<String>();
			cbxEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (cbxEquipo.getSelectedIndex() > 0) {
						team = Liga.getInstance().buscarEquipoPorNombre(cbxEquipo.getSelectedItem().toString());
						llenarCbxJugadores();
					} else if (cbxEquipo.getSelectedIndex() == 0) {
						cbxJugador.removeAllItems();
						cbxJugador.addItem("<Seleccione>");
					}
				}
			});
			cbxEquipo.setBackground(Color.WHITE);
			cbxEquipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbxEquipo.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
			cbxEquipo.setBounds(120, 71, 122, 24);
			contentPanel.add(cbxEquipo);
		}
		{
			cbxCategoria = new JComboBox<String>();
			cbxCategoria.setBackground(Color.WHITE);
			cbxCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbxCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Cabeza", "Hombro", "Brazo", "Espalda", "Pierna", "Pie"}));
			cbxCategoria.setBounds(119, 183, 122, 24);
			contentPanel.add(cbxCategoria);
		}
		{
			cbxJugador = new JComboBox<String>();
			cbxJugador.setBackground(Color.WHITE);
			cbxJugador.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbxJugador.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
			cbxJugador.setBounds(119, 127, 122, 24);
			contentPanel.add(cbxJugador);
		}
		{
			txtDiag = new JTextArea();
			txtDiag.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtDiag.setBorder(new LineBorder(new Color(0, 0, 0)));
			txtDiag.setLineWrap(true);
			txtDiag.setBounds(303, 102, 164, 159);
			contentPanel.add(txtDiag);
		}
		{
			JButton btnSave = new JButton("Guardar");
			btnSave.setBackground(new Color(255, 255, 255));
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Jugador player = null;
					Lesion broken = null;
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			        Date culmi = null;
					
					if (cbxCategoria.getSelectedIndex() == 0 || cbxEquipo.getSelectedIndex() == 0 || cbxJugador.getSelectedIndex() == 0 || txtDiag.getText().isEmpty() || txtDiag.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por Favor Completar Campos", null, JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							culmi = formato.parse(txtFecha.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1, "Error Parseando Fecha", JOptionPane.ERROR_MESSAGE);
						}
						player = Liga.getInstance().buscarJugadorPorNombre(cbxJugador.getSelectedItem().toString());
						broken = new Lesion(player, team, cbxCategoria.getSelectedItem().toString(), txtDiag.getText(), culmi);
						if (player.insertarLesion(broken) == true) {
							JOptionPane.showMessageDialog(null, "Lesión Agregada", null, JOptionPane.WARNING_MESSAGE);
							clean();
						}
					}
				}
			});
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSave.setIcon(new ImageIcon(RegistrarLesion.class.getResource("/Imagenes/add.png")));
			btnSave.setBounds(205, 292, 122, 31);
			contentPanel.add(btnSave);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(204, 204, 204)));
			buttonPane.setBackground(new Color(51, 51, 51));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	public void clean() {
		cbxCategoria.setSelectedIndex(0);
		cbxEquipo.setSelectedIndex(0);
		cbxJugador.setSelectedIndex(0);
		txtDiag.setText(null);
		txtFecha.setText(null);
		team = null;
		txtDiag.grabFocus();
	}

	public void llenarCbxEquipos() {
		for (Equipo tea : Liga.getInstance().getListaEquipos()) {
			cbxEquipo.addItem(tea.getNombre());
		}
	}
	
	public void llenarCbxJugadores() {
		cbxJugador.removeAllItems();
		cbxJugador.addItem("<Seleccione>");
		for (Jugador player : team.getMisJugadores()) {
			if (player.isLesionado() == false) {
				cbxJugador.addItem(player.getNombre());
			}
		}
	}
}
