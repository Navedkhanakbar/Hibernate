package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class one_to_many {
    public static void main(String[] args) {
        try {
            SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();


            Session session = sessionfactory.openSession();

            Transaction tx = session.beginTransaction();


            Children child1 = new Children();
            child1.setName("al-vida");


            Parent parent1 = new Parent("male", child1);
            Parent parent2 = new Parent("female", child1);

            child1.getParentList().add(parent1);
            child1.getParentList().add(parent2);


            session.persist(child1);

            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
