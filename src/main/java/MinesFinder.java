import javax.swing.*;
import java.awt.*;

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
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
