package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class one_to_one_main {

    public static void main(String[] args) {

        Session ses = Hidernate_util.getSessionFactory().openSession();
        Transaction tx = ses.beginTransaction();


        profile pro = new profile("loves naved");

        users us = new users("Al-fiya", pro);

        ses.persist(us);

        tx.commit();

        ses.close();

        System.out.println("made a foreign key relation");


    }
}
