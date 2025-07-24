package Mft.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Form extends JPanel {
    private JTextField nameField, familyField;
    private JButton addButton, viewButton;

    public Form() {
        JLabel nameLabel = new JLabel("Name:");
        JLabel familyLabel = new JLabel("Family:");
        nameField = new JTextField(15);
        familyField = new JTextField(15);
        addButton = new JButton("Add Person");
        viewButton = new JButton("View All Persons");

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(familyLabel, gbc);

        gbc.gridx = 1;
        add(familyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(addButton, gbc);

        gbc.gridy = 3;
        add(viewButton, gbc);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getFamily() {
        return familyField.getText();
    }

    public void submitPerson(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewPerson(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void reset(boolean bln) {
        if (bln) {
            nameField.setText("");
            familyField.setText("");
        }
    }

    public void addViewButtonListener(ActionListener listener) {
        viewButton.addActionListener(listener);
    }

}
