package com.example;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hidernate_util {

    private static final SessionFactory sessionFactory = buildsessionfactory();


    private static SessionFactory buildsessionfactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        catch (Exception ex) {
            throw new RuntimeException("session creation failed"+ ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
