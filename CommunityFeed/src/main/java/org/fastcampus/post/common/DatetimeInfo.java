package org.fastcampus.post.common;

import java.time.LocalDate;

public class DatetimeInfo {

    private boolean isEdited;
    private LocalDate dateTime;

    public DatetimeInfo() {
        this.isEdited = false;
        this.dateTime = LocalDate.now();
    }

    public boolean isEdited() {
        return isEdited;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void updateEditDatetime() {
        this.isEdited = true;
        this.dateTime = LocalDate.now();
    }
}
