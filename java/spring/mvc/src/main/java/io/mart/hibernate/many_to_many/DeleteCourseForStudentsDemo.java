package io.mart.hibernate.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Aleksandr Martiushov.
 *
 * It is possible to see real values inside logs, instead of ?
 *
 * insert into student (email, first_name, last_name, id) values (?, ?, ?, ?)
 *
 * For this you have to see TRACE logs of hibernate, log4j.logger.org.hibernate=TRACE
 *  especially BasicBinder
 */
public class DeleteCourseForStudentsDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")     // actually hibernate by default will search file with such name
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int courseid = 13;

            Course course = session.get(Course.class, courseid);

            System.out.println("Deleting course " + course);
            session.delete(course);


            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
