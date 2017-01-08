
/**
 * Clase que representa los distintos comandos que puede utilizar el usuario
 */
public class Command {
	
	private ENUM_COMMAND command;
	private ByteCode instruccion;
	private int replace;
	
	/**
	 * Constructora por defecto
	 */
	public Command(){
			
	}
	
	/**
	 * Constructora que recibe un comando como parametro
	 * @param comando, comando que recibe
	 */
	public Command(ENUM_COMMAND comando){
		this.command = comando;
		instruccion = null;
		replace = -1;
	}
	
	
	/**
	 * Constructora que recibe un comando y una instruccion
	 * @param comando, comando que recibe
	 * @param instr, instruccion que recibe
	 */
	public Command(ENUM_COMMAND comando, ByteCode instr){
		this.command = comando;
		this.instruccion = instr;
		replace = -1;
	}
	
	/**
	 * Constructora que recibe un comando y un numero
	 * @param comando, comando que recibe
	 * @param replace, numero por el que vamos a reemplazar
	 */
	public Command(ENUM_COMMAND comando, int replace){
		this.command = comando;
		this.replace = replace;
		instruccion = null;
	}
	
	
	/**
	 * Metodo que se encarga de ejecutar los comandos
	 * @param engine, recibe la clase de control
	 * @return true si se ha ejecutado el comando y false en caso contrario
	 */
	public boolean execute(Engine engine){
		
		boolean ok = false;
		
		if (this.get_command().equals(ENUM_COMMAND.HELP)){					
			engine.mostrarAyuda();
			ok = true;
		}
		
		else if (this.get_command().equals(ENUM_COMMAND.RESET)){			
			engine.reset();
			ok = true;
		}
		
		else if (this.get_command().equals(ENUM_COMMAND.RUN)){			
			if(engine.run())
				ok = true;			
		}
		
		else if (this.get_command().equals(ENUM_COMMAND.NEWINST)){
			engine.newInst(instruccion);
			ok = true;
		}
			
		
		else if (this.get_command().equals(ENUM_COMMAND.REPLACE)){
			engine.replace(replace);
			ok = true;
		}
		
		else if (this.get_command().equals(ENUM_COMMAND.QUIT)){
			engine.quit();
			ok = true;
		}		
		
		return ok;
	}
	

	public ENUM_COMMAND get_command() {
		return command;
	}

	public void set_command(ENUM_COMMAND _command) {
		this.command = _command;
	}

/**
 * Metodo que devuelve el nombre de la instruccion
 * @return el nombre se la instruccion
 */
	public String nombreInstruccion() {
		return instruccion.getNombreBytecode();
	}

/**
 * Metodo que devuelve la instruccion de tipo ByteCode
 * @return instruccion
 */
	public ByteCode getInstruccion(){
		return instruccion;
	}
	
	public void setInstruccion(ByteCode instruccion) {
		this.instruccion = instruccion;
	}

	public int getReplace() {
		return replace;
	}

	public void setReplace(int replace) {
		this.replace = replace;
	}
			
	
	public String toString(){
		return this.command.toString();		
	}
}
