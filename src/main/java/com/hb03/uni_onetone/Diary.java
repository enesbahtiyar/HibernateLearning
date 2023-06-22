package com.hb03.uni_onetone;

import javax.persistence.*;

@Entity
@Table(name = "t_diary")
public class Diary
{
    @Id
    private Long id;

    private String name;


    @OneToOne
    @JoinColumn(name = "stu_id")
    private Student03 student; //this will onyl give you the student id as column


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
