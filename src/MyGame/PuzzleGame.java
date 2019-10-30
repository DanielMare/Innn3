package MyGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleGame implements ActionListener {
    JFrame jFrame;

    JButton btnStart;
    JPanel firstPan;
    JPanel secondPan;
    JScrollPane scrollPan;
    int indexNull = 15;

    //for all buttons
    JButton [] buttons;


    public PuzzleGame() {
        jFrame = new JFrame("Puzzle");
        firstPan = new JPanel();
        secondPan = new JPanel();

        scrollPan = new JScrollPane(secondPan);

          //  add all buttons to frame & actionListener
        btnStart = new JButton("New Game");
        btnStart.addActionListener(this);
        jFrame.add(btnStart, BorderLayout.NORTH);

        allNumbers();
        jFrame.add(scrollPan, BorderLayout.CENTER);

        jFrame.setSize(200, 200);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void allNumbers(){
        secondPan.setLayout((new GridLayout(4,4)));
        buttons = new JButton[16];
        for (int i = 0; i < buttons.length ; i ++) {
            buttons[i] = new JButton(""+ (i+1));
            if(i==buttons.length)   {
            buttons[i] = new JButton();
            buttons[i].setOpaque(false);
            buttons[i].setContentAreaFilled(false);
            buttons[i].setBorderPainted(false);
            }
            buttons[i].addActionListener(this);
            secondPan.add(buttons[i]);
        }
     
    }
    void shuffleButtons(){
        secondPan.removeAll();
        for (int i = buttons.length-1-1; i >=0 ; i--){
            int index = (int)(Math.random()*i);
            JButton temp = buttons[i];
            buttons[i] = buttons[index];
            buttons[index]= temp;
            System.out.println(i+"  "+buttons[i].getText());
        }
        for (int i = 0; i < buttons.length-1; i++) {
            secondPan.add(buttons[i]);
        }
        System.out.println(buttons.length);
        secondPan.validate();
        secondPan.repaint();
    }

    public static void main(String[] args) {
        new PuzzleGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                                      
         if(e.getSource()==btnStart){
             indexNull = 15;
             allNumbers();
             shuffleButtons();

         }

          for(int i = 0; i < buttons.length; i++){
              if(e.getSource()==buttons[i]){
                  System.out.println("button index: "+i+" "+indexNull);
                    if ((i==indexNull-4)||(i==indexNull+4)||(i+1==indexNull && (i+1)%4!=0)||(i-1==indexNull && i%4!=0)){
                        JButton temp = buttons[i];
                        buttons[i] = new JButton();
                        buttons[indexNull] =temp;
                        buttons[i].setOpaque(false);

                        buttons[i].setContentAreaFilled(false);
                        indexNull = i;
                        buttons[i].setBorderPainted(false);
                        System.out.println("indexNull: "+indexNull);}
                        updateButton();
                        break ;
                    }
              }

    }
    private void updateButton() {
        System.out.println("it runs here");

       secondPan.removeAll();
       //for (int i = 0; i < buttons.length-1; i++) {
        for (int i = 0; i < buttons.length; i++) {
           secondPan.add(buttons[i]);
        }
         secondPan.repaint();
       secondPan.validate();
        System.out.println("array length "+buttons.length);
     }

}