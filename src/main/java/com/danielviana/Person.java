package com.danielviana;

public class Person {
    private int idPerson;
    private String namePerson;
    private String surnamePerson;
    private String emailPerson;
    private String passwordPerson;
    private String rolePerson;

    public Person() {
    }

    public Person(String namePerson, String surnamePerson, String emailPerson, String passwordPerson,
            String rolePerson) {
        this.namePerson = namePerson;
        this.surnamePerson = surnamePerson;
        this.emailPerson = emailPerson;
        this.passwordPerson = passwordPerson;
        this.rolePerson = rolePerson;
    }

    public Person(int idPerson, String namePerson, String surnamePerson, String emailPerson, String passwordPerson,
            String rolePerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.surnamePerson = surnamePerson;
        this.emailPerson = emailPerson;
        this.passwordPerson = passwordPerson;
        this.rolePerson = rolePerson;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getSurnamePerson() {
        return surnamePerson;
    }

    public void setSurnamePerson(String surnamePerson) {
        this.surnamePerson = surnamePerson;
    }

    public String getEmailPerson() {
        return emailPerson;
    }

    public void setEmailPerson(String emailPerson) {
        this.emailPerson = emailPerson;
    }

    public String getPasswordPerson() {
        return passwordPerson;
    }

    public void setPasswordPerson(String passwordPerson) {
        this.passwordPerson = passwordPerson;
    }

    public String getRolePerson() {
        return rolePerson;
    }

    public void setRolePerson(String rolePerson) {
        this.rolePerson = rolePerson;
    }

}
