package org.fastcampus.student_management.application.student;

import org.fastcampus.student_management.application.student.dto.StudentInfoDto;
import org.fastcampus.student_management.domain.Student;
import org.fastcampus.student_management.repo.StudentRepository;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentInfoDto studentInfoDto) {
        Student student = new Student(studentInfoDto.getName(), studentInfoDto.getAge(),
                studentInfoDto.getAddress());
        studentRepository.save(student);
    }

    public Student getStudent(String name) {
        return findStudentByName(name); // 공통 함수 호출
    }

    public void activateStudent(String name) {
        // TODO: 과제 구현 부분
        Student student = getStudent(name);
        if (!student.isActivate()) {
            student.setActivated(true); // 학생을 활성화 상태로 설정
            studentRepository.save(student); // 변경 사항 저장
        } else {
            throwException("이미 활성 상태입니다."); // 예외 처리 메서드 호출
        }
    }

    public void deactivateStudent(String name) {
        // TODO: 과제 구현 부분
        Student student = getStudent(name);
        if (student.isActivate()) {
            student.setActivated(false); // 학생을 비활성화 상태로 설정
            studentRepository.save(student); // 변경 사항 저장
        } else {
            throwException("이미 비활성 상태입니다."); // 예외 처리 메서드 호출
        }
    }

    private Student findStudentByName(String name) {
        return studentRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("해당하는 학생이 없습니다."));
    }

    private void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
}
