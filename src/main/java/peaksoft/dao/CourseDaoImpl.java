package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Course saveCourse(Course course) {
         entityManager.persist(course);
         return course;
    }

    @Override
    public void removeCourseById(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Course getById(Long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    public List<Course> getAllCourse() {
        return entityManager.createQuery("select c from Course c",Course.class).getResultList();
    }

    @Override
    public void updateCourse(Long id, Course course) {
        Course course1= getById(id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        entityManager.merge(course);
    }
}