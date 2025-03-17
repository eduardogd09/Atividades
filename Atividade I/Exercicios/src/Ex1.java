import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 { 
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o tamanho da lista: ");
        int tamanho = sc.nextInt();
        boolean x = true;
        for (int i = 0; i < tamanho; i++){
            System.out.println("Digite  o " + (i+1) + "º número da lista");
            lista.add(sc.nextInt());

        }
        sc.close();
        for(int i = 0; i < lista.size() - 1; i++){
            if (lista.get(i) == lista.get(i+1)){
                System.out.println("O número repetido é: " + lista.get(i));
                x = false  ;
                break;
            }
            
            
        }
        if (x == true){
            System.out.println("Não há números repetidos");

        }

    }
}

// A ordem de complexidade deste algoritmo é de O(n)