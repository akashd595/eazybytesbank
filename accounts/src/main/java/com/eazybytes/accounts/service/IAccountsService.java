package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDTO;

public interface IAccountsService {
    void createAccount(CustomerDTO customerDTO);
    public CustomerDTO fetchAccount( String mobileNumber );
    public boolean updateAccount( CustomerDTO customerDTO );
    public boolean deleteAccount( String mobileNumber );
}
