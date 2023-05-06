package com.example.application.data.service;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
public class CrmService {
    private final CompanyRepository companyRepository;
    private final ContactRepository contactRepository;
    private final StatusRepository statusRepository;

    @Autowired
    public CrmService(CompanyRepository companyRepository, ContactRepository contactRepository, StatusRepository statusRepository) {
        this.companyRepository = companyRepository;
        this.contactRepository = contactRepository;
        this.statusRepository = statusRepository;
    }

    public List<Contact> findAllContacts(String stringFilter) {
        if (isEmpty(stringFilter))
            return contactRepository.findAll();
        else
            return contactRepository.search(stringFilter);
    }

    public long countContacts() {
        return contactRepository.count();
    }

    public void deleteContacts(Contact contact) {
        contactRepository.delete(contact);
    }

    public void saveContact(Contact contact) {
        if (contact == null) {
            System.out.println("Contact is null");
            return;
        }
        contactRepository.save(contact);
    }

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    public List<Status> findAllStatuses() {
        return statusRepository.findAll();
    }
}
