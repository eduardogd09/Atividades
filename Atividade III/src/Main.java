import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n, k;

        System.out.print("Insira o numero de participantes: ");
        n = entrada.nextInt();

        System.out.print("Número de batidas: ");
        k = entrada.nextInt();

        Queue<Integer> fila = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            fila.add(i);
        }

        while (fila.size() > 1) {
            for (int i = 1; i < k; i++) {
                int participante = fila.remove();
                fila.add(participante);
            }
            int eliminado = fila.remove();
            System.out.println("Jogador eliminado: " + eliminado);
        }

        System.out.println("Jogador vencedor: " + fila.peek());

        entrada.close();
    }
}
