package ru.inbox.foreman.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.inbox.foreman.phonebook.model.Contact;
import ru.inbox.foreman.phonebook.model.ValidationContact;
import ru.inbox.foreman.phonebook.service.ContactService;

import java.util.List;

@Controller
@RequestMapping("/phoneBook/rcp/api/v1")
public class myController {
    @Autowired
    private ContactService contactService;


    public myController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "getAllContacts", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getAllContact() {
        return contactService.gelAllContacts();
    }

    @RequestMapping(value = "addContacts", method = RequestMethod.POST)
    @ResponseBody
    public ValidationContact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }
}
