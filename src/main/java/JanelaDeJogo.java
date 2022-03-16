import javax.swing.*;
import java.awt.*;

public class JanelaDeJogo extends JFrame {
    private JPanel painelJogo;
    private BotaoCampoMinado[][] botoes;
    private CampoMinado campoMinado;

    public JanelaDeJogo(CampoMinado campoMinado){
        this.campoMinado = campoMinado;

        var largura = campoMinado.getLargura();
        var altura = campoMinado.getAltura();

        this.botoes = new BotaoCampoMinado[largura][altura];

        painelJogo.setLayout(new GridLayout(altura,largura));

        // Criar e adicionar os botões à janela
        for (int coluna = 0; coluna < altura; ++coluna) {
            for (int linha = 0; linha < largura; ++linha) {
                botoes[linha][coluna] = new BotaoCampoMinado();
                painelJogo.add(botoes[linha][coluna]);
            }
        }

        setContentPane(painelJogo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }
}
