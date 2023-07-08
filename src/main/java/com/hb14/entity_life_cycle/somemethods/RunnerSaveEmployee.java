package com.hb14.entity_life_cycle.somemethods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSaveEmployee
{
    public static void main(String[] args)
    {
        Employee employee1 = new Employee();
        employee1.setName("enes");
        employee1.setSalary(250000.0);

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(employee1);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
