package client.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class RegistrationFrame extends JFrame {
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
  private RegistrationLogic registrationLogic;
  private RegistrationFrame thisFrame;

	public RegistrationFrame( RegistrationLogic registrationLogic ) {
    this.thisFrame = this;
    this.registrationLogic = registrationLogic;
		getContentPane().setLayout(null);
		getContentPane().setName("One Arm Bandit");
		JButton btnRejestruj = new JButton("Register");
		btnRejestruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        String loginString = textField.getText( );
        @SuppressWarnings( "deprecation" )
        String passwordString = passwordField.getText( );
        String passwordString1 = passwordField_1.getText( );
        registrationLogic.register( loginString, passwordString, passwordString1 );
      }
    } );
		btnRejestruj.setBounds(29, 141, 106, 29);
		getContentPane().add(btnRejestruj);

		passwordField = new JPasswordField();
		passwordField.setBounds(108, 61, 162, 29);
		getContentPane().add(passwordField);

		textField = new JTextField();
		textField.setBounds(108, 21, 162, 29);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnLogowanie = new JButton("Log in");
		btnLogowanie.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
		    registrationLogic.logIn( );
		  }
		});
		btnLogowanie.setBounds(145, 141, 107, 29);
		getContentPane().add(btnLogowanie);

		JLabel lblRegistration = new JLabel("Login");
		lblRegistration.setBounds(20, 21, 70, 29);
		getContentPane().add(lblRegistration);

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
