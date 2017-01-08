
/**
 * Clase que se encarga de parsear los byteCode
 */
public class ByteCodeParser {
	
	
/**
 * Metodo que se encarga parsear las instrucciones
 * @param s, el nombre de la instruccion
 * @return el byteCode parseado
 */
public static ByteCode parse(String s){
		
		ByteCode codigoByte = null;
		String codigo[] = s.split(" +");
		codigo[0] = codigo[0].toLowerCase();
		int param;

		
		
		switch(codigo[0]){
		case "push":
			if (isNum(codigo[1])){
				param = Integer.parseInt(codigo[1]);
				codigoByte = new ByteCode(ENUM_BYTECODE.PUSH, param);
			}
			
			break;
			
		case "load":
			if (codigo.length == 2 && isNum(codigo[1])){
				param = Integer.parseInt(codigo[1]);
				codigoByte = new ByteCode(ENUM_BYTECODE.LOAD, param);
			}
			break;
			
		case "store":
			if (codigo.length == 2 && isNum(codigo[1])){
				param = Integer.parseInt(codigo[1]);
				codigoByte = new ByteCode(ENUM_BYTECODE.STORE, param);
			}
			break;
			
		case "add":
			codigoByte = new ByteCode(ENUM_BYTECODE.ADD);
			break;
			
		case "sub":
			codigoByte = new ByteCode(ENUM_BYTECODE.SUB);
			break;
			
		case "mul":
			codigoByte = new ByteCode(ENUM_BYTECODE.MUL);
			break;
			
		case "div":
			codigoByte = new ByteCode(ENUM_BYTECODE.DIV);
			break;
			
		case "out":
			codigoByte = new ByteCode(ENUM_BYTECODE.OUT);
			break;
			
		case "halt":
			codigoByte = new ByteCode(ENUM_BYTECODE.HALT);
			break;
		}
		
		
		return codigoByte;
		
	}
	private static boolean isNum(String s){
		return (s.matches("[+-]?\\d*(\\.\\d+)?") && s.equals("") == false);
	}



}
