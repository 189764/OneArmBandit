package client.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

import client.frames.LoginLogic;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class LoginFrame extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = 6235646634736375047L;
  private JPasswordField passwordField;
  private JTextField textField;
  private LoginLogic loginLogic;
  private LoginFrame thisFrame;
  
  
  public LoginFrame( LoginLogic loginLogic ) {
    this.thisFrame = this;
    this.loginLogic = loginLogic;
    setSize( new Dimension( 400, 240 ) );
    getContentPane().setLayout(null);
    getContentPane().setName("One Arm Bandit");
    JButton btnLoguj = new JButton("Log in");
    btnLoguj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String loginString = textField.getText( );
        @SuppressWarnings( "deprecation" )
        String passwordString = passwordField.getText( );
        loginLogic.logIn( loginString, passwordString );
      }
    } );
    btnLoguj.setBounds(20, 101, 106, 29);
    getContentPane().add(btnLoguj);
    
    passwordField = new JPasswordField();
    passwordField.setBounds(81, 61, 162, 29);
    getContentPane().add(passwordField);
    
    textField = new JTextField();
    textField.setBounds(81, 21, 162, 29);
    getContentPane().add(textField);
    textField.setColumns(10);
    
    JButton btnNewButton = new JButton("Register");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        loginLogic.register( );
      }
    });
    btnNewButton.setBounds(136, 101, 107, 29);
    getContentPane().add(btnNewButton);
    
    JLabel lblLogin = new JLabel("Login");
    lblLogin.setBounds(20, 21, 70, 29);
    getContentPane().add(lblLogin);
    
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(20, 68, 46, 14);
    getContentPane().add(lblPassword);
    setVisible(true);
  }
}