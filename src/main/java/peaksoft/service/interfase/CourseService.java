package peaksoft.service.interfase;

import peaksoft.model.Course;

import java.util.List;

public interface CourseService {

    Course saveCourse(Course course);

    void removeCourseById(long id);

    Course getById(long id);

    List<Course> getAllCourse();

    void updateCourse(long id, Course course);
}
