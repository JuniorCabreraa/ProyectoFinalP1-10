package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import logical.Equipo;
import logical.Liga;
import logical.Partido;

import java.awt.event.ActionListener;
import java.text.DateFormat;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;

@SuppressWarnings("serial")
public class RegistrarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNum;
	private JTextField txtEstadio;
	private JFormattedTextField txtFecha;
	private JComboBox<String> cbxLocal;
	private JComboBox<String> cbxVisitante;
	private JSpinner spnHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPartido dialog = new RegistrarPartido();
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
	public RegistrarPartido() throws ParseException {
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
		setBounds(100, 100, 526, 291);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new LineBorder(new Color(204, 204, 204)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(51, 153, 153));
			panel.setBounds(0, 0, 526, 43);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblInsertarPartido = new JLabel("INSERTAR PARTIDO");
				lblInsertarPartido.setForeground(new Color(0, 0, 0));
				lblInsertarPartido.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblInsertarPartido.setBounds(42, 11, 168, 20);
				panel.add(lblInsertarPartido);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				lblNewLabel.setIcon(new ImageIcon(RegistrarPartido.class.getResource("/Imagenes/Salir.png")));
				lblNewLabel.setBounds(491, 11, 25, 25);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setIcon(new ImageIcon(RegistrarPartido.class.getResource("/Imagenes/estadioteam.png")));
				lblNewLabel_1.setBounds(10, 11, 22, 22);
				panel.add(lblNewLabel_1);
			}
		}
		{
			JLabel lblNoPartido = new JLabel("No. Partido:");
			lblNoPartido.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNoPartido.setBounds(28, 64, 73, 15);
			contentPanel.add(lblNoPartido);
		}
		{
			JLabel lblFecha = new JLabel("Fecha:");
			lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblFecha.setBounds(316, 64, 38, 15);
			contentPanel.add(lblFecha);
		}
		{
			JLabel lblLocal = new JLabel("Equipo Local:");
			lblLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblLocal.setBounds(28, 119, 81, 15);
			contentPanel.add(lblLocal);
		}
		{
			JLabel lblEquipoVisitante = new JLabel("Equipo Visitante:");
			lblEquipoVisitante.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEquipoVisitante.setBounds(28, 174, 104, 15);
			contentPanel.add(lblEquipoVisitante);
		}
		{
			JLabel lblEstadio = new JLabel("Estadio:");
			lblEstadio.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEstadio.setBounds(316, 174, 49, 15);
			contentPanel.add(lblEstadio);
		}
		{
			txtNum = new JTextField();
			txtNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNum.setText(""+(Liga.getInstance().getCantPartidos()+1));
			txtNum.setEditable(false);
			txtNum.setBounds(142, 59, 118, 24);
			contentPanel.add(txtNum);
			txtNum.setColumns(10);
		}
		{
			MaskFormatter aux = new MaskFormatter("##/##/####");
			aux.setPlaceholderCharacter(' ');
			txtFecha = new JFormattedTextField(aux);
			txtFecha.setToolTipText("DD/MM/AAAA");
			txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtFecha.setBounds(376, 59, 118, 24);
			contentPanel.add(txtFecha);
		}
		{
			cbxLocal = new JComboBox<String>();
			cbxLocal.setBackground(Color.WHITE);
			cbxLocal.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					Equipo team = null;
					team = Liga.getInstance().buscarEquipoPorNombre(cbxLocal.getSelectedItem().toString());
					txtEstadio.setText(""+team.getEstadio());
				}
			});
			cbxLocal.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
			cbxLocal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbxLocal.setBounds(142, 114, 118, 24);
			contentPanel.add(cbxLocal);
		}
		{
			cbxVisitante = new JComboBox<String>();
			cbxVisitante.setBackground(Color.WHITE);
			cbxVisitante.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccione>"}));
			cbxVisitante.setFont(new Font("Tahoma", Font.PLAIN, 12));
			cbxVisitante.setBounds(142, 169, 118, 24);
			contentPanel.add(cbxVisitante);
		}
		{
			txtEstadio = new JTextField();
			txtEstadio.setEditable(false);
			txtEstadio.setBounds(376, 169, 118, 24);
			contentPanel.add(txtEstadio);
			txtEstadio.setColumns(10);
		}
		{
			JButton btnSave = new JButton("Guardar");
			btnSave.setToolTipText("");
			btnSave.setBackground(new Color(255, 255, 255));
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Partido game = null;
					Equipo visitante = null;
					Equipo local = null;
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
			        Date inicia = null;
					
					if (cbxLocal.getSelectedIndex() == 0 || cbxVisitante.getSelectedIndex() == 0 || txtEstadio.getText().isEmpty() || txtFecha.getText().isEmpty() || txtNum.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Por Favor Completar Campos", null, JOptionPane.ERROR_MESSAGE);
					} else {
						try {
							inicia = formato.parse(txtFecha.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1, "Error Parseando Fecha", JOptionPane.ERROR_MESSAGE);
						}
						local = Liga.getInstance().buscarEquipoPorNombre(cbxLocal.getSelectedItem().toString());
						visitante = Liga.getInstance().buscarEquipoPorNombre(cbxVisitante.getSelectedItem().toString());
						Date x = (Date)spnHora.getValue();
						String hora = dateFormat.format(x);
						game = new Partido((Liga.getInstance().getCantPartidos()+1), inicia, hora, local, visitante, txtEstadio.getText());
						Liga.getInstance().insertarPartido(game);
						JOptionPane.showMessageDialog(null, "Agregado Satisfactoriamente", null, JOptionPane.WARNING_MESSAGE);
						clean();
					}
				}
			});
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnSave.setIcon(new ImageIcon(RegistrarPartido.class.getResource("/Imagenes/add.png")));
			btnSave.setBounds(174, 233, 178, 31);
			contentPanel.add(btnSave);
		}
		{
			JLabel lblHora = new JLabel("Hora:");
			lblHora.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblHora.setBounds(316, 119, 49, 15);
			contentPanel.add(lblHora);
		}
		{
			spnHora = new JSpinner();
			spnHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
			//Date date = new Date(); 
			spnHora.setModel(new SpinnerDateModel(new Date(), null, new Date(), Calendar.AM_PM));
			JSpinner.DateEditor sp = new JSpinner.DateEditor(spnHora, "hh:mm a"); 
			spnHora.setEditor(sp);
			//spnHora.setValue(new Date());
			spnHora.setBounds(376, 114, 118, 24);
			contentPanel.add(spnHora);
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
		txtEstadio.setText(null);
		txtFecha.setText(null);
		txtNum.setText(""+(Liga.getInstance().getCantPartidos()+1));
		cbxLocal.setSelectedIndex(0);
		cbxVisitante.setSelectedIndex(0);
		txtFecha.grabFocus();
	}

	public void llenarCbxEquipos() {
		for (Equipo team : Liga.getInstance().getListaEquipos()) {
			cbxLocal.addItem(team.getNombre());
			cbxVisitante.addItem(team.getNombre());
		}
	}
}
