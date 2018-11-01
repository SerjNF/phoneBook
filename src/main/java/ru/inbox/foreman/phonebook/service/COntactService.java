package ru.inbox.foreman.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ru.inbox.foreman.phonebook.dao.ContactDao;
import ru.inbox.foreman.phonebook.model.Contact;
import ru.inbox.foreman.phonebook.model.ValidationContact;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactDao contactDao;
    @Autowired
    private ContactValidator contactValidator;

    public List<Contact> gelAllContacts() {
        return contactDao.getAllContacts();
    }

    public ValidationContact addContact(Contact contact) {
        ValidationContact validationContact = contactValidator.validationContact(contact);
        if (validationContact.isValidate()) {
            contactDao.addContact(contact);
        }
        return validationContact;
    }

    List<Contact> findContactByPhone(String phone) {
        List<Contact> contactList = contactDao.getAllContacts();
        return contactList.stream().filter(contact -> contact.getPhone().equals(phone)).collect(Collectors.toList());
    }
}
