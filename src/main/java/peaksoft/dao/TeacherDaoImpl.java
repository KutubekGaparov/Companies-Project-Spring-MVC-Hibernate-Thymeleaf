package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    @Override
    public void removeTeacherById(long id) {
        entityManager.remove(id);
    }

    @Override
    public Teacher getById(long id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return entityManager.createQuery("select t from Teacher t",Teacher.class).getResultList();
    }

    @Override
    public void cleanTeacherTable() {
        entityManager.clear();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
    }
}
