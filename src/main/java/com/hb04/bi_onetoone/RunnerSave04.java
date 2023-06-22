package com.hb04.bi_onetoone;

import com.hb03.uni_onetone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04
{
    public static void main(String[] args)
    {
        Student04 student1 = new Student04();
        student1.setId(1001L);
        student1.setName("enes");
        student1.setGrade(20);

        Student04 student2 = new Student04();
        student2.setId(1002L);
        student2.setName("esra");
        student2.setGrade(100);

        Student04 student3 = new Student04();
        student3.setId(1003L);
        student3.setName("boncuk");
        student3.setGrade(48);


        Diary diary1 = new Diary();
        diary1.setId(101L);
        diary1.setName("enes's diary");
        diary1.setStudent(student1);


        Diary diary2 = new Diary();
        diary2.setId(102L);
        diary2.setName("esra's diary");
        diary2.setStudent(student2);


        Diary diary3 = new Diary();
        diary3.setId(103L);
        diary3.setName("boncu's diary");
        diary3.setStudent(student3);

        //setting students diary's no need to do that part
        /*
        student1.setDiary(diary1);
        student1.setDiary(diary2);
        student1.setDiary(diary3);
         */


        Configuration configuration = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).
                addAnnotatedClass(Diary.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
