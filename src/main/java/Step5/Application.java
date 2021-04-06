package Step5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            // 1
            session.beginTransaction();
            Student student = session.get(Student.class,1);
            student.setLastname("Dota2");
            session.getTransaction().commit();

            // 2
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='Dota2@gmail.com' where id='1'").executeUpdate();
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
