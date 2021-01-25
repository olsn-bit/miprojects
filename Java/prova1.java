import java.util.concurrent.TimeUnit;

public class prova1 {
  public static void main(String[] args) {
      // System.out.printl("Hola java");
      boolean bool = true;
      int numero;
      while (bool){
        // TimeUnit.SECONDS.sleep(1);
        numero = (int )(Math.random() * 50 + 1);
        if (numero == 18){
          bool = false;
        }
        System.out.println(bool+" Hola java"+" tinc "+numero+" anys.");
      }
      }
    }
