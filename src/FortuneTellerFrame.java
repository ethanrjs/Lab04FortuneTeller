import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private JTextArea textArea;
    private JButton readFortuneButton;
    private JButton quitButton;
    private ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        createComponents();
        layoutComponents();
        initializeFortunes();
        addListeners();
        configureFrame();
    }

    private void createComponents() {
        textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 16));

        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("SansSerif", Font.PLAIN, 20));

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
    }

    private void layoutComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Fortune Teller", new ImageIcon("path/to/image.png"), JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readFortuneButton);
        buttonPanel.add(quitButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
    }

    private void initializeFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You will have a great day!");
        fortunes.add("You will find 55.3 million dollars!");
        fortunes.add("You will get married to the person you just met 17 days ago.");
        fortunes.add("You will win the lottery, but a small sum.");

        // Jackpot
        fortunes.add("You will stop being forced to write Java in 2024.");
    }

    private void addListeners() {
        readFortuneButton.addActionListener(e -> displayFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }

    private void displayFortune() {
        Random rand = new Random();
        int newIndex;
        do {
            newIndex = rand.nextInt(fortunes.size());
        } while (newIndex == lastFortuneIndex);
        lastFortuneIndex = newIndex;
        String newFortune = fortunes.get(newIndex);
        textArea.append(newFortune + "\n");
    }

    private void configureFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width * 3 / 4;
        int height = screenSize.height * 3 / 4;
        setSize(width, height);
        setLocationRelativeTo(null);
    }
}
