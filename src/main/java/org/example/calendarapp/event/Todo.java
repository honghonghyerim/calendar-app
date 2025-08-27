package org.example.calendarapp.event;

import org.example.calendarapp.event.update.AbstractAuditableEvent;

import java.time.ZonedDateTime;

public class Todo extends AbstractEvent {

    private String description;

    public Todo(int id, String title,
                ZonedDateTime startAt, ZonedDateTime endAt,
                String description) {

        super(id, title, startAt,endAt);

        this.description = description;
    }

    @Override
    public void print() { //출력하는메서드 이걸 호출하면 아래 출력물이나옴
        System.out.printf("[할 일] %s : %s%n",getTitle() ,description);
    }

    @Override
    public boolean support(EventType type) {
        return type == EventType.TO_DO;
    }

    @Override
    protected void update(AbstractAuditableEvent update) {

    }
}
