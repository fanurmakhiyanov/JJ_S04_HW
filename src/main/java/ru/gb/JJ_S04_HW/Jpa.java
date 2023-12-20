package ru.gb.JJ_S04_HW;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Jpa {

    public static List<Book> main(String[] args) {
        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory();

        Book book1 = new Book();
        book1.setName("A Tale of Two Cities");
        book1.setAuthor("Charles Dickens");

        Book book2 = new Book();
        book2.setName("She: A History of Adventure");
        book2.setAuthor("H. Rider Haggard");

        Book book3 = new Book();
        book3.setName("The Da Vinci Code");
        book3.setAuthor("Dan Brown");

        Book book4 = new Book();
        book4.setName("Harry Potter and the Chamber of Secrets");
        book4.setAuthor("J. K. Rowling");

        Book book5 = new Book();
        book5.setName("Harry Potter and the Prisoner of Azkaban");
        book5.setAuthor("J. K. Rowling");

        Book book6 = new Book();
        book6.setName("Harry Potter and the Goblet of Fire");
        book6.setAuthor("J. K. Rowling");

        Book book7 = new Book();
        book7.setName("The Alchemist");
        book7.setAuthor("Paulo Coelho");

        Book book8 = new Book();
        book8.setName("The Catcher in the Rye");
        book8.setAuthor("J. D. Salinger");

        Book book9 = new Book();
        book9.setName("Lolita");
        book9.setAuthor("Vladimir Nabokov");

        Book book10 = new Book();
        book10.setName("Heidi");
        book10.setAuthor("Johanna Spyri");

        try (Session session = sessionFactory.openSession()) {
            String hql = "from Book";
            Query<String> query = session.createQuery(hql , String.class);
            return query.list();
        }

        sessionFactory.close();
    }
}
