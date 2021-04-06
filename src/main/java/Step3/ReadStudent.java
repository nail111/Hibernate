package Step3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            // create
            session.beginTransaction();
            session.save(new Student("Anna","Lambda","Anna@mail.ru"));
            session.getTransaction().commit();

            // read
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.get(Student.class,4);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
