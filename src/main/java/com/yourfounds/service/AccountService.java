package com.yourfounds.service;

import com.yourfounds.entity.Account;

import java.util.List;

public interface AccountService {
    void addAccount(Account account);
    List<Account> getAccounts();
    Account getAccount(int id);
    void deleteAccountById(int id);
    void updateAccount(Account account);
}
