package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mundo.Proyecto;
import mundo.Tarea;

public class Eliminar extends JFrame implements ActionListener{

	private int x=300,y=150;
	
	private JButton eliminar;
	
	@SuppressWarnings("unused")
	private JLabel nombre;
	
	private JTextField tnombre;
	
	private Proyecto miProyecto;
	
	private Principal miPrincipal;
	
	public Eliminar(Proyecto miProyecto, Principal miPrincipal) {
		this.miProyecto = miProyecto;
		this.miPrincipal = miPrincipal;
		iniciar_componentes();
		alinear_componentes();
		setSize(x,y);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	
	public void iniciar_componentes() {
		nombre = new JLabel("nombre");

		tnombre = new JTextField();

		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(this);
	}
	
	public void alinear_componentes() {
		setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		panel1.setLayout(new GridLayout(1, 1));
		panel2.setLayout(new GridLayout(1, 1));
		
		panel1.add(nombre);
		panel2.add(tnombre);
		
		add(eliminar,BorderLayout.SOUTH);
		add(panel1,BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(eliminar == e.getSource()) {
			if(!miProyecto.eliminar_tarea(tnombre.getText())) {
				JOptionPane.showMessageDialog(null,"No se encontro tarea");
			}
			miPrincipal.Actualizar_textos();
			dispose();
		}
	}
}