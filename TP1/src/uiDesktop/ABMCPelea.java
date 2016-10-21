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

public class ABMCPelea {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPelea window = new ABMCPelea();
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
	public ABMCPelea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{89, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{114, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblInterfazDePelea = new JLabel("Interfaz De Pelea");
		lblInterfazDePelea.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblInterfazDePelea = new GridBagConstraints();
		gbc_lblInterfazDePelea.anchor = GridBagConstraints.NORTH;
		gbc_lblInterfazDePelea.gridwidth = 5;
		gbc_lblInterfazDePelea.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterfazDePelea.gridx = 1;
		gbc_lblInterfazDePelea.gridy = 0;
		frame.getContentPane().add(lblInterfazDePelea, gbc_lblInterfazDePelea);
		
		JButton btnBuscP1 = new JButton("Buscar P1");
		btnBuscP1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
		/*		aca  tendria que: 
		 * 			-buscar en BD por codigo o nombre abriendo una interfaz nueva
		 * 			-mapear a formulario con lo que encontro
		 * 			-exhibirlo
		 * 			- */ 
			}
		});
		GridBagConstraints gbc_btnBuscP1 = new GridBagConstraints();
		gbc_btnBuscP1.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuscP1.anchor = GridBagConstraints.WEST;
		gbc_btnBuscP1.gridx = 1;
		gbc_btnBuscP1.gridy = 1;
		frame.getContentPane().add(btnBuscP1, gbc_btnBuscP1);
		
		JButton btnBuscP2 = new JButton("Buscar P2");
		GridBagConstraints gbc_btnBuscP2 = new GridBagConstraints();
		gbc_btnBuscP2.gridx = 5;
		gbc_btnBuscP2.gridy = 1;
		frame.getContentPane().add(btnBuscP2, gbc_btnBuscP2);
	}

}
