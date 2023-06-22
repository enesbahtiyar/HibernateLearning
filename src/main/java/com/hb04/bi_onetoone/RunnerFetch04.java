package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04
{
    public static void main(String[] args)
    {

        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student04 student = session.get(Student04.class, 1001L);

        System.out.println(student.getDiary());


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
