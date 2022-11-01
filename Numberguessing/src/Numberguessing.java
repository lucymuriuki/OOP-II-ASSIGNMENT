import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.Random;

public class Numberguessing extends JFrame {
    private JTextField guessed;
    private JPanel panel1;
    private JButton checkme;
    private JButton restart;
    private JLabel output;
    private  DefaultListModel listModel = new DefaultListModel();
    private JList history;
    private int j =0;
    public Numberguessing() {

        checkme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Guess = Integer.parseInt(guessed.getText());
                java.util.Random Random = new Random();
                int randomNo = Random.nextInt(100);
                listModel.addElement(Guess);
                history.setModel(listModel);
                if (Guess == randomNo) {
                    output.setText("You guessed right");
                } else if (Guess > randomNo) {
                    output.setText("Your guess is too high, the number guessed is " + randomNo);
                } else {
                    output.setText("Your guess is too low, the number guessed is " + randomNo);
                }
//                history.setVisibleRowCount(3);
            }
        });
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessed.setText("");
                output.setText("");
            }
        });

    }


    public static void main(String[] args) {
        Numberguessing h = new Numberguessing();
        h.setContentPane(h.panel1);
        h.setTitle("Number Guessing Application");
        h.setSize(500, 200);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}



