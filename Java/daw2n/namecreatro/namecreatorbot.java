import java.util.*;
import java.io.File;
// import java.util.ArrayList;
public class namecreatorbot {
		public static void main(String[] args){
				File noms = new File("noms.txt");
				File cognoms = new File("cognoms.txt");

				ArrayList<String> arraynoms = txtIntoArray(noms);
				ArrayList<String> arraycognoms = txtIntoArray(cognoms);
				System.out.println(Arrays.toString(arraycognoms.toArray()));
				Integer contadorNoms = 0;

				while(contadorNoms<630) {
						randomFullName(arraynoms,arraycognoms);
						contadorNoms++;
				}
		}
		public static ArrayList<String> txtIntoArray(File file){
				Scanner sc;
				ArrayList<String> array = new ArrayList<String>();
				try
				{
						sc = new Scanner(file);
						while(sc.hasNext()) {

								array.add(sc.next());
						}
				}
				catch(Exception e) {

				}
				return array;
		}
		public static void randomFullName(ArrayList<String> noms,ArrayList<String> cognoms){
				String randomName = noms.get((int)(Math.random()*noms.size()));
				String randomLastname = cognoms.get((int)(Math.random()*cognoms.size()));
				String randomLastlastname = cognoms.get((int)(Math.random()*cognoms.size()));
				System.out.println("{name: \'"+randomName+" "+randomLastname+" "+randomLastlastname+"\' },");
		}
}
