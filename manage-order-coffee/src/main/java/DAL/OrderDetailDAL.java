package DAL;

import BLL.OrderBLL;
import BLL.SanPhamBLL;
import hibernate.entities.Order;
import hibernate.entities.OrderDetail;
import hibernate.entities.Product;
import hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//import javax.persistence.Query;
import org.hibernate.query.Query;
import java.util.List;

public class OrderDetailDAL {
    static final SessionFactory factory = HibernateUtils.getSessionFactory();
    public List getAllOrderDetail(int orderID){
        Session session = factory.openSession();
        List listOrderDetail = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM OrderDetail WHERE order="+orderID;
            listOrderDetail = session.createQuery(hql).list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listOrderDetail;
    }
    public OrderDetailDAL getOrderDetailById(int id){
        Session session = factory.openSession();
       OrderDetailDAL orderDetailDAL = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM OrderDetail P WHERE P.id ="+ id;
            orderDetailDAL = (OrderDetailDAL) session.createQuery(hql).uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return orderDetailDAL;
    }
    public int insertOrderdetail(OrderDetail orderDetail){
        Session session = factory.openSession();
        int result = 1;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(orderDetail);
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
            Query query = session.createQuery("select count(*) from OrderDetail");
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

    public int deleteOrderDetail(int id){
        Session session = factory.openSession();
        int result = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "DELETE FROM OrderDetail WHERE order = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            result = query.executeUpdate();
            //  System.out.println("Rows affected: " + result);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static void main(String[] args) {
        OrderBLL odbll = new OrderBLL();
        Order order = odbll.getOrderById(1);

        SanPhamBLL spbll = new SanPhamBLL();
        Product product = spbll.getProductById(2);

        OrderDetailDAL dal = new OrderDetailDAL();
        OrderDetail orderDetail = new OrderDetail(3, order, product,product.getName(), 2, 1000);
//        System.out.println(orderDetail);
        dal.insertOrderdetail(orderDetail);
    }
}
