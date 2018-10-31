package ru.inbox.foreman.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.foreman.phonebook.model.Contact;
import ru.inbox.foreman.phonebook.model.ValidationContact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactValidator {
    private final ContactService contactService;

    @Autowired
    public ContactValidator(ContactService contactService) {
        this.contactService = contactService;
    }

    public ValidationContact validationContact(Contact contact) {
        ValidationContact validationContact = new ValidationContact();
        validationContact.setValidate(true);

        if (contact.getName().length() < 2) {
            validationContact.setValidate(false);
            validationContact.setNameError("не корректное имя");
        }
        if (contact.getLastName().length() < 2) {
            validationContact.setValidate(false);
            validationContact.setNameError("не корректная фамилия");
        }
        if (!checkPhone(contact)) {
            validationContact.setValidate(false);
            validationContact.setNameError("номер задан не корректно");
        }
        if (contactService.findPhone(contact.getPhone())) {
            validationContact.setValidate(false);
            validationContact.setNameError("не корректное имя");
        }


        return validationContact;
    }

    //TODO сделать тест
    private boolean checkPhone(Contact contact) {
        String phone = contact.getPhone();
        Pattern p = Pattern.compile("^+7[\\d]{9}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }
}
