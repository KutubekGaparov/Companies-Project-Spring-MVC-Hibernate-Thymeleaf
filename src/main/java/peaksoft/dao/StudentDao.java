package peaksoft.dao;

import peaksoft.model.Student;
import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student);

    void removeStudentById(long id);

    Student getById(long id);

    List<Student> getAllStudent();

    void cleanStudentTable();

    void updateStudent(Student student);
}
