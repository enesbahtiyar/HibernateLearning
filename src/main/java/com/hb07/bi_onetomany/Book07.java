package com.hb07.bi_onetomany;

import javax.persistence.*;

@Entity
@Table(name = "t_book07")
public class Book07
{
    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "stu_id")
    private Student07 student;

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

    public Student07 getStudent() {
        return student;
    }

    public void setStudent07(Student07 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student07=" + student +
                '}';
    }
}
