import java.util.LinkedList;

public class ZonaUrbana extends Zona {
    private LinkedList<Sensor> sensores = new LinkedList<>();

    public ZonaUrbana(String nome) {
        super(nome);
    }

    public void adicionarSensor(Sensor s) {
        sensores.add(s);
    }

    public double calcularTotal() {
        return sensores.stream().mapToDouble(Sensor::getAqi).sum();
    }

    public double calcularMedia() {
        if (sensores.isEmpty()) return 0;
        return calcularTotal() / sensores.size();
    }

    public String classificarNivelEmergencia() {
        double media = calcularMedia();
        if (media <= 50) return "Sem risco";
        else if (media <= 100) return "Monitoramento intensificado";
        else if (media <= 150) return "Alerta para grupos sensíveis";
        else if (media <= 200) return "Alerta Amarelo";
        else if (media <= 300) return "Alerta Laranja";
        else return "Alerta Vermelho (emergência total)";
    }

    public String relatorio() {
        double total = calcularTotal();
        double media = calcularMedia();
        String nivel = classificarNivelEmergencia();

        String relatorio = "Zona: " + getNome() +
                "\nTotal semanal: " + total +
                "\nMédia semanal: " + String.format("%.2f", media) +
                "\nNível de emergência: " + nivel;

        if (nivel.contains("Vermelho")) {
            relatorio += "\n>>> Ação imediata recomendada: evacuação ou restrição de atividades externas.";
        }

        return relatorio;
    }
}
