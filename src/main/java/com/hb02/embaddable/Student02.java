package com.hb02.embaddable;

import javax.persistence.*;

@Entity
@Table( name = "t_student02")
public class Student02
{
    @Id
    private int id;

    @Column(name = "student_name", length = 50, nullable = false)
    private String name;

    private int grade;

    @Embedded //optional
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
