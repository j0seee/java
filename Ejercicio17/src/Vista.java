import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Vista extends JFrame{
	
	public Vista()
	{
		inicio();
	}
	
	private void inicio()
	{
		
		// La aplicación será verde porque es objetivamente el mejor color
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setTitle("Homebaking");
		 setSize(400,300);
		 
		 JPanel panel = new JPanel(new BorderLayout());
		 add(panel);
		 
		 // Creamos el titulo
		 JLabel label = new JLabel("     Bievenido a la app de Homebaking     ");
		 label.setFont(new Font("Arial",Font.BOLD, 15));
		 label.setHorizontalAlignment(SwingConstants.CENTER);
		 panel.setBackground(new Color(195,232,201));
		 panel.add(label, BorderLayout.NORTH);
		 
		 //Creamos los botones
		 	//FlowLayout para dejarlos ordenados
		 JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		 panelBotones.setBackground(new Color(195,232,201));
		 panel.add(panelBotones, BorderLayout.CENTER);
		 
		// Ahora vamos a por el botón de Login
	        JButton botonLogin = new JButton("Login");
	        botonLogin.setPreferredSize(new Dimension(100, 40));
	        botonLogin.setFont(new Font("Arial", Font.BOLD, 15));
	        botonLogin.setBackground(new Color(84, 138, 92)); // Cambiar el color del botón a azul oscuro
	        botonLogin.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        botonLogin.setOpaque(true);
	        botonLogin.setBorderPainted(false);
	        botonLogin.setFocusPainted(false);
	        botonLogin.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Agregar un espacio interno al botón
	        botonLogin.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                FrameLogin framelogin = new FrameLogin();
	                framelogin.setVisible(true);
	            }
	        });

	        panelBotones.add(botonLogin);
		 
	     // Ahora vamos a por el botón de registro
	        JButton botonRegistro = new JButton("Registro");
	        botonRegistro.setPreferredSize(new Dimension(100, 40));
	        botonRegistro.setFont(new Font("Arial", Font.BOLD, 15));
	        botonRegistro.setBackground(new Color(84, 138, 92)); // Cambiar el color del botón a azul oscuro
	        botonRegistro.setForeground(Color.WHITE); // Cambiar el color del texto a blanco
	        botonRegistro.setOpaque(true);
	        botonRegistro.setBorderPainted(false);
	        botonRegistro.setFocusPainted(false);
	        botonRegistro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Agregar un espacio interno al botón
	        botonRegistro.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                FrameRegistro framereg = new FrameRegistro();
	                framereg.setVisible(true);
	            }
	        });

	        panelBotones.add(botonRegistro);
	        
	        pack();
	        
	        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

		 
		 
	}

}
