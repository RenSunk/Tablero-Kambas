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

public class Estado extends JFrame implements ActionListener{

	private int x=300,y=150;
	
	private JButton cambiar;
	
	@SuppressWarnings("unused")
	private JLabel estado;
	
	private JComboBox<String> combo;
	
	private Proyecto miProyecto;
	
	private Principal miPrincipal;
	
	private String nombre;
	
	public Estado(Proyecto miProyecto, Principal miPrincipal,String nombre) {
		this.nombre = nombre;
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
		estado = new JLabel("estado");

		combo = new JComboBox<>();
		
		combo.addItem("por hacer");
		combo.addItem("en curso");
		combo.addItem("finalizada");
		
		cambiar = new JButton("Cambiar");
		cambiar.addActionListener(this);
	}
	
	public void alinear_componentes() {
		setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		panel1.setLayout(new GridLayout(1, 1));
		panel2.setLayout(new GridLayout(1, 1));
		
		panel1.add(estado);
		panel2.add(combo);
		
		add(cambiar,BorderLayout.SOUTH);
		add(panel1,BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(cambiar == e.getSource()) {
			int estado=0;
			if(combo.getSelectedIndex() == 0) {
				estado = 100;
			}else if(combo.getSelectedIndex() == 1) {
				estado = 50;
			}
			if(!miProyecto.cambiar_estado(nombre, estado)) {
				JOptionPane.showMessageDialog(null,"No se encontro tarea");
			}
			miPrincipal.Actualizar_textos();
			dispose();
		}
	}
}