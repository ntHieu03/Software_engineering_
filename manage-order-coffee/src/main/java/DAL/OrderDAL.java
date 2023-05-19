package DAL;

import BLL.CustomerBLL;
import BLL.OrderDetailBLL;
import hibernate.entities.Category;
import hibernate.entities.Customer;
import hibernate.entities.OrderDetail;
import hibernate.entities.Order;
import hibernate.entities.Product;
import hibernate.utils.HibernateUtils;

import java.util.Date;
import java.util.HashSet;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
//import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class OrderDAL {
    static final SessionFactory factory = HibernateUtils.getSessionFactory();

    public List getAllOrder(String orderby) {
        Session session = factory.openSession();
        List listOrder = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Order  ORDER BY id " + orderby;
            listOrder = session.createQuery(hql).list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOrder;
    }

    public Order getOrderById(int id) {
        Session session = factory.openSession();
        Order order = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM Order P WHERE P.id =" + id;
            order = (Order) session.createQuery(hql).uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }

    public int deleteOrder(int id) {
        Session session = factory.openSession();
        int result = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "DELETE FROM Order WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            result = query.executeUpdate();
            // System.out.println("Rows affected: " + result);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public int updateOrder(Order order){
        System.out.println("A - "+order);
        Session session = factory.openSession();
        int result = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "UPDATE Order SET customer.id = :id_KH , id_Staff = :id_NV" +
                    ", totalPrice  = :total_money, createdDate  = :create_day WHERE id = :id";

            Query query = session.createQuery(hql);

            query.setParameter("id_KH", order.getCustomer().getId());
            query.setParameter("id_NV", order.getId_Staff());
            query.setParameter("total_money", order.getTotalPrice());
            query.setParameter("create_day", order.getCreatedDate());
            query.setParameter("id", order.getId());
            System.out.println(hql);
            result = query.executeUpdate();
           System.out.println("Rows affected: " + result);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

    public int insertOrder(Order order){
        Session session = factory.openSession();
        int result = 1;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(order);
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

    public long getCount(){
        Session session = factory.openSession();
        long amount = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("select count(*) from Order");
            amount = (long)query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return amount;
    }

    public int getTotalRevenue(){
        Session session = factory.openSession();
        double total = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT sum(totalPrice) from Order");
            total = (double)query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (int)total;
    }

    public static void main(String[] args) {
//        new OrderDAL().getAllOrder("DESC").forEach(s->System.out.println(s));

//        Customer customer = new CustomerDAL().getCustomerById(2);
//        System.out.println(customer);
//        List<OrderDetail> orderDetail = new OrderDetailDAL().getAllOrderDetail(2);
//        orderDetail.forEach(System.out::println);
        OrderDAL dal = new OrderDAL();
//        Order order = new Order(1, 21112001f, new Date(), 1, customer, orderDetail);
//        dal.updateOrder(order);

        Customer customer = new CustomerBLL().getCustomerById(4);
        List<OrderDetail> listOrderDetail = new OrderDetailBLL(1).getCt_hdBLL();
        Order order = new Order(3, 200f, new Date(), 1, customer, listOrderDetail);
        dal.insertOrder(order);



    }
}