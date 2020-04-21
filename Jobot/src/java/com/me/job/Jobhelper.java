/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.job;

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
import com.me.job.Job;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author qiank
 */
public class Jobhelper {
    //return number fo movie added
    private static SessionFactory factory; 
    
    public Jobhelper() {
        //获取加载配置管理类
        Configuration configuration = new Configuration();

        //不给参数就默认加载hibernate.cfg.xml文件，
        configuration.configure();
        //创建Session工厂对象
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        StandardServiceRegistryImpl registry = (StandardServiceRegistryImpl) builder.build();
        factory = configuration.buildSessionFactory(registry);
    }
    
    public void addJob(int id, String username,String title, String url){
            Job jb = new Job();
            jb.setName(username);
            jb.setId(id);
            jb.setTitle(title);
            jb.setUrl(url);
            
            Session session = factory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            session.save(jb);
            transaction.commit();

            session.close();
    }
    
     public List<Job> getJobs(String restrict, String key) {
            Session session = factory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();
            Criteria criteria = session.createCriteria(Job.class);
            
            criteria.add(Restrictions.eq(restrict,key));
            List list = criteria.list();

            transaction.commit();

            session.close();
        return list;
}

}
