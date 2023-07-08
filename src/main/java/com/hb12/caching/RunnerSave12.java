package com.hb12.caching;

import com.hb11.criteriaapi.Student12;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave12
{
    public static void main(String[] args)
    {
        Student13 student1 = new Student13();
        student1.setName("enes");
        student1.setGrade(90);

        Student13 student2 = new Student13();
        student2.setName("esra");
        student2.setGrade(200);

        Student13 student3 = new Student13();
        student3.setName("boncuk");
        student3.setGrade(20);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student13.class);

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
