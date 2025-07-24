package Mft.Controller;

import Mft.Model.DataBase;
import Mft.Model.Person;
import Mft.View.Form;

import Mft.View.PersonDetails;


import javax.swing.*;
import java.io.File;
import java.util.List;

public class PersonController {
    private final String databaseFile = "src\\main\\java\\Mft\\Data\\database.txt";
    private final DataBase database;
    private final Form form;
    private final PersonDetails personDetails;

    public PersonController(Form form, PersonDetails personDetails) {
        this.database = new DataBase();
        this.form = form;
        this.personDetails = personDetails;

        this.form.submitPerson(e -> {
            String name = this.form.getName().trim();
            String family = this.form.getFamily().trim();
            System.out.println("Name: '" + name + "'");
            System.out.println("Family: '" + family + "'");

            if (name.isEmpty() || family.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.database.addPerson(new Person(name, family));
            this.database.savePerson(new File(databaseFile));
            this.form.reset(true);


            JOptionPane.showMessageDialog(this.form, "Person added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public void loadAndShowPersons() {
        this.database.loadFromFile(new File(databaseFile));
        List<Person> list = this.database.getAllPersonList();
        Object[][] data = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getName();
            data[i][1] = list.get(i).getFamily();
        }
        this.personDetails.setPersonData(data);
    }

}
