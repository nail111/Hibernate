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

            Instructor instructor = new Instructor("Johny","Bravo","Johny@mail.ru");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/kuplinov","Create a video");

            instructor.setInstructorDetail(instructorDetail);


            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        }
        finally {
            session.close();
        }
    }
}
