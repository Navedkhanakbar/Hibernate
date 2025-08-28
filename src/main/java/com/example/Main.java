package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        // created the table
        create(new User("Naved","nk9167755768@gmail.com",(new Address("molana azad road","thane","maharashtra","400612"))));
        create(new User("Al-fiya","alfi9001@gmail.com",(new Address("kabrastan road","thane","maharashtra","400612"))));

        //read
        User user = Read(1);
        System.out.println("read the first id number: "+ user);


        //update
        update(1,"naved");

        //delete
        Delete(1);

        Hidernate_util.getSessionFactory().close();





    }

    //CRUD

    //create
    public static void create(User user) {
        Session session = Hidernate_util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(user);

        tx.commit();

        session.close();

        System.out.println("user added successfully: "+user);

    }

    //READ
    public static User Read(int id) {
        Session session = Hidernate_util.getSessionFactory().openSession();


        User user = session.get(User.class,id);

        session.close();

        return user;

    }


    //Update
    public static void update(int id,String newname) {
        Session session = Hidernate_util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class,id);

        if (user != null) {
            user.setName(newname);
            session.update(user);

            tx.commit();

            System.out.println("updated user number: "+id);

        }
        session.close();
    }

    //Delete
    public static void Delete(int id) {
        Session session = Hidernate_util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class,id);

        if (user != null) {
            session.delete(user);
            tx.commit();
            System.out.println("deleted the user id: "+ id);
        }
        session.close();

    }




}


