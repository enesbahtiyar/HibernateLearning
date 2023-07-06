package com.hb09.fetchTypes;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09
{
    public static void main(String[] args)
    {
        Student09 student1 = new Student09();
        student1.setId(1001L);
        student1.setName("Enes");
        student1.setGrade(90);

        Student09 student2 = new Student09();
        student2.setId(1002L);
        student2.setName("Esra");
        student2.setGrade(200);

        Student09 student3 = new Student09();
        student3.setId(1003L);
        student3.setName("Boncuk");
        student3.setGrade(20);


        Book09 book1 = new Book09();
        book1.setId(101L);
        book1.setName("Spring book");

        Book09 book2 = new Book09();
        book2.setId(102L);
        book2.setName("Hibernate book");

        Book09 book3 = new Book09();
        book3.setId(103L);
        book3.setName("Java book");

        Book09 book4 = new Book09();
        book4.setId(104L);
        book4.setName("C# book");

        Book09 book5 = new Book09();
        book5.setId(105L);
        book5.setName("Python book");

        book1.setStudent(student1);
        book2.setStudent(student1);

        book3.setStudent(student2);
        book4.setStudent(student2);

        book5.setStudent(student3);

        //if you use cascadetype.persist you need to set the other side of the relation too

        student1.getBookList().add(book1);
        student1.getBookList().add(book2);

        student2.getBookList().add(book3);
        student2.getBookList().add(book4);

        student3.getBookList().add(book5);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book09.class)
                .addAnnotatedClass(Student09.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        //when you use cascadetype.persist you do not need to save the other objects in relation
        /*
        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);
         */

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
