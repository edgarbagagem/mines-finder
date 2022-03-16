import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesFinder extends JFrame {

    private JPanel painelPrincipal;
    private JLabel lblNorte;
    private JPanel jPanelWest;
    private JLabel lblRecordes;
    private JLabel lblFacil;
    private JLabel lblJogadorFacil;
    private JLabel lblMedio;
    private JLabel lblJogadorMedio;
    private JLabel lblDificil;
    private JLabel lblJogadorDificil;
    private JPanel jPanelCentro;
    private JButton buttonSair;
    private JButton buttonMedio;
    private JButton buttonFacil;
    private JButton buttonDificil;

    public MinesFinder(String title) {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);
        pack();
        buttonSair.addActionListener(this::buttonSairActionPerformed);
        buttonFacil.addActionListener(this::buttonFacilActionPerformed);
        buttonMedio.addActionListener(this::buttonMedioActionPerformed);
        buttonDificil.addActionListener(this::buttonDificilActionPerformed);
    }

    private void buttonDificilActionPerformed(ActionEvent e) {
        // TODO
    }

    private void buttonMedioActionPerformed(ActionEvent e) {
        // TODO
    }

    private void buttonFacilActionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo();
        janela.setVisible(true);
    }

    private void buttonSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
