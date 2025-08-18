package com.JobApplication.Firstjobapp.company;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/companies")
public class companyController {
    private final companyServices companyServices;

    public companyController(companyServices companyServices) {
        this.companyServices = companyServices;
    }
    @GetMapping
    public ResponseEntity<List<company>>findAll(){
        List<company>company=companyServices.findAll();
        if(company.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String>createCompany( @Valid @RequestBody company companies){
        companyServices.createJob(companies);
        return new ResponseEntity<>("Company added successfully",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<company>findById(@PathVariable @Min(value = 1, message = "Id must be greater than 0") Long id){
        company company=companyServices.findById(id);
        if(company==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Company Not found");
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String>updateCompany(@PathVariable Long id,@Valid @RequestBody company companies){
        boolean update= companyServices.updateCompany(companies, id);
        if(update)return new ResponseEntity<>("Update successfully",HttpStatus.OK);
        return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteById(@PathVariable Long id){
        boolean deleted=companyServices.deleteById(id);
        if(deleted)return new ResponseEntity<>("Company Deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
    }
}
