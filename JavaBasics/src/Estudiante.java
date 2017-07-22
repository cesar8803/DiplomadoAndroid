import java.util.Random;

public class Estudiante extends Persona implements Evaluable{

	private int matricula;
	private GradoEstudio grado;
	
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public GradoEstudio getGrado() {
		return grado;
	}
	public void setGrado(GradoEstudio grado) {
		this.grado = grado;
	}

	public String quienSoy() {
		return "Soy un estudiante";
	}
	
	public String saluda() {
		return super.saluda() + "\n"+"Mi numero de matricula es: "+matricula;
	}
	
	@Override
	public int Evalua() {
		
	    Random rand = new Random();
	    int randomNum = rand.nextInt(10) ;
	    
		return randomNum;
	}
}
