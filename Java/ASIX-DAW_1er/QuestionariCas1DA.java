import java.util.Scanner;


public class QuestionariCas1DA{

    public static void main(String []args){
        final int saw_size = 2;

        System.out.println("Introdueixi la mida del llistó (en mm sense decimals):");
        Scanner sc = new Scanner(System.in);
        int total_length = sc.nextInt();

        int three_cuts_raw_q = total_length - (4-1)*(saw_size);
        int piece_length = three_cuts_raw_q/4;

        int unused_piece = three_cuts_raw_q%4;
        boolean four_cuts = unused_piece >= saw_size;

        boolean three_cuts_sand = unused_piece > 0 && unused_piece < saw_size;
        // System.out.println("Mida de la fusta si fem 3 talls: "+three_cuts_raw_q+"mm");
        System.out.println("Mida de les peçes individualment : "+piece_length+"mm /"+piece_length/1000+"m");
        System.out.println("Mida del quart troç : "+unused_piece+"mm");
        System.out.println("Cal fer 4 talls? "+four_cuts);
        System.out.println("Cal fer 3 talls i llimar? "+three_cuts_sand);

    }
}
