package com.peaksoft;

import com.peaksoft.model.*;
import com.peaksoft.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {


        Student student1=new Student();
        student1.setName("Bayaman");
         Student student2=new Student();
         student2.setName("Saidibakas");
         List<Student> students=new ArrayList<>();
         students.add(student1);
         students.add(student2);

        Course course1=new Course();
        course1.setName("Java");
        Course course2=new Course();
        course2.setName("JavaScript");
        List<Course> courses=new ArrayList<>();
        courses.add(course1);
        courses.add(course2);

       course1.setStudents(students);
       course2.setStudents(students);


       create(student1);
       create(student2);
       createC(course1);
       createC(course2);


     HibernateUtil.close();
    }
    public static void create(Student student) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
    public static void createC(Course course) {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        session.close();
    }
    public static User getById(Long id){
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    public static List<User> getAllUsers(){
        List<User>users;
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        users=session.createQuery("FROM User").getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }
    public static void updateUser(Long id,String name,int age){
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        User user =session.get(User.class,id);
        user.setName(name);
        user.setAge(age);
        session.getTransaction().commit();
        session.close();
    }

    public static void deleteByID(long id){
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }


}
