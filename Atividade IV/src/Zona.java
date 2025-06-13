public abstract class Zona implements Emergencia, Comparable<Zona> {
    private String nome;

    public Zona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int compareTo(Zona outra) {
        return this.nome.compareTo(outra.getNome());
    }
}
