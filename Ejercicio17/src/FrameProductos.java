import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameProductos extends JFrame {

    private String[] productos = {"Hipoteca", "Prestamo", "Domiciliación"};
    private String[] descripciones = {
        "Disfrute de su hogar con nuestras hipotecas flexibles.     ",
        "Aproveche nuestros préstamos de bajo interés.     ",
        "Domicilie su nómina y entre en el sorteo de un curso de Java.     "
    };

    public FrameProductos() {
       
        inicio();
    }

    private void inicio() {
    	 setTitle("Productos");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(195,232,201));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Mostrar el título y descripción de cada producto
        for (int i = 0; i < productos.length; i++) {
            String titulo = productos[i];
            String descripcion = descripciones[i];

            JLabel labelTitulo = new JLabel(titulo);
            labelTitulo.setFont(new Font("Arial", Font.BOLD, 16));
            panel.add(labelTitulo);

            JLabel labelDescripcion = new JLabel(descripcion);
            panel.add(labelDescripcion);

            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JButton boton = new JButton("Logout");
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
                dispose();
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(boton);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

}
