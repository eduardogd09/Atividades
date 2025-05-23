import java.util.Stack;

public class ExServidor{

    public static int diasAteEstabilizar(int[] cargas) {
        int dias = 0;
        boolean houveMudanca = true;

        while (houveMudanca) {
            Stack<Integer> pilha = new Stack<>();
            pilha.push(cargas[0]);
            houveMudanca = false;

            for (int i = 1; i < cargas.length; i++) {
                if (cargas[i] <= cargas[i - 1]) {
                    pilha.push(cargas[i]);
                } else {
                    houveMudanca = true; 
                }
            }

            if (houveMudanca) {
                int[] nCargas = new int[pilha.size()];
                for (int i = pilha.size() - 1; i >= 0; i--) {
                    nCargas[i] = pilha.pop();
                }
                cargas = nCargas;
                dias++;
            }
        }

        return dias;
    }

    public static void main(String[] args) {
        int[] servidores = {30, 25, 40, 20, 35,50,45};

        int dias = diasAteEstabilizar(servidores);
        System.out.println("Dias até estabilizar: " + dias);
    }
}
