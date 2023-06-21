package com.hb01.annotations;

import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /*
            in order to fetch data from DB there are three ways

            1.get();
            2.SQL query:
            3.Hql query:
         */

        //Get
        System.out.println(session.get(Student01.class, 1));  //data type, PK value
        System.out.println(session.get(Student01.class, 2));
        System.out.println(session.get(Student01.class, 3));

        //SQL
        String sqlQuery = "SELECT * FROM t_student01";

        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList();

        for (Object[] w: resultList)
        {
            System.out.println(Arrays.toString(w));
        }


        //Hql
        String hqlQuery1 = "FROM Student01";
        List<Student01> resultList2 = session.createQuery(hqlQuery1, Student01.class).getResultList();

        for (Student01 w: resultList2)
        {
            System.out.println(w);
        }

        //TASKS
        //get the student with the name enes as a unique result

        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name = 'enes'";
        Object[] std = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();

        System.out.println(Arrays.toString(std));

        //get the student with the name enes as a unique result in HQL with aliases
        String hqlQuery2 = "FROM Student01 s WHERE s.name = 'enes'";
        Student01 student2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println(student2);

        //get the name and id's students whose id's are less than 3, in hql using aliases

        String hqlQuery3 = "SELECT s.name, s.id From Student01 s Where s.id < 3";
        List<Object[]> student3 = session.createQuery(hqlQuery3).getResultList();

        for (Object[] w: student3)
        {
            System.out.println(Arrays.toString(w));
        }

        transaction.commit();
        session.close();
        sessionFactory.close();






    }
}
