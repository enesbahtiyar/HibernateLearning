package com.hb07.bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student07")
public class Student07
{
    @Id
    private Long id;


    private String name;

    private int grade;

    @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.REMOVE)
    /*
        CascadeType.Remove: if the parent gets removed children tables get removed with it too
        cascade.Persist:   if a student is saved you dont need to save the books separately(only when you already set the books for the student)
     */
    private List<Book07> bookList = new ArrayList<>();

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
//                ", bookList=" + bookList +
                '}';
    }
}
