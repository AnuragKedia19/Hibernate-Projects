package com.Anurag19.HibExp2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Anurag19.HibExp2.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Student st = new Student();
    	Laptop lp = new Laptop();
    	st.setRoll(1);
        st.setName("Anurag");
        st.setMarks(90);
        st.getLaptop().add(lp);
        lp.setLid(101);
        lp.setLname("Dell");
        lp.setStd(st);
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        		
        Transaction tx = session.beginTransaction();
        
        session.save(st);
        
        session.save(lp);
        
        
        tx.commit();
        
        //System.out.println(a);
        
        sf.close();
    }
}
