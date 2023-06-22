package com.hb04.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_student04")
public class Student04
{
    @Id
    private Long id;

    @Column(name = "stu_name", length = 100)
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student") //mapped by will not create any column
    //@JoinColumn(name = "diary_id") //this will always be null
    private Diary diary;

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

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


    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                //", diary=" + diary + // this will create infinite loop
                '}';
    }
}
