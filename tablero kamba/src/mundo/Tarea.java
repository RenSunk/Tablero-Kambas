package mundo;

public class Tarea {
	
	private int estado;
	
	private int prioridad;
	
	private String nombre;
	
	private final int urgente = 100;
	
	private final int importante = 50 ;
	
	private final int normal = 0 ;
	
	private final int por_hacer = 100 ;
	
	private final int en_curso = 50 ;
	
	private final int finalizada = 0 ;
	
	public Tarea(int estado, int prioridad, String nombre) {
		this.estado = estado;
		this.prioridad = prioridad;
		this.nombre = nombre;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUrgente() {
		return urgente;
	}

	public int getImportante() {
		return importante;
	}

	public int getNormal() {
		return normal;
	}

	public int getPor_hacer() {
		return por_hacer;
	}

	public int getEn_curso() {
		return en_curso;
	}

	public int getFinalizada() {
		return finalizada;
	}
	
}
