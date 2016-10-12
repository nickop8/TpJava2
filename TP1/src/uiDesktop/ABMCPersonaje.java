package uiDesktop;

import java.awt.EventQueue;

import negocio.*;
import entidades.*;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import org.omg.CORBA.portable.ApplicationException;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
public class ABMCPersonaje {

	private JFrame frame;
	private JTextField cod;
	private JTextField nom;
	private JTextField energia;
	private JTextField vida;
	private JTextField evasion;
	private JTextField def;
	private JTextField ptosTot;
	
	private CtrlABMPersonaje ctrl;
	private JTextField ptosDisp;
	public int creo=0;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaje window = new ABMCPersonaje();
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
	public ABMCPersonaje() {
		initialize();
		ctrl = new CtrlABMPersonaje();
		
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
		//cod.setVisible(false);
		
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
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(42, 107, 46, 14);
		frame.getContentPane().add(lblEnergia);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(41, 132, 58, 14);
		frame.getContentPane().add(lblDefensa);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(42, 157, 46, 14);
		frame.getContentPane().add(lblVida);
		
		JLabel lblEvasion = new JLabel("Evasion");
		lblEvasion.setBounds(42, 180, 46, 14);
		frame.getContentPane().add(lblEvasion);
		
		energia = new JTextField();
		energia.setBounds(94, 104, 34, 20);
		frame.getContentPane().add(energia);
		energia.setColumns(10);
		
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
		ptosTot.setBounds(94, 208, 34, 20);
		frame.getContentPane().add(ptosTot);
		//textField_6.setText("200");
		ptosTot.setColumns(10);
		
		
		
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setBounds(10, 208, 104, 20);
		frame.getContentPane().add(lblPuntosTotales);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(355, 128, 89, 23);
		frame.getContentPane().add(btnCrear);
		
		btnCrear.setVisible(false);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(355, 103, 89, 23);
		frame.getContentPane().add(btnModificar);
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificar();
			}
		});
		
		
		JButton btnBuscarPorNombre = new JButton("Buscar Por Nombre");
		btnBuscarPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscarPorNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarPorNombre();
			}
		});
		btnBuscarPorNombre.setBounds(326, 128, 135, 23);
		frame.getContentPane().add(btnBuscarPorNombre);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(355, 190, 89, 23);
		frame.getContentPane().add(btnBorrar);
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrar();
			}
		});
		
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
		
		JButton btnLimpiarCampos = new JButton("Limpiar Campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		});
		btnLimpiarCampos.setBounds(190, 209, 113, 23);
		frame.getContentPane().add(btnLimpiarCampos);
		
		ptosDisp = new JTextField();
		ptosDisp.setBounds(94, 245, 40, 20);
		frame.getContentPane().add(ptosDisp);
		ptosDisp.setColumns(10);
		
		JLabel lblPuntosDisponibles = new JLabel("Puntos Disp");
		lblPuntosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosDisponibles.setBounds(10, 239, 75, 28);
		frame.getContentPane().add(lblPuntosDisponibles);
		
		JButton btnBuscarPorCodigo = new JButton("Buscar Por Codigo");
		btnBuscarPorCodigo.setBounds(326, 176, 135, 23);
		frame.getContentPane().add(btnBuscarPorCodigo);
		btnBuscarPorCodigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarPorCodigo();
			}
		});
		
		newPers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
					if (newPers.isSelected()==true)
						{
							cod.setVisible(false);
							lblCodigo.setVisible(false);
							btnCrear.setVisible(true);
							btnBuscarPorCodigo.setVisible(false);
							btnBuscarPorNombre.setVisible(false);
							btnBorrar.setVisible(false);
							btnModificar.setVisible(false);
							ptosDisp.setText("200");
							ptosTot.setText("0");
							energia.setText("0");
							def.setText("0");
							vida.setText("0");
							evasion.setText("0");
							nom.setText("Ingrese nombre");
							condEv.setText("Max 80 puntos");
							condDef.setText("Max 20 puntos");
						 }
					else{	btnCrear.setVisible(false);
							cod.setVisible(true);
							lblCodigo.setVisible(true);
							btnBuscarPorCodigo.setVisible(true);
							btnBuscarPorNombre.setVisible(true);
							btnBorrar.setVisible(true);
							btnModificar.setVisible(true);
							ptosTot.setText("");
							ptosDisp.setText("");
							energia.setText("");
							def.setText("");
							vida.setText("");
							evasion.setText("");
							nom.setText("");
							condEv.setText("");
							condDef.setText("");
						};
			}
		});
		
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				creo=1;
				agregar();
				newPers.setSelected(false);
				condEv.setText("");
				condDef.setText("");
				limpiarCampos();
				creo=0;
				cod.setVisible(true);
				lblCodigo.setVisible(true);
				btnCrear.setVisible(false);
				btnBuscarPorCodigo.setVisible(true);
				btnBuscarPorNombre.setVisible(true);
				btnBorrar.setVisible(true);
				btnModificar.setVisible(true);
			}
		});
		

	};
