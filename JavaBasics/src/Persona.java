
public class Persona {
	private int edad;
	private float estatura;
	private int peso;
	private String nombre;
	private boolean genero;
	private FechaNacimiento fechanacimiento;
	
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getEstatura() {
		return estatura;
	}
	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isGenero() {
		return genero;
	}
	public void setGenero(boolean genero) {
		this.genero = genero;
	}
	public FechaNacimiento getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(FechaNacimiento fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	
	
	public String quienSoy() {
		return "Soy una persona";
	}
	
	public String saluda() {
		return "\nHola!! mi nombre es: "+nombre;
	}
	

}
