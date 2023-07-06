package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book07.class)
                .addAnnotatedClass(Student07.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student07 student = session.get(Student07.class, 101L);

        System.out.println(student);
        System.out.println(student.getBookList());

        //fetch the assigned student name and book names using sql from t_student07
        /*
        String sql = "SELECT b.name, s.name FROM t_student07 s INNER JOIN t_book07 b ON s.id = b.stu_id"; // Encountered a duplicated sql alias [name] during auto-discovery of a native-sql query
        List<Object[]> resultList = session.createSQLQuery(sql).getResultList();

        for (Object[] w : resultList)
        {
            System.out.println(Arrays.toString(w));
        }
         */

        //do the same task with HQL
        String hql = "SELECT s.name, b.name FROM Student07 s INNER JOIN Book07 b ON s.id = b.student.id";
        List<Object[]> resultList = session.createQuery(hql).getResultList();

        for (Object[] w : resultList)
        {
            System.out.println(Arrays.toString(w));
        }

        //delete all the records from book07 wih sql
        //String sqlQuery2 = "Delete FROM t_book07";
        //int deletedROWCount = session.createSQLQuery(sqlQuery2).executeUpdate();
        //System.out.println(deletedROWCount);

        String hql2 = "DELETE FROM Student07";
        int deletedRowCountHql = session.createQuery(hql2).executeUpdate();
        System.out.println("deleted row count for hql: " + deletedRowCountHql);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
