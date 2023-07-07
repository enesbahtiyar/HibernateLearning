package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave11
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student12.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Random random = new Random();

        for (int i = 1; i < 21; i++)
        {
            Student12 student = new Student12();
            student.setName("Student " + i);
            student.setGrade(random.nextInt(100));
            session.save(student);
        }



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
