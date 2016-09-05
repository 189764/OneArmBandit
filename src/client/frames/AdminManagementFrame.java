package client.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;


import javax.swing.JTextField;

public class AdminManagementFrame extends JFrame {
	private JTextField textFieldS1;
	private JTextField textFieldS2;
	private JTextField textFieldS3;
	private JTextField textFieldS4;
	private JTextField textFieldS5;
	private JTextField textFieldS6;
	private JTextField textFieldS7;
	private JTextField textFieldS8;
	private JTextField textFieldS9;
	private JTextField textField;
	public AdminManagementFrame() {
		//AdminManagementLogic admMan = new AdminManagementLogic();
		getContentPane().setLayout(null);
		setSize( new Dimension( 550, 400 ) );
		JLabel lblCentralBank = new JLabel("CENTRAL BANK:");
		lblCentralBank.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		lblCentralBank.setBounds(21, 11, 318, 53);
		getContentPane().add(lblCentralBank);
		
		JButton btnSetPrizes = new JButton("Set prizes");
		btnSetPrizes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//	List<Integer> listOfSymbolValues = new ArrayList<Integer>();
		//	admMan.setSymbolValues(listOfSymbolValues);
			}
		});
		btnSetPrizes.setBounds(10, 298, 127, 36);
		getContentPane().add(btnSetPrizes);
		
		JLabel lblNewLabel = new JLabel("Symbol 1:");
		lblNewLabel.setBounds(10, 72, 81, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSymbol = new JLabel("Symbol 2:");
		lblSymbol.setBounds(10, 97, 81, 14);
		getContentPane().add(lblSymbol);
		
		JLabel lblSymbol_1 = new JLabel("Symbol 3:");
		lblSymbol_1.setBounds(10, 121, 81, 14);
		getContentPane().add(lblSymbol_1);
		
		JLabel lblSymbol_2 = new JLabel("Symbol 4:");
		lblSymbol_2.setBounds(10, 146, 81, 14);
		getContentPane().add(lblSymbol_2);
		
		JLabel lblSymbol_3 = new JLabel("Symbol 5:");
		lblSymbol_3.setBounds(10, 171, 81, 14);
		getContentPane().add(lblSymbol_3);
		
		JLabel lblSymbol_4 = new JLabel("Symbol 6:");
		lblSymbol_4.setBounds(10, 196, 81, 14);
		getContentPane().add(lblSymbol_4);
		
		JLabel lblSymbol_5 = new JLabel("Symbol 7:");
		lblSymbol_5.setBounds(10, 221, 81, 14);
		getContentPane().add(lblSymbol_5);
		
		JLabel lblSymbol_6 = new JLabel("Symbol 8:");
		lblSymbol_6.setBounds(10, 248, 81, 14);
		getContentPane().add(lblSymbol_6);
		
		JLabel lblSymbol_7 = new JLabel("Symbol 9:");
		lblSymbol_7.setBounds(10, 273, 81, 14);
		getContentPane().add(lblSymbol_7);
		
		textFieldS1 = new JTextField();
		textFieldS1.setBounds(72, 69, 86, 20);
		getContentPane().add(textFieldS1);
		textFieldS1.setColumns(10);
		
		textFieldS2 = new JTextField();
		textFieldS2.setBounds(72, 94, 86, 20);
		getContentPane().add(textFieldS2);
		textFieldS2.setColumns(10);
		
		textFieldS3 = new JTextField();
		textFieldS3.setBounds(72, 118, 86, 20);
		getContentPane().add(textFieldS3);
		textFieldS3.setColumns(10);
		
		textFieldS4 = new JTextField();
		textFieldS4.setBounds(72, 143, 86, 20);
		getContentPane().add(textFieldS4);
		textFieldS4.setColumns(10);
		
		textFieldS5 = new JTextField();
		textFieldS5.setBounds(72, 168, 86, 20);
		getContentPane().add(textFieldS5);
		textFieldS5.setColumns(10);
		
		textFieldS6 = new JTextField();
		textFieldS6.setBounds(72, 193, 86, 20);
		getContentPane().add(textFieldS6);
		textFieldS6.setColumns(10);
		
		textFieldS7 = new JTextField();
		textFieldS7.setBounds(72, 218, 86, 20);
		getContentPane().add(textFieldS7);
		textFieldS7.setColumns(10);
		
		textFieldS8 = new JTextField();
		textFieldS8.setBounds(72, 246, 86, 20);
		getContentPane().add(textFieldS8);
		textFieldS8.setColumns(10);
		
		textFieldS9 = new JTextField();
		textFieldS9.setBounds(72, 273, 86, 20);
		getContentPane().add(textFieldS9);
		textFieldS9.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(411, 69, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPointsToTransfer = new JLabel("Points to transfer from central bank to the bandit:");
		lblPointsToTransfer.setBounds(168, 71, 263, 17);
		getContentPane().add(lblPointsToTransfer);
		
		JButton btnTransfer = new JButton("TRANSFER");
		btnTransfer.setBounds(165, 93, 332, 42);
		getContentPane().add(btnTransfer);
	}
}