///METODOS/////////////////////	
			protected void agregar() {
				if(datosValidos(creo)){
					//JOptionPane.showMessageDialog(null, "TODO OK");
						Personaje p=MapearDeFormulario();
						ctrl.add(p);
						//MapearAFormulario(p);
						
				}
			}
			protected void buscarPorNombre() {
				//creo=1;
				if(!nom.getText().matches(""))
					{	
						Personaje p = ctrl.getPersonaje(nom.getText());
						if(p!=null) MapearAFormulario(p);
						else JOptionPane.showMessageDialog(null, "No se encontro el nombre del personaje");
					}
				else
					{
						JOptionPane.showMessageDialog(null, "Ha habido un error amigoh\nVolve a ingresar un nombre");
						limpiarCampos();
					}
			}
			protected void buscarPorCodigo() {	
				if(!cod.getText().matches(""))
					{	
						Personaje p = ctrl.getPersonaje(Integer.parseInt(cod.getText()));
						if(p!=null) MapearAFormulario(p);
						else JOptionPane.showMessageDialog(null, "No se encontro el codigo del personaje");
					}
				else
					{
						JOptionPane.showMessageDialog(null, "Ha habido un error amigoh\nVolve a ingresar un codigo");
						limpiarCampos();
					}
				
			}
			
			protected void modificar() {
				if(cod.getText().matches("")) cod.setText("0");
				if (datosValidos(creo))
				{
					Personaje po = ctrl.getPersonaje(Integer.parseInt(cod.getText()));
					if(po!=null)	MapearAFormulario(po);
					
					/*	po tiene el personaje con su nombre antiguo, esto lo hago por si tambien decido cambiarle su nombre ademas de los atributos
						p va a tener el nuevo nombre (si es que lo cambie) y los atributos nuevos
				 		a update le doy el personaje modificado y el nombre del personaje original para que lo busque y modifique ese personaje*/
					Personaje p=MapearDeFormulario();
					ctrl.update(p, po.getNombre());
					limpiarCampos();}
					/*if(p!=null)
					JOptionPane.showMessageDialog(null, "Nombre: "+p.getNombre()+" Energia:");*/
				}

			protected void borrar() {
				//if(datosValidos()){
				//Personaje p=MapearDeFormulario();
				
				ctrl.delete(Integer.parseInt(cod.getText()),nom.getText());
				JOptionPane.showMessageDialog(null, "PERSONAJE ELIMINADO: " + nom.getText() + " CORRECTAMENTE");
				limpiarCampos();
						//MapearAFormulario(p);
				//}
			}
				
			public void MapearAFormulario(Personaje p){
				if(p.getNombre()!=null || p.getCodigo()!=0) 
				{	cod.setText(String.valueOf(p.getCodigo()));
					nom.setText(String.valueOf(p.getNombre()));
					energia.setText(String.valueOf( p.getEnergia()));
					def.setText(String.valueOf(p.getDefensa()));
					vida.setText(String.valueOf(p.getVida()));
					evasion.setText(String.valueOf( p.getEvasion()));
					ptosTot.setText(String.valueOf(p.getPtos_totales()));
				}
				
			}
			
			public Personaje MapearDeFormulario(){
				Personaje p = new Personaje();
				
				p.setCodigo(Integer.parseInt("0"));
				p.setEnergia(Integer.parseInt(energia.getText()));
				p.setDefensa(Integer.parseInt(def.getText()));
				p.setVida(Integer.parseInt(vida.getText()));
				p.setEvasion(Integer.parseInt(evasion.getText()));
				p.setNombre(nom.getText());
				int suma=0;
				suma=p.getEnergia()+p.getDefensa()+p.getVida()+p.getEvasion();
				p.setPtos_totales(suma);
				return p;
			}
			
			protected void limpiarCampos(){	
				{	
					ptosTot.setText("");
					ptosDisp.setText("");
					energia.setText("");
					def.setText("");
					vida.setText("");
					evasion.setText("");
					nom.setText("");
					cod.setText("");
			
			
				};
			}
			
			public boolean datosValidos(int creo){
				boolean valido=true;
				boolean coincideNom=false;
				boolean coincideCodNom=false;
				int suma=0;
				//Font fuente =new Font("Serief",Font.BOLD|Font.ITALIC,14);
				   
				
				
				if(!energia.getText().matches("[0-9]*") || energia.getText().matches(""))
				{
				JOptionPane.showMessageDialog(null, "LA ENERGIA NO ES UN NUMERO");
				 valido=false;
				// energia.setFont(fuente);
				}
				
				if(!def.getText().matches("[0-9]*") || def.getText().matches("") ||Integer.parseInt(def.getText())>20 )
				{
					 JOptionPane.showMessageDialog(null, "DEFENSA MAYOR A 20 O NO ES UN NUMERO");
					 valido=false;
					// def.setText("0"); 
				}
				
				if(!evasion.getText().matches("[0-9]*") || evasion.getText().matches("") || Integer.parseInt(evasion.getText())>80)
				{
				JOptionPane.showMessageDialog(null, "EVASION MAYOR A 80 o NO ES UN NUMERO");
				 valido=false;
				 //evasion.setText("0");
				}
				
				if(!vida.getText().matches("[0-9]*")|| vida.getText().matches(""))
				{
				JOptionPane.showMessageDialog(null, "LA VIDA NO ES UN NUMERO");
				 valido=false;
				 //vida.setText("0");
				}
				
				if(nom.getText().matches("") || nom.getText().matches("Ingrese nombre") )
				{
				JOptionPane.showMessageDialog(null, "NO SE HA INGRESADO NOMBRE");
				 valido=false;
				 nom.setText("Ingresa nombre!!");
				}
				
				coincideNom= ctrl.coincideNombre(nom.getText());
				if(creo==0) 
				{	coincideCodNom= ctrl.coincideCodNom(Integer.parseInt(cod.getText()), nom.getText());
					if (coincideCodNom==false && coincideNom==true) 
					{JOptionPane.showMessageDialog(null, "No coincide Nombre con el codigo pero si esta en la BD");
					valido=false;
					}
				}
				
				if (coincideNom==true && creo==1)
				{ 	valido=false;
					JOptionPane.showMessageDialog(null, "Ya existe nombre en BD");
				}
				
				
				
				if (valido==true)
				{	int resto=0;
				 	suma= Integer.parseInt(def.getText()) + Integer.parseInt(evasion.getText()) + Integer.parseInt(vida.getText()) + Integer.parseInt(energia.getText());
				 	if(suma>200)
				 	{
				 		JOptionPane.showMessageDialog(null, "PUNTOS ASIGNADOS MAYORES A LOS TOTALES");
				 		valido=false;
				 		//energia.setText("0");
				 		//def.setText("0");
				 		//vida.setText("0");
				 		//evasion.setText("0");
				 	}
				 	resto=200-suma;
				 	if (resto>=0)
				 	{	ptosTot.setText(String.valueOf(suma));
				 		ptosDisp.setText(String.valueOf(resto));
				 		JOptionPane.showMessageDialog(null, "Te sobran: "+resto+" puntos para asignar, podes modificar esos puntos en cualquier momento");
				 	}
				 	else JOptionPane.showMessageDialog(null, "Te excediste: "+ -(resto)+" puntos");
				}
				
				return valido;
				
			}
}
		
	
		
	

	

