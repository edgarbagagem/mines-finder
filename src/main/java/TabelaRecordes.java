public class TabelaRecordes {
    private String nome;
    private long tempoDeJogo;

    public TabelaRecordes() {
        this.nome = "Anónimo";
        this.tempoDeJogo = 9999999;
    }

    public String getNome() {
        return nome;
    }

    public long getTempoDeJogo() {
        return tempoDeJogo;
    }

    public void setRecorde(String nome, long tempoDeJogo) {
        this.nome = nome;
        this.tempoDeJogo = tempoDeJogo;
    }
}
