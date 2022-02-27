package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.StudentDao;
import peaksoft.model.Student;
import peaksoft.service.interfase.StudentService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    @Autowired
    public StudentServiceImpl(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Student saveStudent(Student student) {
        return dao.saveStudent(student);
    }

    @Override
    public void removeStudentById(long id) {
        dao.removeStudentById(id);
    }

    @Override
    public Student getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return dao.getAllStudent();
    }

    @Override
    public void cleanStudentTable() {
        dao.cleanStudentTable();
    }

    @Override
    public void updateStudent(Student student) {
        dao.updateStudent(student);
    }
}
