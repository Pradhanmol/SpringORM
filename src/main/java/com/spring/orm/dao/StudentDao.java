package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao {

    public HibernateTemplate hibernateTemplate;
    //Save Student
    @Transactional
    //save Data
    public int insert(Student student) {
        //insert student
        Integer i = (Integer) this.hibernateTemplate.save(student);
        return i;
    }
    //get single data
    public Student getStudent(int studentId){
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
    }
    //get multiple studentData
    public List<Student> getAllStudent(){
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }
    //delete the student
    @Transactional
    public void deleteStudent(int studentId){
        Student student = this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.delete(student);
    }
    //update the student data
    @Transactional
    public void updateStudent(int studentId){
        this.hibernateTemplate.update(studentId);
    }
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

}
