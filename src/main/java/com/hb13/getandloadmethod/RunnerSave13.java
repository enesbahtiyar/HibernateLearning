package com.hb13.getandloadmethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13
{
    public static void main(String[] args)
    {
        Student14 student1 = new Student14();
        student1.setName("enes");
        student1.setGrade(90);

        Student14 student2 = new Student14();
        student2.setName("esra");
        student2.setGrade(200);

        Student14 student3 = new Student14();
        student3.setName("boncuk");
        student3.setGrade(20);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student14.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
