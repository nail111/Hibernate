package Step7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate2.cfg.xml").
                addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            // save

            Instructor instructor = new Instructor("Marci","Helper","Marci@mail.ru");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/marci","Helper");

            instructor.setInstructorDetail(instructorDetail);


            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

            // delete
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Instructor instructor2 = session.get(Instructor.class,1);
            session.delete(instructor2);
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
