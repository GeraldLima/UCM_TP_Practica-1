import java.util.Scanner;

/**
 * Clase que se encarga del control de la aplicacion
 *
 */
public class Engine {	

	private ByteCodeProgram	program;
	private boolean end;
	private Scanner in;

	/**
	 * Constructora
	 */
	public Engine(){
		
		end = false;
		program = new ByteCodeProgram();
		in = new Scanner(System.in);
		
	}
	
	/**
	 * Metodo que se encarga del control de la aplicacion
	 */
	public void start() {	
		String str;//para leer los comandos	
		String[] palabras;		
		
		do{		
			System.out.println();
			System.out.print("Comando > ");	
			str = this.in.nextLine();
			str = str.trim();
			Command comando = CommandParser.parse(str);
			palabras = str.split(" ");
		
			if (comando != null  && comando.getReplace() < program.getPosicion() ){
					
				System.out.print("Comienza la ejecucion del comando " + comando.toString().toUpperCase());//escribe el nombre del comando
		
				if(palabras.length > 1 ){
					if(comando.get_command().equals(ENUM_COMMAND.NEWINST)){
						
						System.out.print(" ");
						System.out.print(comando.nombreInstruccion().toUpperCase() + " ");//escribe el nombre de la instruccion
					}
			
				}
				
				if(palabras.length > 2){
					System.out.print(" ");
					System.out.print(comando.getInstruccion().get_param());//escribe el parametro 
				}
				
				//Se ejecuta el comando. Si devuelve false, lanza el correspondiente mensaje
				if(!comando.execute(this)){	
					
					System.out.println("Error: Ejecucion incorrecta del comando" + System.getProperty("line.separator"));	
					
				}
				
				
				//programa almacenado
				if(!comando.get_command().equals(ENUM_COMMAND.HELP) && !comando.get_command().equals(ENUM_COMMAND.RESET)){	
				
					System.out.println(System.getProperty("line.separator") + "Programa almacenado: ");				
					
					for (int i = 0; i < program.getPosicion(); i++){
					
					    ByteCode instruccion = program.getByteCode(i); //devuelvo la instruccion en dicha posicion
					    
					   if(instruccion.getNumeroPalabras() == 1){
						   
						   	System.out.print(i + ": " + instruccion.getNombreBytecode().toUpperCase() + System.getProperty("line.separator"));
					    }
					    
						if(instruccion.getNumeroPalabras() == 2){//si el bytecode es de 2 palabras
							
							System.out.print(i + ": " + instruccion.getNombreBytecode().toUpperCase());
							System.out.println( " " + instruccion.get_param());	
						}
						
					}					
				}				
				//programa almacenado
				
			}
			else{	
				
				System.out.println("Error: Comando incorrecto" + System.getProperty("line.separator"));
				
			}
			
			
			//else if (comando != null && comando.getReplace() >= program.getPosicion())
				//System.out.println("Posicion fuera de rango");
			
			
		}while (!end);
		
		if (end){
			
			System.out.println();
			System.out.println("Fin de la ejecucion...");
		}		
	}
	
	
	/**
	 * Metodo que se encarga de ejecutar las instrucciones
	 * @return true si se ha podido ejecutar, false en caso contrario
	 */
	public boolean run(){		
		boolean ok, terminado;
		CPU cpu;
		ok = false;
		cpu = new CPU();
		
		int i = 0;
		while(i < program.getPosicion() && (!cpu.isTerminado())){
			//obtengo la instruccion
			ByteCode instruccion = program.getByteCode(i);
			
	
			//se ejecutan las instrucciones			
			ok = cpu.execute(instruccion); //si devuelte false si error, sino true
			
			if(ok && !cpu.isTerminado()){
				
				System.out.print(System.getProperty("line.separator") + "El estado de la maquina tras ejecutar el bytecode " + instruccion.getNombreBytecode().toUpperCase());
				
				if(instruccion.getNumeroPalabras() == 2){
					System.out.println(" " + instruccion.get_param());				
				}
				
				System.out.print(cpu.toString());
				ok = true;
			}
			
			else if (cpu.isTerminado()){
				
				System.out.println(System.getProperty("line.separator") + "Maquina parada. Se ha pulsado HALT...");
				
			}
			i++;			
		}		
		System.out.println();
	
		return ok;	
	}
	
	
	/**
	 * Metodo que se encarga de meter una nueva instruccion en el array del programa
	 * @param bc, la instruccion a aniadir
	 */
	public void newInst(ByteCode bc){
		 	
		//aniadimos una nueva instruccion
		program.aniadirInstruccion(bc); 
	}
	
	
	/**
	 * Metodo que se encarga de inicializar el array de programa
	 */
	public void reset(){
		
		program.inicializa();
	}
	
	
	/**
	 * Metodo que se encarga de reemplazar una instruccion por otra
	 * @param repl, numero de instruccion que quiero reemplazar
	 */
	public void replace(int repl){

		String str = "";	
		String[] palabras;
		ByteCode codigoByte = new ByteCode(null, repl);
		
		do{
			
			palabras = str.split(" ");
			System.out.print("\nNueva instruccion: ");	
			str = this.in.nextLine();
			str = str.trim();
			codigoByte = ByteCodeParser.parse(str);
	
			if (codigoByte != null)
				program.colocarInstrEnPos(codigoByte, repl);
			
		}while(codigoByte == null);
	}
	 
	
	/**
	 * Metodo wue sirve para salir del programa
	 */
	public void quit(){
		end = true;
	}
	
	
	public ByteCodeProgram getProgram() {
		return program;
	}
	
	
	/**
	 * Metodo que se encargade mostrar la ayuda por pantalla
	 */
	public void mostrarAyuda(){
		
		System.out.println();
		System.out.println();
		System.out.println("HELP: Muestra esta ayuda");
		System.out.println("QUIT: Cierra la aplicacion");
		System.out.println("RUN: Ejecuta el programa");
		System.out.println("NEWINST BYTECODE: Introduce una nueva instrucción al programa");
		System.out.println("RESET: Vacia el programa actual");
		System.out.println("REPLACE N: Reemplaza la instruccion N por la solicitada al usuario\n");
	}
			
}

