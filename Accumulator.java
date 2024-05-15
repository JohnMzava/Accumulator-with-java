import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Accumulator extends JFrame {
    private int sum = 0;
    private JLabel sumLabel;

    public Accumulator() {
        setTitle("Accumulator GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        JLabel valueLabel = new JLabel("Enter value:");
        JTextField valueField = new JTextField(10);
        JButton addButton = new JButton("Add");
        sumLabel = new JLabel("Sum: " + sum);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(valueField.getText());
                    sum += value;
                    sumLabel.setText("Sum: " + sum);
                    valueField.setText(""); // Clear the text field after adding
                } catch (NumberFormatException ex) {
                    // Handle if the user enters a non-integer value
                    JOptionPane.showMessageDialog(Accumulator.this,
                            "Invalid input. Please enter an integer.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(valueLabel);
        add(valueField);
        add(addButton);
        add(sumLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Accumulator();
            }
        });
    }
}
