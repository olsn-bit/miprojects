import java.util.Random;
import java.util.Scanner;
import java.util.*;
public class Parentesis {
  public static void print(String print){
    System.out.println(print);
  }
  public static String validator(String code){
    String strinput = code;
    int opencount = 0;
    int closecount = 0;
    boolean formatcheck = false;
    Character firstchar = strinput.charAt(0);
    Character lastchar = strinput.charAt((strinput.length()-1));
    if (firstchar == '(' && lastchar ==')'){
      formatcheck = true;
    }
    for ( int e = 0 ; e < strinput.length(); ++e){
      Character sel_char = strinput.charAt(e);
      if (sel_char == '('){
        opencount++;
      }else if (sel_char == ')'){
        closecount++;
      }
    }
    if (opencount == closecount && formatcheck == true){
      return "si";
    }else{
      return "no";
    }
  }
  public static void main(String[] args){
    int value_lenght = 10;
    String var1 = "(";
    String var2 = ")";
    String returned_value = "no";
    List log = new ArrayList();
    int possiblityes = 0;
    while (possiblityes < Math.pow(2,value_lenght)){
      List total = new ArrayList();
      for (int e = 0;e<value_lenght;++e){
        double randint = Math.random();
        if ((int) (randint * 3) == 1){
          total.add(var1);
        }else{
          total.add(var2);
        }
      }
        if(log.contains(String.join("",total)) == false){
          returned_value = validator(String.join("",total));
          log.add(String.join("",total));
          possiblityes++;
          if (validator(String.join("",total))=="si"){
            System.out.println(String.join("",total));
            total_options++;
          }
        }
      }
    }
  }
