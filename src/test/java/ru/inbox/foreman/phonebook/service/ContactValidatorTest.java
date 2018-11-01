package ru.inbox.foreman.phonebook.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.inbox.foreman.phonebook.model.Contact;

import static org.junit.Assert.*;

public class ContactValidatorTest {
    @Autowired
    private ContactValidator contactValidator = new ContactValidator();

    @Test
    public void validationContact() {

        Contact contact = new Contact();
        contact.setId(0);
        contact.setName("Iliay");
        contact.setLastName("Fadeev");
        contact.setPhone("+79138956666");

        assertTrue(contactValidator.validationContact(contact).isValidate());
    }
}