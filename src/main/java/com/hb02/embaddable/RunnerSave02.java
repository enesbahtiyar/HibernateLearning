package com.hb02.embaddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02
{
    public static void main(String[] args) {
        Student02 student1 = new Student02();
        student1.setId(1);
        student1.setName("enes");
        student1.setGrade(10);

        Address address1 = new Address("Apple Street", "New yorj", "usa", "01-9991");
        student1.setAddress(address1);

        Student02 student2 = new Student02();
        student2.setId(2);
        student2.setName("esra");
        student2.setGrade(100);
        student1.setAddress(new Address("Boncuk Street", "Amsterdam", "DE", "01-9921"));

        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
