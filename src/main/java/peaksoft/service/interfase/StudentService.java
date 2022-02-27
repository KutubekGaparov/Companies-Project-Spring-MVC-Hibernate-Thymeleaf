package peaksoft.service.interfase;

import peaksoft.model.Course;
import peaksoft.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    void removeStudentById(long id);

    Student getById(long id);

    List<Student> getAllStudent();

    void cleanStudentTable();

    void updateStudent(Student student);
}
