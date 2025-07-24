package Mft;

import Mft.View.MainForm;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainForm::new);
    }
}
