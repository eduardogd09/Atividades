import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        String menu = "1. Cadastrar cidades\n2. Cadastrar ligações entre cidades\n3. Listar todas as cidades com suas ligações diretas\n4. Verificar se existe ligação direta\n5. Trajeto com tempo limite\n6. Sair";
        int opcao;

        while(true) {
            opcao = parseInt(showInputDialog(menu));
            switch(opcao) {
                case 1:
                    // cadastrarCidades();
                    break;
                case 2:
                    // cadastrarLigacoes();
                    break;
                case 3:
                    // listarCidadesELigacoes();
                    break;
                case 4:
                    // verificarLigacaoDireta();
                    break;
                case 5:
                    // trajetoComTempoLimite();
                    break;
                case 6:
                    showMessageDialog(null, "Adeus!");
                    return;
                default:
                    showMessageDialog(null, "Opção inválida");
            }
        }
    }
}
