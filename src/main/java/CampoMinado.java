import java.util.Random;

public class CampoMinado {
    private boolean[][] minas;
    public static final int VAZIO = 0;
    /* de 1 a 8 são o número de minas à volta */
    public static final int TAPADO = 9;
    public static final int DUVIDA = 10;
    public static final int MARCADO = 11;
    public static final int REBENTADO = 12;
    private int[][] estado;
    private int largura;
    private int altura;
    private int numMinas;
    private boolean primeiraJogada;
    private boolean jogoTerminado;
    private boolean jogadorDerrotado;
    private long instanteInicioJogo;
    private long duracaoJogo;


    public CampoMinado(int largura, int altura, int numMinas) {
        this.largura = largura;
        this.altura = altura;
        this.numMinas = numMinas;
        minas = new boolean[largura][altura];//valores começam a false
        estado = new int[largura][altura];//valores começam a 0
        primeiraJogada = true;
        jogoTerminado = false;
        jogadorDerrotado = false;

        for (var x = 0; x < largura; ++x) {
            for (var y = 0; y < altura; ++y) {
                estado[x][y] = TAPADO;
            }
        }
    }


    public int getEstadoQuadricula(int x, int y) {
        return estado[x][y];
    }

    public boolean hasMina(int x, int y) {
        return minas[x][y];
    }

    public boolean isJogoTerminado() {
        return jogoTerminado;
    }

    public boolean isJogadorDerrotado() {
        return jogadorDerrotado;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public void revelarQuadricula(int x, int y) {
        if (jogoTerminado || estado[x][y] < TAPADO) {
            return;
        }

        if (primeiraJogada){
            primeiraJogada = false;
            colocarMinas(x,y);

            instanteInicioJogo = System.currentTimeMillis();
        }

        if(hasMina(x,y)){
            estado[x][y]= REBENTADO;
            jogoTerminado = true;
            jogadorDerrotado = true;
            duracaoJogo = System.currentTimeMillis() - instanteInicioJogo;
        } else {
            estado[x][y] = contarMinasVizinhas(x,y);
            if(estado[x][y] == 0){
                revelarQuadricalusVizinhas(x,y);
            }
            if(isVitoria()){
                jogoTerminado = true;
                jogadorDerrotado = false;
                duracaoJogo = System.currentTimeMillis() - instanteInicioJogo;
            }
        }
    }

    public long getDuracaoJogo() {
        if(primeiraJogada){
            return 0;
        }

        if(!jogoTerminado){
            return System.currentTimeMillis() - instanteInicioJogo;
        }
        return duracaoJogo;
    }

    private void colocarMinas(int exceptoX, int exceptoY) {
        var aleatorio = new Random();
        var x = 0;
        var y = 0;

        for (var i = 0; i < numMinas; i++) {
            do {
                x = aleatorio.nextInt(largura);
                y = aleatorio.nextInt(altura);
            } while (minas[x][y] || (x==exceptoX && y == exceptoY));

            minas[x][y] = true;
        }
    }

    private int contarMinasVizinhas(int x, int y){
        var numMinasVizinhas = 0;

        for (var i = Math.max(0, x - 1); i < Math.min(largura, x + 2); ++i) {
            for (var j = Math.max(0, y - 1); j < Math.min(altura, y + 2); ++j) {
                if (minas[i][j]) {
                    ++numMinasVizinhas;
                }
            }
        }
        return numMinasVizinhas;
    }

    private void revelarQuadricalusVizinhas(int x, int y){
        for (var i = Math.max(0, x - 1); i < Math.min(largura, x + 2); ++i) {
            for (var j = Math.max(0, y - 1); j < Math.min(altura, y + 2); ++j) {
                if (!minas[i][j]) {
                    revelarQuadricula(i,j);
                }
            }
        }
    }

    private boolean isVitoria() {
        for (int i = 0; i < largura; ++i) {
            for (var j = 0 ; j < altura; ++j) {
                if (!minas[i][j] && estado[i][j] >= TAPADO) {
                    return false;
                }
            }
        }
        return true;
    }

    private void marcarComoTendoMina(int x, int y) {
        if (estado[x][y] == TAPADO || estado[x][y] == DUVIDA) {
            estado[x][y] = MARCADO;
        } else{
            return;//return no caso de mina destapada
        }
    }

    private void marcarComoSuspeita(int x, int y){
        if (estado[x][y] == TAPADO || estado[x][y] == MARCADO) {
            estado[x][y] = DUVIDA;
        } else{
            return;//return no caso de mina destapada
        }
    }

    private void desmarcarQuadricula(int x, int y){
        if(estado[x][y] == DUVIDA || estado[x][y] == MARCADO){
            estado[x][y] = TAPADO;
        } else {
            return;//return no caso de a mina não estar nem marcada nem assinalda como duvidosa
        }
    }
}