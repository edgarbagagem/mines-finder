import java.io.Serializable;
import java.util.ArrayList;

public class TabelaRecordes implements Serializable {
    private String nome;
    private long tempoDeJogo;

    private transient ArrayList<TabelaRecordesListener> listeners;


    public TabelaRecordes() {
        this.nome = "Anónimo";
        this.tempoDeJogo = 9999999;
        listeners = new ArrayList<>();
    }

    public void addTabelaRecordesListener(TabelaRecordesListener list) {
        if (listeners == null) listeners = new ArrayList<>();
        listeners.add(list);
    }

    public void removeTabelaRecordesListener(TabelaRecordesListener list) {
        if (listeners != null) listeners.remove(list);
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
        if (listeners != null) {
            for (TabelaRecordesListener list : listeners)
                list.recordesActualizados(this);
        }
    }
}
