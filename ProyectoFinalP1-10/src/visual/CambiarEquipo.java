package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import logical.Bateador;
import logical.Equipo;
import logical.Jugador;
import logical.Lanzador;
import logical.Liga;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CambiarEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> cbxTeamPertenece;
	private JComboBox<String> cbxJugador;
	private JComboBox<String> cbxTeamDeseado;
	private Equipo team = null;
	private Equipo teamCambio = null;
	private Jugador gamer = null;
	private int no = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CambiarEquipo dialog = new CambiarEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CambiarEquipo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				llenarCBXEquipo();
			}
		});
		setUndecorated(true);
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 513, 271);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 51));
			panel.setBounds(0, 0, 611, 48);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("CAMBIAR EQUIPO");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
				lblNewLabel.setBounds(10, 11, 164, 22);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblSalir = new JLabel("");
				lblSalir.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				lblSalir.setIcon(new ImageIcon(CambiarEquipo.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
				lblSalir.setBounds(473, 8, 32, 32);
				panel.add(lblSalir);
			}
		}
		{
			JPanel panelee = new JPanel();
			panelee.setBackground(Color.WHITE);
			panelee.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione el Jugador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelee.setBounds(10, 59, 488, 80);
			contentPanel.add(panelee);
			panelee.setLayout(null);
			{
				cbxTeamPertenece = new JComboBox<String>();
				cbxTeamPertenece.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cbxTeamPertenece.getSelectedIndex() > 0) {
							team = Liga.getInstance().buscarEquipoPorNombre(cbxTeamPertenece.getSelectedItem().toString());
							llenarCBXJugador();
							cbxJugador.setEnabled(true);
						} else {
							cbxJugador.setEnabled(false);
						}
					}
				});
				cbxTeamPertenece.setBackground(Color.WHITE);
				cbxTeamPertenece.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cbxTeamPertenece.setModel(new DefaultComboBoxModel<String>(new String[] {"<Equipo Perteneciente>"}));
				cbxTeamPertenece.setBounds(10, 25, 185, 24);
				panelee.add(cbxTeamPertenece);
			}
			{
				cbxJugador = new JComboBox<String>();
				cbxJugador.setEnabled(false);
				cbxJugador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cbxJugador.getSelectedIndex() > 0) {
							gamer = Liga.getInstance().buscarJugadorPorNombre(cbxJugador.getSelectedItem().toString());
						}
					}
				});
				cbxJugador.setBackground(Color.WHITE);
				cbxJugador.setModel(new DefaultComboBoxModel<String>(new String[] {"<Jugador>"}));
				cbxJugador.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cbxJugador.setBounds(285, 25, 191, 24);
				panelee.add(cbxJugador);
			}
		}
		{
			JPanel paneloo = new JPanel();
			paneloo.setBackground(Color.WHITE);
			paneloo.setLayout(null);
			paneloo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione el Equipo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			paneloo.setBounds(10, 152, 488, 80);
			contentPanel.add(paneloo);
			{
				cbxTeamDeseado = new JComboBox<String>();
				cbxTeamDeseado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cbxTeamDeseado.getSelectedIndex() > 0) {
							teamCambio = Liga.getInstance().buscarEquipoPorNombre(cbxTeamDeseado.getSelectedItem().toString());
						}
					}
				});
				cbxTeamDeseado.setBackground(Color.WHITE);
				cbxTeamDeseado.setModel(new DefaultComboBoxModel<String>(new String[] {"<Equipo Deseado>"}));
				cbxTeamDeseado.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cbxTeamDeseado.setBounds(146, 30, 194, 24);
				paneloo.add(cbxTeamDeseado);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cambiar");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Jugador juga = null;
						no = (int) (Math.random()*90+1);
						if (cbxJugador.getSelectedIndex() > 0 && cbxTeamPertenece.getSelectedIndex() > 0) {
							if (gamer instanceof Lanzador) {
								juga = new Lanzador(gamer.getNombre(), gamer.getNacimiento(), gamer.getAltura(), gamer.getPeso(), no, gamer.getBat_lanz(), gamer.getPosicion(), teamCambio);
							}
							if (gamer instanceof Bateador) {
								juga = new Bateador(gamer.getNombre(), gamer.getNacimiento(), gamer.getAltura(), gamer.getPeso(), no, gamer.getBat_lanz(), gamer.getPosicion(), teamCambio);
							}
							if (teamCambio.verificarNoCami(juga) == false) {
								if (teamCambio.getMisJugadores().size() < 25) {
									teamCambio.insertarJugador(juga);
									team.eliminarJugador(gamer);
									Liga.getInstance().eliminarJugador(gamer);
									JOptionPane.showMessageDialog(null, "Agregado Satisfactoriamente", null, JOptionPane.WARNING_MESSAGE);
									cbxTeamPertenece.setSelectedIndex(0);
									cbxTeamDeseado.setSelectedIndex(0);
								} else {
									JOptionPane.showMessageDialog(null, "Límite de Jugadores por Equipo Alcanzado" , null, JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Número de Camiseta No Disponible. Incrementado! Intente Nuevamente!" , null, JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Complete los Campos" , null, JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(210);
				buttonPane.add(horizontalStrut);
			}
		}
	}

	public void llenarCBXEquipo() {
		for (Equipo team : Liga.getInstance().getListaEquipos()) {
			cbxTeamPertenece.addItem(team.getNombre());
			cbxTeamDeseado.addItem(team.getNombre());
		}
	}
	
	public void llenarCBXJugador() {
			cbxJugador.removeAllItems();
			cbxJugador.addItem("<Jugador>");
		for (Jugador player : team.getMisJugadores()) {
			cbxJugador.addItem(player.getNombre());
		}
	}
}
