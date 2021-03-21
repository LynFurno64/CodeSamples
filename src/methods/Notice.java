package methods;

import javax.swing.*;

public class Notice {
    static JFrame f;

    public void notice() {
        JOptionPane.showMessageDialog(f,"<html><center><font size='3'- color=red><b>Please complete the form</b></font></html>");
    }// notice

    public void emailnotice() {
        JOptionPane.showMessageDialog(f,"<html><center><font size='3'- color=red><b>@ and domain Required for a Valid Email.<br>" +
                "domains: .co, .org., .net, .com & .edu</b></font></html>");
    }// emailnotice

    public void submit() {
        JOptionPane.showMessageDialog(f,"<html><center><font size='3'- color=red><b>Appointment Submitted!</b></font></html>");
    }// sumbit

    public void password() {
        JOptionPane.showMessageDialog(f,"<html><center><font size='3'- color=red><b>Password does not match</b></font></html>");
    }// password
    public void passwordLength() {
        JOptionPane.showMessageDialog(f,"<html><center><font size='3'- color=red><b>Only 10 characters</b></font></html>");
    }// password
    public void coderror() {
        JOptionPane.showMessageDialog(f,"<html><center><font size='3'- color=red><b>Not a valid ID use 000 or ID if you can't remember</b></font></html>");
    }// password
    public void notExist() {
        String message = "<html><body><div width='100px' align='center'><font size='3'- color=red>Does not exist!</font></div></body></html>";
        JLabel messageLabel = new JLabel(message);
        JOptionPane.showMessageDialog(f,messageLabel);
    }// notice3
}
