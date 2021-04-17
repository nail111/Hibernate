package Step8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate2.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            Instructor instructor = new Instructor("Leo","Messi","Leo@mail.ru");
            InstructorDetail instructorDetail = new InstructorDetail("youtube/messi","player");
            instructor.setInstructorDetail(instructorDetail);
            instructorDetail.setInstructor(instructor);
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
