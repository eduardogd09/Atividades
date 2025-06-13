import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Zona> zonas = new TreeSet<>();
        int opcao = 0;

        System.out.println("=== SISTEMA DE MONITORAMENTO DE QUALIDADE DO AR ===");

        while (opcao != 4) {
            System.out.println("\n1. Registrar Zona");
            System.out.println("2. Adicionar Sensor");
            System.out.println("3. Imprimir Relatório (Zona Urbana ou Rural)");
            System.out.println("4. Finalizar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome da Zona: ");
                String nome = sc.nextLine();
                System.out.print("Tipo (U para Urbana, R para Rural): ");
                char tipo = sc.nextLine().toUpperCase().charAt(0);
                if (tipo == 'U') zonas.add(new ZonaUrbana(nome));
                else if (tipo == 'R') zonas.add(new ZonaRural(nome));
                else System.out.println("Tipo inválido.");

            } else if (opcao == 2) {
                System.out.print("Nome da Zona Urbana: ");
                String nome = sc.nextLine();
                Zona z = zonas.stream()
                        .filter(zo -> zo.getNome().equalsIgnoreCase(nome))
                        .findFirst().orElse(null);

                if (z instanceof ZonaUrbana) {
                    System.out.print("ID do sensor: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // limpa buffer

                    System.out.print("Data: ");
                    String data = sc.nextLine();

                    System.out.print("Valor AQI: ");
                    double valor = sc.nextDouble();
                    sc.nextLine(); // limpa buffer

                    ((ZonaUrbana) z).adicionarSensor(new Sensor(id, data, valor));
                } else {
                    System.out.println("Zona não encontrada ou não é urbana.");
                }

            } else if (opcao == 3) {
                System.out.print("Nome da Zona: ");
                String nome = sc.nextLine();
                Zona zona = zonas.stream()
                        .filter(zo -> zo.getNome().equalsIgnoreCase(nome))
                        .findFirst().orElse(null);

                if (zona != null) {
                    System.out.println("\n=== RELATÓRIO DE EMERGÊNCIA AMBIENTAL ===");
                    System.out.println(zona.relatorio());

                    if (zona instanceof ZonaUrbana && ((ZonaUrbana) zona).calcularMedia() > 300) {
                        System.out.println(">>> ALERTA EXTREMO: Média crítica ultrapassada!");
                    }
                } else {
                    System.out.println("Zona não encontrada.");
                }

            } else if (opcao == 4) {
                System.out.println("Aplicação finalizada.");
            } else {
                System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}
