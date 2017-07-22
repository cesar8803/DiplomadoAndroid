import java.util.ArrayList;

public class Launcher {

	public static void main(String[] args) {
		System.out.println("Aprendiendo Java!!!");
		
		Persona gerardo = new Persona();
		
		gerardo.setNombre("Gerardo");
		gerardo.setEdad(34);
		gerardo.setEstatura(1.75f);
		gerardo.setPeso(80);
		gerardo.setGenero(true);
		gerardo.setFechanacimiento(new FechaNacimiento(23, 5, 1983));
		
		
		
		Estudiante axel = new Estudiante();		
		//Atributos de la clase Persona
		axel.setNombre("Axel");
		axel.setEdad(19);
		axel.setEstatura(1.73f);
		axel.setFechanacimiento(new FechaNacimiento(21, 8, 1997));
		axel.setGenero(true);
		axel.setPeso(82);

		//Atributos de la clase Estudiante
		axel.setMatricula(12345678);
		axel.setGrado(new GradoEstudio());
		
				
		Instructor cesar = new Instructor();
		//Atributos de la clase Persona
		cesar.setNombre("Cesar");
		cesar.setEdad(29);
		cesar.setEstatura(1.82f);
		cesar.setFechanacimiento(new FechaNacimiento(25, 5, 1988));
		cesar.setGenero(true);
		cesar.setPeso(90);
		
		//Atributos de la clase Instructor
		cesar.setNoInstructor(87654321);
		cesar.setGradoestudio(new GradoEstudio());
		cesar.setSalariomensual(10000);
		
		ArrayList<Persona> grupodepersonas = new ArrayList<>();
		
		grupodepersonas.add(cesar);
		grupodepersonas.add(axel);
		grupodepersonas.add(gerardo);
		
		for(Persona  personaActual : grupodepersonas) {
			
			System.out.println(personaActual.saluda());
			System.out.println(personaActual.quienSoy());
			
			
			try {
				System.out.println(((Evaluable) personaActual).Evalua());
				
			}catch (Exception e) {
				System.out.println("La persona: "+personaActual.getNombre()+ " no se puede evaluar ");
			}
			
			//ClaseEstatica.calculaSalario();
		}
		
		
		
		
	}

}
