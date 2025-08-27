package org.example.calendarapp.event;

import org.example.calendarapp.event.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

public class OutOfOffice extends AbstractEvent {

    public OutOfOffice(int id, String title,
                ZonedDateTime startAt, ZonedDateTime endAt) {

        super(id, title, startAt,endAt);

    }

    @Override
    protected void update(AbstractAuditableEvent update) {

    }

    @Override
    public void print() { //출력하는메서드 이걸 호출하면 아래 출력물이나옴

    }

    @Override
    public boolean support(EventType type) {
        return type == EventType.OUT_OF_OFFICE;
    }
}
