package com.hb06.uni_onetomany;

import com.hb05.uni_manytoone.Student05;
import com.hb05.uni_manytoone.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave06
{
    public static void main(String[] args)
    {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setName("1984");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setName("A TIME TO KILL");

        Book book3 = new Book();
        book3.setId(3L);
        book3.setName("THE HOUSE OF MIRTH");


        Student06 student1 = new Student06();
        student1.setId(1001L);
        student1.setName("enes");
        student1.setGrade(20);

        Student06 student2 = new Student06();
        student2.setId(1002L);
        student2.setName("esra");
        student2.setGrade(100);

        Student06 student3 = new Student06();
        student3.setId(1003L);
        student3.setName("boncuk");
        student3.setGrade(10);

        /* 1.way
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        student1.setBooklist(bookList);
        */

        //2.way
        student1.getBooklist().add(book1);
        student1.getBooklist().add(book2);

        student2.getBooklist().add(book3);

        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);


        session.save(student1);
        session.save(student2);
        session.save(student3);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
