package DAL;

import hibernate.entities.Category;
import hibernate.utils.HibernateUtils;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CategoryDAL {
    
    static final SessionFactory factory = HibernateUtils.getSessionFactory();
    
    public List findAll() {
        Session session = factory.openSession();
        List listCategory = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM loai";
            listCategory = session.createQuery(hql).list();
            
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listCategory;
    }
    
    public int insertCategory(Category category) {
        Session session = factory.openSession();
        int result = 1;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(category);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
        return result;
    }
    
    public int updateCategory(Category category) {
        Session session = factory.openSession();
        int result = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
//            String hql = "UPDATE loai SET  name = :name "  +
//                    "WHERE id = :id";
//            Query query = session.createQuery(hql);
//            query.setParameter("name", category.getName());
//            query.setParameter("id", category.getId());
//            result = query.executeUpdate();
            
            session.update(category);
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
    
    public int deleteCategory(int id) {
        Session session = factory.openSession();
        int result = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "DELETE FROM loai WHERE id= :id";
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
    
    public long getCount(){
        Session session = factory.openSession();
        long amount = 0;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("select count(*) from loai");
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
    
    public static void main(String[] args) {
//        new CategoryDAL().findAll().forEach(s->System.out.println(s));

        CategoryDAL dal = new CategoryDAL();
        System.out.println("Count: "+String.valueOf(dal.getCount()));
    }
}
