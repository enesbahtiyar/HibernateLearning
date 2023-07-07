package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
@Table(name = "t_Student11")
public class Student11
{
    @Id
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "sequence",
            sequenceName = "student_id",
            initialValue = 1001,
            allocationSize = 10
    )
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
