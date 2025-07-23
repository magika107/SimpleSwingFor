import Mft.Model.DataBase;
import Mft.Model.Person;

import java.io.File;

public class TestDataBase {
    public static void main(String[] args) {
        DataBase db = new DataBase();
        db.addPerson(new Person("ali","ahmadi"));
        db.addPerson(new Person("hamed","ghanbari"));
        File file=new File("persons.txt");
        db.savePerson(file);
        db.loadFromFile(file);


        for (Person person:db.getAllPersonList()){
            System.out.println(person);
        }
    }
}
