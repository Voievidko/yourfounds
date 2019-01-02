package com.yourfounds.entity;

import com.yourfounds.validation.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "email")
    @NotNull(message = "is required")
    @ValidEmail
    private String email;

    @Column(name = "password")
    @NotNull(message = "is required")
    private String password;

    @Column(name = "name")
    @NotNull(message = "is required")
    @Pattern(regexp = "[a-zA-Z]*")
    private String name;

    @Column(name = "surname")
    @NotNull(message = "is required")
    @Pattern(regexp = "[a-zA-Z]*", message = "Only letters")
    private String surname;

    @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                           CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "expense")
    @JoinColumn(name = "expense_id")
    private List<Expense> expenses;

    @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                           CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "account")
    @JoinColumn(name = "account_id")
    private List<Account> accounts;

    public User() {
    }

    public User(String email, String password, String name, String surname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    //for bi-directional relationship
    public void setExpence(Expense expence) {
        if (expenses == null){
            expenses = new ArrayList<>();
        }
        expenses.add(expence);
        expence.setUser(this);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    //for bi-directional relationship
    public void setAccount(Account account){
        if(accounts == null){
            accounts = new ArrayList<>();
        }
        accounts.add(account);
        account.setUser(this);
    }
}