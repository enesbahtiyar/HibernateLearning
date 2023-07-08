package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch11
{
    public static void main(String[] args)
    {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student12.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /*
            CRUD(CREATE, READ, UPDATE, DELETE)

            c --> session.save() session.persist()
            R --> session.get(), Hql, Sql
            U --> session.Update() update query
            D --> session.delete() Hql, Sql
         */

        //update an existing data
        Student12 student1 = session.get(Student12.class, 1L);
        student1.setName("Updated" + student1.getName());
        session.update(student1);

        //update and existing data with query
        int sGrade = 70;
        int lGrade = 50;
        String hql = "UPDATE Student12 s SET s.grade =: sMath WHERE s.grade <: lMath";
        Query query1 = session.createQuery(hql);

        //assign the variables
        query1.setParameter("sMath", sGrade);
        query1.setParameter("lMath", lGrade);

        //execute the query
        int numberOfUpdatedRows = query1.executeUpdate();
        System.out.println("Updated Row Count: " + numberOfUpdatedRows);

        //criteria API            --        Criteria Query's
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student12> criteriaQuery = criteriaBuilder.createQuery(Student12.class);
        Root<Student12> root = criteriaQuery.from(Student12.class); //FROM Student12

        //Select All students
        //String sql = "SELECT * FROM Student11"; //hql sql query

        criteriaQuery.select(root); //SELECT * FROM student11
        Query<Student12> query = session.createQuery(criteriaQuery);
        List<Student12> resultList = query.getResultList();
        for (Student12 w : resultList)
        {
            System.out.println(w);
        }

        //get the student whose name is Student5
        String sql = "SELECT * FROM  t_student11 s WHERE s.name = 'Student 5'";

        criteriaQuery.select(root)
                        .where(criteriaBuilder.equal(root.get("name"), "Student 5"));   //WHERE student12.name = 'student 5'

        Query<Student12> query2 = session.createQuery(criteriaQuery);
        List<Student12> resultList2 = query2.getResultList();
        for (Student12 w : resultList2)
        {
            System.out.println(w);
        }


        //get the students whose grade are bigger than 80

        criteriaQuery.select(root)
                        .where(criteriaBuilder.greaterThan(root.get("grade"), 80));

        Query<Student12> query3 = session.createQuery(criteriaQuery);
        List<Student12> resultList3 = query3.getResultList();

        for (Student12 w : resultList3)
        {
            System.out.println(w);
        }

        //find the records whose id is equal to 1 or grade is greater than 75
        //predicate

        Predicate predicateForId = criteriaBuilder.equal(root.get("id"), 1);
        Predicate predicateForGrade = criteriaBuilder.greaterThan(root.get("grade"), 75);
        Predicate predicateForOr = criteriaBuilder.or(predicateForId, predicateForGrade);

        criteriaQuery.where(predicateForOr);

        Query<Student12> query4 = session.createQuery(criteriaQuery);
        List<Student12> resultList4 = query4.getResultList();

        for (Student12 w : resultList4)
        {
            System.out.println(w);
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
