package Mft.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private ArrayList<Person> personList;

    public DataBase() {
        personList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public List<Person> getAllPersonList() {
        return personList;
    }

    public void savePerson(File file) {
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (Person person : personList) {
                String line = person.getName() + "," + person.getFamily();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(File file) {
        personList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Person person = new Person();
                    person.setName(parts[0]);
                    person.setFamily(parts[1]);
                    personList.add(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
