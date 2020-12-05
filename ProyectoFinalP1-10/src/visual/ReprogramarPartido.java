package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logical.Liga;
import logical.Partido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ReprogramarPartido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JTextField txtNum;
	private JLabel label_1;
	private JFormattedTextField txtFecha;
	private JLabel label_2;
	private JSpinner spnHora;
	private Component horizontalStrut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReprogramarPartido dialog = new ReprogramarPartido(null);
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
	public ReprogramarPartido(Partido juego) throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReprogramarPartido.class.getResource("/Imagenes/change.png")));
		setResizable(false);
		setModal(true);
		setTitle("Reprogramar Partido");
		setBounds(100, 100, 274, 296);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(11, 11, 236, 188);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				label = new JLabel("No. Partido:");
				label.setFont(new Font("Tahoma", Font.BOLD, 12));
				label.setBounds(10, 29, 73, 15);
				panel.add(label);
			}
			{
				txtNum = new JTextField();
				txtNum.setText(""+juego.getNoPartido());
				txtNum.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtNum.setEditable(false);
				txtNum.setColumns(10);
				txtNum.setBounds(93, 25, 118, 24);
				panel.add(txtNum);
			}
			{
				label_1 = new JLabel("Fecha:");
				label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				label_1.setBounds(10, 84, 38, 15);
				panel.add(label_1);
			}
			{
				MaskFormatter aux = new MaskFormatter("##/##/####");
				aux.setPlaceholderCharacter(' ');
				txtFecha = new JFormattedTextField(aux);
				txtFecha.setToolTipText("DD/MM/AAAA");
				txtFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtFecha.setBounds(93, 80, 118, 24);
				panel.add(txtFecha);
			}
			{
				label_2 = new JLabel("Hora:");
				label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
				label_2.setBounds(10, 139, 49, 15);
				panel.add(label_2);
			}
			{
				spnHora = new JSpinner();
				spnHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
				spnHora.setModel(new SpinnerDateModel());
				JSpinner.DateEditor sp = new JSpinner.DateEditor(spnHora, "hh:mm a"); 
				spnHora.setEditor(sp);
				spnHora.setValue(new Date());
				spnHora.setBounds(93, 135, 118, 24);
				panel.add(spnHora);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Reprogramar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Partido etesi = null;
						if (txtFecha.getText().contentEquals("  /  /    ")) {
							JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS", null, JOptionPane.ERROR_MESSAGE);
						} else {
							SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
							DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
					        Date inicia = null;
					        try {
								inicia = formato.parse(txtFecha.getText());
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(null, e1, "Error Parseando Fecha", JOptionPane.ERROR_MESSAGE);
							}
					        Date x = (Date)spnHora.getValue();
							String hora = dateFormat.format(x);
							etesi = new Partido(juego.getNoPartido(), inicia, hora, juego.getLocal(), juego.getVisitante(), juego.getEstadio());
							Liga.getInstance().eliminarPartido(juego);
							Liga.getInstance().insertarPartido(etesi);
							JOptionPane.showMessageDialog(null, "Reprogramado Satisfactoriamente", null, JOptionPane.WARNING_MESSAGE);
							dispose();
						}
					}
				});
				okButton.setBackground(Color.WHITE);
				okButton.setIcon(new ImageIcon(ReprogramarPartido.class.getResource("/Imagenes/modify.png")));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				horizontalStrut = Box.createHorizontalStrut(50);
				buttonPane.add(horizontalStrut);
			}
		}
	}
}
