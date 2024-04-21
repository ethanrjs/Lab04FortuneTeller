import javax.swing.JFrame;

public class FortuneTellerViewer {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            FortuneTellerFrame frame = new FortuneTellerFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Fortune Teller");
            frame.pack();
            frame.setVisible(true);
        });
    }
}
