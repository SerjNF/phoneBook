package ru.inbox.foreman.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.inbox.foreman.phonebook.dao.ContactDao;
import ru.inbox.foreman.phonebook.model.Contact;
import ru.inbox.foreman.phonebook.model.ValidationContact;

import java.util.List;

@Service
public class ContactService {
    private final ContactDao contactDao;
    private final ContactValidator contactValidator;

    @Autowired
    public ContactService(ContactDao contactDao, ContactValidator contactValidator) {
        this.contactDao = contactDao;
        this.contactValidator = contactValidator;
    }

    public List<Contact> gelAllContacts() {
        Contact contact = new Contact();
        contact.setId(0);
        contact.setName("Iliay");
        contact.setLastName("Fadeev");
        contact.setPhone("89138956669");
        contactDao.addContact(contact);

        return contactDao.getAllContacts();
    }

    public ValidationContact addContact(Contact contact){
        ValidationContact validationContact = contactValidator.validationContact(contact);
        return validationContact;
    }

    public boolean findPhone(String phone) {
        return false;
    }
}
