package com.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01
{
    public static void main(String[] args)
    {
        Student01 student1 = new Student01();
        student1.setId(1);
        student1.setName("enes");
        student1.setGrade(90);

        Student01 student2 = new Student01();
        student2.setId(2);
        student2.setName("esra");
        student2.setGrade(100);

        Student01 student3 = new Student01();
        student3.setId(3);
        student3.setName("boncuk");
        student3.setGrade(48);


        //specifying the configuration file and the class that i would like to use this configuration with the hibernate
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        transaction.commit();
        session.close();
        sf.close();
    }
}
