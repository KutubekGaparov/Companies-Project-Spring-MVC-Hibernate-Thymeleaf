package peaksoft.dao;

import peaksoft.model.Company;
import peaksoft.model.Course;

import java.util.List;

public interface CourseDao {

    Course saveCourse(Course course);

    void removeCourseById(long id);

    Course getById(long id);

    List<Course> getAllCourse();

    void cleanCourseTable();

    void updateCourse(Course course);

}
