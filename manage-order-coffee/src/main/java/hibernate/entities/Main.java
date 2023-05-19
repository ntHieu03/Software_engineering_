package hibernate.entities;

import hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static final SessionFactory factory = HibernateUtils.getSessionFactory();
    public static void listProduct( ) {
        Session session = factory.openSession();
        List listProduct = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            listProduct = session.createQuery("FROM Product ").list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

       listProduct.forEach(s-> System.out.println(s.toString()));

    }
    public static void listCustomer( ) {
        Session session = factory.openSession();
        List listProduct = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            listProduct = session.createQuery("FROM Customer ").list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        listProduct.forEach(s-> System.out.println(s.toString()));

    }
    public static void listOrder( ) {
        Session session = factory.openSession();
        List listProduct = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            listProduct = session.createQuery("FROM Order ").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        listProduct.forEach(s-> System.out.println(s.toString()));

    }
    public static void listOrderDetail( ) {
        Session session = factory.openSession();
        List listProduct = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            listProduct = session.createQuery("FROM OrderDetail ").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        listProduct.forEach(s-> System.out.println(s.toString()));

    }
    public static void main(String[] args) {
       /* assert factory != null;
        Session session= factory.openSession();
        Transaction tx = session.beginTransaction();
        loai loai=new loai();
        loai.setId_Loai(25);
        loai.setName("trungbanbanh");
        session.save(loai);
        tx.commit();*/


        Main.listProduct();
       // Main.listCustomer();
        // Main.listOrder();



    }
}
