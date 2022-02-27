package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Course saveCourse(Course course) {
         entityManager.persist(course);
         return course;
    }

    @Override
    public void removeCourseById(long id) {
        entityManager.remove(id);
    }

    @Override
    public Course getById(long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    public List<Course> getAllCourse() {
        return entityManager.createQuery("select c from Course c",Course.class).getResultList();
    }

    @Override
    public void cleanCourseTable() {
        entityManager.clear();
    }

    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }
}
