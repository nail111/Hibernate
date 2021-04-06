package Step4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Application {

    public static void show(List<Student> students) {
        for(Student i: students) {
            System.err.println(i);
        }
    }
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            // 1
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            show(theStudents);
            // 2
            theStudents = session.createQuery("from Student s where s.lastname='Dota'").getResultList();
            show(theStudents);
            // 3
            theStudents = session.createQuery("from Student s where s.lastname='Dota' OR s.id='2'").getResultList();
            show(theStudents);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
