package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mundo.Proyecto;
import mundo.Tarea;

public class Agregar extends JFrame implements ActionListener{

	private int x=300,y=150;
	
	private JButton crear;
	
	@SuppressWarnings("unused")
	private JLabel nombre;
	
	private JTextField tnombre;
	
	private Proyecto miProyecto;
	
	private Principal miPrincipal;
	
	private int estado,prioridad;
	
	public Agregar(Proyecto miProyecto, Principal miPrincipal,int estado, int prioridad) {
		this.estado = estado;
		this.prioridad =prioridad;
		this.miPrincipal = miPrincipal;
		this.miProyecto = miProyecto;
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

		crear = new JButton("Crear");
		crear.addActionListener(this);
	}
	
	public void alinear_componentes() {
		setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		panel1.setLayout(new GridLayout(1, 1));
		panel2.setLayout(new GridLayout(1, 1));
		
		panel1.add(nombre);
		panel2.add(tnombre);
		
		add(crear,BorderLayout.SOUTH);
		add(panel1,BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(crear == e.getSource()) {
			miProyecto.crear_tarea(new Tarea(estado, prioridad, tnombre.getText()));
			miPrincipal.Actualizar_textos();
			dispose();
		}
	}
}
