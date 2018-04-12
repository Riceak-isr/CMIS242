package edu.UMUC.CMIS242.Project2;

import javax.swing.JOptionPane;

/**
 * File Name: Account.java
 * Name: riceak.isr
 * Date: April 8, 2018
 * Purpose: Throws InsufficientFunds exception when requested by GUI.
 */

@SuppressWarnings("serial")
public class InsufficientFunds extends Exception{
	
	public InsufficientFunds() {
		JOptionPane frame = new JOptionPane();
				JOptionPane.showMessageDialog(frame,  "Insufficient Funds"
						+ "\nPlease Check Account Balance!");
	}
} // end InsufficientFunds