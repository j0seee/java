import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

import java.util.List;

public class Vista extends JFrame {
	
	private JTable table;
	private JComboBox<String> vuelosComboBox;
	

	
	public Vista(List<Vuelo> vuelos)
	{
		setTitle("Info Vuelos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		
		iniciarPanel(vuelos);
		completarPanel(vuelos);
	}
	
	private void iniciarPanel(List<Vuelo> vuelos)
	{
		JPanel panel = new JPanel(new BorderLayout());
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		
		vuelosComboBox = new JComboBox<>();
		
		for (Vuelo vuelo  : vuelos)
		{
			vuelosComboBox.addItem(vuelo.getNombre());
		}
		
		// Esto es para poder cambiar el vuelo que queremos mostrar por pantalla
		vuelosComboBox.addActionListener(e -> { int i = vuelosComboBox.getSelectedIndex();
			if (i >= 0)
			{
				Vuelo vuelo_aux =vuelos.get(i);
				mostrarVuelo(vuelo_aux);
			}
		});
		
		panel.add(vuelosComboBox, BorderLayout.NORTH);
		
		add(panel);
		
	}
	
	private void completarPanel(List<Vuelo> vuelos)
	{
		DefaultTableModel model = new DefaultTableModel();
		
		 model.addColumn("Nombre del vuelo");
	     model.addColumn("Origen");
	     model.addColumn("Destino");
	     model.addColumn("Fecha de salida");
	     model.addColumn("Fecha de llegada");
	     
	     for (Vuelo vuelo : vuelos)
	     {
	    	 Object[] aux = { vuelo.getNombre(), vuelo.getOrigen(), vuelo.getDestino(), vuelo.getSalida(), vuelo.getLlegada()
 	     };
	    	 
	    model.addRow(aux);
	}
	    
	     table.setModel(model);
	}
	
	private void mostrarVuelo(Vuelo vuelo)
	{
		String aux = "Nombre: " + vuelo.getNombre() + "\n"
                + "Origen: " + vuelo.getOrigen() + "\n"
                + "Destino: " + vuelo.getDestino() + "\n"
                + "Fecha Salida " + vuelo.getSalida() + "\n"
                + "Fecha Llegada " + vuelo.getLlegada();
		
		JOptionPane.showMessageDialog(this, aux, "Información del vuelo", JOptionPane.INFORMATION_MESSAGE);
	}

}
