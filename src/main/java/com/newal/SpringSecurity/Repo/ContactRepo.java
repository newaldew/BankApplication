package com.newal.SpringSecurity.Repo;

import com.newal.SpringSecurity.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends CrudRepository<Contact, String> {
}
