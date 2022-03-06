package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.CourseDao;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.service.interfase.CourseService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseDao.saveCourse(course);
    }

    @Override
    public void removeCourseById(Long id) {
        courseDao.removeCourseById(id);
    }

    @Override
    public Course getById(Long id) {
        return courseDao.getById(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public void updateCourse(Long id, Course course) {
        courseDao.updateCourse(id,course);
    }
}
