package com.example;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.management.Query;
import java.util.List;

public class F_t_HQL {
    public static void main(String[] args) {
        SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();


        Session session = sessionfactory.openSession();

        Transaction tx = session.beginTransaction();

        try {
//            Worker work1 = new Worker(21,"Naved","maharashtra",2_0_0);
//            Worker work2 = new Worker(22,"Al-fiya","maharashtra",2_0_0_0);
//            Worker work3 = new Worker(0,"Al-vida","maharashtra",0);
//
//            session.persist(work1);
//            session.persist(work2);
//            session.persist(work3);
//
//            tx.commit();


            TypedQuery<Worker> query = session.createQuery("FROM Worker", Worker.class);
            List<Worker> employee = query.getResultList();


            TypedQuery<Worker> query1 = session.createQuery("FROM Worker w WHERE w.salary >= :sal", Worker.class);

            query1.setParameter("sal",2000);

            List<Worker> highsalary = query1.getResultList();

            for(Worker w: highsalary) {
                System.out.println(w);
            }
        }
        finally {
            session.close();
            sessionfactory.close();

        }
    }
}
