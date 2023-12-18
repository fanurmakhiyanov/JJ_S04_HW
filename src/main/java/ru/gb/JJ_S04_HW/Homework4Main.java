package ru.gb.JJ_S04_HW;

import java.sql.*;

public class Homework4Main {

    /**
     * Задания необходимо выполнять на ЛЮБОЙ СУБД (postgres, mysql, sqllite, h2, ...)
     * <p>
     * 1. С помощью JDBC выполнить:
     * 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
     * 1.2 Добавить в таблицу 10 книг
     * 1.3 Сделать запрос select from book where author = 'какое-то имя' и прочитать его с помощью ResultSet
     * <p>
     * 2. С помощью JPA(Hibernate) выполнить:
     * 2.1 Описать сущность Book из пункта 1.1
     * 2.2 Создать Session и сохранить в таблицу 10 книг
     * 2.3 Выгрузить список книг какого-то автора
     * <p>
     * 3.* Создать сущность Автор (id biging, name varchar), и в сущности Book сделать поле типа Author (OneToOne)
     * 3.1 * Выгрузить Список книг и убедиться, что поле author заполнено
     * 3.2 ** В классе Author создать поле List<Book>, которое описывает список всех книг этого автора. (OneToMany)
     */

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:h2:mem:database.db");
        // 1.1 Создать таблицу book с колонками id bigint, name varchar, author varchar, ...
        prepareTables(connection);
        insertData(connection);

        try (Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery("select id, name, author from book");
//
//            while (resultSet.next()) {
//                int id =  resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String author  = resultSet.getString("author");
//
//                System.out.println("[ " + "ID: " + id + ", Name: " + name + ", Author: " + author + " ]");
//
//            }

            ResultSet resultSet = statement.executeQuery("select * from book where author = 'Lewis Carrol'");
            while (resultSet.next()) {
                String author  = resultSet.getString("author");
                System.out.println(author);
            }
        }

            connection.close();

    }

    private static void prepareTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                    create table book (
                        id bigint,
                        name varchar(255),
                        author varchar(255)
                    )
                    """);
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("insert into book(id, name, author) values (1, 'Adventures of Tom Sawyer', 'Mark Twain')");
            statement.execute("insert into book(id, name, author) values (2, 'Alice in Wonderland', 'Lewis Carrol')");
            statement.execute("insert into book(id, name, author) values (3, 'Gulliver’s Travels', 'Jonathan Swift')");
            statement.execute("insert into book(id, name, author) values (4, 'The Lady of the Last Minstrel', 'Sir Walter Scott')");
            statement.execute("insert into book(id, name, author) values (5, 'Adventures of Sherlock Holmes', 'Arthur Conan Doyle')");
            statement.execute("insert into book(id, name, author) values (6, 'Antony and Cleopatra', 'Shakespeare')");
            statement.execute("insert into book(id, name, author) values (7, 'Crime and Punishment', 'Dostoevsky')");
            statement.execute("insert into book(id, name, author) values (8, 'Count of Monte Cristo', 'Alexander Dumas')");
            statement.execute("insert into book(id, name, author) values (9, 'Canterbury Tales', 'Chaucer')");
            statement.execute("insert into book(id, name, author) values (10, 'Divine Comedy', 'Dante')");
        }
    }
}