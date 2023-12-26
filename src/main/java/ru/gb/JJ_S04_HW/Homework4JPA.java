package ru.gb.JJ_S04_HW;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Homework4JPA {
    final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml").buildSessionFactory();
    Book book;

    public void createTableBook() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Author author01 = new Author("Charles Dickens");
            session.persist(author01);

            Author author02 = new Author("H. Rider Haggard");
            session.persist(author02);

            Author author03 = new Author("Dan Brown");
            session.persist(author03);

            Author author04 = new Author("J. K. Rowling");
            session.persist(author04);

            Author author05 = new Author("Paulo Coelho");
            session.persist(author05);

            Author author06 = new Author("J. D. Salinger");
            session.persist(author06);

            Author author07 = new Author("Vladimir Nabokov");
            session.persist(author07);

            Author author08 = new Author("Johanna Spyri");
            session.persist(author08);


            book = new Book("A Tale of Two Cities", author01);
            session.persist(book);

            book = new Book("She: A History of Adventure", author02);
            session.persist(book);

            book = new Book("The Da Vinci Code", author03);
            session.persist(book);

            book = new Book("Harry Potter and the Chamber of Secret", author04);
            session.persist(book);

            book = new Book("Harry Potter and the Prisoner of Azkaban", author04);
            session.persist(book);

            book = new Book("Harry Potter and the Goblet of Fire", author04);
            session.persist(book);

            book = new Book("The Alchemist", author05);
            session.persist(book);

            book = new Book("The Catcher in the Rye", author06);
            session.persist(book);

            book = new Book("Lolita", author07);
            session.persist(book);

            book = new Book("Heidi", author08);
            session.persist(book);

            session.getTransaction().commit();
        }
    }

    public void getBooksByAuthor(String searchAuthor) {
        try (Session session = sessionFactory.openSession()) {
            List<Book> books = session.createQuery(
                            "FROM Book WHERE author = (FROM Author WHERE nameAuthor = :name_author)", Book.class
                    ).setParameter("name_author", searchAuthor)
                    .getResultList();

            books.forEach(System.out::println);
        }
    }
    public void closedSession() {
        sessionFactory.close();
    }
}