/**
 * Clase que se encarga de parsear los comandos
 */
public class CommandParser {

	
	public CommandParser() {

	}

	/**
	 * Metodo que se encarga de parsear los comandos
	 * 
	 * @param line, el string introducido por el usuario
	 * @return comando, devuelve el comado ya parseado
	 */
	public static Command parse(String line) {
	
		String palabras[] = line.split(" +");

		Command comando = null;

		if (palabras.length == 1) {//si la longitud del comando es 1


			if (palabras[0].equalsIgnoreCase("help")) {

				comando = new Command(ENUM_COMMAND.HELP);
			}

			else if (palabras[0].equalsIgnoreCase("quit")) {

				comando = new Command(ENUM_COMMAND.QUIT);
			}

			else if (palabras[0].equalsIgnoreCase("run")) {

				comando = new Command(ENUM_COMMAND.RUN);

			}

			else if (palabras[0].equalsIgnoreCase("reset")) {

				comando = new Command(ENUM_COMMAND.RESET);
			}
		}

		else if (palabras.length == 2) {//si la longitud del comando es 2


			if (palabras[0].equalsIgnoreCase("newinst")) {

				ByteCode bc = ByteCodeParser.parse(palabras[1]);
				if (bc != null)
					comando = new Command(ENUM_COMMAND.NEWINST, bc);

			}
			else if(palabras[0].equalsIgnoreCase("replace")){
				
				if (isNum(palabras[1])){
					int numero = Integer.parseInt(palabras[1]);					
					comando = new Command(ENUM_COMMAND.REPLACE, numero);
				}
			}
		}

		else if (palabras.length == 3) {//si la longitud del comando es 3

			if (palabras[0].equalsIgnoreCase("newinst")) {

				ByteCode bc = ByteCodeParser.parse(palabras[1] + " " + palabras[2]);
				if (bc != null)
					comando = new Command(ENUM_COMMAND.NEWINST, bc);
			}
		}
		
		return comando;

	}

	private static boolean isNum(String s){
		return (s.matches("[+-]?\\d*(\\.\\d+)?") && s.equals("") == false);
	}
}
