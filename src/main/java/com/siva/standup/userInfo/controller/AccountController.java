package com.siva.standup.userInfo.controller;

import com.siva.standup.userInfo.data.AccountProfileRepository;
import com.siva.standup.userInfo.model.AccountProfile;
import com.siva.standup.userInfo.model.LoginVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AccountController {

    @Autowired
    private AccountProfileRepository accountProfileRepository;

    @PostMapping(value = "/register")
    ResponseEntity<?> addAccountProfile(@Valid @RequestBody AccountProfile accountProfile) {
        accountProfileRepository.save(accountProfile);
        return new ResponseEntity<>("Profile Created", HttpStatus.CREATED);
    }

    @GetMapping(value = "/accountProfile/{id}")
    ResponseEntity<?> getAddAccountProfile(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(accountProfileRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAccountProfile/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") long id) {
        accountProfileRepository.deleteById(id);

        return new ResponseEntity<>("Profile Deleted", HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    ResponseEntity<?> login(@RequestBody LoginVerification loginVerification) {
        String userName = loginVerification.getUserName();
        String password = loginVerification.getPassword();

        AccountProfile profileByUserName = accountProfileRepository.findProfileByUserName(userName);

        if (profileByUserName != null && profileByUserName.getPassword() != null) {
            if (profileByUserName.getPassword().equals(password)) {
                return new ResponseEntity<>(profileByUserName, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("User name or Password invalid. ", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/")
    String addAccountProfile() {
        return "Account Profile :: Running successfully...";

    }

    @GetMapping(value = "/accountProfile")
    ResponseEntity<?> getAllAddAccountProfile() {
        return new ResponseEntity<>(accountProfileRepository.findAll(Sort.by("id")), HttpStatus.OK);
    }
}
