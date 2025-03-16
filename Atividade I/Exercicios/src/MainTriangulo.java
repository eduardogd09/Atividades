import java.util.ArrayList;
import java.util.Scanner;

public class MainTriangulo {
    public static void main(String[] args) {
    ArrayList<Triangulo> triangulo = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    System.out.println("Quantos Triangulos serão armazenados? ");
    int x = sc.nextInt();
    for(int i = 0; i < x; i ++){
        System.out.println("Qual o valor de A no " + (i+1) + "º triangulo");
        int a = sc.nextInt();
        System.out.println("Qual o valor de B no " + (i+1) + "º triangulo");
        int b = sc.nextInt();
        System.out.println("Qual o valor de C no " + (i+1) + "º triangulo");
        int c = sc.nextInt();
        triangulo.add(new Triangulo(a,b,c));

    }

    sc.close();

    for(Triangulo t : triangulo){
        t.exibirDados();
    } 


    }
    
}
