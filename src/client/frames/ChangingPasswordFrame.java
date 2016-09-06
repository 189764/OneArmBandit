package client.frames;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ChangingPasswordFrame extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = -3061026132611032983L;
  private JPasswordField passwordField;
  private JPasswordField passwordField_1;

  
  public ChangingPasswordFrame( ChangingPasswordLogic changingPasswordLogic ) {
    setSize( new Dimension( 400, 240 ) );
    getContentPane().setLayout(null);
    getContentPane().setName("One Arm Bandit");
    JButton btnChangePassword = new JButton("Change Password");
    btnChangePassword.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        @SuppressWarnings( "deprecation" )
        String passwordString = passwordField.getText( );
        @SuppressWarnings( "deprecation" )
        String passwordString1 = passwordField_1.getText( );
        changingPasswordLogic.changePassword( passwordString, passwordString1 );
      }
    } );
    btnChangePassword.setBounds(29, 141, 205, 29);
    getContentPane().add(btnChangePassword);

    passwordField = new JPasswordField();
    passwordField.setBounds(108, 61, 162, 29);
    getContentPane().add(passwordField);

    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(20, 68, 46, 14);
    getContentPane().add(lblPassword);

    JLabel JLabelRepeatPass = new JLabel("Repeat password");
    JLabelRepeatPass.setBounds(20, 103, 119, 21);
    getContentPane().add(JLabelRepeatPass);

    passwordField_1 = new JPasswordField();
    passwordField_1.setBounds(108, 101, 162, 29);
    getContentPane().add(passwordField_1);
    setVisible( true );

  }
}
