package hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtils {

    public static SessionFactory getSessionFactory() {
        try{
            Configuration configuration=new Configuration();
            configuration.configure("hibernate.cfg.xml");
            return configuration.buildSessionFactory();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
