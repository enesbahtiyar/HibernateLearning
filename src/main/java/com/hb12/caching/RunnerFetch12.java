package com.hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student13.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student13 student1 = session.get(Student13.class, 1L);

        //session.clear(); // to clear cache memory

        Student13 student2 = session.get(Student13.class, 1L);

        transaction.commit();
        session.close();


        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();


        Student13 student3 = session2.get(Student13.class, 1L);


        transaction2.commit();;
        session2.close();
        sessionFactory.close();
    }
}
