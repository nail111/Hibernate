package Step2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).
                buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            // ALTER TABLE *Name of table* AUTO_INCREMENT=1; SQL
            // Truncate *Name of table*; SQL - delete all elements of table and reset the auto increment to 1
            Student student1 = new Student("Mirana","Dota","Mirana@main.ru");
            Student student2 = new Student("John","Bilingual","John@main.ru");
            Student student3 = new Student("Mike","Vazovski","Mike@main.ru");
            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
