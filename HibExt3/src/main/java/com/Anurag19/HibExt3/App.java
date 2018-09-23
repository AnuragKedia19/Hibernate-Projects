package com.Anurag19.HibExt3;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Anurag19.HibExt3.Alien;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Alien a = new Alien();
    	Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Query q1 = session.createQuery("from Alien where aid = 102");
        q1.setCacheable(true);
        a=(Alien)q1.uniqueResult();
        //a = (Alien)session.get(Alien.class, 102);
        System.out.println(a);
        tx.commit();
        session.close();
        
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        Query q2 = session1.createQuery("from Alien where aid = 102");
        q2.setCacheable(true);
        a=(Alien)q2.uniqueResult();
        //a = (Alien)session1.get(Alien.class, 102);
        System.out.println(a);
        tx1.commit();
        session1.close();
        
        sf.close();
    }
}
