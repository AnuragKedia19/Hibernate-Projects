package com.Anurag19.HibExp;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien a = new Alien();
        //a.setAid(102);
        //a.setAname("Zedi");
        //a.setColor("Blue");
        
        
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        //ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        		
        Transaction tx = session.beginTransaction();
        
        //session.save(a);
        
        a = (Alien)session.get(Alien.class, 102);
        a = (Alien)session.get(Alien.class, 102);
        
        tx.commit();
        
        System.out.println(a);
        
        sf.close();
        
    }
}
