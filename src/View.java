import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

enum Algorithm {
    NONE,
    MERGESORT,
    FORKJOIN,
    EXECUTE,
}

public class View extends JFrame {

    private final JTextPane unsortedTextPane;
    private final JTextPane sortedTextPane;
    private final JTextField arraySizeTextField;
    private final JLabel selectedAlgorithmLabel;
    private final JLabel elapsedTimeMergeSort;
    private final JLabel elapsedTimeForkJoin;
    private final JLabel elapsedTimeExecute;
    private final JLabel messageLabel;
    private Algorithm algorithm = Algorithm.NONE;
    public View(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                UnsupportedLookAndFeelException e) {

            System.out.println("Look and feel not set");
        }
        Panel panel = new Panel();
        panel.setBackground(Color.DARK_GRAY);
        this.setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Algoritmos de ordenamiento");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 480);

        JButton mergeButton = new JButton("MergeSort");
        mergeButton.setBounds(25, 60, 100, 25);

        JButton forkJoinButton = new JButton("ForkJoin");
        forkJoinButton.setBounds(25, 95, 100, 25);

        JButton executeButton = new JButton("Execute");
        executeButton.setBounds(25, 130, 100, 25);

        arraySizeTextField = new JTextField();
        arraySizeTextField.setBounds(25, 25, 100, 25);
        arraySizeTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                arraySizeTextField.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '\u0008');
            }
        });

        unsortedTextPane = new JTextPane();
        unsortedTextPane.setEditable(false);

        sortedTextPane = new JTextPane();
        sortedTextPane.setEditable(false);

        JButton startButton = new JButton("Comenzar");
        startButton.setBounds(25, 200, 100, 25);

        JButton clearButton = new JButton("Borrar");
        clearButton.setBounds(25, 235, 100, 25);

        selectedAlgorithmLabel = new JLabel("<html>Algoritmo<br>selecciónado:<br>Ninguno</html>");
        selectedAlgorithmLabel.setBounds(25, 270, 100, 50);
        selectedAlgorithmLabel.setForeground(Color.WHITE);

        JScrollPane scrollPane1 = new JScrollPane(unsortedTextPane);
        scrollPane1.setBounds(150, 25, 400, 150);

        JScrollPane scrollPane2 = new JScrollPane(sortedTextPane);
        scrollPane2.setBounds(150, 200, 400, 150);

        elapsedTimeMergeSort = new JLabel("");
        elapsedTimeMergeSort.setBounds(25, 390, 400, 25);
        elapsedTimeMergeSort.setForeground(Color.RED);

        elapsedTimeForkJoin = new JLabel("");
        elapsedTimeForkJoin.setBounds(175, 390, 400, 25);
        elapsedTimeForkJoin.setForeground(Color.RED);

        elapsedTimeExecute = new JLabel("");
        elapsedTimeExecute.setBounds(325, 390, 400, 25);
        elapsedTimeExecute.setForeground(Color.RED);

        messageLabel = new JLabel("");
        messageLabel.setBounds(150, 175, 400, 25);
        messageLabel.setForeground(Color.RED);


        panel.add(mergeButton);
        panel.add(arraySizeTextField);
        panel.add(forkJoinButton);
        panel.add(executeButton);
        panel.add(scrollPane1);
        panel.add(scrollPane2);
        panel.add(startButton);
        panel.add(clearButton);
        panel.add(selectedAlgorithmLabel);
        panel.add(elapsedTimeMergeSort);
        panel.add(elapsedTimeForkJoin);
        panel.add(elapsedTimeExecute);
        panel.add(messageLabel);

        mergeButton.addActionListener(e -> selectSortingAlgorithm(Algorithm.MERGESORT));

        forkJoinButton.addActionListener(e -> selectSortingAlgorithm(Algorithm.FORKJOIN));

        executeButton.addActionListener(e -> selectSortingAlgorithm(Algorithm.EXECUTE));

        clearButton.addActionListener(e -> {
            selectSortingAlgorithm(Algorithm.NONE);
            arraySizeTextField.setText("");
            sortedTextPane.setText("");
            unsortedTextPane.setText("");
            elapsedTimeMergeSort.setText("");
            elapsedTimeForkJoin.setText("");
            elapsedTimeExecute.setText("");
        });

        startButton.addActionListener(e -> {
            switch (algorithm) {
                case NONE -> {
                    sortedTextPane.setText("Seleccione un algoritmo!");
                    return;
                }
                case MERGESORT -> {

                }
                case FORKJOIN -> {

                }
                case EXECUTE -> {

                }
            }
        });
    }

    private void selectSortingAlgorithm(Algorithm selected) {
        this.algorithm = selected;
        switch (algorithm) {
            case NONE -> selectedAlgorithmLabel.setText("<html>Algoritmo<br>selecciónado:<br>Ninguno</html>");
            case MERGESORT -> selectedAlgorithmLabel.setText("<html>Algoritmo<br>selecciónado:<br>MergeSort</html>");
            case FORKJOIN -> selectedAlgorithmLabel.setText("<html>Algoritmo<br>selecciónado:<br>ForkJoin</html>");
            case EXECUTE -> selectedAlgorithmLabel.setText("<html>Algoritmo<br>selecciónado:<br>Execute</html>");
        }
    }
}
