package org.example.services;

import org.example.daos.AssignmentDao;
import org.example.daos.CourseDao;
import org.example.daos.GenericDao;
import org.example.entities.Assignment;
import org.example.entities.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class AssignmentService {
    private final CourseDao courseDao;
    private final AssignmentDao assignmentDao;


    public AssignmentService(Session session) {
        this.courseDao = new CourseDao(session);
        this.assignmentDao = new AssignmentDao(session);
    }


    public Assignment createAssignment(String description, LocalDate dueDate, Long courseId) {
        Course course = courseDao.findById(courseId);

        Assignment assignment = new Assignment();
        assignment.setDescription(description);
        assignment.setDueDate(dueDate);
        assignment.setCourse(course);

        assignmentDao.save(assignment);
        return assignment;
    }

    public Assignment updateAssignment(Long assignmentId, String newDescription, LocalDate newDueDate) {
        Assignment assignment = assignmentDao.findById(assignmentId);
        if (assignment == null) {
            throw new RuntimeException("Assignment not found with ID: " + assignmentId);
        }
        if (newDescription != null) {
            assignment.setDescription(newDescription);
        }
        if (newDueDate != null) {
            assignment.setDueDate(newDueDate);
        }
        assignmentDao.save(assignment);
        return assignment;
    }




}
