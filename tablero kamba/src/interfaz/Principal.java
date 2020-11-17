package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mundo.*;

public class Principal extends JFrame implements ActionListener{
	
	private final int x=1300;
	
	private final int y=500;
	
	private Proyecto miProyecto;

	private JPanel panel_arriba,panel_izquierda,panel_centro,panel_abajo;
	
	private JTextArea[] textos_superior,textos_izquierda;
	
	private JPanel[][] paneles; 
	
	private JButton[] agregar;
	
	private JPanel[] panel_botones;
	
	private JTextArea[] textos;
	
	private JTextArea titulo;
	
	private JButton hacer_reporte,eliminar,cambiar_estado;
	
	public Principal() {
		super("Tablero Kamba");
		iniciar_componentes();
		alinear_componentes();
		Actualizar_textos();
		setSize(x, y);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void iniciar_componentes() {
		miProyecto = new Proyecto();
		miProyecto.leer_archivo();
		
		panel_arriba = new JPanel();
		panel_izquierda = new JPanel();
		panel_centro = new JPanel();
		panel_abajo = new JPanel();
		textos_superior = new JTextArea[3];
		textos_izquierda = new JTextArea[3];
		
		paneles = new JPanel[3][3];
		
		hacer_reporte = new JButton("Reporte");
		hacer_reporte.addActionListener(this);
		
		titulo = new JTextArea("tablero\nkamba");
		titulo.setEnabled(false);
		
		textos_superior[0] = new JTextArea("Urgente");
		textos_superior[1] = new JTextArea("Importante");
		textos_superior[2] = new JTextArea("Normal");
		
		textos_izquierda[0] = new JTextArea("\n\n\n\n\nPor Hacer");
		textos_izquierda[1] = new JTextArea("\n\n\n\n\nEn Curso");
		textos_izquierda[2] = new JTextArea("\n\n\n\n\nFinalizada");
		
		for (int i = 0; i < textos_izquierda.length; i++) {
			textos_izquierda[i].setEditable(false);
			textos_superior[i].setEditable(false);
		}
		

		
		for (int i = 0; i < paneles.length; i++) {
			for (int j = 0; j < paneles[0].length; j++) {
				paneles[i][j] = new JPanel(); 
			}
		}
		
		panel_botones = new JPanel[9];
		agregar = new JButton[9];		
		eliminar = new JButton("");	
		cambiar_estado = new JButton("");	
		
		for (int i = 0; i < 9; i++) {
			panel_botones[i] = new JPanel();
			agregar[i] = new JButton("Agregar");
			agregar[i].addActionListener(this);
			
		}
		
		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(this);
		cambiar_estado = new JButton("estado/prioridad");
		cambiar_estado.addActionListener(this);
		
		textos = new JTextArea[9];
		
		for (int i = 0; i < textos.length; i++) {
			textos[i] = new JTextArea();
			textos[i].setEditable(false);
		}
		
	}
	
	public void alinear_componentes() {
		setLayout(new BorderLayout());
		
		panel_arriba.setLayout(new GridLayout(1, 4));
		panel_izquierda.setLayout(new GridLayout(3, 1));
		panel_centro.setLayout(new GridLayout(3, 3,20,20));
		panel_abajo.setLayout(new GridLayout(1, 3));
		
		panel_arriba.add(titulo);
		panel_arriba.add(textos_superior[0]);
		panel_arriba.add(textos_superior[1]);
		panel_arriba.add(textos_superior[2]);
		
		
		panel_izquierda.add(textos_izquierda[0]);
		panel_izquierda.add(textos_izquierda[1]);
		panel_izquierda.add(textos_izquierda[2]);
		
		panel_abajo.add(eliminar);
		panel_abajo.add(cambiar_estado);
		panel_abajo.add(hacer_reporte);
		
		add(panel_arriba, BorderLayout.NORTH);
		add(panel_izquierda, BorderLayout.WEST);
		add(panel_centro, BorderLayout.CENTER);
		add(panel_abajo, BorderLayout.SOUTH);
		
		for (int i = 0; i < paneles.length; i++) {
			for (int j = 0; j < paneles[0].length; j++) {
				panel_centro.add(paneles[i][j]);
			}
		}
		
		for (int i = 0; i < panel_botones.length; i++) {
			panel_botones[i].setLayout(new GridLayout(1, 3));
			panel_botones[i].add(agregar[i]);
		}
		
		
		for (int i = 0,k=0; i < paneles.length; i++) {
			for (int j = 0; j < paneles[0].length; j++) {
				paneles[i][j].setLayout(new BorderLayout());
				paneles[i][j].add(textos[k],BorderLayout.CENTER);
				paneles[i][j].add(panel_botones[k],BorderLayout.SOUTH);
				k++;
			}
		}
	}
	
	public void limpiar_textos() {
		for (int i = 0; i < 9; i++) {
			textos[i].setText("");
		}
	}
	
	public void Actualizar_textos() {

		limpiar_textos();
		for (int i = 0; i < miProyecto.ver_tarea().size(); i++) {
			//por hacer y urgente
			if(miProyecto.ver_tarea().get(i).getEstado() == miProyecto.ver_tarea().get(i).getPor_hacer() && miProyecto.ver_tarea().get(i).getPrioridad() == miProyecto.ver_tarea().get(i).getUrgente()) {
				textos[0].append(miProyecto.ver_tarea().get(i).getNombre()+"\n");
			}
			// por hacer e importante
			if(miProyecto.ver_tarea().get(i).getEstado() == miProyecto.ver_tarea().get(i).getPor_hacer()  && miProyecto.ver_tarea().get(i).getPrioridad() == miProyecto.ver_tarea().get(i).getImportante()) {
				textos[1].append(miProyecto.ver_tarea().get(i).getNombre()+"\n");
			}else
			// por hacer y normal
			if(miProyecto.ver_tarea().get(i).getEstado() == miProyecto.ver_tarea().get(i).getPor_hacer()  && miProyecto.ver_tarea().get(i).getPrioridad() == miProyecto.ver_tarea().get(i).getNormal()) {
				textos[2].append(miProyecto.ver_tarea().get(i).getNombre()+"\n");
			}else
			//en curso y urgente
			if(miProyecto.ver_tarea().get(i).getEstado() == miProyecto.ver_tarea().get(i).getEn_curso()  && miProyecto.ver_tarea().get(i).getPrioridad() == miProyecto.ver_tarea().get(i).getUrgente()) {
				textos[3].append(miProyecto.ver_tarea().get(i).getNombre()+"\n");
			}else
			//en curso e importante
			if(miProyecto.ver_tarea().get(i).getEstado() == miProyecto.ver_tarea().get(i).getEn_curso()  && miProyecto.ver_tarea().get(i).getPrioridad() == miProyecto.ver_tarea().get(i).getImportante()) {
				textos[4].append(miProyecto.ver_tarea().get(i).getNombre()+"\n");
			}else
			//en curso y normal
			if(miProyecto.ver_tarea().get(i).getEstado() == miProyecto.ver_tarea().get(i).getEn_curso()  && miProyecto.ver_tarea().get(i).getPrioridad() == miProyecto.ver_tarea().get(i).getNormal()) {
				textos[5].append(miProyecto.ver_tarea().get(i).getNombre()+"\n");
			}else
			// finalizada y urgente
			if(miProyecto.ver_tarea().get(i).getEstado() == miProyecto.ver_tarea().get(i).getFinalizada()  && miProyecto.ver_tarea().get(i).getPrioridad() == miProyecto.ver_tarea().get(i).getUrgente()) {
				textos[6].append(miProyecto.ver_tarea().get(i).getNombre()+"\n");
			}else
			//finalizada e importante
			if(miProyecto.ver_tarea().get(i).getEstado() == miProyecto.ver_tarea().get(i).getFinalizada()  && miProyecto.ver_tarea().get(i).getPrioridad() == miProyecto.ver_tarea().get(i).getImportante()) {
				textos[7].append(miProyecto.ver_tarea().get(i).getNombre()+"\n");
			}else
			// finalizada y normal
			if(miProyecto.ver_tarea().get(i).getEstado() == miProyecto.ver_tarea().get(i).getFinalizada()  && miProyecto.ver_tarea().get(i).getPrioridad() == miProyecto.ver_tarea().get(i).getNormal()) {
				textos[8].append(miProyecto.ver_tarea().get(i).getNombre()+"\n");
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new Principal().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int estado=0,prioridad=0;
		for (int i = 0; i < 9; i++) {
			
			switch(i) {
			case 0:
				estado = 100;
				prioridad = 100;
				break;
			case 1:
				estado = 100;
				prioridad = 50;
				break;
			case 2:
				estado = 100;
				prioridad = 0;
				break;
			case 3:
				estado = 50;
				prioridad = 100;
				break;
			case 4:
				estado = 50;
				prioridad = 50;
				break;
			case 5:
				estado = 50;
				prioridad = 0;
				break;
			case 6:
				estado = 0;
				prioridad = 100;
				break;
			case 7:
				estado = 0;
				prioridad =  50;
				break;
			case 8:
				estado = 0;
				prioridad = 0;
				break;
			}
			if(agregar[i] == e.getSource()) {
				new Agregar(miProyecto,this,estado,prioridad);
			}
		}
		if(eliminar == e.getSource()) {
			new Eliminar(miProyecto,this);
		}
		if(cambiar_estado == e.getSource()) {
			new Cambiar(miProyecto, this);
		}
		if(hacer_reporte == e.getSource()) {
			miProyecto.hacer_reporte();
		}
	}
}
