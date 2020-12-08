package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logical.Bateador;
import logical.Equipo;
import logical.Jugador;
import logical.Lanzador;
import logical.Liga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.ComponentOrientation;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings({ "unused", "serial" })
public class ModificarJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtNombre;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblNoCamiseta;
	private JLabel lblLateralidad;
	private JLabel lblPosicin;
	private JSpinner spnAltura;
	private JSpinner spnPeso;
	private JSpinner spnCamiseta;
	private JCheckBox checkZurdo;
	private JCheckBox checkDiestro;
	private JCheckBox checkAmbidex;
	private JComboBox<String> cbxPosicion;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JButton btnSave;
	private Jugador jug = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModificarJugador dialog = new ModificarJugador(null);
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
	public ModificarJugador(Jugador juga){
		setResizable(false);
		setModal(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				txtNombre.grabFocus();
				txtNombre.setText(juga.getNombre());
			}
		});
		jug = juga;
		setUndecorated(true);
		setBounds(100, 100, 575, 346);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 102));
		contentPanel.setBorder(new LineBorder(new Color(204, 204, 204)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(204, 0, 0));
			panel.setBounds(0, 0, 575, 43);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel_1 = new JLabel("MODIFICAR JUGADOR");
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNewLabel_1.setBounds(42, 12, 181, 20);
				panel.add(lblNewLabel_1);
			}
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(ModificarJugador.class.getResource("/Imagenes/bateador.png")));
			lblNewLabel_2.setBounds(10, 10, 22, 22);
			panel.add(lblNewLabel_2);
			{
				lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				lblNewLabel_3.setIcon(new ImageIcon(ModificarJugador.class.getResource("/Imagenes/Salir.png")));
				lblNewLabel_3.setBounds(540, 11, 25, 25);
				panel.add(lblNewLabel_3);
			}
		}
		{
			lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setForeground(new Color(204, 204, 204));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(37, 72, 61, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombre.setToolTipText("");
			txtNombre.setBounds(134, 68, 400, 24);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			lblAltura = new JLabel("Altura:");
			lblAltura.setForeground(new Color(204, 204, 204));
			lblAltura.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAltura.setBounds(37, 124, 61, 14);
			contentPanel.add(lblAltura);
		}
		{
			lblPeso = new JLabel("Peso:");
			lblPeso.setForeground(new Color(204, 204, 204));
			lblPeso.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPeso.setBounds(331, 124, 61, 14);
			contentPanel.add(lblPeso);
		}
		{
			lblNoCamiseta = new JLabel("No. Camiseta:");
			lblNoCamiseta.setForeground(new Color(204, 204, 204));
			lblNoCamiseta.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNoCamiseta.setBounds(331, 181, 113, 14);
			contentPanel.add(lblNoCamiseta);
		}
		{
			lblLateralidad = new JLabel("Lateralidad:");
			lblLateralidad.setForeground(new Color(204, 204, 204));
			lblLateralidad.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblLateralidad.setBounds(37, 242, 80, 14);
			contentPanel.add(lblLateralidad);
		}
		{
			lblPosicin = new JLabel("Posici\u00F3n:");
			lblPosicin.setForeground(new Color(204, 204, 204));
			lblPosicin.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPosicin.setBounds(37, 181, 61, 14);
			contentPanel.add(lblPosicin);
		}
		{
			spnAltura = new JSpinner();
			spnAltura.setToolTipText("Cent\u00EDmetros");
			spnAltura.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			spnAltura.setFont(new Font("Tahoma", Font.PLAIN, 12));
			spnAltura.setModel(new SpinnerNumberModel(150, 150, 250, 1));
			spnAltura.setBounds(134, 119, 103, 24);
			contentPanel.add(spnAltura);
		}
		{
			spnPeso = new JSpinner();
			spnPeso.setToolTipText("Libras");
			spnPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
			spnPeso.setModel(new SpinnerNumberModel(100, 100, 400, 1));
			spnPeso.setBounds(431, 119, 103, 24);
			contentPanel.add(spnPeso);
		}
		{
			spnCamiseta = new JSpinner();
			spnCamiseta.setFont(new Font("Tahoma", Font.PLAIN, 12));
			spnCamiseta.setModel(new SpinnerNumberModel(0, 0, 99, 1));
			spnCamiseta.setBounds(431, 176, 103, 24);
			contentPanel.add(spnCamiseta);
		}
		{
			checkZurdo = new JCheckBox("Zurdo");
			checkZurdo.setBackground(new Color(0, 51, 102));
			checkZurdo.setForeground(new Color(204, 204, 204));
			checkZurdo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkAmbidex.setSelected(false);
					checkDiestro.setSelected(false);
				}
			});
			checkZurdo.setHorizontalAlignment(SwingConstants.LEFT);
			checkZurdo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			checkZurdo.setBounds(465, 238, 69, 23);
			contentPanel.add(checkZurdo);
		}
		{
			checkDiestro = new JCheckBox("Diestro");
			checkDiestro.setBackground(new Color(0, 51, 102));
			checkDiestro.setForeground(new Color(204, 204, 204));
			checkDiestro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkAmbidex.setSelected(false);
					checkZurdo.setSelected(false);
				}
			});
			checkDiestro.setFont(new Font("Tahoma", Font.PLAIN, 12));
			checkDiestro.setBounds(307, 238, 69, 23);
			contentPanel.add(checkDiestro);
		}
		{
			checkAmbidex = new JCheckBox("Ambidextro");
			checkAmbidex.setForeground(new Color(204, 204, 204));
			checkAmbidex.setBackground(new Color(0, 51, 102));
			checkAmbidex.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkDiestro.setSelected(false);
					checkZurdo.setSelected(false);
				}
			});
			checkAmbidex.setFont(new Font("Tahoma", Font.PLAIN, 12));
			checkAmbidex.setBounds(134, 238, 89, 23);
			contentPanel.add(checkAmbidex);
		}
		{
			cbxPosicion = new JComboBox<String>();
			cbxPosicion.setBackground(Color.WHITE);
			cbxPosicion.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>", "Pitcher", "Catcher", "1B", "2B", "3B", "SS", "LF", "CF", "RF"}));
			cbxPosicion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbxPosicion.setBounds(134, 176, 103, 24);
			contentPanel.add(cbxPosicion);
		}
		{
			btnSave = new JButton("Modificar");
			btnSave.setBackground(new Color(255, 255, 255));
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSave.setIcon(new ImageIcon(ModificarJugador.class.getResource("/Imagenes/add.png")));
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        String lateralidad = null;
			        Jugador player = null;
			        Equipo team = null;
			        if (checkAmbidex.isSelected()) {
						lateralidad = "Ambidextro";
					} else if (checkDiestro.isSelected()) {
						lateralidad = "Diestro";
					} else if (checkZurdo.isSelected()) {
						lateralidad = "Zurdo";
					}
			        
					if (txtNombre.getText().isEmpty() || cbxPosicion.getSelectedIndex() == 0 || (!checkAmbidex.isSelected() && !checkDiestro.isSelected() && !checkZurdo.isSelected()) ) {
						JOptionPane.showMessageDialog(null, "Por Favor Completar Campos", null, JOptionPane.ERROR_MESSAGE);
					} else {
						team = jug.getEquipo();
						if (cbxPosicion.getSelectedIndex() == 1) {
							player = new Lanzador(txtNombre.getText(), jug.getNacimiento(), Integer.valueOf(spnAltura.getValue().toString()), Integer.valueOf(spnPeso.getValue().toString()), Integer.valueOf(spnCamiseta.getValue().toString()), lateralidad, cbxPosicion.getSelectedItem().toString(), team);
							team.eliminarJugador(jug);
							if (team.verificarNoCami(player) == false) {
								if (team.getMisJugadores().size() < 25) {
									if (jug instanceof Lanzador) {
										team.eliminarLanzador((Lanzador) jug);
									}
									team.eliminarJugadorAlineacion(jug);
									team.insertarJugador(player);
									team.insertarLanzador((Lanzador) player);
									Liga.getInstance().eliminarJugador(jug);
									JOptionPane.showMessageDialog(null, "Modificado Satisfactoriamente", null, JOptionPane.WARNING_MESSAGE);
									clean();
									dispose();
								} else {
									JOptionPane.showMessageDialog(null, "Límite de Jugadores por Equipo Alcanzado" , null, JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Número de Camiseta No Disponible" , null, JOptionPane.ERROR_MESSAGE);
							}
						} else if (cbxPosicion.getSelectedIndex() != 1){
							player = new Bateador(txtNombre.getText(), jug.getNacimiento(), Integer.valueOf(spnAltura.getValue().toString()), Integer.valueOf(spnPeso.getValue().toString()), Integer.valueOf(spnCamiseta.getValue().toString()), lateralidad, cbxPosicion.getSelectedItem().toString(), team);
							team.eliminarJugador(jug);
							if (team.verificarNoCami(player) == false) {
								if (team.getMisJugadores().size() < 25) {
									if (jug instanceof Lanzador) {
										team.eliminarLanzador((Lanzador) jug);
									}
									team.eliminarJugadorAlineacion(jug);
									team.insertarJugador(player);
									Liga.getInstance().eliminarJugador(jug);
									JOptionPane.showMessageDialog(null, "Modificado Satisfactoriamente", null, JOptionPane.WARNING_MESSAGE);
									clean();
									dispose();
								} else {
									JOptionPane.showMessageDialog(null, "Límite de Jugadores por Equipo Alcanzado" , null, JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Número de Camiseta No Disponible" , null, JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			});
			btnSave.setBounds(243, 282, 121, 31);
			contentPanel.add(btnSave);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(255, 255, 255)));
			buttonPane.setBackground(new Color(0, 51, 102));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			}
		}
	}
	
	public void clean() {
		txtNombre.setText(null);
		spnAltura.setValue(Integer.valueOf("150"));
		spnCamiseta.setValue(Integer.valueOf("0"));
		spnPeso.setValue(Integer.valueOf("100"));
		cbxPosicion.setSelectedIndex(0);
		checkAmbidex.setSelected(false);
		checkDiestro.setSelected(false);
		checkZurdo.setSelected(false);
		txtNombre.grabFocus();
	}
}
