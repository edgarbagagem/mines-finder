import java.util.ArrayList;

public class TabelaRecordes {
    private String nome;
    private long tempoDeJogo;

    private ArrayList<TabelaRecordesListener> listeners;


    public TabelaRecordes() {
        this.nome = "Anónimo";
        this.tempoDeJogo = 9999999;
        listeners = new ArrayList<>();
    }

    public void addTabelaRecordesListener(TabelaRecordesListener list) {
        listeners.add(list);
    }
    public void removeTabelaRecordesListener(TabelaRecordesListener list) {
        listeners.remove(list);
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
        notifyRecordesActualizados();
    }

    private void notifyRecordesActualizados() {
        for (TabelaRecordesListener list:listeners)
            list.recordesActualizados(this);
    }
}
