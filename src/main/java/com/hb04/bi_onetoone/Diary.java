package com.hb04.bi_onetoone;

import com.hb03.uni_onetone.Student03;

import javax.persistence.*;

@Entity
@Table(name = "t_diary1")
public class Diary
{
    @Id
    private Long id;

    private String name;

    @OneToOne //student_id
    @JoinColumn(name = "stu_id")
    private Student04 student;


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

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
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
