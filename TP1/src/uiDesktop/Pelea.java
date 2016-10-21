package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import negocio.*;
import entidades.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Pelea {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private Personaje per;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pelea window = new Pelea();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pelea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 320, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPelea = new JLabel("PELEA");
		lblPelea.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
		lblPelea.setBounds(102, 11, 113, 38);
		frame.getContentPane().add(lblPelea);
		
		JLabel lblPersonaje = new JLabel("Personaje 1");
		lblPersonaje.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 14));
		lblPersonaje.setBounds(36, 66, 78, 14);
		frame.getContentPane().add(lblPersonaje);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(10, 91, 46, 14);
		frame.getContentPane().add(lblVida);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(10, 121, 46, 14);
		frame.getContentPane().add(lblEnergia);
		
		textField = new JTextField();
		textField.setBounds(64, 88, 46, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPersonaje_1 = new JLabel("Personaje 2");
		lblPersonaje_1.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 14));
		lblPersonaje_1.setBounds(182, 66, 78, 14);
		frame.getContentPane().add(lblPersonaje_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(214, 88, 46, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(64, 118, 48, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblVida_1 = new JLabel("Vida");
		lblVida_1.setBounds(169, 91, 46, 14);
		frame.getContentPane().add(lblVida_1);
		
		JLabel lblEnergia_1 = new JLabel("Energia");
		lblEnergia_1.setBounds(169, 121, 46, 14);
		frame.getContentPane().add(lblEnergia_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(214, 118, 46, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTurno = new JLabel("Turno Personaje: ");
		lblTurno.setBounds(10, 170, 88, 41);
		frame.getContentPane().add(lblTurno);
		
		textField_4 = new JTextField();
		textField_4.setBounds(97, 180, 40, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.setBounds(169, 179, 89, 23);
		frame.getContentPane().add(btnAtacar);
		
		JButton btnDefender = new JButton("Defender");
		btnDefender.setBounds(171, 213, 89, 23);
		frame.getContentPane().add(btnDefender);
		
		JButton btnAbandonar = new JButton("Abandonar");
		btnAbandonar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ABMCPelea.main(null);
			}
		});
		btnAbandonar.setBounds(36, 228, 89, 23);
		frame.getContentPane().add(btnAbandonar);
	}
}


//Para agarrar cada personaje se basa en el codigo y nombre proporcioando en la ABMCBusqueda