import java.util.Random;

public class Instructor extends Persona implements Evaluable {

	private int noInstructor;
	private GradoEstudio gradoestudio;
	private int salariomensual;
	public int getNoInstructor() {
		return noInstructor;
	}
	public void setNoInstructor(int noInstructor) {
		this.noInstructor = noInstructor;
	}
	public GradoEstudio getGradoestudio() {
		return gradoestudio;
	}
	public void setGradoestudio(GradoEstudio gradoestudio) {
		this.gradoestudio = gradoestudio;
	}
	public int getSalariomensual() {
		return salariomensual;
	}
	public void setSalariomensual(int salariomensual) {
		this.salariomensual = salariomensual;
	}

	public String quienSoy() {
		return "Soy un instructor";
	}
	
	public String saluda() {
		
		return super.saluda()+"\n"+"Mi numero de profesor es: "+noInstructor;
	}
	@Override
	public int Evalua() {
		
	    Random rand = new Random();
	    int randomNum = rand.nextInt(10) ;
	    
		return randomNum;
	}
}
