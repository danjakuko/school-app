package org.example.services;

import org.example.daos.CourseDao;
import org.example.daos.TeacherDao;
import org.example.entities.Course;

public class CourseService {
    private final CourseDao courseDao;
    private final TeacherDao teacherDao;
    public CourseService(TeacherDao teacherDao, CourseDao courseDao) {
        this.courseDao = courseDao;
        this.teacherDao = teacherDao;
    }

    public Course createCourse (Long teacherId, String name) {
        Course course = new Course();
        course.setName(name);
        course.setTeacher(teacherDao.findById(teacherId));
        return courseDao.save(course);
    }


}
