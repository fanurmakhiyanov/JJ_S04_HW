package ru.gb.JJ_S04_HW;

import java.sql.Connection;

public class Main {
    public static <DatabaseHibernate> void main(String[] args) {
        String searchAuthor = "J. K. Rowling";
        Homework4JPA dbHibernate = new Homework4JPA();
        dbHibernate.createTableBook();
        dbHibernate.getBooksByAuthor(searchAuthor);
        dbHibernate.closedSession();
    }
}