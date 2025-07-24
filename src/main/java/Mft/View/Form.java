package Mft.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Form extends JPanel {
    private JTextField nameField, familyField;
    private JButton addButton, viewButton;

    public Form() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField(15);
        add(nameField);

        JLabel familyLabel = new JLabel("Family:");
        add(familyLabel);
        familyField = new JTextField(15);
        add(familyField);


        addButton = new JButton("Add Person");
        viewButton = new JButton("View All Persons");
        add(viewButton);
        add(addButton);

    }

    public String getName() {
        return nameField.getText();
    }

    public String getFamily() {
        return familyField.getText();
    }

    public void setAddButtonListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }
    public void setViewButtonListener(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void clearFormFields(boolean shouldClear) {
if(shouldClear) {
            nameField.setText("");
            familyField.setText("");
        }
    }

    public void addViewButtonListener(ActionListener listener) {
        viewButton.addActionListener(listener);
    }

}
