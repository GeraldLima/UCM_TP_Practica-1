
/**
 * Clase que implementa las instrucciones de tipo bytecode
 * 
 */
public class ByteCode {

	private ENUM_BYTECODE name;
	private int param;
	
	/**
	 * Constructora que recibe un byteCode como parametro
	 * @param codigoByte, el byteCode de tipo enumerado
	 */
	public ByteCode(ENUM_BYTECODE codigoByte){
		this.name = codigoByte;
	}
	
	/**
	 * Constructora que recibe un byteCode y un parametro
	 * @param codigoByte, enumerado que recibe
	 * @param parametro, parametro que recibe
	 */
	public ByteCode(ENUM_BYTECODE codigoByte, int parametro){
		this.name = codigoByte;
		this.param = parametro;
	}
	
	
	public ENUM_BYTECODE getByteCode(){
		return name;
	}
	public int get_param() {
		return param;
	}
	
	/**
	 * Metodo que devuelve el nombre del tipo enumerado
	 * @return nombre del byteCode
	 */
	public String getNombreBytecode(){
		return name.getNombre(); //metodo que me devuelve el nombre del eunumerado
	}
	
	/**
	 * Metodo que devuelve el numero de palabras que tiene el enumerado
	 * @return numero de palabras
	 */
	public int getNumeroPalabras(){
		return name.getNumPalabras(); //accedo al numero de palabras que tiene el enumerado
	}
	
}
