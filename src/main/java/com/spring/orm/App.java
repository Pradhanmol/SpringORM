package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.Xml");;
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        InputStreamReader inputObject = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputObject);
        //using hardcoded value
/*        Student student = new Student(120,"Shubham Jaiswal","New Delhi");
        int r = studentDao.insert(student);*/
        //for inserting the data through user input
        /*        Student student = new Student();
        System.out.println("Enter the student id : - ");
        student.setStudentId(Integer.parseInt(br.readLine()));
        System.out.println("Enter the student name : -");
        student.setStudentname(br.readLine());
        System.out.println("Enter the city name : -");
        student.setStudentCity(br.readLine());
        int r = studentDao.insert(student);
        System.out.println("Data is inserted"+r);*/
        //for getting the single student data
        Student student = new Student();
        boolean go = true;
        while (go){
            System.out.println("-----------Console Based Application----------");
            System.out.println("***********Welcome to spring orm project***********");
            System.out.println("PRESS 1 for add new student");
            System.out.println("PRESS 2 for display all students");
            System.out.println("PRESS 3 for get detail of single student");
            System.out.println("PRESS 4 for delete students");
            System.out.println("PRESS 5 for update student");
            System.out.println("PRESS 6 for exit");
            try {
                int input = Integer.parseInt(br.readLine());
                switch (input){
                    case 1:
                        //add a new student
                        Student student1 = new Student();
                        System.out.println("Enter the student id : - ");
                        student.setStudentId(Integer.parseInt(br.readLine()));
                        System.out.println("Enter the student name : -");
                        student.setStudentname(br.readLine());
                        System.out.println("Enter the city name : -");
                        student.setStudentCity(br.readLine());
                        int r = studentDao.insert(student);
                        System.out.println("Data is inserted "+ r);
                        System.out.println("Student Id : - " + student.getStudentId());
                        System.out.println("Student Name : - " + student.getStudentname());
                        System.out.println("Student Id : - " + student.getStudentCity());
                        break;
                    case 2:
                        //display all student
                        List<Student> students = studentDao.getAllStudent();
                        for(Student s:students){
                            System.out.println("Student Id : - " + s.getStudentId());
                            System.out.println("Student Name : - " + s.getStudentname());
                            System.out.println("Student city : - " + s.getStudentCity());
                        }
                        break;
                    case 3:
                        //get details of single student
                        System.out.println("Enter the student id :-\n");
                        Student student3 = studentDao.getStudent(Integer.parseInt(br.readLine()));
                        System.out.println(student3);
                        System.out.println("Student Id : - " + student3.getStudentId());
                        System.out.println("Student Name : - " + student3.getStudentname());
                        System.out.println("Student city : - " + student3.getStudentCity());
                        break;
                    case 4:
                        //delete student
                        System.out.println("Enter the student id which you want to delete :-\n");
                        studentDao.deleteStudent(Integer.parseInt(br.readLine()));
                        break;
                    case 5:
                        //update the student
                        System.out.println("Enter the student id which you want to Update :-\n");
                        studentDao.updateStudent(Integer.parseInt(br.readLine()));
                        break;
                    case 6 :
                        go = false;
                        break;
                }
            }catch (Exception e){
                System.out.println("Invalid input Try with another one");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank you for using my application");
        System.out.println("See you again");
    }
}
