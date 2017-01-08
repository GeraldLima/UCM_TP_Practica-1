
/**
 * Clase que representa la unidad de procesamiento de la maquina
 */
public class CPU {

	private Memory memory;
	private OperandStack stack;
	private boolean terminado = false;
	
	/**
	 * Constructora
	 */
	public CPU(){
	
		memory = new Memory();
		stack = new OperandStack();		
	}

	/**
	 * Metodo que se encarga de ejecutar en bytecode
	 * @param instr, instruccion bytecode que recibe
	 * @return true si se ha ejecutado correctamente false en caso contrario
	 */
	public boolean execute(ByteCode instr){
		
		int elem1, elem2, resul;
		boolean ok = false;

		if (instr.getByteCode().equals(ENUM_BYTECODE.HALT)){
			terminado = true;
			ok = true;
		}
		
		else if(instr.getByteCode().equals(ENUM_BYTECODE.PUSH)){
			stack.push(instr.get_param());
			ok = true;
		}
		
		else if(instr.getByteCode().equals(ENUM_BYTECODE.LOAD)){
			elem1 = instr.get_param();
			elem2 = memory.read(elem1);
			stack.push(elem2);
			ok = true;
		}
		
		else if(instr.getByteCode().equals(ENUM_BYTECODE.STORE)){					
			
			if (stack.pilaVacia())
				System.out.print("		La pila esta vacia.");
			
			else if (!memory.posicionOcupada(instr.get_param())){//si la posicion esta ocupada no guarda
			
				memory.write(instr.get_param(), stack.pop());//si la pila no esta vacia y la pos no esta ocupada guarda en memoria
				ok = true;
			}
			else{
				 stack.push(stack.pop());	//y vuelve a meter el elemento en la pila
				 System.out.print(System.getProperty("line.separator") + "	Error: Posicion ocupada...");
			}

		}
			
		else if(instr.getByteCode().equals(ENUM_BYTECODE.OUT)){		
		
			System.out.println(	System.getProperty("line.separator") + "La cima de la pila es: " + stack.getCima());
			ok = true;
		}
		
				
		else if(instr.getByteCode().equals(ENUM_BYTECODE.ADD)){		
			if(stack.getDimensionPila() >= 2){
				elem1 = stack.pop();
				elem2 = stack.pop();
				resul = elem2 + elem1; 
				stack.push(resul);
				ok = true;
			}
			
			
		}
		else if(instr.getByteCode().equals(ENUM_BYTECODE.SUB)){
			
			if(stack.getDimensionPila() >= 2){
				elem1 = stack.pop();
				elem2 = stack.pop();
				resul = elem2 - elem1;
				stack.push(resul);
				ok = true;
			}
			
			
		}
	
		else if(instr.getByteCode().equals(ENUM_BYTECODE.DIV)){
			if(stack.getDimensionPila() >= 2){
				elem1 = stack.pop();
				elem2 = stack.pop();
				if(elem1 == 0){
					System.out.print("");
				}
				else{
					resul = elem2 / elem1;
					stack.push(resul);
					ok = true;
				}
			}
			
		
		}
	
		else if(instr.getByteCode().equals(ENUM_BYTECODE.MUL)){
			if(stack.getDimensionPila() >= 2){
				elem1 = stack.pop();
				elem2 = stack.pop();
				resul = elem2 * elem1;
				stack.push(resul);
				ok = true;
			}
			
		}			
		
		
		return ok;
	}


	public boolean isTerminado() {
		return terminado;
	}		
	
	/**
	 * Metodo que muestra la informacion de la CPU
	 */
	public String toString(){
		String s = System.getProperty("line.separator") +
		"Estado de la CPU: " + System.getProperty("line.separator") +
		" Memoria: " + this.memory.toString() + System.getProperty("line.separator") +
		" Pila: " + this.stack.toString() + System.getProperty("line.separator");
		return s;
	}

	
}
