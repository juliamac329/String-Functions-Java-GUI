/*
 * Julia Macdonald
 * September 30, 2025
 * StringFunctions GUI Assignment
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StringFunctions extends JFrame implements ActionListener {

    // GUI Components
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton lengthButton, lowerCaseButton, allCapsButton, lastCharButton, replaceButton;

    // Constructor
    public StringFunctions() {
        // Window settings
        setTitle("StringFunctions");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Title panel
        JLabel title = new JLabel("String Functions", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.RED);
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.RED);
        inputPanel.add(new JLabel("Enter a string:"));
        inputField = new JTextField(20);
        inputPanel.add(inputField);
        add(inputPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBackground(Color.RED);

        lengthButton = new JButton("Length");
        lowerCaseButton = new JButton("Lower Case");
        allCapsButton = new JButton("All Caps");
        lastCharButton = new JButton("Last Char");
        replaceButton = new JButton("Replace");

        // Add buttons to button panel
        buttonPanel.add(lengthButton);
        buttonPanel.add(lowerCaseButton);
        buttonPanel.add(allCapsButton);
        buttonPanel.add(lastCharButton);
        buttonPanel.add(replaceButton);

        // Button listener
        JButton[] buttons = {lengthButton, lowerCaseButton, allCapsButton, lastCharButton, replaceButton};
        for (JButton button : buttons) {
            button.setBackground(Color.WHITE);
            button.addActionListener(this);
        }

        // Result label
        resultLabel = new JLabel("Result will be displayed here", SwingConstants.CENTER);
        resultLabel.setForeground(Color.BLACK);
        resultLabel.setBackground(Color.PINK);
        resultLabel.setOpaque(true);

        // Button and result panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        bottomPanel.add(resultLabel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        String result = "";

        if (e.getSource() == lengthButton) {
            result = "Length: " + input.length();
        } else if (e.getSource() == lowerCaseButton) {
            result = "Lower Case: " + input.toLowerCase();
        } else if (e.getSource() == allCapsButton) {
            result = "All Caps: " + input.toUpperCase();
        } else if (e.getSource() == lastCharButton) {
            if (input.isEmpty()) {
                result = "Last Char: String is empty";
            } else {
                result = "Last Char: " + input.charAt(input.length() - 1);
            }
        } else if (e.getSource() == replaceButton) {
            result = "Replace: " + input.replaceAll(" ", "-");
        }

        resultLabel.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StringFunctions app = new StringFunctions();
            app.setVisible(true);
        });
    }
}

