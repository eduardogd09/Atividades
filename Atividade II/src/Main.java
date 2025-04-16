import javax.swing.*;
import static java.lang.Integer.parseInt;

public class Main {

    static ListaDupla<Cidade> cidades = new ListaDupla<>();

    public static void main(String[] args) {
        String menu = "1. Cadastrar cidades\n2. Cadastrar ligações entre cidades\n3. Listar todas as cidades com suas ligações diretas\n4. Verificar se existe ligação direta\n5. Trajeto com tempo limite\n6. Sair";
        int opcao;
        String entrada;

        while (true) {
            entrada = JOptionPane.showInputDialog(menu);
            if (entrada != null && !entrada.equals("")) {
                opcao = parseInt(entrada);

                switch (opcao) {
                    case 1:
                        cadastrarCidade();
                        break;
                    case 2:
                        cadastrarLigacao();
                        break;
                    case 3:
                        listarTudo();
                        break;
                    case 4:
                        verificarLigacao();
                        break;
                    case 5:
                        consultarPorTempo();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Adeus!");
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            }
        }
    }

    private static void cadastrarCidade() {
        String nome = JOptionPane.showInputDialog("Digite o nome da cidade:");
        if (nome != null && !nome.trim().equals("")) {
            if (buscarCidade(nome) == null) {
                cidades.inserir(new Cidade(nome));
            } else {
                JOptionPane.showMessageDialog(null, "Cidade já cadastrada.");
            }
        }
    }

    private static void cadastrarLigacao() {
        String origem = JOptionPane.showInputDialog("Cidade de origem:");
        String destino = JOptionPane.showInputDialog("Cidade de destino:");
        if (origem != null && destino != null) {
            Cidade cidadeOrigem = buscarCidade(origem);
            if (cidadeOrigem != null) {
                String dStr = JOptionPane.showInputDialog("Distância em km:");
                String tStr = JOptionPane.showInputDialog("Fator de tráfego (0 a 2):");
                String pStr = JOptionPane.showInputDialog("Número de pedágios:");
                if (dStr != null && tStr != null && pStr != null) {
                    double distancia = Double.parseDouble(dStr);
                    double trafego = Double.parseDouble(tStr);
                    int pedagios = parseInt(pStr);
                    cidadeOrigem.getLigacoes().inserir(new Ligacao(destino, distancia, trafego, pedagios));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cidade de origem não encontrada.");
            }
        }
    }

    private static void listarTudo() {
        String resultado = "";
        No<Cidade> atual = cidades.getInicio();
    
        while (atual != null) {
            Cidade cidade = atual.getDado();
            resultado = resultado + "Cidade: " + cidade.getNome() + "\n";
    
            No<Ligacao> ligacaoAtual = cidade.getLigacoes().getInicio();
            if (ligacaoAtual == null) {
                resultado = resultado + "  (sem ligações)\n";
            } else {
                while (ligacaoAtual != null) {
                    resultado = resultado + ligacaoAtual.getDado().toString() + "\n";
                    ligacaoAtual = ligacaoAtual.getProximo();
                }
            }
    
            resultado = resultado + "\n";
            atual = atual.getProximo();
        }
    
        JOptionPane.showMessageDialog(null, resultado);
    }
    

    private static void verificarLigacao() {
        String origem = JOptionPane.showInputDialog("Cidade de origem:");
        String destino = JOptionPane.showInputDialog("Cidade de destino:");

        if (origem != null && destino != null) {
            Cidade cidadeOrigem = buscarCidade(origem);
            if (cidadeOrigem != null) {
                No<Ligacao> ligacaoAtual = cidadeOrigem.getLigacoes().getInicio();
                while (ligacaoAtual != null) {
                    Ligacao l = ligacaoAtual.getDado();
                    if (l.getDestino().equalsIgnoreCase(destino)) {
                        JOptionPane.showMessageDialog(null, "Existe ligação direta.\nTempo estimado: " + l.getTempo() + " minutos.");
                        return;
                    }
                    ligacaoAtual = ligacaoAtual.getProximo();
                }
                JOptionPane.showMessageDialog(null, "Não existe ligação direta.");
            } else {
                JOptionPane.showMessageDialog(null, "Cidade de origem não encontrada.");
            }
        }
    }

    private static void consultarPorTempo() {
        String tempoStr = JOptionPane.showInputDialog("Digite o tempo máximo (em minutos):");

        if (tempoStr != null && !tempoStr.equals("")) {
            double tempoLimite = Double.parseDouble(tempoStr);
            String resultado = "Entregas possíveis com tempo ≤ " + tempoLimite + " minutos:\n\n";

            No<Cidade> atual = cidades.getInicio();
            while (atual != null) {
                Cidade cidade = atual.getDado();
                No<Ligacao> ligacaoAtual = cidade.getLigacoes().getInicio();

                while (ligacaoAtual != null) {
                    Ligacao l = ligacaoAtual.getDado();
                    if (l.getTempo() <= tempoLimite) {
                        resultado = resultado + cidade.getNome() + " → " + l.getDestino() + " (" + l.getTempo() + " min)\n";
                    }
                    ligacaoAtual = ligacaoAtual.getProximo();
                }

                atual = atual.getProximo();
            }

            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    private static Cidade buscarCidade(String nome) {
        No<Cidade> atual = cidades.getInicio();
        while (atual != null) {
            Cidade c = atual.getDado();
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
            atual = atual.getProximo();
        }
        return null;
    }
}
