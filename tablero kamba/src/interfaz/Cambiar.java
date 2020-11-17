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

public class Cambiar extends JFrame implements ActionListener{

	private int x=300,y=150;
	
	private JButton prioridad,estado;
	
	@SuppressWarnings("unused")
	private JLabel nombre;
	
	private JTextField tnombre;
	
	private Proyecto miProyecto;
	
	private Principal miPrincipal;
	
	public Cambiar(Proyecto miProyecto, Principal miPrincipal) {
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

		prioridad = new JButton("Prioridad");
		prioridad.addActionListener(this);
		

		estado = new JButton("estado");
		estado.addActionListener(this);
	}
	
	public void alinear_componentes() {
		setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		panel1.setLayout(new GridLayout(1, 1));
		panel2.setLayout(new GridLayout(1, 1));
		panel3.setLayout(new GridLayout(1, 2));
		
		panel1.add(nombre);
		panel2.add(tnombre);
		panel3.add(prioridad);
		panel3.add(estado);
		
		add(panel3,BorderLayout.SOUTH);
		add(panel1,BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(prioridad == e.getSource()) {
			new Prioridad(miProyecto,miPrincipal,tnombre.getText());
			dispose();
		}
		if(estado == e.getSource()) {
			new Estado(miProyecto,miPrincipal,tnombre.getText());
			dispose();
		}
	}
}