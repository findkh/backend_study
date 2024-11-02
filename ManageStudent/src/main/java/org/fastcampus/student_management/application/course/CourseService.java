package org.fastcampus.student_management.application.course;

import java.util.List;
import java.util.stream.Collectors;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.domain.Course;
import org.fastcampus.student_management.domain.DayOfWeek;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.CourseRepository;

public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;

    public CourseService(CourseRepository courseRepository, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    public void registerCourse(CourseInfoDto courseInfoDto) {
        Student student = studentService.getStudent(courseInfoDto.getStudentName());
        Course course = new Course(student, courseInfoDto.getCourseName(), courseInfoDto.getFee(),
                courseInfoDto.getDayOfWeek(), courseInfoDto.getCourseTime());
        courseRepository.save(course);
    }

    public List<CourseInfoDto> getCourseDayOfWeek(DayOfWeek dayOfWeek) {
        // TODO: 과제 구현 부분
        return courseRepository.getCourseDayOfWeek(dayOfWeek).stream()
                .filter(Course::isActivateUser) // 학생이 활성 상태인 경우에만 필터링
                .map(course -> new CourseInfoDto(
                        course.getCourseName(),
                        course.getFee(),
                        course.getDayOfWeek().name(), // dayOfWeek를 String으로 변환
                        course.getStudentName(),
                        course.getCourseTime()
                ))
                .collect(Collectors.toList());
    }

    public void changeFee(String studentName, int fee) {
        // TODO: 과제 구현 부분
        List<Course> courses = courseRepository.getCourseListByStudent(studentName);

        // 각 수업의 수강료를 변경하고 저장합니다.
        courses.stream()
                .map(course -> course.withUpdatedFee(fee)) // 수업의 수강료를 변경한 새로운 Course 객체 생성
                .forEach(courseRepository::save); // 변경된 수업 저장
    }
}
