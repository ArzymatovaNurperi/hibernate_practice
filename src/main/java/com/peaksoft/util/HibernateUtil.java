package com.peaksoft.util;

import com.peaksoft.model.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    SessionFactory sessionFactory=buildSessionFactory();

     private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Details.class)
                    .addAnnotatedClass(Company.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
        }
        catch (HibernateException e){
            throw new ExceptionInInitializerError(e);
        }
     }
     public static SessionFactory getSessionFactory(){
         return buildSessionFactory();
     }
     public static void close(){
         getSessionFactory().close();
     }

}
