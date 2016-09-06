package client.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;

public class GameFrame extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = 5603105110124533265L;
  private JTextField textField;
  private JLabel label1;
  private JLabel label2;
  private JLabel label3;
  private JLabel label4;
  private JLabel label5;
  private JLabel label6;
  private JLabel label7;
  private JLabel label8;
  private JLabel label9;

  public GameFrame( GameLogic gameLogic ) {
    setSize( new Dimension( 800, 600 ) );
    getContentPane( ).setLayout( null );

    JButton btnBet = new JButton( "Bet" );
    btnBet.addActionListener( new ActionListener( ) {
      public void actionPerformed( ActionEvent e ) {
        gameLogic.play( Integer.parseInt( textField.getText( ) ) );
      }
    } );
    btnBet.setBounds( 193, 371, 157, 41 );
    getContentPane( ).add( btnBet );

    JLabel lblStake_1 = new JLabel( "Stake" );
    lblStake_1.setFont( new Font( "Tahoma", Font.PLAIN, 20 ) );
    lblStake_1.setBounds( 374, 373, 56, 39 );
    getContentPane( ).add( lblStake_1 );

    label1 = new JLabel( "1" );
    label1.setOpaque( true );
    label1.setBackground( new Color( 255, 200, 0 ) );
    label1.setForeground( Color.BLACK );
    label1.setHorizontalAlignment( SwingConstants.CENTER );
    label1.setFont( new Font( "Old English Text MT", Font.PLAIN, 50 ) );
    label1.setBounds( 26, 48, 80, 80 );
    getContentPane( ).add( label1 );

    label2 = new JLabel( "2" );
    label2.setOpaque( true );
    label2.setHorizontalAlignment( SwingConstants.CENTER );
    label2.setForeground( Color.BLACK );
    label2.setFont( new Font( "Old English Text MT", Font.PLAIN, 50 ) );
    label2.setBackground( Color.ORANGE );
    label2.setBounds( 116, 48, 80, 80 );
    getContentPane( ).add( label2 );

    label3 = new JLabel( "3" );
    label3.setOpaque( true );
    label3.setHorizontalAlignment( SwingConstants.CENTER );
    label3.setForeground( Color.BLACK );
    label3.setFont( new Font( "Old English Text MT", Font.PLAIN, 50 ) );
    label3.setBackground( Color.ORANGE );
    label3.setBounds( 206, 48, 80, 80 );
    getContentPane( ).add( label3 );

    label4 = new JLabel( "4" );
    label4.setOpaque( true );
    label4.setHorizontalAlignment( SwingConstants.CENTER );
    label4.setForeground( Color.BLACK );
    label4.setFont( new Font( "Old English Text MT", Font.PLAIN, 50 ) );
    label4.setBackground( Color.ORANGE );
    label4.setBounds( 26, 139, 80, 80 );
    getContentPane( ).add( label4 );

    label5 = new JLabel( "5" );
    label5.setOpaque( true );
    label5.setHorizontalAlignment( SwingConstants.CENTER );
    label5.setForeground( Color.BLACK );
    label5.setFont( new Font( "Old English Text MT", Font.PLAIN, 50 ) );
    label5.setBackground( Color.ORANGE );
    label5.setBounds( 116, 139, 80, 80 );
    getContentPane( ).add( label5 );

    label6 = new JLabel( "6" );
    label6.setOpaque( true );
    label6.setHorizontalAlignment( SwingConstants.CENTER );
    label6.setForeground( Color.BLACK );
    label6.setFont( new Font( "Old English Text MT", Font.PLAIN, 50 ) );
    label6.setBackground( Color.ORANGE );
    label6.setBounds( 206, 139, 80, 80 );
    getContentPane( ).add( label6 );

    label7 = new JLabel( "7" );
    label7.setOpaque( true );
    label7.setHorizontalAlignment( SwingConstants.CENTER );
    label7.setForeground( Color.BLACK );
    label7.setFont( new Font( "Old English Text MT", Font.PLAIN, 50 ) );
    label7.setBackground( Color.ORANGE );
    label7.setBounds( 26, 230, 80, 80 );
    getContentPane( ).add( label7 );

    label8 = new JLabel( "8" );
    label8.setOpaque( true );
    label8.setHorizontalAlignment( SwingConstants.CENTER );
    label8.setForeground( Color.BLACK );
    label8.setFont( new Font( "Old English Text MT", Font.PLAIN, 50 ) );
    label8.setBackground( Color.ORANGE );
    label8.setBounds( 116, 230, 80, 80 );
    getContentPane( ).add( label8 );

    label9 = new JLabel( "9" );
    label9.setOpaque( true );
    label9.setHorizontalAlignment( SwingConstants.CENTER );
    label9.setForeground( Color.BLACK );
    label9.setFont( new Font( "Old English Text MT", Font.PLAIN, 50 ) );
    label9.setBackground( Color.ORANGE );
    label9.setBounds( 206, 230, 80, 80 );
    getContentPane( ).add( label9 );

    JButton btnShowPoints = new JButton( "Show points" );
    btnShowPoints.addActionListener( new ActionListener( ) {
      public void actionPerformed( ActionEvent e ) {
        gameLogic.showPoints( );
      }
    } );
    btnShowPoints.setBounds( 49, 379, 108, 25 );
    getContentPane( ).add( btnShowPoints );

    textField = new JTextField( );
    textField.setBounds( 444, 380, 116, 22 );
    getContentPane( ).add( textField );
    textField.setColumns( 10 );
    setVisible( true );
  }

  public JLabel getLabel1( ) {
    return label1;
  }

  public void setLabel1( JLabel label1 ) {
    this.label1 = label1;
  }

  public JLabel getLabel2( ) {
    return label2;
  }

  public void setLabel2( JLabel label2 ) {
    this.label2 = label2;
  }

  public JLabel getLabel3( ) {
    return label3;
  }

  public void setLabel3( JLabel label3 ) {
    this.label3 = label3;
  }

  public JLabel getLabel4( ) {
    return label4;
  }

  public void setLabel4( JLabel label4 ) {
    this.label4 = label4;
  }

  public JLabel getLabel5( ) {
    return label5;
  }

  public void setLabel5( JLabel label5 ) {
    this.label5 = label5;
  }

  public JLabel getLabel6( ) {
    return label6;
  }

  public void setLabel6( JLabel label6 ) {
    this.label6 = label6;
  }

  public JLabel getLabel7( ) {
    return label7;
  }

  public void setLabel7( JLabel label7 ) {
    this.label7 = label7;
  }

  public JLabel getLabel8( ) {
    return label8;
  }

  public void setLabel8( JLabel label8 ) {
    this.label8 = label8;
  }

  public JLabel getLabel9( ) {
    return label9;
  }

  public void setLabel9( JLabel label9 ) {
    this.label9 = label9;
  }
}
