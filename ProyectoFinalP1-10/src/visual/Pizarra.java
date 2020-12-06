package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import logical.Partido;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings("serial")
public class Pizarra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JFormattedTextField txtCVis;
	private JFormattedTextField txtCLoc;
	private JFormattedTextField txtHVis;
	private JFormattedTextField txtHLoc;
	private JFormattedTextField txtEVis;
	private JFormattedTextField txtELoca;
	private JLabel lblVis;
	private JLabel lblLocal;
	private JLabel lblganador;
	private Partido gameP = null;
	private Component horizontalStrut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Pizarra dialog = new Pizarra(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Pizarra(Partido juego) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				lblganador.setText(""+gameP.ganador().getNombre());
				lblVis.setText(gameP.getVisitante().getNombre());
				lblLocal.setText(gameP.getLocal().getNombre());
				txtCVis.setText(""+gameP.getCarrerasVisitante());
				txtCLoc.setText(""+gameP.getCarrerasLocal());
				txtHVis.setText(""+gameP.getHitsVisitante());
				txtHLoc.setText(""+gameP.getHitsLocal());
				txtEVis.setText(""+gameP.getErroresVisitante());
				txtELoca.setText(""+gameP.getErroresLocal());
			}
		});
		gameP = juego;
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 389, 217);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(Color.WHITE));
			panel.setBackground(Color.BLACK);
			panel.setBounds(0, 0, 389, 44);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblNewLabel = new JLabel("GANADOR:");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
				lblNewLabel.setBounds(20, 9, 110, 23);
				panel.add(lblNewLabel);
			}
			{
				lblganador = new JLabel("");
				lblganador.setForeground(Color.WHITE);
				lblganador.setFont(new Font("Tahoma", Font.BOLD, 19));
				lblganador.setBounds(140, 9, 190, 23);
				panel.add(lblganador);
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new LineBorder(Color.WHITE));
			panel_1.setBackground(Color.BLACK);
			panel_1.setBounds(44, 55, 173, 88);
			contentPanel.add(panel_1);
			{
				separator = new JSeparator();
				separator.setForeground(Color.WHITE);
				separator.setBackground(Color.WHITE);
				separator.setBounds(1, 57, 171, 2);
				panel_1.add(separator);
			}
			{
				separator_1 = new JSeparator();
				separator_1.setForeground(Color.WHITE);
				separator_1.setBackground(Color.WHITE);
				separator_1.setBounds(1, 26, 171, 2);
				panel_1.add(separator_1);
			}
			{
				separator_2 = new JSeparator();
				separator_2.setOrientation(SwingConstants.VERTICAL);
				separator_2.setForeground(Color.WHITE);
				separator_2.setBackground(Color.WHITE);
				separator_2.setBounds(113, 3, 2, 90);
				panel_1.add(separator_2);
			}
			{
				separator_3 = new JSeparator();
				separator_3.setOrientation(SwingConstants.VERTICAL);
				separator_3.setForeground(Color.WHITE);
				separator_3.setBackground(Color.WHITE);
				separator_3.setBounds(59, 3, 2, 90);
				panel_1.add(separator_3);
			}
			{
				label = new JLabel("C");
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Tahoma", Font.BOLD, 21));
				label.setBounds(25, 0, 24, 32);
				panel_1.add(label);
			}
			{
				label_1 = new JLabel("H");
				label_1.setForeground(Color.WHITE);
				label_1.setFont(new Font("Tahoma", Font.BOLD, 21));
				label_1.setBounds(78, 0, 24, 32);
				panel_1.add(label_1);
			}
			{
				label_2 = new JLabel("E");
				label_2.setForeground(Color.WHITE);
				label_2.setFont(new Font("Tahoma", Font.BOLD, 21));
				label_2.setBounds(130, 0, 24, 32);
				panel_1.add(label_2);
			}
			{
				MaskFormatter aux = null;
				try {
					aux = new MaskFormatter("##");
					aux.setPlaceholder("00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtCVis = new JFormattedTextField(aux);
				txtCVis.setForeground(Color.WHITE);
				txtCVis.setFont(new Font("Tahoma", Font.PLAIN, 15));
				txtCVis.setEditable(false);
				txtCVis.setBorder(null);
				txtCVis.setBackground(Color.BLACK);
				txtCVis.setBounds(23, 32, 34, 20);
				panel_1.add(txtCVis);
			}
			{
				MaskFormatter aux = null;
				try {
					aux = new MaskFormatter("##");
					aux.setPlaceholder("00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtCLoc = new JFormattedTextField(aux);
				txtCLoc.setForeground(Color.WHITE);
				txtCLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
				txtCLoc.setEditable(false);
				txtCLoc.setBorder(null);
				txtCLoc.setBackground(Color.BLACK);
				txtCLoc.setBounds(23, 61, 34, 20);
				panel_1.add(txtCLoc);
			}
			{
				MaskFormatter aux = null;
				try {
					aux = new MaskFormatter("##");
					aux.setPlaceholder("00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtHVis = new JFormattedTextField(aux);
				txtHVis.setForeground(Color.WHITE);
				txtHVis.setFont(new Font("Tahoma", Font.PLAIN, 15));
				txtHVis.setEditable(false);
				txtHVis.setBorder(null);
				txtHVis.setBackground(Color.BLACK);
				txtHVis.setBounds(77, 32, 34, 20);
				panel_1.add(txtHVis);
			}
			{
				MaskFormatter aux = null;
				try {
					aux = new MaskFormatter("##");
					aux.setPlaceholder("00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtHLoc = new JFormattedTextField(aux);
				txtHLoc.setForeground(Color.WHITE);
				txtHLoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
				txtHLoc.setEditable(false);
				txtHLoc.setBorder(null);
				txtHLoc.setBackground(Color.BLACK);
				txtHLoc.setBounds(77, 61, 34, 20);
				panel_1.add(txtHLoc);
			}
			{
				MaskFormatter aux = null;
				try {
					aux = new MaskFormatter("##");
					aux.setPlaceholder("00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtEVis = new JFormattedTextField(aux);
				txtEVis.setForeground(Color.WHITE);
				txtEVis.setFont(new Font("Tahoma", Font.PLAIN, 15));
				txtEVis.setEditable(false);
				txtEVis.setBorder(null);
				txtEVis.setBackground(Color.BLACK);
				txtEVis.setBounds(129, 32, 34, 20);
				panel_1.add(txtEVis);
			}
			{
				MaskFormatter aux = null;
				try {
					aux = new MaskFormatter("##");
					aux.setPlaceholder("00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtELoca = new JFormattedTextField(aux);
				txtELoca.setForeground(Color.WHITE);
				txtELoca.setFont(new Font("Tahoma", Font.PLAIN, 15));
				txtELoca.setEditable(false);
				txtELoca.setBorder(null);
				txtELoca.setBackground(Color.BLACK);
				txtELoca.setBounds(129, 61, 34, 20);
				panel_1.add(txtELoca);
			}
		}
		{
			lblVis = new JLabel("");
			lblVis.setForeground(Color.WHITE);
			lblVis.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblVis.setBounds(237, 85, 142, 19);
			contentPanel.add(lblVis);
		}
		{
			lblLocal = new JLabel("");
			lblLocal.setForeground(Color.WHITE);
			lblLocal.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblLocal.setBounds(237, 122, 142, 19);
			contentPanel.add(lblLocal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Seguir!");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				horizontalStrut = Box.createHorizontalStrut(150);
				buttonPane.add(horizontalStrut);
			}
		}
	}
}
