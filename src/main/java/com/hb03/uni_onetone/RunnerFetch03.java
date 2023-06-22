package com.hb03.uni_onetone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diary.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        System.out.println("******* using .get() to fetch student with id 1001");

        Student03 student = session.get(Student03.class, 1001L);
        System.out.println(student);

        System.out.println("******* using .get() to fetch diary with id 101");

        Diary diary = session.get(Diary.class, 101L);
        System.out.println(diary);


        System.out.println("****** using getter to fetch the student from diary");

        System.out.println(diary.getStudent());

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
