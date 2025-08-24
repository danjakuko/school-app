package org.example.services;

import org.example.daos.CourseDao;
import org.example.daos.StudentDao;
import org.example.entities.Course;
import org.example.entities.Student;

public class StudentService {
private final StudentDao studentDao;
private final CourseDao courseDao;
public StudentService(StudentDao studentDao, CourseDao courseDao) {
    this.studentDao = studentDao;
    this.courseDao = courseDao;
}

public Student createStudent (Student student, Long courseId) {
    Course course = courseDao.findById(courseId);
    student.setCourse(course);
    return studentDao.save(student);
}

public Student updateStudent (Student student, Long courseId) {
    Student existingStudent = studentDao.findById(student.getId());
    existingStudent.setFirstName(student.getFirstName());
    existingStudent.setLastName(student.getLastName());
    existingStudent.setBirthDate(student.getBirthDate());
    existingStudent.setCourse(courseDao.findById(courseId));
    return studentDao.save(existingStudent);
}


}
