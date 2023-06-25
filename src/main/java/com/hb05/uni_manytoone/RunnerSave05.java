package com.hb05.uni_manytoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05
{
    public static void main(String[] args)
    {
        Student05 student1 = new Student05();
        student1.setId(1001L);
        student1.setName("enes");
        student1.setGrade(20);

        Student05 student2 = new Student05();
        student2.setId(1002L);
        student2.setName("esra");
        student2.setGrade(100);

        Student05 student3 = new Student05();
        student3.setId(1003L);
        student3.setName("boncuk");
        student3.setGrade(10);

        University university = new University();
        university.setId(101L);
        university.setName("Istanbul University");

        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);

        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).
                addAnnotatedClass(University.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(university);

        session.save(student1);
        session.save(student2);
        session.save(student3);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
