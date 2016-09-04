package client.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class GameFrame extends JFrame{
	public GameFrame() {
		getContentPane().setLayout(null);
		
		JLabel lblPoints = new JLabel("Points");
		lblPoints.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoints.setBounds(10, 373, 178, 39);
		getContentPane().add(lblPoints);
		
		JButton btnBet = new JButton("Bet");
		btnBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBet.setBounds(193, 371, 157, 41);
		getContentPane().add(btnBet);
		
		JButton btnIncreaseStake = new JButton("Increase Stake");
		btnIncreaseStake.setBounds(341, 265, 113, 41);
		getContentPane().add(btnIncreaseStake);
		
		JButton btnDecreaseStake = new JButton("Decrease Stake");
		btnDecreaseStake.setBounds(341, 319, 113, 41);
		getContentPane().add(btnDecreaseStake);
		
		JLabel lblStake_1 = new JLabel("Stake");
		lblStake_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStake_1.setBounds(374, 373, 172, 39);
		getContentPane().add(lblStake_1);
		
		JLabel label1 = new JLabel("1");
		label1.setOpaque(true);
		label1.setBackground(new Color(255, 200, 0));
		label1.setForeground(Color.BLACK);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		label1.setBounds(26, 48, 80, 80);
		getContentPane().add(label1);
		
		JLabel label2 = new JLabel("2");
		label2.setOpaque(true);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		label2.setBackground(Color.ORANGE);
		label2.setBounds(116, 48, 80, 80);
		getContentPane().add(label2);
		
		JLabel label3 = new JLabel("3");
		label3.setOpaque(true);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setForeground(Color.BLACK);
		label3.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		label3.setBackground(Color.ORANGE);
		label3.setBounds(206, 48, 80, 80);
		getContentPane().add(label3);
		
		JLabel label4 = new JLabel("4");
		label4.setOpaque(true);
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setForeground(Color.BLACK);
		label4.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		label4.setBackground(Color.ORANGE);
		label4.setBounds(26, 139, 80, 80);
		getContentPane().add(label4);
		
		JLabel label5 = new JLabel("5");
		label5.setOpaque(true);
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setForeground(Color.BLACK);
		label5.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		label5.setBackground(Color.ORANGE);
		label5.setBounds(116, 139, 80, 80);
		getContentPane().add(label5);
		
		JLabel label6 = new JLabel("6");
		label6.setOpaque(true);
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setForeground(Color.BLACK);
		label6.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		label6.setBackground(Color.ORANGE);
		label6.setBounds(206, 139, 80, 80);
		getContentPane().add(label6);
		
		JLabel label7 = new JLabel("7");
		label7.setOpaque(true);
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setForeground(Color.BLACK);
		label7.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		label7.setBackground(Color.ORANGE);
		label7.setBounds(26, 230, 80, 80);
		getContentPane().add(label7);
		
		JLabel label8 = new JLabel("8");
		label8.setOpaque(true);
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setForeground(Color.BLACK);
		label8.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		label8.setBackground(Color.ORANGE);
		label8.setBounds(116, 230, 80, 80);
		getContentPane().add(label8);
		
		JLabel label9 = new JLabel("9");
		label9.setOpaque(true);
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setForeground(Color.BLACK);
		label9.setFont(new Font("Old English Text MT", Font.PLAIN, 50));
		label9.setBackground(Color.ORANGE);
		label9.setBounds(206, 230, 80, 80);
		getContentPane().add(label9);
	}
}
