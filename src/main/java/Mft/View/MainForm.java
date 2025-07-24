package Mft.View;

import Mft.Controller.PersonController;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private PersonController controller;

    public MainForm() {
        super("Java Swing MVC");

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        Form form = new Form();
        PersonDetails personDetails = new PersonDetails();

        controller = new PersonController(form, personDetails);

        mainPanel.add(form, "form");
        mainPanel.add(personDetails, "details");

        form.addViewButtonListener(e -> {
            controller.loadAndShowPersons();
            cardLayout.show(mainPanel, "details");
        });

        personDetails.getBackButton().addActionListener(e -> {
            cardLayout.show(mainPanel, "form");
        });

        setContentPane(mainPanel);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
