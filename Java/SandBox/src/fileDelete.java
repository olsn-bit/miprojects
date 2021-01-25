import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class fileDelete {
    public static void main(String[] args) {
        String files;
        String frompath ="C:\\Users\\lavvo\\Downloads";
                String topath = "C:\\Users\\lavvo\\Downloads\\Images";
                String[] regex = {"png","jpg","PNG"};
        try {
            files = look4Files(frompath);
            String selected = look4Name(files,regex);
            System.out.println(selected);
            moveFilesTo(selected,frompath,topath);

        }catch (Exception e) {
            e.printStackTrace();
        }



    }

    private static void moveFilesTo(String selected, String frompath, String topath) throws IOException {
        Scanner sc = new Scanner(selected);
        Runtime.getRuntime().exec("cmd /c mkdir "+topath);

        while(sc.hasNextLine()){
            String file = sc.nextLine().substring(36);
            System.out.println("Moving "+file+" to "+topath);
            Runtime.getRuntime().exec("cmd /c MOVE "+frompath+"\\"+file+" "+topath);

        }
    }

    public static String look4Files(String path) throws Exception{
        Process p = Runtime.getRuntime().exec("cmd /c dir "+path);

        System.out.println("Command: "+ "cmd /c dir "+path);
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        prt("Read done");
        String output = null;
        while (true) {
            String line = r.readLine();
            if (line == null) { break; }
            output += line + "\n";


        }
        return output;
    }
    public static String look4Name(String dirCmd, String[] regex){
        String output = "";
        for (String s : regex) {
            System.out.println("Looking for files containing \"" + s + "\"");
            Scanner sc = new Scanner(dirCmd);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if ( line.toLowerCase().contains(s) ) output += line + "\n";
            }
        }
        return output;
    }

}
