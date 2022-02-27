package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public void removeStudentById(long id) {
        entityManager.remove(id);
    }

    @Override
    public Student getById(long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> getAllStudent() {
        return entityManager.createQuery("select s from Student s",Student.class).getResultList();
    }

    @Override
    public void cleanStudentTable() {
        entityManager.clear();
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }
}
