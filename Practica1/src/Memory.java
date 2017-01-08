
/**
 * Clase que representa la memoria de la maquina
 */
public class Memory {

	private static final int TAM = 2;
	private Integer[] memory;	
	
	/**
	 * Constructora
	 */
	public Memory(){
		
		this.memory = new Integer[TAM];
	
		for(int i = 0; i < this.memory.length; i++){
			memory[i] = null;//ponemos todas las posiciones a null
		}		
	}
	
	
	/**
	 * Metodo que se encarga de escribir un dato en la memoria
	 * @param pos, posicion de memoria donde vamos a escribir el dato
	 * @param value, dato a escribir
	 * @return true si se ha escrito correctamente y false en caso contrario
	 */
	public boolean write(int pos, int value){
		
		//para que no escriba si la pos esta ocupada 
		boolean ok = false;

			if (pos >= memory.length){ // si la posicion es mayor redimensionamos la memoria
				Integer[] mem2 = new Integer[pos*2];
				copiarMem(mem2); //copiamos los elementos anteriores

				 if(posicionOcupada(pos)){
					 ok = false;
				 }
				 else{
					 memory[pos] = value;
						ok= true;
				 }
				
			}
			
			else{
				
				memory[pos] = value;
				ok= true;
			}
		
		return ok;
	}
	
	
	/**
	 * Metodo que se encarga de copiar los datos de la memoria actual en otra auxiliar
	 * @param mem, nueva memoria
	 */
	public void copiarMem(Integer[] mem){
		
		for (int i = 0; i < memory.length; i++) {
			mem[i] = memory[i];
		}
		memory = mem;
	}
	
	
	/**
	 * Metodo que se encarga de leer un dato de memoria si no se lee nada devuelve un 0
	 * @param pos, posicion en la que quiero leer
	 * @return elem, elemto leido sino devuelve un 0
	 */
	public int read(int pos){
		int elem = 0;
		
		if((pos < memory.length ) && (pos >= 0)){ 
			if(memory[pos] != null){
				elem = memory[pos];
			}
		}
		
		return elem;
	}
	
	
	/**
	 * Metodo que se encarga de comprobar que si la memoria esta vacia
	 * @return true si esta vacia, false en caso contrario
	 */
	protected boolean esVacia(){
		
		boolean vacia = true;
		int i = memory.length-1; 
		
		while ( vacia && i >= 0){
			if (memory[i] != null)
				vacia = false;
			else
				i--;
		}
		
		return vacia;

	}

	
	/*protected boolean estaLlena(){
		boolean llena = true;
		int j = 0;
		while (llena && j < memory.length){
			if (memory[j] == null)
				llena = false;
			else
				j++;
		}
		return llena;
	}*/
	

	
	public boolean posicionOcupada(int posicion){	
			
		boolean ok = false;
		
		if((posicion < memory.length ) && (posicion >= 0)){ 
			if(this.memory[posicion] != null){
				ok = true;
			}
		}
		
		return 	ok;
	}
	/**
	 * Metodo que muestra por pantalla el estado de la memoria
	 */
	public String toString(){
		String s = " ";	
		
		if(esVacia())
			s = "<vacia>";	
		else{			
			for(int i = 0; i < memory.length; i++){
				if(memory[i] != null)
					s = s + "[" + i + "]:" + memory[i] + " ";				
			}
		}
		return s;
	}
}
