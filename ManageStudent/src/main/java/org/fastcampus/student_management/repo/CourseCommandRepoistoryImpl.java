package org.fastcampus.student_management.repo;

import java.util.HashMap;
import java.util.Map;
import org.fastcampus.student_management.application.course.Interface.CourseCommandRepository;
import org.fastcampus.student_management.domain.Course;

public class CourseCommandRepoistoryImpl implements CourseCommandRepository {

    private final Map<String, Course> courseMap = new HashMap<>();

    @Override
    public void save(Course course) {
        courseMap.put(course.getCourseName(), course);
    }

//    private final Map<String, Course> courseMap = new HashMap<>();

//    public void save(Course course) {
//        courseMap.put(course.getCourseName(), course);
//    }

//    public List<Course> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
//        List<Course> courses = new ArrayList<>();
//        for (Course course : courseMap.values()) {
//            if (course.isSameDay(dayOfWeek) && course.isActivateUser()) {
//                courses.add(course);
//            }
//        }
//        return courses;
//    }
//
//    public List<Course> getCourseListByStudent(String studentName) {
//        List<Course> courses = new ArrayList<>();
//        for (Course course : courseMap.values()) {
//            if (course.getStudentName().equals(studentName)) {
//                courses.add(course);
//            }
//        }
//        return courses;
//    }
//
//    public void saveCourses(List<Course> courses) {
//        for (Course course : courses) {
//            courseMap.put(course.getCourseName(), course);
//        }
//    }
}
