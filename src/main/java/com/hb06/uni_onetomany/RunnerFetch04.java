package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).
                addAnnotatedClass(Book.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student06 student1 = session.get(Student06.class, 1001L);
        System.out.println(student1);

        //get fetch the book with id: 101 using HQL
        System.out.println("************* GET/FETCH the book with id: 1001 using HQL**********");
        String hql1 = "Select b.id, b.name FROM Student06 s INNER JOIN s.booklist b WHERE s.id = 1001L";
        List<Object[]> resultlist1 = session.createQuery(hql1).getResultList();
        for (Object[] w : resultlist1)
        {
            System.out.println(Arrays.toString(w));
        }

        System.out.println("************* FETCH the book with id 1001L **********");
        Student06 student2 = session.get(Student06.class, 1001L);

        System.out.println(student2.getBooklist());

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
