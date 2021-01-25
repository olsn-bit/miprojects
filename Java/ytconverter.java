import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
	catch (IOException e) {
public class ytconverter {
		public static void main(String[] args){
				File file = new File("ytlinks.txt");
				int counter = 0;
				String[] linklist = new String[10];
				try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name())) {
						while (counter<10 && sc.hasNextLine()) {
								String nextLine = sc.nextLine();
								if (nextLine != null) {
										linklist[counter] = nextLine.substring(32);
										counter++;
								}
						}
				}
				catch (IOException e) {
						e.printStackTrace();
				}

				for (String e : linklist) {
						if ( e != null) {
								InputStream in = new URL(FILE_URL).openStream();
								Files.copy(in, Paths.get(FILE_NAME), StandardCopyOption.REPLACE_EXISTING);
						}
				}
				// for (int e : linklist) {
				//      final WebClient webClient = new WebClient();
				//      HtmlPage page1 = webClient.getPage("https://www.pointmp4.com/es/musica/descarga/"+ytcode+"#");
				//      System.out.println(e);
				// }
		}
}
