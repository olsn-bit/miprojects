import java.util.Arrays;
import java.io.*;
import java.io.IOException;
//Made By Alberto Dos Santos Rodríguez
public class ASCII_Combinations {

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
						String chars = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";
						int actual_length = 1;
						char[] password;
						int[] pass_codes;
						while(actual_length <= 8) {
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
										System.out.print(codelisttocharlist(pass_codes,chars));
										if(inputcount%10==0) {System.out.println(); out.println(); inputcount=0;}
										out.print(codelisttocharlist(pass_codes,chars));
										inputcount++;
								}
								actual_length++;
						}
				}catch(Exception i) {
						System.out.println(i);
						System.out.print("if you see this, is not working haha Made By Alberto Dos Santos Rodríguez");
				}
		}
		public static String codelisttocharlist(int[] codes, String chars){
				String word = "";
				for( int e = 0; e<codes.length; e++) {
						word += chars.charAt(codes[e]);
				}
				return word+",";
		}
}
