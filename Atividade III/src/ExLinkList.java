import java.util.LinkedList;

public class ExLinkList {

    public static LinkedList<Integer> intercalarOrdenado(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> resultado = new LinkedList<>();

        int i = 0, j = 0;

        while (i < l1.size() && j < l2.size()) {
            int val1 = l1.get(i);
            int val2 = l2.get(j);

            if (val1 <= val2) {
                resultado.add(val1);
                i++;
            } else {
                resultado.add(val2);
                j++;
            }
        }

        while (i < l1.size()) {
            resultado.add(l1.get(i));
            i++;
        }

        while (j < l2.size()) {
            resultado.add(l2.get(j));
            j++;
        }

        return resultado;
    }

    public static void main(String[] args) {
        LinkedList<Integer> lista1 = new LinkedList<>();
        LinkedList<Integer> lista2 = new LinkedList<>();

        lista1.add(1);
        lista1.add(4);
        lista1.add(5);
        lista1.add(6);
        lista1.add(9);
        lista1.add(19);

        lista2.add(2);
        lista2.add(3);
        lista2.add(7);
        lista2.add(10);
        lista2.add(12);
        lista2.add(14);


        LinkedList<Integer> resultado = intercalarOrdenado(lista1, lista2);

        System.out.println("Lista intercalada e ordenada: " + resultado);
    }
}
