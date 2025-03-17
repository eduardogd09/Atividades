import java.util.ArrayList;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos números serão adicionados na lista? ");
        int x = sc.nextInt();
        for(int i = 0; i < x; i++){
            System.out.println("Insira um número: ");
            lista.add(sc.nextInt());

        }
        System.out.println("Insira o valor de k: ");
        int k = sc.nextInt();
        sc.close();

        for(int i = 0; i < x; i++){
            if(lista.get(i)<= k){
                int aux = lista.get(i);
                lista.remove(i);
                lista.add(0,aux);
                

            }
            else{
                int aux = lista.get(i);
                lista.remove(i);
                lista.add(aux);
            }
        }
        System.out.println(lista);        
        
    }

}

