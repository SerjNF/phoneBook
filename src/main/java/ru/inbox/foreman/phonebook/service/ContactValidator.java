package ru.inbox.foreman.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.foreman.phonebook.model.Contact;
import ru.inbox.foreman.phonebook.model.ValidationContact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactValidator {
    @Autowired
    private ContactService contactService;


    public ValidationContact validationContact(Contact contact) {
        ValidationContact validationContact = new ValidationContact();
        validationContact.setValidate(true);

        if (contact.getName().length() < 2) {
            validationContact.setValidate(false);
            validationContact.setNameError("не корректное имя");
        }
        if (contact.getLastName().length() < 2) {
            validationContact.setValidate(false);
            validationContact.setLastNameError("не корректная фамилия");
        }
        if (!checkPhone(contact)) {
            validationContact.setValidate(false);
            validationContact.setPhoneError("номер задан не корректно");
        }

        if (!contactService.findContactByPhone(contact.getPhone()).isEmpty()) {
            validationContact.setValidate(false);
            validationContact.setPhoneError("номер существует");
        }
        return validationContact;
    }


    private boolean checkPhone(Contact contact) {
        String phone = contact.getPhone();
        Pattern p = Pattern.compile("^[+][0-9]{1,2}[\\d]{10}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
