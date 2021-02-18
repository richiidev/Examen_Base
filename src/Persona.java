import java.util.Random;

public class Persona {
	
	String nombre = "";
	short edad = 0;
	String nss;
	char sexo = 'H';
	double peso = 0;
	double altura = 0;
	
	static final int FALTA_PESO = -1;
	static final int PESO_IDEAL = 0;
	static final int SOBRE_PESO = 1;
	
	public Persona(String nombre, short edad, String nss, char sexo, float peso, float altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.nss = generaNSS();
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(short edad) {
		this.edad = edad;
	}
	
	public String getNSS() {
		return nss;
	}
	
	public char getSexo() {
		return sexo;	
	}
	
	public void setSexo(char sexo) throws Exception {
		if(comprobarSexo(sexo)) {
			this.sexo = sexo;
		} else {
			throw new Exception("\u001B[31m" + "Sexo no valido" + "\u001B[0m");
		}
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public short calcularIMC() {
		
		short resultado = 0;
		int pesoMaximo = 0, pesoMinimo = 0;
		double calculo = peso/(altura*altura);
		
		switch(sexo) {
		case 'H':
			pesoMaximo = 25;
			pesoMinimo = 20;
			break;
		case 'M':
			pesoMaximo = 19;
			pesoMinimo = 24;
			break;
		}
		
		if(calculo<pesoMinimo) {
			resultado = FALTA_PESO;
		}else if(calculo>=pesoMinimo && calculo<=pesoMaximo) {
			resultado= PESO_IDEAL;
		}else if(calculo>pesoMaximo) {
			resultado = SOBRE_PESO;
		}
		
		return resultado;
	}
	
	public boolean esMayorDeEdad() {
		return (edad>60);
	}
	
	public String toString() {
		return "Nombre: " + nombre + "\nEdad: " + edad + "\nNSS: " + nss + "\nSexo: " + sexo + "\nPeso: " + peso + "\nAltura: " + altura;
	}
	
	private boolean comprobarSexo(char sexo) {
		return (sexo == 'H' || sexo == 'M');
	}
	
	private String generaNSS() {
		
		Random rnd = new Random();
        int longitud = 8;
		String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = rnd.nextInt(letras.length());
            char caracterAleatorio = letras.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

}