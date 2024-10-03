package com.newal.SpringSecurity.Controller;

import com.newal.SpringSecurity.Repo.ContactRepo;
import com.newal.SpringSecurity.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepo contactRepo;

    @PostMapping("/contact")
    //@PreFilter("filterObject.contactName!='Test'")
    @PostFilter("filterObject.contactName!='Test'")
    public List<Contact> myContactDetails(@RequestBody List<Contact>contacts) {

        List<Contact>returnContact=new ArrayList<Contact>();

        if(!contacts.isEmpty()){
            Contact contact = contacts.getFirst();
            contact.setContactId(getServiceReqNumber());
            contact.setCreateDt(new Date(System.currentTimeMillis()));
            Contact savedContact =contactRepo.save(contact);
            returnContact.add(savedContact);
        }
        return returnContact;
    }
    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
