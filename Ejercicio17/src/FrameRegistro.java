import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class FrameRegistro extends JFrame{
	
	public FrameRegistro()
	{
		inicio();
	}
	
	private void inicio()
	{
		setTitle("Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));
        setLayout(new BorderLayout());
        
        JPanel panel= new JPanel();
        panel.setBackground(new Color(195,232,201));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        //El titulo
        JLabel label = new JLabel("Registro");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        
        
        //Los campos de registro
        JPanel panelCamposRegistro = new JPanel();
        panelCamposRegistro.setBackground(new Color(195,232,201));
        panelCamposRegistro.setLayout(new GridLayout(6, 2, 10, 10));
        panelCamposRegistro.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JLabel labelNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField(20);
        JLabel labelApellido = new JLabel("Apellido:");
        JTextField campoApellido = new JTextField(20);
        JLabel labelCiudad = new JLabel("Ciudad:");
        JTextField campoCiudad = new JTextField(20);
        JLabel labelEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField(20);
        JLabel labelSalario = new JLabel("Salario:");
        JTextField campoSalario = new JTextField(20);
        JLabel labelFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        JTextField campoFechaNacimiento = new JTextField(20);

        panelCamposRegistro.add(labelNombre);
        panelCamposRegistro.add(campoNombre);
        panelCamposRegistro.add(labelApellido);
        panelCamposRegistro.add(campoApellido);
        panelCamposRegistro.add(labelCiudad);
        panelCamposRegistro.add(campoCiudad);
        panelCamposRegistro.add(labelEmail);
        panelCamposRegistro.add(campoEmail);
        panelCamposRegistro.add(labelSalario);
        panelCamposRegistro.add(campoSalario);
        panelCamposRegistro.add(labelFechaNacimiento);
        panelCamposRegistro.add(campoFechaNacimiento);

        panel.add(panelCamposRegistro);
        
        
        // Por últmo el botón
        
        JButton boton = new JButton("Registro");
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
                System.out.println("Te has registrado con éxito!");
                dispose();
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(boton);
        
        add(panel);
        
        pack();
        
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
	}

}
