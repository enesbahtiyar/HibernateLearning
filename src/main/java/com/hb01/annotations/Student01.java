package com.hb01.annotations;

import javax.persistence.*;

@Entity //with Entitiy we are creating a table in our database
@Table (name = "t_student01") //naming the table
public class Student01
{
    @Id //defining a primary key is necessary
    private int id;

    @Column(name = "student_name", length = 50, nullable = false) //if we don't use this the column name will be name this column is not necessary
    private String name;

    //@Transient //making it not appear on the DB as a column
    private int grade;

    //@Lob //to hold big data large data
    //private byte[] image;

    //constructor
    public Student01()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}


