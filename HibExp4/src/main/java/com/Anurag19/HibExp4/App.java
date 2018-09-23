package com.Anurag19.HibExp4;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.Anurag19.HibExp4.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	//ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory();
        
        Session session = sf.openSession();
        		
        Transaction tx = session.beginTransaction();
        
       /* Random r = new Random();
        
        for(int i=0;i<50;i++){
        	Student s = new Student();
        	s.setRoll(i);
        	s.setName("Name" + i);
        	s.setMarks(r.nextInt(100));
        	session.save(s);
        }*/
        
       // Query q1 = session.createQuery("select roll,name,marks from Student where roll = 7");
       // Object[] s = (Object[])q1.uniqueResult();
        //List<Student> li = q1.list();
        
		/*for(Object s1: s){
			
        	System.out.println(s1);
        }*/
        //Native Queries....
        SQLQuery q = session.createSQLQuery("select * from Student");
        //q.addEntity(Student.class);
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List<Student> stud = (List)q.list();
        for(Object o:stud){
        	Map m = (Map)o;
        	System.out.println(m.get("name")+":"+m.get("marks"));
        }
        
        tx.commit();
        
        //System.out.println(a);
        
        sf.close();
    }
}
