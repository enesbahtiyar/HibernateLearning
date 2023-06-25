package com.hb05.uni_manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).
                addAnnotatedClass(University.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student05 student1 = session.get(Student05.class, 1001l);
        System.out.println(student1);

        University university = session.get(University.class, 101L);
        System.out.println(university);

        System.out.println(student1.getUniversity());
        System.out.println(student1.getUniversity().getName());

        //fetch the students whose university id is 101
        String sql = "SELECT * FROM t_Student05 WHERE univ_id = 101";
        List<Object[]> resultlist = session.createSQLQuery(sql).getResultList();
        for (Object[] w: resultlist)
        {
            System.out.println(Arrays.toString(w));
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
