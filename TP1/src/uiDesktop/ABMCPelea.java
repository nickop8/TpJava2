package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import entidades.Personaje;

public class ABMCPelea {

	private JFrame frmSeleccinDePersonajes;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblEnerga;
	private JLabel lblAtaque;
	private JLabel lblDefensa;
	private JLabel lblJugador1;
	private JLabel lblJugador2;
	private JLabel lblCdigo;
	private JLabel lblNombre;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField textField_10;
	private JTextField textField_11;
	private JButton btnElegirJ;
	private JButton btnElegirJ_1;
	private JButton btnCancelar;
	private JButton btnpelear;
	private Personaje j1, j2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPelea window = new ABMCPelea();
					window.frmSeleccinDePersonajes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ABMCPelea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeleccinDePersonajes = new JFrame();
		frmSeleccinDePersonajes.setTitle("Selecci\u00F3n de personajes");
		frmSeleccinDePersonajes.setBounds(100, 100, 357, 343);
		frmSeleccinDePersonajes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 146, 35, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 175, 35, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 203, 35, 20);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(66, 230, 35, 20);
		textField_4.setColumns(10);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(30, 205, 20, 14);
		
		lblEnerga = new JLabel("Energ\u00EDa");
		lblEnerga.setBounds(14, 233, 36, 14);
		
		lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(15, 149, 35, 14);
		
		lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(10, 178, 40, 14);
		
		lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setBounds(14, 11, 137, 14);
		lblJugador1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJugador1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setBounds(176, 11, 137, 14);
		lblJugador2.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugador2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout groupLayout = new GroupLayout(frmSeleccinDePersonajes.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		panel.add(lblJugador1);
		panel.add(lblEnerga);
		panel.add(lblVida);
		panel.add(lblAtaque);
		panel.add(lblDefensa);
		panel.add(textField_4);
		panel.add(textField_3);
		panel.add(textField_2);
		panel.add(textField_1);
		panel.add(lblJugador2);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(15, 79, 36, 14);
		panel.add(lblCdigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 104, 40, 14);
		panel.add(lblNombre);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(66, 76, 35, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(66, 101, 86, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		label = new JLabel("Energ\u00EDa");
		label.setBounds(175, 233, 36, 14);
		panel.add(label);
		
		label_1 = new JLabel("Vida");
		label_1.setBounds(191, 205, 20, 14);
		panel.add(label_1);
		
		label_2 = new JLabel("Ataque");
		label_2.setBounds(176, 149, 35, 14);
		panel.add(label_2);
		
		label_3 = new JLabel("Defensa");
		label_3.setBounds(171, 178, 40, 14);
		panel.add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(227, 230, 35, 20);
		panel.add(textField);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(227, 202, 35, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(227, 175, 35, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(227, 146, 35, 20);
		panel.add(textField_7);
		
		label_4 = new JLabel("C\u00F3digo");
		label_4.setBounds(176, 76, 36, 14);
		panel.add(label_4);
		
		label_5 = new JLabel("Nombre");
		label_5.setBounds(176, 104, 40, 14);
		panel.add(label_5);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(227, 73, 35, 20);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(227, 101, 86, 20);
		panel.add(textField_11);
		
		btnElegirJ = new JButton("Elegir J1...");
		btnElegirJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ElegirPersonaje.main(j1);
			}
		});
		btnElegirJ.setBounds(40, 36, 89, 23);
		panel.add(btnElegirJ);
		
		btnElegirJ_1 = new JButton("Elegir J2...");
		btnElegirJ_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ElegirPersonaje.main(j2);
			}
		});
		btnElegirJ_1.setBounds(200, 36, 89, 23);
		panel.add(btnElegirJ_1);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(242, 271, 89, 23);
		panel.add(btnCancelar);
		
		btnpelear = new JButton("\u00A1Pelear!");
		btnpelear.setBounds(143, 271, 89, 23);
		panel.add(btnpelear);
		frmSeleccinDePersonajes.getContentPane().setLayout(groupLayout);
	}
}
