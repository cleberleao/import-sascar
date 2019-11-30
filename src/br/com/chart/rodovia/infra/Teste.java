package br.com.chart.rodovia.infra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Teste {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) throws FileNotFoundException {
    ArrayList<String> vet = new ArrayList<>();
    String aux = null;
    int i = 0;
    vet.add("nome");
    vet.add("cidade");
    vet.add("estado");
    vet.add("aula");
    vet.add("cifra");


      BufferedReader lerArq = new BufferedReader(new FileReader("macros.csv"));
      String s;
      int n = 0;
      try{
          while ((s = lerArq.readLine()) != null){
              n++;
          }
          System.out.println(s);
      }
   catch(Exception e){
       System.out.println("Excecao1\n");
   }

    System.out.println("Vetor desordenado: ");
    for (i = 0; i < 5; i++) {
        System.out.println(" " + vet.get(i));
    }
    System.out.println(" ");
    for (i = 0; i < vet.size(); i++) {
        for (int j = 0; j < vet.size()-1; j++) {
            if (vet.get(j).compareToIgnoreCase(vet.get(j + 1)) > 0) {
                aux = vet.get(j);
                vet.set(j, vet.get(j + 1));
                vet.set(j + 1, aux);
            }
        }
    }
    System.out.println("Vetor organizado:");
    for (i = 0; i < vet.size(); i++) {
        System.out.println(" " + vet.get(i));

    }
    int x = 1;
     System.out.println(vet.get(x-1));
}
}