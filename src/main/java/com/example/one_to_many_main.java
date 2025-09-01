package com.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class one_to_many_main {

    public static void main(String[] args) {

        //1. setup hibernate session
        SessionFactory sessionfactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        Session session = sessionfactory.openSession();

        Transaction tx = session.beginTransaction();


        try {
            //2. Create department
//            Department dep = new Department();
//            dep.setName("Engineering");

            Department department = new Department();
            department.setName("Commerce");

            //3. create employee
//            Employee emp1 = new Employee();
//            emp1.setName("naved");
//            emp1.setDepartment(dep);


//            Employee emp2 = new Employee();
//            emp2.setName("Al-fiya");
//            emp2.setDepartment(dep);

            Employee emp3 = new Employee();
            emp3.setName("Atif");
            emp3.setDepartment(department);


            department.getEmployees().add(emp3);

            //4. added employee to department
//            dep.getEmployees().add(emp1);
//            dep.getEmployees().add(emp2);


            session.persist(department);

            tx.commit();


            System.out.println("saved department and employee successfully");



        }
        finally {
            session.close();
            sessionfactory.close();

        }



    }
}
