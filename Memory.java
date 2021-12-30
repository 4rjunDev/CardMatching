import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Memory extends JFrame implements ActionListener
{
    int clicked = 0;
    int pairsFound = 0;
    Card firstCard = new Card();
    Card secondCard = new Card();
    private final int SIZE = 4;
    private Card[] card = new Card[SIZE * SIZE];

    public Memory()
    {
        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 300, 500, 250);

        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));

        int indx;
        for (int r = 0 ; r < SIZE ; r++)
        {
            for (int c = 0 ; c < SIZE ; c++)
            {
                indx = r * SIZE + c;
                card[indx] = new Card();
                card[indx].addActionListener(this);
                panel.add(card[indx]);
            }
        }

        for (int i = 1 ; i <= SIZE * SIZE / 2 ; i++)
        {
            for (int j = 0 ; j < 2 ; j++)
            {
                do
                {
                    indx = (int) (Math.random () * SIZE * SIZE);
                }
                while (card [indx].getValue () != 0);
                card [indx].setValue (i);
            }
        }

        //show the contents
        this.setContentPane(panel);
        this.setVisible (true);

    }

    public static void main (String[] args)
    {
        new Memory ();
    }

    public void actionPerformed (ActionEvent e)
    {
        Card card = (Card) e.getSource();
        
        if (card.getText() != "") 
        {
            return;
        }
        
        card.setText(Integer.toString(card.getValue()));
        card.setOpaque(true);
        
        clicked++;
        if (clicked == 1)
        {
            if (firstCard.getValue () != secondCard.getValue ()) 
            {
                firstCard.setText("");
                secondCard.setText("");
            }
            firstCard = card;
        }
        else if (clicked == 2)
        {
            secondCard = card;
            if (firstCard == secondCard) 
            {
                firstCard.setText("");
            } else if (firstCard.getValue () == secondCard.getValue ()) {
                firstCard.setBackground(Color.GREEN);
                secondCard.setBackground(Color.GREEN);
                firstCard.setMatched(true);
                secondCard.setMatched(true);
                pairsFound++;
                if (pairsFound == SIZE*SIZE/2) {
                    JOptionPane.showMessageDialog (null, "You Found All Pairs! Click OK to exit.");
                    System.exit (0);
                }
            }
            clicked = 0;
        }
    }
}
