package Mft.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PersonTablePanel extends JPanel {

    private JTable personTable;
    private String[] personTableColumn = {"name", "family"};
    private DefaultTableModel tableModel;
    private JButton backButton;

    public PersonTablePanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JToolBar toolBar = new JToolBar();
        backButton = new JButton("Back");
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getPreferredSize().height));
        add(toolBar);

        tableModel = new DefaultTableModel(personTableColumn, 0);
        personTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(
                personTable,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        add(scrollPane);
    }

    public void setPersonData(Object[][] data) {
        String[] columns = {"Name", "Family"};
        tableModel.setRowCount(0);
        for (Object[] row : data) {
            tableModel.addRow(row);
        }
    }

    public JButton getBackButton() {
        return backButton;
    }

}
