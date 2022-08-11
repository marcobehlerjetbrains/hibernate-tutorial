package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test for simple App.
 */
public class HibernateFullTest {

    private SessionFactory sessionFactory;

    @BeforeEach
    protected void setUp() throws Exception {
	   // A SessionFactory is set up once for an application!
	   final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			 .configure() // configures settings from hibernate.cfg.xml
			 .build();
	   try {
		  sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	   }
	   catch (Exception e) {
		  // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
		  // so destroy it manually.
		  StandardServiceRegistryBuilder.destroy( registry );
	   }
    }

    @AfterEach
    protected void tearDown() throws Exception {
	   if ( sessionFactory != null ) {
		  sessionFactory.close();
	   }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testBasicUsage() {
	   // create a couple of events...
	   Session session = sessionFactory.openSession();
	   session.beginTransaction();
	   session.remove(new User("Marco's Friend", LocalDate.now()));
	   session.getTransaction().commit();
	   session.close();

	   session = sessionFactory.openSession();
	   session.beginTransaction();
	   List<User> result = session.createQuery( "select u from User u" , User.class).list();
	   for ( User user : result) {
		  System.out.println( "User (" + user.getName() + ") : " + user.getBirthDate() );
	   }
	   session.getTransaction().commit();
	   session.close();
    }

    @Test
    public void marco_is_in_the_house() {
	   assertThat(1).isGreaterThanOrEqualTo(0);
    }
}
