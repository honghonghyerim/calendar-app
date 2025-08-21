package org.example.calendarapp.event;

import java.time.ZonedDateTime;

public class NoDisturbance extends AbstractEvent {

    public NoDisturbance(int id, String title,
                       ZonedDateTime startAt, ZonedDateTime endAt) {

        super(id, title, startAt,endAt);

    }

    @Override
    public void print() { //출력하는메서드 이걸 호출하면 아래 출력물이나옴

    }
}
