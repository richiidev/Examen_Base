import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	@SuppressWarnings("resource")
	public void menu() throws Exception {
		
		Persona p = new Persona();
		String cadenaTemporal;
		char caracterTemporal;
		short enteroTemporal;
		double flotanteTemporal;
        boolean salir = false;
        int opcion; 
 
        Scanner sn = new Scanner(System.in);
        
        while (!salir) {
        	System.out.println("---------------------------------------------------");
        	System.out.println("Agregar Datos de Persona");
            System.out.println("   1. Nombre");
            System.out.println("   2. Edad");
            System.out.println("   3. Sexo");
            System.out.println("   4. Peso");
            System.out.println("   5. Altura");
            System.out.println("6. Calcular IMC");
            System.out.println("7. Mostrar");
            System.out.println("8. Salir");
            System.out.println("---------------------------------------------------\n");
 
            try {
                System.out.print("Seleccione una opcion: ");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1: // Nombre
                        System.out.print("Nombre Completo: ");
                        sn.nextLine();
                        cadenaTemporal = sn.nextLine();
                        p.setNombre(cadenaTemporal);
                        break;
                    case 2: // Edad
                        System.out.print("Edad: ");
                        enteroTemporal = sn.nextShort();
                        p.setEdad(enteroTemporal);
                        break;
                    case 3: // Sexo
                		System.out.print("Sexo: ");
                        caracterTemporal = sn.next().charAt(0);
                        p.setSexo(caracterTemporal);
                        break;
                    case 4: // Peso 
                        System.out.print("Peso: ");
                        flotanteTemporal = sn.nextDouble();
                        p.setPeso(flotanteTemporal);
                        break;
                    case 5: // Atura
                        System.out.print("Altura: ");
                        flotanteTemporal = sn.nextDouble();
                        p.setAltura(flotanteTemporal);
                        break;
                    case 6: // Calcular IMC
                    	short peso = p.calcularIMC();
                    	System.out.println("\n\t\tCalculo de IMC");
                    	System.out.println("---------------------------------------------------");
                    	switch (peso) {
						case -1:
							System.out.println("Falta de Peso");
							break;
						case 0:
							System.out.println("Peso Normal");
							break;
						case 1:
							System.out.println("Sobrepeso");
							break;	
						default:
							System.out.println("Error de calculo");
							break;
						}
                    	System.out.println("---------------------------------------------------");
                    	break;
                    case 7: // Mostrar
                    	System.out.println("\n\t\tPersona Registrada");
                    	System.out.println("---------------------------------------------------");
                        System.out.println(p.toString());
                    	System.out.println("---------------------------------------------------");
                        break;
                    case 8: // Salir
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
}
