package org.fastcampus.student_management.domain;

/*
 * VO 사용 이유: 코드를 읽기 쉬워짐, 재사용 가능
 * */

public class CourseFee {

    private int fee;

    public CourseFee(int fee) {
        this.fee = fee;
    }

    public void changeFee(int fee) {
        this.fee = fee;
    }

    private void checkFee(int fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("수강료는 0원 이상이어야합니다.");
        }
    }

    public int getFee() {
        return fee;
    }
}
