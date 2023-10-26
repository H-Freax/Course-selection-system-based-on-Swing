package Business.Directory;

import Business.Person.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDirectory {
    private ArrayList<Person> persons;

    public PersonDirectory() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }

    public Person findPersonById(String personID) {
        for (Person person : persons) {
            if (person.getPersonID().equals(personID)) {
                return person;
            }
        }
        return null;
    }

    public ArrayList<Person> listPersons() {
        return persons;
    }

    public void loadPersonsFromDatabase(Connection connection) throws SQLException {
        String query = "SELECT * FROM Person ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String personName = resultSet.getString("PersonName");
                String personID = resultSet.getString("PersonID");
                String role = resultSet.getString("role");
                Person person = new Person(personName, personID, role);
                persons.add(person);
            }
        }
    }

    public void savePersonsToDatabase(Connection connection) throws SQLException {
        for (Person person : persons) {
            String query = "INSERT INTO Person (PersonName, PersonID, role) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, person.getPersonName());
                statement.setString(2, person.getPersonID());
                statement.setString(3, person.getRole());
                statement.executeUpdate();
            }
        }
    }

    public void updatePersonsInDatabase(Connection connection) throws SQLException {
        for (Person person : persons) {
            String query = "UPDATE Person SET PersonName = ?, role = ? WHERE PersonID = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, person.getPersonName());
                statement.setString(2, person.getRole());
                statement.setString(3, person.getPersonID());
                statement.executeUpdate();
            }
        }
    }
}
