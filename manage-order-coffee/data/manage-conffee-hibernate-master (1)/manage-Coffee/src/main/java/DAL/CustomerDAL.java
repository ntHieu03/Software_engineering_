/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import hibernate.entities.Customer;
import hibernate.utils.HibernateUtils;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Trần Kim Phú
 */
public class CustomerDAL {

    static final SessionFactory factory = HibernateUtils.getSessionFactory();

    public List getAllCustomer(String orderby) {
        Session session = factory.openSession();
        List listCustomer = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Customer ORDER BY id " + orderby;
            listCustomer = session.createQuery(hql).list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listCustomer;
    }

    public Customer getCustomerById(int id) {
        Session session = factory.openSession();
        Customer customer = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Customer C WHERE C.id =" + id;
            customer = (Customer) session.createQuery(hql).uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return customer;
    }

    public int insertCustomer(Customer customer) {
        Session session = factory.openSession();
        int result = 1;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            

            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
        return result;
    }

    public int updateCustomer(Customer c) {
        Session session = factory.openSession();
        int result = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "UPDATE Customer set firstName=:firstName, lastName=:lastName, phoneNumber=:phoneNumber"
                    + " WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", c.getId());
            query.setParameter("firstName", c.getFirstName());
            query.setParameter("lastName", c.getLastName());
            query.setParameter("phoneNumber", c.getPhoneNumber());
            result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
//            session.update(query);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public int deleteCustomer(int id) {
        Session session = factory.openSession();
        int result = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "DELETE FROM Customer WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            result = query.executeUpdate();
            //  System.out.println("Rows affected: " + result);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
    
    public static void main(String[] args) {
        CustomerDAL dal = new CustomerDAL();
        List listProduct = dal.getAllCustomer("DESC");
        listProduct.forEach(s-> System.out.println(s.toString()));
        //dal.updateProdct(1);
        Customer c = new Customer();
        c.setId(6);
        c.setFirstName("Phú");
        c.setLastName("Trần");
        c.setPhoneNumber("0123456789");
        dal.updateCustomer(c);
//        dal.deleteProduct(22);
        System.out.println("Element: "+dal.getCustomerById(1));

    }
}
