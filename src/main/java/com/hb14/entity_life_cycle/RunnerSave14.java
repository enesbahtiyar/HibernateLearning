package com.hb14.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14
{
    public static void main(String[] args)
    {
        Student15 student1 = new Student15(); // transient state Hibernate has no responsibility
        student1.setName("enes");
        student1.setGrade(90);

        Student15 student2 = new Student15();
        student2.setName("esra");
        student2.setGrade(200);

        Student15 student3 = new Student15();
        student3.setName("boncuk");
        student3.setGrade(20);


        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student15.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


//        session.save(student1); //persistent state hibernate will track with my object
//        session.save(student2);
//        session.save(student3);

        session.evict(student1); //detached state
        student1.setName("Enes"); //object is still in detached state

        session.merge(student1); //back to persistent state
        student1.setName("Bahtiyar");

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
