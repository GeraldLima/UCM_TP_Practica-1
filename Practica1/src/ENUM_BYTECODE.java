
/**
 * Clase que representa las instrucciones byteCode
 */
public enum ENUM_BYTECODE {
	PUSH("push", 2), 
	LOAD("load", 2), STORE("store", 2), 
	ADD("add", 1), SUB("sub", 1), MUL("mul", 1), DIV("div", 1), 
	OUT("out",1), HALT("halt", 1);
	
	private final String nombre;
	private final int numPalabras;

	/**
	 * Constructora que recibe en nombre y el numero de palabras que tiene el bytecode
	 * @param nombre, nombre del bytecode
	 * @param numPalabras, numero de palabras que tiene el bytecode
	 */
	ENUM_BYTECODE(String nombre, int numPalabras){
		this.nombre = nombre;
		this.numPalabras = numPalabras;
		
	}


	public String getNombre() {
		return nombre;
	}


	public int getNumPalabras() {
		return numPalabras;
	}
	
}
