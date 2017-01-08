
/**
 * Clase que representa los distintos comandos
 */
public enum ENUM_COMMAND {
	
	HELP("help"), QUIT("quit"), NEWINST("newinst"), RUN("run"), RESET("reset") ,REPLACE("replace");
	
	private String info;
	
	/**
	 * Constructora
	 * @param informacion, recibe el nombre del bytecode
	 */
	ENUM_COMMAND(String informacion){
		this.info = informacion;	
	}


	public String getInfo() {
		return info;
	}

}

