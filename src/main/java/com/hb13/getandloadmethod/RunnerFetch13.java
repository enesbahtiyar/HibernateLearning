package com.hb13.getandloadmethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student14.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        //getting data with get and load from existing values

        Student14 student1 = session.get(Student14.class, 1L);

        System.out.println(student1.getId());
        System.out.println(student1.getName());

        Student14 student2 = session.load(Student14.class, 2L);
        System.out.println(student2.getName());
        System.out.println(student2.getId());


        //getting data with get and load from non-existing values

        Student14 student3 = session.get(Student14.class, 4L);
        //System.out.println(student3.getId()); // will give nullPointerException
        //System.out.println(student3.getName()); // will give nullPointerException

        Student14 student4 = session.load(Student14.class, 4L);
        System.out.println(student4.getName()); // going to throw ObjectNotFoundException
        System.out.println(student4.getId()); // going to throw ObjectNotFoundException

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
