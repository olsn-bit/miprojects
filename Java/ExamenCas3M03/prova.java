import java.util.* ;

public class CastellsJosepCas3 {

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

  //Creem variables
  int num_elements = 0; //Nombre elements son els elements plens de la llista
  int valor_llista = 20; //Valor llista es la longitud total de la llista
  Double suma_total =0.0;
  int[] llista; //Creem la llista de nombres enters
  int nombresmajors = 0;
  int  comprovacio =0;//Variable que revisa que els nombres no siguin majors que 5.
  Double resultat1 = 0.0;
  int resultat2 = 0;

  llista = new int[valor_llista];
  while(sc.hasNextInt()){ //mentre hi hagin enters a llegir que realitzi el codi pertinent.

    for(int j =0;j<valor_llista;j++){ //Insereixo els elements a la llista fins que el comptador arribi al valor de la llista
        llista[j]= sc.nextInt();
        num_elements++;
      }


  comprovacio =sc.nextInt(); //Comprovem tots els nombres per a veure si son menors que 5
  if(comprovacio > 5 ){

    break;
  }
  else if(comprovacio ==-1){
    nombresmajors = sc.nextInt(); //Guardo a la variable el nombre per a comparar-lo amb tots els elements de l'array

    for(int i = 0;i<valor_llista;i++){ //Calculem la suma dels nombres de la llista
      suma_total += llista[i];

    }

    for(int k =0;; k++ ){
      if(llista[k] > nombresmajors){
        resultat2++ ;
      }
    }
    resultat1=  suma_total/num_elements;
    System.out.println(resultat1 + " " + resultat2);



  }
}
}
