/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.user;

/**
 *
 * @author qiank
 */
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qiank
 */
public class UserDao {
    //return number fo movie added
    private static SessionFactory factory; 
    
    public UserDao() {
        //获取加载配置管理类
        Configuration configuration = new Configuration();

        //不给参数就默认加载hibernate.cfg.xml文件，
        configuration.configure();
        //创建Session工厂对象
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        StandardServiceRegistryImpl registry = (StandardServiceRegistryImpl) builder.build();
        factory = configuration.buildSessionFactory(registry);
    }
    public int getUserId(String username, String password){
        List<Userinfo> users = getUsers(username, password);
        for(Userinfo i : users){
            if(i.getUsername().compareTo(username) == 0){
                if(i.getPassword().compareTo(password) == 0){
                    return i.getId();
                }
            }
        }
        return 0;
    }
    public boolean verifyUser(String username, String password){
        List<Userinfo> users = getUsers(username, password);
        if(username ==null&& password == null){
            return true;
        }
        for(Userinfo i : users){
            if(i.getUsername().compareTo(username) == 0){
                if(i.getPassword().compareTo(password) == 0){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void addUser(int id, String username,String password){
            Userinfo ui = new Userinfo();
            ui.setUsername(username);
            ui.setPassword(password);

            
            Session session = factory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            session.save(ui);
            transaction.commit();

            session.close();
    }
    
     public List<Userinfo> getUsers(String key, String restrict) {
            Session session = factory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Criteria criteria = session.createCriteria(Userinfo.class);

            List list = criteria.list();

            transaction.commit();

            session.close();
        return list;
}

}
