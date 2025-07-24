package Mft.View;

import Mft.Controller.PersonController;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    public MainForm() {
        setTitle("Simple Person Form");

        CardLayout layout = new CardLayout();
        JPanel panel = new JPanel(layout);

        Form form = new Form();
        PersonTablePanel details = new PersonTablePanel();

        PersonController controller = new PersonController(form, details);

        panel.add(form, "form");
        panel.add(details, "details");

        form.addViewButtonListener(e -> {
            controller.loadAndShowPersons();
            layout.show(panel, "details");
        });

        details.getBackButton().addActionListener(e -> {
            layout.show(panel, "form");
        });

        setContentPane(panel);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
