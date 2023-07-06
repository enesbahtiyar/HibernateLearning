package com.hb07.bi_onetomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07
{
    public static void main(String[] args)
    {
        Student07 student1 = new Student07();
        student1.setId(101L);
        student1.setName("Enes");
        student1.setGrade(80);

        Student07 student2 = new Student07();
        student2.setId(102L);
        student2.setName("Esra");
        student2.setGrade(200);

        Student07 student3 = new Student07();
        student3.setId(103L);
        student3.setName("Boncuk");
        student3.setGrade(10);



        Book07 book1 = new Book07();
        book1.setId(1001L);
        book1.setName("Math Book");
        book1.setStudent07(student1);

        Book07 book2 = new Book07();
        book2.setId(1002L);
        book2.setName("C# Book");
        book2.setStudent07(student1);

        Book07 book3 = new Book07();
        book3.setId(1003L);
        book3.setName("JAVA Book");
        book3.setStudent07(student2);

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book07.class)
                .addAnnotatedClass(Student07.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);


        transaction.commit();
        session.close();
        sessionFactory.close();


    }
}
