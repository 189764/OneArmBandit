package client.frames;

import javax.swing.JFrame;


import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUserFrame extends JFrame {
  
  private MainUserLogic mainUserLogic;
  private MainUserFrame thisFrame;
  
  
  public MainUserFrame( MainUserLogic mainUserLogic ) {
    this.thisFrame = this;
    this.mainUserLogic = mainUserLogic;
    setSize( new Dimension( 400, 240 ) );
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[]{431, 0};
    gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
    gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
    getContentPane().setLayout(gridBagLayout);
    
    JButton btnPlay = new JButton("Play");
    btnPlay.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
    	  mainUserLogic.play();
      }
    });
    GridBagConstraints gbc_btnPlay = new GridBagConstraints();
    gbc_btnPlay.insets = new Insets(0, 0, 5, 0);
    gbc_btnPlay.gridx = 0;
    gbc_btnPlay.gridy = 1;
    getContentPane().add(btnPlay, gbc_btnPlay);
    
    JButton btnChangePassword = new JButton("Change password");
    btnChangePassword.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainUserLogic.changePassword( );
      }
    });
    
    JButton btnShowRanking = new JButton("Show ranking");
    btnShowRanking.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainUserLogic.showRanking( );
      }
    });
    
    JButton btnMyAccount = new JButton("My account");
    btnMyAccount.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainUserLogic.showPoints( );
      }
    });
    GridBagConstraints gbc_btnMyAccount = new GridBagConstraints();
    gbc_btnMyAccount.insets = new Insets(0, 0, 5, 0);
    gbc_btnMyAccount.gridx = 0;
    gbc_btnMyAccount.gridy = 2;
    getContentPane().add(btnMyAccount, gbc_btnMyAccount);
    GridBagConstraints gbc_btnShowRanking = new GridBagConstraints();
    gbc_btnShowRanking.insets = new Insets(0, 0, 5, 0);
    gbc_btnShowRanking.gridx = 0;
    gbc_btnShowRanking.gridy = 3;
    getContentPane().add(btnShowRanking, gbc_btnShowRanking);
    GridBagConstraints gbc_btnChangePassword = new GridBagConstraints();
    gbc_btnChangePassword.insets = new Insets(0, 0, 5, 0);
    gbc_btnChangePassword.gridx = 0;
    gbc_btnChangePassword.gridy = 4;
    getContentPane().add(btnChangePassword, gbc_btnChangePassword);
    
    JButton btnLogOut = new JButton("Log out");
    btnLogOut.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainUserLogic.logOut( );
      }
    });
    GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
    gbc_btnLogOut.insets = new Insets(0, 0, 5, 0);
    gbc_btnLogOut.gridx = 0;
    gbc_btnLogOut.gridy = 5;
    getContentPane().add(btnLogOut, gbc_btnLogOut);
    setVisible(true);
  }

  /**
   * 
   */
  private static final long serialVersionUID = -3872502555934432786L;

}
