package com.hb04.bi_onetoone;

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
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student04 student = session.get(Student04.class, 1001L);
        System.out.println(student.getDiary());

        System.out.println("********** INNER JOIN**************");
        //get the student name and diary name with  hql. (by using inner join)

        String hql = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary d ON s.id = d.student.id";
        List<Object[]> list = session.createQuery(hql).getResultList();
        for (Object[] w: list)
        {
            System.out.println(Arrays.toString(w));
        }

        list.forEach(obj -> System.out.println(Arrays.toString(obj))); //lambda

        System.out.println("*********** LEFT JOIN ************");
        //Get the student name and diary name with hql by using left join
        String hql2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary d ON s.id = d.student.id";
        List<Object[]> resultList2 = session.createQuery(hql2).getResultList();
        for (Object[] w: resultList2)
        {
            System.out.println(Arrays.toString(w));
        }


        System.out.println("*********** RIGHT JOIN ************");
        //Get the student name and diary name with hql by using left join
        String hql3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary d ON s.id = d.student.id";
        List<Object[]> resultList3 = session.createQuery(hql3).getResultList();
        for (Object[] w: resultList3)
        {
            System.out.println(Arrays.toString(w));
        }


        //get the student name and diary name with hql
        String hql4 = "SELECT s.name, d.name FROM Students04 s FULL JOIN FETCH Diary d ON s.id = d.student.id";
        List<Object[]> resultList4 = session.createQuery(hql4).getResultList();
        for (Object[] w: resultList4)
        {
            System.out.println(Arrays.toString(w));
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
