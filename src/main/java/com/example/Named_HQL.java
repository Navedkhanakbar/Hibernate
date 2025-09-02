package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Named_HQL {
    public static void main(String[] args) {
        SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionfactory.openSession();

        Transaction tx = session.beginTransaction();

        try{
            family fm = new family("naved",3);
            family fm1 = new family("Al-fiya",3);
            family fm2 = new family("Al-vida",3);


            session.persist(fm);
            session.persist(fm1);
            session.persist(fm2);

            tx.commit();


            List<family> allfamilymembers = session.createNamedQuery("member.Findall", family.class).getResultList();

            List<family>  bynamelist = session.createNamedQuery("person.Findbyname", family.class).setParameter("name","Al-fiya").getResultList();

            List<family> byidlist = session.createNamedQuery("id.Findbyid", family.class).setParameter("id",2).getResultList();

            for (family f1: allfamilymembers) {
                System.out.println(f1);
            }

            for (family f2: bynamelist) {
                System.out.println(f2);
            }

            for (family f3: byidlist) {
                System.out.println(f3);
            }



        }
        finally {
            session.close();
            sessionfactory.close();

        }
    }
}
