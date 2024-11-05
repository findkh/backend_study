package org.fastcampus.student_management.domain;

import java.util.List;

public class CourseList {

    private final List<Course> courses;

    public CourseList(List<Course> course) {
        this.courses = course;
    }

    public void changeAllCourseFee(int fee) {
        for (Course course : courses) {
            System.out.println(course.isSameDay(DayOfWeek.SATURDAY));
            if (course.isSameDay(DayOfWeek.SATURDAY) || course.isSameDay(DayOfWeek.SUNDAY)) {
                System.out.println((fee * 1.5));
                course.changeFee((int) (fee * 1.5));
            } else {
                course.changeFee(fee);
            }
        }
    }
}
