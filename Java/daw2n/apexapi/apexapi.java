import java.util.*;
import java.util.zip.GZIPInputStream;
import java.io.*;
public class apexapi {
		public static void main(String[] args){

		}
		public static void getResultOfLastReadyRun() throws IOException {
				URL url = new URL("https://public-api.tracker.gg/apex/v1/standard/profile/5/RPZ_iitzBug");

				try(Scanner sc = new Scanner(new GZIPInputStream(url.openStream()))) {
						while (sc.hasNext()) {
								System.out.println(sc.nextLine());
						}
				}
		}
}
