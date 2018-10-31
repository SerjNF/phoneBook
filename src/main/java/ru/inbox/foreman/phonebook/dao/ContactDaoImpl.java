package ru.inbox.foreman.phonebook.dao;

import org.springframework.stereotype.Repository;
import ru.inbox.foreman.phonebook.model.Contact;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {
    private List<Contact> contactList = new ArrayList<>();

    @Override
    public List<Contact> findContact() {
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactList;
    }

    @Override
    public void addContact(Contact contact) {
        contactList.add(contact);
    }
}
