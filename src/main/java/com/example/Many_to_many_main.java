package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Many_to_many_main {
    public static void main(String[] args) {
        SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = sessionfactory.openSession();

        Transaction tx  = session.beginTransaction();

        try {
            Student student1 = new Student();
            student1.setName("naved");

            Student student2 = new Student();
            student2.setName("Al-fiya");


            Course hibernate_master = new Course();
            hibernate_master.setName("Hibernate");

            Course java_spring = new Course();
            java_spring.setName("Java_spring");


            student1.getCourses().add(hibernate_master);
            student1.getCourses().add(java_spring);


            student2.getCourses().add(hibernate_master);


            session.persist(hibernate_master);
            session.persist(java_spring);

            session.persist(student1);
            session.persist(student2);

            tx.commit();
        }
        finally {

            session.close();
            sessionfactory.close();

        }
    }
}
