package MyGame;
import javax.swing.*;
import java.awt.*;

public class PuzzleGame {
    JFrame jFrame;
    JLabel label;
    JButton btnStart;
    JPanel firstPan;
    JPanel secondPan;
    JScrollPane scrollPan;

    JButton [] buttons;


    public PuzzleGame() {
        jFrame = new JFrame("Puzzle");
        firstPan = new JPanel();
        secondPan = new JPanel();

        scrollPan = new JScrollPane(secondPan);

        btnStart = new JButton("New Game");

        jFrame.add(btnStart, BorderLayout.NORTH);

        allNumbers();
        jFrame.add(scrollPan, BorderLayout.CENTER);

        jFrame.setSize(700, 700);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void allNumbers(){
        secondPan.setLayout((new GridLayout(4,4)));
        buttons = new JButton[16];
        for (int i = 0; i < buttons.length ; i ++) {
            JButton button = new JButton(" "+ (i+1));
            secondPan.add(button);
        }
    }
    void ShuffleButtons(){
        secondPan.removeAll();
        for (int i = buttons.length-1-1; i >=0 ; i--){
            int index = (int)(Math.random()*buttons.length-1);
            JButton temp = buttons[i];
            buttons[i] = buttons[index];
            buttons[index]= temp;
            System.out.println(i+" "+buttons[i].getText());
        }
        for (int i = 0; i < buttons.length-1; i++) {
            secondPan.add(buttons[i]);
        }
    }

    public static void main(String[] args) {
        new PuzzleGame();
    }
}
