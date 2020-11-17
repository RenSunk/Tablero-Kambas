package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Proyecto {
	
	private ArrayList<Tarea> mitareas;
	
	public Proyecto() {
		mitareas = new ArrayList<>();
	}
	
	public void crear_tarea(Tarea nuevatarea) {
		mitareas.add(nuevatarea);
	}
	
	public ArrayList<Tarea> ver_tarea() {
		return mitareas;
	}
	
	public boolean eliminar_tarea(String nombre) {
		for (int i = 0; i < mitareas.size(); i++) {
			if(mitareas.get(i).getNombre().equals(nombre)) {
				mitareas.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean cambiar_estado(String nombre, int estado) {
		for (int i = 0; i < mitareas.size(); i++) {
			if(mitareas.get(i).getNombre().equals(nombre)) {
				mitareas.get(i).setEstado(estado);
				return true;
			}
		}
		return false;
	}
	
	public boolean cambiar_prioridad(String nombre, int prioridad) {
		for (int i = 0; i < mitareas.size(); i++) {
			if(mitareas.get(i).getNombre().equals(nombre)) {
				mitareas.get(i).setPrioridad(prioridad);
				return true;
			}
		}
		return false;
	}
	
	public int[] contar_estados() {
		int contar[] = new int[3];
		int contar1=0,contar2=0,contar3=0;
			for (int i = 0; i < ver_tarea().size(); i++) {
				if(ver_tarea().get(i).getEstado() == ver_tarea().get(i).getPor_hacer()) {
					contar1++;
				}else if(ver_tarea().get(i).getEstado() == ver_tarea().get(i).getEn_curso()) {
					contar2++;
				}else if(ver_tarea().get(i).getEstado() == ver_tarea().get(i).getFinalizada()) {
					contar3++;
				}
			}
		contar[0] = contar1;
		contar[1] = contar2;
		contar[2] = contar3;
 		
		return contar;
	}
	
	public void hacer_reporte(){
		try {
			File achivo = new File("./data/reporte.txt");
			PrintWriter pw = new PrintWriter(achivo);
			
			
			pw.println("Por hacer: "+contar_estados()[0]);
			pw.println("En curso: "+contar_estados()[1]);
			pw.println("Finalizadas: "+contar_estados()[2]);
			pw.close();
		} catch (IOException e) {
			
		}
	}
	
	public void leer_archivo() {
		try {
			FileReader archivo = new FileReader("./data/datos.txt");
			BufferedReader br = new BufferedReader(archivo);
			
			int tamanio = Integer.parseInt(br.readLine());
			for (int i = 0; i <tamanio; i++) {
				String nombre = br.readLine();
				int prioridad = Integer.parseInt(br.readLine());
				int estado = Integer.parseInt(br.readLine());
			crear_tarea(new Tarea(estado, prioridad, nombre));
			}
			br.close();
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Archivo para leer los datos no a sido encontrado");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null,"Error de"+e);
		}catch (NumberFormatException e) {
			
		}catch (NullPointerException e) {
			
		}
	}
}
