package org.fastcampus.student_management;

import org.fastcampus.student_management.application.course.CourseService;
import org.fastcampus.student_management.application.course.dto.CourseInfoDto;
import org.fastcampus.student_management.application.student.StudentService;
import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.repo.CourseRepository;
import org.fastcampus.student_management.repo.StudentRepository;
import org.fastcampus.student_management.ui.course.CourseController;
import org.fastcampus.student_management.ui.course.CoursePresenter;
import org.fastcampus.student_management.ui.student.StudentController;
import org.fastcampus.student_management.ui.student.StudentPresenter;
import org.fastcampus.student_management.ui.UserInputType;

public class Main {

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();

        StudentService studentService = new StudentService(studentRepository);
        CourseService courseService = new CourseService(courseRepository, studentService);

        CoursePresenter coursePresenter = new CoursePresenter();
        StudentPresenter studentPresenter = new StudentPresenter();

        CourseController courseController = new CourseController(coursePresenter, courseService,
                studentPresenter);
        StudentController studentController = new StudentController(studentPresenter,
                studentService);

        // default 세팅 추가
        StudentInfoDto studentInfoDto = new StudentInfoDto("홍길동", 28, "서울시 구로구");
        StudentInfoDto studentInfoDto2 = new StudentInfoDto("박하파", 13, "서울시 구로구");
        studentService.saveStudent(studentInfoDto);
        studentService.saveStudent(studentInfoDto2);

        CourseInfoDto courseInfoDto = new CourseInfoDto("영어", 100000, "SUNDAY", "홍길동", 10L);
        CourseInfoDto courseInfoDto2 = new CourseInfoDto("수학", 150000, "SUNDAY", "박하파", 10L);
        courseService.registerCourse(courseInfoDto);
        courseService.registerCourse(courseInfoDto2);

        studentPresenter.showMenu();
        UserInputType userInputType = studentController.getUserInput();
        while (userInputType != UserInputType.EXIT) {
            switch (userInputType) {
                case NEW_STUDENT:
                    studentController.registerStudent();
                    break;
                case NEW_COURSE:
                    courseController.registerCourse();
                    break;
                case SHOW_COURSE_DAY_OF_WEEK:
                    courseController.showCourseDayOfWeek();
                    break;
                case ACTIVATE_STUDENT:
                    studentController.activateStudent();
                    break;
                case DEACTIVATE_STUDENT:
                    studentController.deactivateStudent();
                    break;
                case CHANGE_FEE:
                    courseController.changeFee();
                    break;
                default:
                    studentPresenter.showErrorMessage();
                    break;
            }
            studentPresenter.showMenu();
            userInputType = studentController.getUserInput();
        }
    }
}