package edu.UMUC.CMIS242.Project2;

/**
 * File Name: Account.java
 * Name: riceak.isr
 * Date: April 8, 2018
 * Purpose: Create GUI to perform checking and savings account functions.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;

@SuppressWarnings("serial")
public class ATM extends JFrame {

    // Variables
    static final int WINDOWWIDTH = 350, WINDOWHEIGHT = 200,
                     TEXTWIDTH = 225, TEXTHEIGHT = 25;

    // Data fields for the construction of the JFrame elements
    private JButton withdrawButton = new JButton("Withdraw");
    private JButton depositButton = new JButton("Deposit");
    private JButton transferToButton = new JButton("Transfer To");
    private JButton balanceButton = new JButton("Balance");
    private JRadioButton checkingRadio = new JRadioButton("Checking");
    private JRadioButton savingsRadio = new JRadioButton("Savings");
    private JTextField entry = new JTextField("");
    private ButtonGroup radios = new ButtonGroup();
    private JOptionPane frame = new JOptionPane();

    // Objects for the checking and savings accounts
    private static Account checking = new Account().new Checking();
    private static Account savings = new Account().new Savings();

    // Formats numbers to monetary $ format
    private static DecimalFormat df = new DecimalFormat("$0.00");

    // Method to create Checking and Savings accounts
    public static void makeAccounts(double checkingStartingBalance,
                                    double savingsStartingBalance) {

        checking.setBalance(checkingStartingBalance);
        savings.setBalance(savingsStartingBalance);
    }// End makeAccounts method

    // Error message to handle invalid input (blanks, letters, and negative numbers)
    public void errorValidNumber() {
        JOptionPane.showMessageDialog(frame, "Please enter a valid amount. " +
                "\n If withdrawing, please use $20 increments.");
    }// End errorValidNumber method

    /**
     * Action Listeners for:
     * Withdraw Button
     * Deposit Button
     * Transfer Button
     * Balance Button
     */

    // Withdraw button action listener
    class WithdrawButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // First checks for negative number and increment of 20
                if (getEntryValue() > 0 && getEntryValue() % 20 == 0) {
                    // Checks radio selection
                    if (checkingRadio.isSelected()) {
                        checking.withdraw(getEntryValue());
                        JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) +
                                " withdrawn from Checking.");
                    } else if (savingsRadio.isSelected()) {
                        savings.withdraw(getEntryValue());
                        JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) +
                                " withdrawn from Savings.");
                    }
                    clearEntryValue();
                } else errorValidNumber();
                clearEntryValue();
            } catch (InsufficientFunds insufficientFunds) {
                System.out.println("Caught in main.");
            }
        }// End actionPerformed method
    }// End WithdrawButtonListener class

    // Deposit button action listener
    class DepositButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // First checks for positive number
            if (getEntryValue() > 0) {
                // Then checks for radio selection
                if (checkingRadio.isSelected()) {
                    checking.deposit(getEntryValue());
                    JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) +
                            " deposited into Checking.");
                } else if (savingsRadio.isSelected()) {
                    savings.deposit(getEntryValue());
                    JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) +
                            " deposited into Savings.");
                }
                clearEntryValue();
            } else errorValidNumber();
            clearEntryValue();
        }// End actionPerformed method
    }// End DepositButtonListener class

    // Transfer button action listener
    class TransferToButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // First checks for positive number
                if (getEntryValue() > 0) {
                    // Then checks for radio selection
                    if (checkingRadio.isSelected()) {
                        // Separate methods for transferFrom and transferTo
                        savings.transferFrom(getEntryValue());
                        checking.transferTo(getEntryValue());
                        JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) +
                                " transferred from Savings to Checking.");
                    } else if (savingsRadio.isSelected()) {
                        checking.transferFrom(getEntryValue());
                        savings.transferTo(getEntryValue());
                        JOptionPane.showMessageDialog(frame, df.format(getEntryValue()) +
                                " transferred from Checking to Savings.");
                    }
                    clearEntryValue();
                } else errorValidNumber();
                clearEntryValue();
            } catch (InsufficientFunds insufficientFunds) {
                System.out.println("Caught in main.");
            }
        }// End actionPerformed method
    }// End TransferToButtonListener class

    // Balance button action listener
    class BalanceButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Only checks for radio selection
            if (checkingRadio.isSelected()) {
                JOptionPane.showMessageDialog(frame,
                        "Your checking account balance is: \n" +
                                df.format(checking.getBalance()));
            } else if (savingsRadio.isSelected()) {
                JOptionPane.showMessageDialog(frame,
                        "Your savings account balance is: \n" +
                                df.format(savings.getBalance()));
            } else errorValidNumber();
            clearEntryValue();
        }// End actionPerformed method
    }// End BalanceButtonListener class

    /**
     * Constructor for ATM class
     * Creates panels and sets layout
     * Creates Checking and Savings accounts, applies action listeners to buttons
     */
    public ATM(double checkingStartingBalance, double savingsStartingBalance) {

        super("ATM Machine");
        setLayout(new GridBagLayout());
        GridBagConstraints layout = new GridBagConstraints();
        setFrame(WINDOWWIDTH, WINDOWHEIGHT);
        JPanel buttonPanel = new JPanel();
        JPanel textEntry = new JPanel();
        setResizable(false);
        layout.gridy = 2;
        add(buttonPanel);
        add(textEntry, layout);
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
        textEntry.setLayout(new GridLayout(1, 1));
        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(transferToButton);
        buttonPanel.add(balanceButton);
        radios.add(checkingRadio);
        radios.add(savingsRadio);
        buttonPanel.add(checkingRadio);
        buttonPanel.add(savingsRadio);
        entry.setPreferredSize(new Dimension(TEXTWIDTH, TEXTHEIGHT));
        checkingRadio.setSelected(true);
        textEntry.add(entry);

        // Creates the checking and savings accounts
        makeAccounts(checkingStartingBalance, savingsStartingBalance);

        // Action listeners
        withdrawButton.addActionListener(new WithdrawButtonListener());
        depositButton.addActionListener(new DepositButtonListener());
        transferToButton.addActionListener(new TransferToButtonListener());
        balanceButton.addActionListener(new BalanceButtonListener());
    }// End ATM constructor

    // This method returns the text in the text entry field as a double
    public double getEntryValue() {
        try {
            return Double.parseDouble(entry.getText());
        } catch (NumberFormatException e) {
            System.out.println("Caught in getEntryValue\n");
            clearEntryValue();
            return 0;
        }
    }// End getEntryValue method

    // Clears the text entry field
    public void clearEntryValue() {
        entry.setText("");
    }// End clearEntryValue method

    private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }// End setFram method

    public void display() {
        setVisible(true);
    }// End display method

    public static void main(String[] args) {
        // Creates a new ATM object that will have $100 in each account
        ATM frame = new ATM(100, 100);
        frame.display();
    }// End main method
}// End ATM class
