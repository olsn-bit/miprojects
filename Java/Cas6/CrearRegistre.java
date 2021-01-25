/**
* <h1>Javadocs example 2 </h1>

* This class aims to deal with standard input output for the application. 

*

* @author  Maria Merino

* @version 1.0

* @since   2017-04-30

*/

import java.io.File;
import java.io.PrintStream;

class CrearRegistre{
	File f;
	
	public static void main (String[] args) {
        CrearRegistre programa = new CrearRegistre();
        programa.inici();  
    }
	
	public void inici(){
		try {
			//S'intenta obrir el fitxer de sortida
			f = new File("dades.txt");
			PrintStream escriptor = new PrintStream(f);
			
			escriptor.println(5); 
			
			for( int j = 1; j<6; j++){
				escriptor.println(crearLinea(j));  //aconseguim la linea i l'escrivim			
			}
			escriptor.close();

		} catch (Exception e) {
			//Excepció!
			System.out.println("Error al guardar registre: " + e);
		}
	}
	
	public String crearLinea(int posicio) {
		String lineaPerArxivar = "";
		for (int j = 1; j < 5; j++){
			lineaPerArxivar = lineaPerArxivar + "fila" + posicio + "camp"+j+"/";
		}
		lineaPerArxivar = lineaPerArxivar + "fila" + posicio + "camp"+5;
		return lineaPerArxivar;
	}		
}