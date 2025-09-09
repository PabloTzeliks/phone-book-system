package pablo.tzeliks.dao;

import pablo.tzeliks.exception.ContactNotFoundException;
import pablo.tzeliks.model.Contact;
import pablo.tzeliks.model.valueobjects.Email;
import pablo.tzeliks.model.valueobjects.PhoneNumber;
import pablo.tzeliks.repository.ConnectDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOImpl implements ContactDAO {

    private Connection getConnection() throws SQLException {
        return ConnectDatabase.connect();
    }

    // CRUD Methods

    @Override
    public void saveContact(Contact contact) {
        String sql = "INSERT INTO contact (name, phonenumber, email, observation) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhoneNumber().getPhoneNumber());
            stmt.setString(3, contact.getEmail().getValue());
            stmt.setString(4, contact.getObservation());

            int affected = stmt.executeUpdate();
            if (affected == 0) {
                throw new RuntimeException("Creating contact failed, no rows affected.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateContact(Contact contact) {
        String sql = "UPDATE contact SET name = ?, phonenumber = ?, email = ?, observation = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhoneNumber().getPhoneNumber());
            stmt.setString(3, contact.getEmail().getValue());
            stmt.setString(4, contact.getObservation());
            stmt.setLong(5, contact.getId());

            int affected = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContact(Contact contact) {

        String sqlById = "DELETE FROM contact WHERE id = ?";
        String sqlByEmail = "DELETE FROM contact WHERE email = ?";

        try (Connection conn = getConnection()) {
            int affected;
            if (contact.getId() > 0) {
                try (PreparedStatement stmt = conn.prepareStatement(sqlById)) {
                    stmt.setLong(1, contact.getId());
                    affected = stmt.executeUpdate();
                }
            } else {
                try (PreparedStatement stmt = conn.prepareStatement(sqlByEmail)) {
                    stmt.setString(1, contact.getEmail().getValue());
                    affected = stmt.executeUpdate();
                }
            }

            if (affected == 0) {
                throw new ContactNotFoundException("Cannot find contact to delete: " +
                        (contact.getId() > 0 ? contact.getId() : contact.getEmail().getValue())); // Caso houver ID, deleta por ID, se não, deleta por Email.
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Reading Methods

    @Override
    public Contact findContactById(long id) {
        String sql = "SELECT id, name, phonenumber, email, observation FROM contact WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    throw new ContactNotFoundException("Cannot find contact with id: " + id);
                }

                long dbId = rs.getLong("id");
                String name = rs.getString("name");
                String phonenumberDb = rs.getString("phonenumber");
                String emailDb = rs.getString("email");
                String observation = rs.getString("observation");

                return new Contact(dbId, name, new PhoneNumber(phonenumberDb), new Email(emailDb), observation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Contact findContactByEmail(Email email) {
        String sql = "SELECT id, name, phonenumber, email, observation FROM contact WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email.getValue());

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    throw new ContactNotFoundException("Cannot find contact by email: " + email.getValue());
                }

                long id = rs.getLong("id");
                String name = rs.getString("name");
                String phonenumberDb = rs.getString("phonenumber");
                String emailDb = rs.getString("email");
                String observation = rs.getString("observation");

                return new Contact(id, name, new PhoneNumber(phonenumberDb), new Email(emailDb), observation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Contact findContactByName(String name) {

        String sql = "SELECT id, name, phonenumber, email, observation FROM contact WHERE name LIKE ?";

        String formatName = '%' + name + '%';

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, formatName);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.next()) {
                    throw new ContactNotFoundException("Cannot find contact by name: " + name);
                }

                long id = rs.getLong("id");
                String nameDb = rs.getString("name");
                String phonenumberDb = rs.getString("phonenumber");
                String emailDb = rs.getString("email");
                String observation = rs.getString("observation");

                return new Contact(id, nameDb, new PhoneNumber(phonenumberDb), new Email(emailDb), observation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Listing Methods

    @Override
    public List<Contact> getAllContacts() throws SQLException {
        String query = "SELECT id, name, phonenumber, email, observation FROM contact";

        List<Contact> contacts = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    String phonenumber = rs.getString("phonenumber");
                    String email = rs.getString("email");
                    String observation = rs.getString("observation");

                    Contact contact = new Contact(id, name, new PhoneNumber(phonenumber), new Email(email), observation);
                    contacts.add(contact);
                }
            }
        }
        return contacts;
    }
}
