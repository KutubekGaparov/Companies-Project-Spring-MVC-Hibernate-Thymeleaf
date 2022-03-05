package peaksoft.dao;

import peaksoft.model.Company;
import peaksoft.model.Course;

import java.util.List;

public interface CourseDao {

    Course saveCourse(Course course);

    void removeCourseById(Long id);

    Course getById(Long id);

    List<Course> getAllCourse();

    void updateCourse(Long id, Course course);

}
