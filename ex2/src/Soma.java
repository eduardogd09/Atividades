import java.util.ArrayList;
import java.util.Scanner;

public class Soma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quantos números?");
        int n = sc.nextInt();
        
        ArrayList<Integer> lista = new ArrayList<>();
        
        System.out.println("Digite os números:");
        for (int i = 0; i < n; i++) {
            lista.add(sc.nextInt());
        }

        boolean valor = false;
        int i = 2;

        while (i < n && !valor) {
            int j = 0;
            while (j < i && !valor) {
                int k = j + 1;
                while (k < i) {
                    if (lista.get(i) == lista.get(j) + lista.get(k)) {
                        valor = true;
                        break;
                    }
                    k++;
                }
                j++;
            }
            i++;
        }

        if (valor) {
            System.out.println("Existe um elemento que é a soma de dois anteriores.");
        } else {
            System.out.println("Nenhum elemento é a soma de dois anteriores.");
        }

        sc.close();
    }
}
