package com.hb10.idgeneration;

import javax.persistence.*;

/*
    generationType.AUTO: Hibernate decides which strategy to use

    generationType.Sequence:  Letting developer configure stuff about ID settings --> Oracle & PostgreSQL

    generationType.IDENTITY: DB control the ID settings --> 1,2,3,4.....  --> MySQL

    generationType.TABLE:   slowest one not really recommended -->  creates a new table to store the id's and fetches the id information from there when needed
 */

@Entity
@Table(name = "t_student10")
public class Student10
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stu_name", nullable = false, unique = false, length = 50)
    private String name;

    private int grade;

    public Long getId() {
        return id;
    }

    /*

    public void setId(Long id) {
        this.id = id;
    }
     */
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
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
