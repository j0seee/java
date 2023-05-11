import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Artista[] artistas = new Artista[5];
		
		// Mis 5 artistas favoritos del momento, muy recomendables 
		
		Artista dellafuente = new Artista("Dellafuente", "Musica Folklorica Atemporal", 2991613, "España");
		Artista recycled = new Artista("Recycled J", "Rap/R&B", 1291591, "España");
		Artista taylor = new Artista("Taylor Swift", "Pop",83956266, "USA" );
		Artista selecta = new Artista("Selecta", "Electrónica", 740824, "España" );
		Artista thenational = new Artista ("The National", "Indie Rock", 7917423, "USA");
		
		// Los meto en el array
		artistas[0] = dellafuente;
		artistas[1] = recycled;
		artistas[2] = taylor;
		artistas[3] = selecta;
		artistas[4] = thenational;
		
		// Creo el JFrame y lo pongo presentable
		JFrame frame = new JFrame("Información de los artistas");
        frame.setSize(1015, 568);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBackground(new Color(240, 240, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        
        // Creo dos label por cada información que quiero mostrar, uno para el nombre y otra para la información en sí
        JLabel nombreLabel = new JLabel("Nombre: ");
        JLabel generoLabel = new JLabel("Género: ");
        JLabel reproduccionesLabel = new JLabel("Reproducciones mensuales: ");
        JLabel paisLabel = new JLabel("País donde más se escucha: ");
        JLabel recaudacionLabel = new JLabel("Recaudación monetaria: ");
        JLabel proyeccionLabel = new JLabel("Proyeccion anual: ");
        
        JLabel nombreValue = new JLabel();
        JLabel generoValue = new JLabel();
        JLabel reproduccionesValue = new JLabel();
        JLabel paisValue = new JLabel();
        JLabel recaudacionValue = new JLabel();
        JLabel proyeccionValue = new JLabel();
        
        // Tantos botones como artistas, ya que hay poquitos
        JButton[] botones = new JButton[artistas.length];
        
        for (int i = 0; i < artistas.length; i++) {
            final int index = i;
            botones[i] = new JButton(artistas[i].getNombre());
            botones[i].setPreferredSize(new Dimension(150, 50));
            botones[i].setForeground(Color.WHITE);
            botones[i].setBackground(new Color(0, 102, 204));
            botones[i].setFont(new Font("Arial", Font.BOLD, 14));
            botones[i].setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0, 102, 204), 2),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	Artista artista = artistas[index];
                    nombreValue.setText(artista.getNombre());
                    generoValue.setText(artista.getGenero());
                    reproduccionesValue.setText(String.valueOf(artista.getCant_rep()));
                    paisValue.setText(artista.getPais_mas_esc());
                    recaudacionValue.setText(String.valueOf(artista.RecaudacionMonetaria()));
                    proyeccionValue.setText(String.valueOf(artista.ProyeccionAnual()));

                }
            });
            panel.add(botones[i]);
        }
        
        panel.add(nombreLabel);
        panel.add(nombreValue);
        
        panel.add(generoLabel);
        panel.add(generoValue);
        
        panel.add(reproduccionesLabel);
        panel.add(reproduccionesValue);
        
        panel.add(paisLabel);
        panel.add(paisValue);
        
        panel.add(recaudacionLabel);
        panel.add(recaudacionValue);
        
        panel.add(proyeccionLabel);
        panel.add(proyeccionValue);
        
        frame.add(panel);
        frame.setVisible(true);
        
        // Al final imprime los datos en un txt
        
        FileWriter fw;
		try {
			fw = new FileWriter("artistas.txt");
			for (int i = 0; i < artistas.length; i++) {
				fw.write("Artista numero: "+ (i+1) +": Nombre:" +  artistas[i].getNombre() + " ; Género: " + artistas[i].getGenero() + "; Cantidad de reproducciones: " +
				        artistas[i].getCant_rep() + "; País donde más se le escucha: " + artistas[i].getPais_mas_esc() + "; Recaudación monetaria: "+ artistas[i].RecaudacionMonetaria() + 
				        "; Proyección anual: " + artistas[i].ProyeccionAnual() + "\n");
				fw.write("\n");
			}
				fw.close();
				
				System.out.println("Se ha generado el txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        	}
        
        
}
