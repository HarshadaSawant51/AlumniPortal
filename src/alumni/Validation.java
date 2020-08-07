/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumni;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class Validation {
    
    public void char_validation(java.awt.event.KeyEvent evt,JTextField t)
    {
        char ch=evt.getKeyChar();
        if(!Character.isDigit(ch) || (evt.getKeyCode()==evt.VK_DELETE) || (evt.getKeyCode()==evt.VK_BACK_SPACE))
        {
            
        }
        else
        {
            evt.consume();
            JOptionPane.showMessageDialog(null,"Please enter only characters");
        }
    }
    public void num_validaion(java.awt.event.KeyEvent evt,JTextField t)
    {
        char ch=evt.getKeyChar();
        if(Character.isDigit(ch) || (evt.getKeyCode()==evt.VK_DELETE) || (evt.getKeyCode()==evt.VK_BACK_SPACE) || (evt.getKeyCode()==evt.VK_ENTER) || (evt.getKeyChar()=='.'))
        {
            
        }
        else
        {
            evt.consume();
            JOptionPane.showMessageDialog(null,"Please enter only numbers");
        }
    }
     public void time_validaion(java.awt.event.KeyEvent evt,JTextField t)
    {
        char ch=evt.getKeyChar();
        if(Character.isDigit(ch) || (evt.getKeyCode()==evt.VK_DELETE) || (evt.getKeyCode()==evt.VK_BACK_SPACE) || (evt.getKeyCode()==evt.VK_ENTER) || (evt.getKeyChar()==':'))
        {
            
        }
        else
        {
            evt.consume();
        }
    }
}
