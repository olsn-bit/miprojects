import java.util.Arrays;
import java.io.*;
import java.io.IOException;
public class sandbox {

		public static void main(String[] args) {
				File file = new File("passcodes.txt");
				int inputcount = 0;
				if(file.delete()) {
						System.out.println("File deleted successfully");
				}
				else{
						System.out.println("Failed to delete the file");
				}
				try(FileWriter fw = new FileWriter("passcodes.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
						String chars = "abcdefghijklmnopqrstuwxyz";
						int actual_length = 6;
						char[] password;
						int[] pass_codes;
						while(actual_length < 7) {
								password = new char[actual_length];
								pass_codes = new int[actual_length];
								Arrays.fill(pass_codes,0);
								while(pass_codes[0]<chars.length()-1) {
										pass_codes[actual_length-1]++;
										for(int e = 0; e<pass_codes.length; e++) {
												if(pass_codes[e] == chars.length()-1) {
														try{
																pass_codes[e-1]++;
																pass_codes[e] = 0;
														}catch(Exception i) {}
												}
										}
										System.out.println(Arrays.toString(pass_codes)+chars.length());
										System.out.print(codelisttocharlist(pass_codes,chars));
										if(inputcount%10==0) {System.out.println(); out.println(); inputcount=0;}
										out.print(codelisttocharlist(pass_codes,chars));
										inputcount++;
								}
								actual_length++;
						}
				}catch(Exception i) {}
		}
		public static String codelisttocharlist(int[] codes, String chars){
				String word = "";
				for( int e = 0; e<codes.length; e++) {
						word += chars.charAt(codes[e]);
				}
				return word+",";
		}
}
