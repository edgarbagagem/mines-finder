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
    private JLabel lblTempoFacil;
    private JLabel lblTempoMedio;
    private JLabel lblTempoDificil;

    private TabelaRecordes recordesFacil;
    private TabelaRecordes recordesMedio;
    private TabelaRecordes recordesDificil;

    public MinesFinder(String title) {
        super(title);

        recordesFacil = new TabelaRecordes();
        recordesMedio = new TabelaRecordes();
        recordesDificil = new TabelaRecordes();

        recordesFacil.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesFacilActualizado(recordes);
            }
        });
        recordesMedio.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesMedioActualizado(recordes);
            }
        });
        recordesDificil.addTabelaRecordesListener(new TabelaRecordesListener() {
            @Override
            public void recordesActualizados(TabelaRecordes recordes) {
                recordesDificilActualizado(recordes);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(painelPrincipal);
        pack();
        buttonSair.addActionListener(this::buttonSairActionPerformed);
        buttonFacil.addActionListener(this::buttonFacilActionPerformed);
        buttonMedio.addActionListener(this::buttonMedioActionPerformed);
        buttonDificil.addActionListener(this::buttonDificilActionPerformed);
    }

    private void recordesDificilActualizado(TabelaRecordes recordes) {
        lblJogadorDificil.setText(recordes.getNome());
        lblTempoDificil.setText(Long.toString(recordes.getTempoDeJogo()));
    }

    private void recordesMedioActualizado(TabelaRecordes recordes) {
        lblJogadorMedio.setText(recordes.getNome());
        lblTempoMedio.setText(Long.toString(recordes.getTempoDeJogo()));
    }

    private void recordesFacilActualizado(TabelaRecordes recordes) {
        lblJogadorFacil.setText(recordes.getNome());
        lblTempoFacil.setText(Long.toString(recordes.getTempoDeJogo()));
    }

    private void buttonDificilActionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(16,40,90), recordesDificil);
        janela.setVisible(true);
    }

    private void buttonMedioActionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(16,16,40), recordesMedio);
        janela.setVisible(true);
    }

    private void buttonFacilActionPerformed(ActionEvent e) {
        var janela = new JanelaDeJogo(new CampoMinado(9,9,10), recordesFacil);
        janela.setVisible(true);
    }

    private void buttonSairActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        new MinesFinder("Mines Finder").setVisible(true);
    }
}
