
/**
 * Clase que representa la pila
 */
public class OperandStack {
	
	private static final int TAMPILA = 1;	
	private int posPila;
	private int[] stack;
	
	/**
	 * Constructora
	 */
	public OperandStack(){
		this.stack = new int[TAMPILA];
		this.posPila = 0; //no hay ningun elemento metido en la pila. Esta vacia

	}
	
	
	/**
	 * Metodo que se encarga de meter un elemento en la pila
	 * @param elemento, elemento a meter en la pila
	 */
	public void push(int elemento){
		
		if(pilaLlena()){
			int[] stackAux = new int[posPila*2];
			copiarPila(stackAux);

		}
		
		stack[posPila] = elemento;
		posPila = posPila + 1; 
		
			
	}
	
	
	/**
	 * Metodo que se encarga de meter un elemento en la pila
	 * @return el elemento metido
	 */
	public int pop(){
	
		int elemento = stack[posPila - 1]; //getCima();
		posPila = posPila - 1;
		
		return elemento;
	}
	
	/**
	 * Metodo que se encarga de copiar los elementos de la pila
	 * @param pila, pila auxiliar
	 */
	private void copiarPila(int[] pila){
		for (int i = 0; i < posPila; i++) {
			pila[i] = stack[i];
		}
		stack = pila;
	}
	
	/**
	 * Metodo que devuelve la cima de la pila
	 * @return elemento de la cima
	 */
	public int getCima(){ //devuelve el de la posicion pos
		int cima = stack[posPila - 1];
		return cima;
	}	
	
	/**
	 * Metodo que comprueba si la pila esta vacia
	 */
	public boolean pilaVacia(){
		return posPila == 0;
 	}
	
	/**
	 * Metodo que comprueba si la pila esta llena
	 */
	public boolean pilaLlena(){
		return posPila >= TAMPILA;
 	}
	
	public int getPosPila(){
		return posPila;
	}	
	
	
	public int getDimensionPila(){
		return this.posPila;
	}
	
	/**
	 * Metodo que muestra el estado de la pila
	 */
	public String toString(){
		
		String s = " ";
		
		if(pilaVacia()){
			s = "<vacia>";
		}
		else
			for(int i = 0; i < posPila; i++){
				s = s + stack[i] + " ";
			}		
		return s;
	}
	
}
