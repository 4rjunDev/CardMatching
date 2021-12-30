import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Card extends JButton
{
    private int value;
    boolean matched = false;
    int num;

    public Card()
    {
        value = 0;
    }

    public void setValue(int val)
    {
        this.value = val;
    }
    
    public void setMatched(boolean match)
    {
        this.matched = match;
    }
    
    public int getValue()
    {
        return this.value;
    }
    
    public static void main (String[] args)
    {
    }
}
