package com.hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08
{
    public static void main(String[] args)
    {
        Student08 student1 = new Student08();
        student1.setId(1001L);
        student1.setName("Enes");
        student1.setGrade(90);

        Student08 student2 = new Student08();
        student2.setId(1002L);
        student2.setName("Esra");
        student2.setGrade(200);

        Student08 student3 = new Student08();
        student3.setId(1003L);
        student3.setName("Boncuk");
        student3.setGrade(20);

        Book08 book1 = new Book08();
        book1.setId(101L);
        book1.setName("Spring book");

        Book08 book2 = new Book08();
        book2.setId(102L);
        book2.setName("Hibernate book");

        Book08 book3 = new Book08();
        book3.setId(103L);
        book3.setName("Java book");

        Book08 book4 = new Book08();
        book4.setId(104L);
        book4.setName("C# book");

        Book08 book5 = new Book08();
        book5.setId(105L);
        book5.setName("Python book");

        Book08 book6 = new Book08();
        book6.setId(106L);
        book6.setName("PHP book");

        student1.getBookList().add(book1);
        student1.getBookList().add(book2);
        student1.getBookList().add(book5);

        student2.getBookList().add(book3);
        student2.getBookList().add(book6);

        student3.getBookList().add(book4);
        student3.getBookList().add(book5);
        student3.getBookList().add(book6);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book08.class)
                .addAnnotatedClass(Student08.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);
        session.save(book6);


        session.save(student1);
        session.save(student2);
        session.save(student3);


        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
