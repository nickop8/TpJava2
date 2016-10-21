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
import javax.swing.UIManager;

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
import javax.swing.JLayeredPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
		
		try 
	    { 
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
	    } 
	    catch(Exception e){ 
	    }
		
		initialize();
		ctrl = new CtrlABMPersonaje();
		
	};

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		cod = new JTextField();
		cod.setBounds(88, 97, 40, 20);
		frame.getContentPane().add(cod);
		cod.setColumns(10);
				
		JLabel lblCodigo = new JLabel("Codigo:  ");
		lblCodigo.setBounds(34, 100, 55, 14);
		frame.getContentPane().add(lblCodigo);
		
		
		JLabel lblNombre = new JLabel("Nombre:  ");
		lblNombre.setBounds(172, 100, 55, 14);
		frame.getContentPane().add(lblNombre);
		
		nom = new JTextField();
		nom.setToolTipText("");
		nom.setBounds(237, 97, 145, 20);
		frame.getContentPane().add(nom);
		nom.setColumns(10);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(42, 160, 46, 14);
		frame.getContentPane().add(lblEnergia);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(41, 185, 58, 14);
		frame.getContentPane().add(lblDefensa);
		
		JLabel lblVida = new JLabel("Vida");
		lblVida.setBounds(42, 210, 46, 14);
		frame.getContentPane().add(lblVida);
		
		JLabel lblEvasion = new JLabel("Evasion");
		lblEvasion.setBounds(42, 233, 46, 14);
		frame.getContentPane().add(lblEvasion);
		
		JLabel lblPuntosDisponibles = new JLabel("Puntos Disp");
		lblPuntosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosDisponibles.setBounds(10, 292, 75, 28);
		frame.getContentPane().add(lblPuntosDisponibles);
		
		energia = new JTextField();
		
		energia.setBounds(93, 157, 35, 20);
		frame.getContentPane().add(energia);
		energia.setColumns(10);
		
		vida = new JTextField();
		vida.setColumns(10);
		vida.setBounds(93, 207, 35, 20);
		frame.getContentPane().add(vida);
		
		evasion = new JTextField();
		evasion.setColumns(10);
		evasion.setBounds(93, 230, 35, 20);
		frame.getContentPane().add(evasion);
		
		def = new JTextField();
		def.setBounds(93, 182, 35, 20);
		frame.getContentPane().add(def);
		def.setColumns(10);
		
		ptosTot = new JTextField();
		ptosTot.setEditable(false);
		ptosTot.setBounds(93, 261, 35, 20);
		frame.getContentPane().add(ptosTot);
		ptosTot.setColumns(10);
		
		ptosDisp = new JTextField();
		ptosDisp.setEditable(false);
		ptosDisp.setBounds(93, 296, 35, 20);
		frame.getContentPane().add(ptosDisp);
		ptosDisp.setColumns(10);
				
		JLabel lblPuntosTotales = new JLabel("Puntos Totales");
		lblPuntosTotales.setBounds(10, 261, 104, 20);
		frame.getContentPane().add(lblPuntosTotales);
		
		
				
		JButton btnModificar = new JButton("Modificar");
		
		btnModificar.setBounds(379, 151, 89, 23);
		frame.getContentPane().add(btnModificar);
		
		
		
		JButton btnBuscarPorNombre = new JButton("Buscar Por Nombre");
		
		btnBuscarPorNombre.setBounds(185, 156, 161, 23);
		frame.getContentPane().add(btnBuscarPorNombre);
		
		
		
		JButton btnBorrar = new JButton("Borrar");
		
		btnBorrar.setBounds(379, 206, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		
		JLabel condDef = new JLabel();
		condDef.setText("Max 20 puntos");
		condDef.setFont(new Font("Tahoma", Font.BOLD, 11));
		condDef.setBackground(SystemColor.control);
		condDef.setBounds(138, 179, 98, 20);
		condDef.setVisible(false);
		frame.getContentPane().add(condDef);
		
		JLabel condEv = new JLabel();
		condEv.setText("Max 80 puntos");
		condEv.setFont(new Font("Tahoma", Font.BOLD, 11));
		condEv.setBackground(SystemColor.control);
		condEv.setBounds(138, 227, 98, 20);
		condEv.setVisible(false);
		frame.getContentPane().add(condEv);
		
		JButton exit = new JButton("EXIT");
		exit.setBounds(207, 297, 89, 23);
		frame.getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		JButton btnLimpiarCampos = new JButton("Limpiar Campos");
		btnLimpiarCampos.setBounds(352, 258, 135, 23);
		frame.getContentPane().add(btnLimpiarCampos);
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		});
		
		JButton btnBuscarPorCodigo = new JButton("Buscar Por Codigo");
		
		btnBuscarPorCodigo.setBounds(185, 206, 161, 23);
		frame.getContentPane().add(btnBuscarPorCodigo);
		
		JButton btnCrear = new JButton("Crear");
		
		btnCrear.setBounds(379, 176, 89, 23);
		frame.getContentPane().add(btnCrear);

		JRadioButton buscar = new JRadioButton("Buscar");
		buscar.setBounds(335, 34, 109, 23);
		frame.getContentPane().add(buscar);
		
		JRadioButton newPers = new JRadioButton("Nuevo Personaje");
		newPers.setBounds(84, 34, 123, 23);
		frame.getContentPane().add(newPers);
		
		btnBuscarPorCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorCodigo();
				if(buscarPorCodigo())
				{  	btnModificar.setVisible(true);
					btnBorrar.setVisible(true);
					btnLimpiarCampos.setVisible(true);
				}	
				
				else 
				{	/*btnModificar.setVisible(false);
					btnBorrar.setVisible(false);
					buscar.setSelected(false);*/
					btnBuscarPorNombre.setVisible(false);
					btnBuscarPorCodigo.setVisible(false);
					cod.setVisible(false);
					nom.setVisible(false);
					evasion.setVisible(false);
					def.setVisible(false);
					energia.setVisible(false);
					vida.setVisible(false);
					ptosTot.setVisible(false);
					ptosDisp.setVisible(false);
					lblCodigo.setVisible(false);
					lblEvasion.setVisible(false);
					lblVida.setVisible(false);
					lblDefensa.setVisible(false);
					lblEnergia.setVisible(false);
					lblNombre.setVisible(false);
					lblPuntosTotales.setVisible(false);
					lblPuntosDisponibles.setVisible(false);
					buscar.setSelected(false);
					newPers.setVisible(true);

				}
			}
		});
		
		btnBuscarPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorNombre();
				if(buscarPorNombre())
				{  	btnModificar.setVisible(true);
					btnBorrar.setVisible(true);
					btnLimpiarCampos.setVisible(true);
					
				}	
				else 
				{	/*btnModificar.setVisible(false);
					btnBorrar.setVisible(false);
					buscar.setSelected(false);*/
					btnBuscarPorNombre.setVisible(false);
					btnBuscarPorCodigo.setVisible(false);
					cod.setVisible(false);
					nom.setVisible(false);
					evasion.setVisible(false);
					def.setVisible(false);
					energia.setVisible(false);
					vida.setVisible(false);
					ptosTot.setVisible(false);
					ptosDisp.setVisible(false);
					lblCodigo.setVisible(false);
					lblEvasion.setVisible(false);
					lblVida.setVisible(false);
					lblDefensa.setVisible(false);
					lblEnergia.setVisible(false);
					lblNombre.setVisible(false);
					lblPuntosTotales.setVisible(false);
					lblPuntosDisponibles.setVisible(false);
					buscar.setSelected(false);
					newPers.setVisible(true);


				}
			}
		});
		
		
		newPers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
					if (newPers.isSelected()==true)
						{	Personaje p = new Personaje();
							btnCrear.setVisible(true);
							nom.setVisible(true);
							evasion.setVisible(true);
							def.setVisible(true);
							energia.setVisible(true);
							vida.setVisible(true);
							ptosTot.setVisible(true);
							ptosDisp.setVisible(true);
							lblEvasion.setVisible(true);
							lblVida.setVisible(true);
							lblDefensa.setVisible(true);
							lblEnergia.setVisible(true);
							lblNombre.setVisible(true);
							lblPuntosTotales.setVisible(true);
							lblPuntosDisponibles.setVisible(true);
							ptosDisp.setText(Integer.toString(p.getPtos_totales()));
							ptosTot.setText("0");
							energia.setText(Integer.toString(p.getEnergia()));
							def.setText(Integer.toString(p.getDefensa()));
							vida.setText("0");
							evasion.setText("0");
							nom.setText(p.getNombre());
							condEv.setVisible(true);;
							condDef.setVisible(true);;
							btnLimpiarCampos.setVisible(true);
							buscar.setVisible(false);
						 }
					 
					else{	buscar.setVisible(true);
							nom.setVisible(false);
							evasion.setVisible(false);
							def.setVisible(false);
							energia.setVisible(false);
							vida.setVisible(false);
							ptosTot.setVisible(false);
							ptosDisp.setVisible(false);
							lblEvasion.setVisible(false);
							lblVida.setVisible(false);
							lblDefensa.setVisible(false);
							lblEnergia.setVisible(false);
							lblNombre.setVisible(false);
							lblPuntosTotales.setVisible(false);
							lblPuntosDisponibles.setVisible(false);
							condEv.setVisible(false);
							condDef.setVisible(false);
							btnCrear.setVisible(false);
							btnLimpiarCampos.setVisible(false);
						};
			}
		});
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();				
				btnBuscarPorCodigo.setVisible(false);
				btnBuscarPorNombre.setVisible(false);
				btnModificar.setVisible(false);
				btnLimpiarCampos.setVisible(false);
				btnBorrar.setVisible(false);
				cod.setVisible(false);
				nom.setVisible(false);
				evasion.setVisible(false);
				def.setVisible(false);
				energia.setVisible(false);
				vida.setVisible(false);
				ptosTot.setVisible(false);
				ptosDisp.setVisible(false);
				lblCodigo.setVisible(false);
				lblEvasion.setVisible(false);
				lblVida.setVisible(false);
				lblDefensa.setVisible(false);
				lblEnergia.setVisible(false);
				lblNombre.setVisible(false);
				lblPuntosTotales.setVisible(false);
				lblPuntosDisponibles.setVisible(false);
				newPers.setVisible(true);
				buscar.setSelected(false);
			}
		});
		
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creo=1;
				agregar();
				btnCrear.setVisible(false);
				btnLimpiarCampos.setVisible(false);
				cod.setVisible(false);
				nom.setVisible(false);
				evasion.setVisible(false);
				def.setVisible(false);
				energia.setVisible(false);
				vida.setVisible(false);
				ptosTot.setVisible(false);
				ptosDisp.setVisible(false);
				lblCodigo.setVisible(false);
				lblEvasion.setVisible(false);
				lblVida.setVisible(false);
				lblDefensa.setVisible(false);
				lblEnergia.setVisible(false);
				lblNombre.setVisible(false);
				lblPuntosTotales.setVisible(false);
				lblPuntosDisponibles.setVisible(false);
				buscar.setVisible(true);
				newPers.setSelected(false);
				condEv.setText("");
				condDef.setText("");
				limpiarCampos();
				creo=0;
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
				btnBuscarPorCodigo.setVisible(false);
				btnBuscarPorNombre.setVisible(false);
				btnModificar.setVisible(false);
				btnLimpiarCampos.setVisible(false);
				btnBorrar.setVisible(false);
				cod.setVisible(false);
				nom.setVisible(false);
				evasion.setVisible(false);
				def.setVisible(false);
				energia.setVisible(false);
				vida.setVisible(false);
				ptosTot.setVisible(false);
				ptosDisp.setVisible(false);
				lblCodigo.setVisible(false);
				lblEvasion.setVisible(false);
				lblVida.setVisible(false);
				lblDefensa.setVisible(false);
				lblEnergia.setVisible(false);
				lblNombre.setVisible(false);
				lblPuntosTotales.setVisible(false);
				lblPuntosDisponibles.setVisible(false);
				newPers.setVisible(true);
				buscar.setSelected(false);
			}
		});
		
		energia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				ptosTot.setText(String.valueOf(Integer.parseInt(energia.getText())+Integer.parseInt(def.getText())+Integer.parseInt(evasion.getText())+Integer.parseInt(vida.getText())));
			}
		});
		
		def.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				ptosTot.setText(String.valueOf(Integer.parseInt(energia.getText())+Integer.parseInt(def.getText())+Integer.parseInt(evasion.getText())+Integer.parseInt(vida.getText())));
			}
		});
		
		vida.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				ptosTot.setText(String.valueOf(Integer.parseInt(energia.getText())+Integer.parseInt(def.getText())+Integer.parseInt(evasion.getText())+Integer.parseInt(vida.getText())));
			}
		});
		
		evasion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				ptosTot.setText(String.valueOf(Integer.parseInt(energia.getText())+Integer.parseInt(def.getText())+Integer.parseInt(evasion.getText())+Integer.parseInt(vida.getText())));
			}
		});
		
		buscar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
					if (buscar.isSelected()==true)
						{	btnBuscarPorNombre.setVisible(true);
							btnBuscarPorCodigo.setVisible(true);
							newPers.setVisible(false);
							cod.setVisible(true);
							nom.setVisible(true);
							evasion.setVisible(true);
							def.setVisible(true);
							energia.setVisible(true);
							vida.setVisible(true);
							ptosTot.setVisible(true);
							ptosDisp.setVisible(true);
							lblCodigo.setVisible(true);
							lblEvasion.setVisible(true);
							lblVida.setVisible(true);
							lblDefensa.setVisible(true);
							lblEnergia.setVisible(true);
							lblNombre.setVisible(true);
							lblPuntosTotales.setVisible(true);
							lblPuntosDisponibles.setVisible(true);
						}
					
					else
						{	btnBuscarPorNombre.setVisible(false);
							btnBuscarPorCodigo.setVisible(false);
							newPers.setVisible(true);
							btnModificar.setVisible(false);
							btnLimpiarCampos.setVisible(false);
							btnBorrar.setVisible(false);
							cod.setVisible(false);
							nom.setVisible(false);
							evasion.setVisible(false);
							def.setVisible(false);
							energia.setVisible(false);
							vida.setVisible(false);
							ptosTot.setVisible(false);
							ptosDisp.setVisible(false);
							lblCodigo.setVisible(false);
							lblEvasion.setVisible(false);
							lblVida.setVisible(false);
							lblDefensa.setVisible(false);
							lblEnergia.setVisible(false);
							lblNombre.setVisible(false);
							lblPuntosTotales.setVisible(false);
							lblPuntosDisponibles.setVisible(false);
							
						}
			}
		});
	
			/*Hago que solo se puedan ver los botones de Buscar y Nuevo Personaje */		
			btnCrear.setVisible(false);
			btnBuscarPorCodigo.setVisible(false);
			btnBuscarPorNombre.setVisible(false);
			btnModificar.setVisible(false);
			btnLimpiarCampos.setVisible(false);
			btnBorrar.setVisible(false);
			cod.setVisible(false);
			nom.setVisible(false);
			evasion.setVisible(false);
			def.setVisible(false);
			energia.setVisible(false);
			vida.setVisible(false);
			ptosTot.setVisible(false);
			ptosDisp.setVisible(false);
			lblCodigo.setVisible(false);
			lblEvasion.setVisible(false);
			lblVida.setVisible(false);
			lblDefensa.setVisible(false);
			lblEnergia.setVisible(false);
			lblNombre.setVisible(false);
			lblPuntosTotales.setVisible(false);
			lblPuntosDisponibles.setVisible(false);
				
		
} //Aca termina el INICIALIZE
		
	
		
		

		

		

	
///METODOS/////////////////////	
			protected void agregar() {
				if(datosValidos(creo)){
					//JOptionPane.showMessageDialog(null, "TODO OK");
						Personaje p=MapearDeFormulario();
						ctrl.add(p);
						//MapearAFormulario(p);
						
				}
			}
			
			protected boolean buscarPorNombre() {
				//creo=1;
				boolean ok=false;
				if(!nom.getText().matches(""))
					{	
						Personaje p = ctrl.getPersonaje(nom.getText());
						if(p!=null) 
							{	MapearAFormulario(p);
								ok=true;
							}
						else JOptionPane.showMessageDialog(null, "No se encontro el nombre del personaje");
						
					}
				else
					{
						JOptionPane.showMessageDialog(null, "Volve a ingresar un nombre");
						limpiarCampos();
					}
				return ok;
			}
			
			protected boolean buscarPorCodigo() {
				boolean ok=false;
				if(!cod.getText().matches(""))
					{	
						Personaje p = ctrl.getPersonaje(Integer.parseInt(cod.getText()));
						if(p!=null) 
						{	MapearAFormulario(p);
							ok=true;
						}
					else JOptionPane.showMessageDialog(null, "No se encontro el codigo del personaje");
					
					}
				else
					{
						JOptionPane.showMessageDialog(null, "Volve a ingresar un codigo");
						limpiarCampos();
					}
				return ok;
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
					
					ptosTot.setText("");
					ptosDisp.setText("");
					energia.setText("");
					def.setText("");
					vida.setText("");
					evasion.setText("");
					nom.setText("");
					cod.setText("");	
			}
			
			public boolean datosValidos(int creo){
				boolean valido=true;
				boolean coincideNom=false;
				boolean coincideCodNom=false;
				int suma=0;
				   
				
				
				if(!energia.getText().matches("[0-9]*") || energia.getText().matches(""))
				{
				JOptionPane.showMessageDialog(null, "LA ENERGIA NO ES UN NUMERO");
				 valido=false;
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
			
} //Aca termina la clase

			
		
	
		
	

	

