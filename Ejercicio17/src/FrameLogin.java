import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrameLogin extends JFrame{
	
	public FrameLogin()
	{
		inicio();
	}
	
	private void inicio()
	{
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(400, 200));
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(195,232,201));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // El titulo
        JLabel titulo = new JLabel("Login");
        titulo.setFont(new Font("Arial", Font.BOLD, 17));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titulo);
        
     // Usuario y contraseña
        JPanel panel2 = new JPanel();
        
        panel2.setSize(100,100);
        
        panel2.setBackground(new Color(195,232,201));
        panel2.setLayout(new GridLayout(2, 2, 10, 10));
        panel2.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JLabel labelUsuario = new JLabel("Usuario:");
        JTextField campoUsuario = new JTextField(20);
        
        JLabel labelPassword = new JLabel("Contraseña:");
        JPasswordField campoPassword = new JPasswordField(20);

        panel2.add(labelUsuario);
        panel2.add(campoUsuario);
        panel2.add(labelPassword);
        panel2.add(campoPassword);

        panel.add(panel2);
        
        // El boton
        JButton boton = new JButton("Acceder");
        boton.setPreferredSize(new Dimension(100, 40));
        boton.setFont(new Font("Arial", Font.BOLD, 15));
        boton.setBackground(new Color(84, 138, 92));
        boton.setForeground(Color.WHITE);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrameProductos frameproc = new FrameProductos();
                frameproc.setVisible(true);
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(boton);

        add(panel, BorderLayout.CENTER);
        
        pack();
        
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

	}

}
