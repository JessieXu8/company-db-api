package com.oocl.companydbapi.one.to.n.controllers;

import com.oocl.companydbapi.one.to.n.entities.Company;
import com.oocl.companydbapi.one.to.n.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private CompanyRepository repository;

    @Autowired
    public CompanyController(CompanyRepository repository){
        this.repository = repository;
    }

    @Transactional
    @PostMapping(path = "" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company){
        return (Company) repository.save(company);
    }

    @Transactional
    @GetMapping(path = "" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> findAll(){
        return repository.findAll();
    }

    @Transactional
    @PutMapping(path = "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Company company){
        repository.save(company);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
