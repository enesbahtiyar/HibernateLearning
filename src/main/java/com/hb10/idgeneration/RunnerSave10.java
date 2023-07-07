package com.hb10.idgeneration;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10
{
    public static void main(String[] args)
    {
        Student10 student1 = new Student10();
        student1.setName("enes");
        student1.setGrade(90);

        Student10 student2 = new Student10();
        student2.setName("esra");
        student2.setGrade(200);

        Student10 student3 = new Student10();
        student3.setName("boncuk");
        student3.setGrade(20);

        Student11 student4 = new Student11();
        student4.setName("boncuk");
        student4.setGrade(20);

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student10.class)
                .addAnnotatedClass(Student11.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
