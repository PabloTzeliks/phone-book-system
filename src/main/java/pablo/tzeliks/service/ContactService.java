package pablo.tzeliks.service;

import pablo.tzeliks.dao.ContactDAO;
import pablo.tzeliks.dao.ContactDAOImpl;
import pablo.tzeliks.exception.ServiceException;
import pablo.tzeliks.model.Contact;
import pablo.tzeliks.model.valueobjects.Email;
import pablo.tzeliks.model.valueobjects.PhoneNumber;

import java.sql.SQLException;
import java.util.List;

public class ContactService {

    private final ContactDAOImpl contactDAO;

    public ContactService(ContactDAOImpl contactDAO) {
        this.contactDAO = contactDAO;
    }

    public Contact createContact(String name, PhoneNumber phonenumber, Email email, String observation) {

        if (name == null || phonenumber == null || email == null || observation == null) {
            throw new ServiceException("Arguments cannot be null");
        }

        if (name.isBlank() || observation.isBlank()) {
            throw new ServiceException("Arguments cannot be empty");
        }

        Contact contact = new Contact(name, phonenumber, email, observation);

        contactDAO.saveContact(contact);

        return contact;
    }

    public void updateContact(Contact contact) {

        contactDAO.updateContact(contact);
    }

    public Contact findById(long id) {

        if (id <= 0) throw new ServiceException("Arguments cannot be null");

        return contactDAO.findContactById(id);
    }

    public List<Contact> getAllContacts() throws SQLException {

        if (contactDAO.getAllContacts() == null) {
            throw new ServiceException("No contact found");
        }

        return contactDAO.getAllContacts();

    }

}
