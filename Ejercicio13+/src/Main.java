import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        // Creamos el JFrame y lo ponemos decente a la vista
        JFrame frame = new JFrame("Usando la PokeAPI");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(171, 219, 190));
        
        // Lo ponemos todo "bonito"
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Introduce el ID del Pokemon: ");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(new Color(35, 54, 42));
        JTextField textField = new JTextField(10);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 0), 2));
        JButton button = new JButton("Buscar");
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(62, 99, 76));
        button.setBorder(BorderFactory.createLineBorder(new Color(33, 51, 40), 2));
        panel.setBackground(new Color(127, 176, 146));
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        
        // Creamos el label para poner el sprite
        JLabel spriteLabel = new JLabel();
        spriteLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(BorderLayout.CENTER, spriteLabel);
        
        // Y aqui el label para la información
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(new Color(127, 176, 146));
        infoPanel.setLayout(new GridBagLayout());
        frame.getContentPane().add(BorderLayout.SOUTH, infoPanel);
        
        // Añadimos la funcionalidad del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ID = Integer.parseInt(textField.getText()); // El ID lo escribimos nosotros
                    
                    // Conectamos con la API
                    URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + ID);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.connect();
                    
                    int tiempoDeRespuesta = con.getResponseCode();
                    if (tiempoDeRespuesta != 200) {
                        throw new RuntimeException("HttpResponseCode " + tiempoDeRespuesta);
                    } else {
                        // Obtenemos la información del Pokemon
                        StringBuilder info = new StringBuilder();
                        Scanner sc = new Scanner(url.openStream());
                        
                        while(sc.hasNext()) {
                            info.append(sc.nextLine());
                        }
                        
                        // Guardamos información del Pokemon
                        JSONObject pokemon = new JSONObject(info.toString());
                        String nombre = pokemon.getString("name");
                        double peso = pokemon.getDouble("weight");
                        double altura = pokemon.getDouble("height");
                        JSONArray tipos = pokemon.getJSONArray("types");
                        // Obtener el tipo o tipos del Pokemon
                        StringBuilder tiposString = new StringBuilder();
                        for (int i = 0; i < tipos.length(); i++) {
                            JSONObject tipo = tipos.getJSONObject(i).getJSONObject("type");
                            tiposString.append(tipo.getString("name"));
                            if (i < tipos.length() - 1) {
                                tiposString.append(", ");
                            }
                        }
                        
                        // Mostramos la información en el panel
                        infoPanel.setLayout(new GridLayout(4, 2, 5, 5)); // Para tenerlo organizado y más o menos bonito (he tenido que buscar documentación porque ni idea de como se hacía)

                        infoPanel.add(new JLabel("Nombre: "));
                        infoPanel.add(new JLabel(nombre.substring(0, 1).toUpperCase() + nombre.substring(1)));
                        infoPanel.add(new JLabel("Peso: "));
                        infoPanel.add(new JLabel(String.format("%.1f kg", peso / 10)));
                        infoPanel.add(new JLabel("Altura: "));
                        infoPanel.add(new JLabel(String.format("%.1f m", altura / 10)));
                        infoPanel.add(new JLabel("Tipo: "));
                        infoPanel.add(new JLabel(tiposString.toString()));
                        
                        // Obtenemos el sprite del Pokemon
                        JSONObject sprites = pokemon.getJSONObject("sprites");
                        String spriteURL = sprites.getString("front_default");
                        URL imageURL = new URL(spriteURL);
                        ImageIcon icon = new ImageIcon(imageURL);
                        spriteLabel.setIcon(icon);
                        
                        // Guardamos la información del Pokemon en un archivo de texto
                        FileWriter fileWriter = new FileWriter("pokemon.txt");
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.println("Nombre: " + nombre.substring(0, 1).toUpperCase() + nombre.substring(1));
                        printWriter.println("Peso: " + String.format("%.1f kg", peso / 10));
                        printWriter.println("Altura: " + String.format("%.1f m", altura / 10));
                        printWriter.println("Tipo: " + tiposString.toString());
                        printWriter.close();
                        
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Introduce un ID válido.");
                } catch (IOException ex) {
                    System.out.println("Ha ocurrido un error");
                } catch (Exception ex) {
                    System.out.println("Ha ocurrido un error: " + ex.getMessage());
                }
            }
        });
        
        // Mostramos el JFrame
        frame.setVisible(true);
    }
}
