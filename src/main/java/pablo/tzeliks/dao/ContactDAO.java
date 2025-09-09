package pablo.tzeliks.dao;

import pablo.tzeliks.model.Contact;
import pablo.tzeliks.model.valueobjects.Email;

import java.sql.SQLException;
import java.util.List;

public interface ContactDAO {

    void saveContact(Contact contact);
    void deleteContact(Contact contact) ;
    void updateContact(Contact contact);

    Contact findContactById(long id);
    Contact findContactByEmail(Email email);

    List<Contact> getAllContacts() throws SQLException;

}
