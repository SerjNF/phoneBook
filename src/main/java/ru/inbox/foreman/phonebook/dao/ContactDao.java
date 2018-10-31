package ru.inbox.foreman.phonebook.dao;

import ru.inbox.foreman.phonebook.model.Contact;

import java.util.List;

public interface ContactDao {

    List<Contact> findContact();

    List<Contact> getAllContacts();

    void addContact(Contact contact);
}
