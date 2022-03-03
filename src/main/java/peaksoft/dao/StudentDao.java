package peaksoft.dao;

import peaksoft.model.Student;
import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student);

    void removeStudentById(Long id);

    Student getById(long id);

    List<Student> getAllStudent();

    void updateStudent(long id,Student student);

}
