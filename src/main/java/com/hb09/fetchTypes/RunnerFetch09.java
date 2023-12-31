package com.hb09.fetchTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book09.class)
                .addAnnotatedClass(Student09.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //fetch types
        Student09 student1 = session.get(Student09.class, 1001L);
        System.out.println(student1);


        /*

        1. If the next side is Many, then the default Type is LAZY.
                OneToMany
                ManyToMany
        2. If the next side is One, then the default Type is EAGER.
                ManyToOne
                OneToOne

 */

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
