package peaksoft.service.interfase;

import peaksoft.model.Course;
import peaksoft.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    void removeStudentById(Long id);

    Student getById(long id);

    List<Student> getAllStudent();

    void updateStudent(long id,Student student);
}
