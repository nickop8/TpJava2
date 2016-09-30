package negocio;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
public class ABMCtrlPersonaje {

	private JFrame frame;
	private JTextField cod;
	private JTextField nom;
	private JTextField ataque;
	private JTextField vida;
	private JTextField evasion;
	private JTextField def;
	private JTextField ptosTot;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCtrlPersonaje window = new ABMCtrlPersonaje();
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
	public ABMCtrlPersonaje() {
		initialize();
	};

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 508, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		cod = new JTextField();
		cod.setBounds(84, 59, 40, 20);
		frame.getContentPane().add(cod);
		cod.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:  ");
		lblCodigo.setBounds(30, 62, 55, 14);
		frame.getContentPane().add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:  ");
		lblNombre.setBounds(150, 62, 55, 14);
		frame.getContentPane().add(lblNombre);
		
		nom = new JTextField();
		nom.setBounds(200, 59, 145, 20);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(42, 107, 46, 14);
		frame.getContentPane().add(lblAtaque);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(42, 132, 46, 14);
		frame.getContentPane().add(lblDefensa);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(42, 157, 46, 14);
		frame.getContentPane().add(lblVida);
		
		JLabel lblEvasion = new JLabel("Evasion");
		lblEvasion.setBounds(42, 180, 46, 14);
		frame.getContentPane().add(lblEvasion);
		
		ataque = new JTextField();
		ataque.setBounds(94, 104, 34, 20);
		frame.getContentPane().add(ataque);
		ataque.setColumns(10);
		
		vida = new JTextField();
		vida.setColumns(10);
		vida.setBounds(94, 154, 34, 20);
		frame.getContentPane().add(vida);
		
		evasion = new JTextField();
		evasion.setColumns(10);
		evasion.setBounds(94, 177, 34, 20);
		frame.getContentPane().add(evasion);
		
		def = new JTextField();
		def.setBounds(93, 129, 35, 20);
		frame.getContentPane().add(def);
		def.setColumns(10);
		
		ptosTot = new JTextField();
		ptosTot.setBounds(94, 210, 34, 20);
		frame.getContentPane().add(ptosTot);
		//textField_6.setText("200");
		ptosTot.setColumns(10);
		
		
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setBounds(73, 233, 104, 20);
		frame.getContentPane().add(lblPuntosTotales);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(344, 104, 89, 23);
		frame.getContentPane().add(btnCrear);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(344, 150, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(344, 192, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(344, 232, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JTextPane condDef = new JTextPane();
		condDef.setFont(new Font("Tahoma", Font.BOLD, 11));
		condDef.setBackground(SystemColor.control);
		condDef.setBounds(139, 129, 98, 20);
		frame.getContentPane().add(condDef);
		
		JTextPane condEv = new JTextPane();
		condEv.setFont(new Font("Tahoma", Font.BOLD, 11));
		condEv.setBackground(SystemColor.control);
		condEv.setBounds(139, 177, 98, 20);
		frame.getContentPane().add(condEv);
		
		JRadioButton newPers = new JRadioButton("Nuevo Personaje");
		newPers.setBounds(351, 58, 123, 23);
		//rdbtnNuevoPersonaje.setText("Nuevo Personaje");
		//newPers.setSelected(true);
		frame.getContentPane().add(newPers);
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setBounds(199, 261, 89, 23);
		frame.getContentPane().add(exit);
		newPers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					if (newPers.isSelected()==true)
						{ptosTot.setText("200");
						ataque.setText("0");
						def.setText("0");
						vida.setText("0");
						evasion.setText("0");
						nom.setText("Ingrese nombre");
						 condEv.setText("Max 80 puntos");
						 condDef.setText("Max 20 puntos");
						 }
					else{	ptosTot.setText("");
							ataque.setText("");
							def.setText("");
							vida.setText("");
							evasion.setText("");
							nom.setText("");
							condEv.setText("");
							condDef.setText("");
						};
						 }
			});
				};
		};
		
	
		
	

	

