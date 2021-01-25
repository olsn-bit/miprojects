import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.temporal.*;
public class saver {
		public static void main(String [] args){
//nutnhoney
		}
		public static void save(int Key,int[] data,int color,String name){
				DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
				LocalDateTime ara = LocalDateTime.now();
				try{
						//diners,upgrades,color,name,time
						FileWriter fstream = new FileWriter("files/data.txt");
						BufferedWriter in = new BufferedWriter(fstream);
						in.write(Key+","+data[0]+","+data[1]+","+data[2]+","+color+","+name+","+dateformat.format(ara));
						in.close();
				}catch (Exception e) {
						System.err.println("Error: " + e.getMessage());
				}
		}
		public static String[] reload(){
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String[] data = new String[6];
				try{
						FileReader fstream = new FileReader("files/data.txt");
						BufferedReader out = new BufferedReader(fstream);
						data = out.readLine().split(",");
						out.close();
				}catch (IOException e) {
						e.printStackTrace();
				}
				//Handle data
				return data;
		}
		public static int secondsBetween(String laststr){
				DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				LocalDateTime fromDateTime = LocalDateTime.parse(laststr,dateformat);
				LocalDateTime toDateTime = now;

				LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );

				long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS );
				tempDateTime = tempDateTime.plusYears( years );

				long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS );
				tempDateTime = tempDateTime.plusMonths( months );

				long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS );
				tempDateTime = tempDateTime.plusDays( days );


				long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS );
				tempDateTime = tempDateTime.plusHours( hours );

				long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES );
				tempDateTime = tempDateTime.plusMinutes( minutes );

				long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS );

				return ((int)seconds+(int)minutes*60+(int)hours*3600+(int)days*86400+(int)months*(86400*30)+(int)years*((86400*30)*12));
		}
}
