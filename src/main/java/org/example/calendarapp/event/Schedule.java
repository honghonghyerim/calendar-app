package org.example.calendarapp.event;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    // 할일과 미팅시간이 겹쳤을때 사용하는 메소드


    private List<AbstractEvent> events = new ArrayList<>();

    public void add(AbstractEvent event) {
        if(hasScheduleConflictWith(event)) {
            return;
        }
        this.events.add(event);
    }

    public void printBy (EventType type) {
        events.stream()
                .filter(event -> event.support(type))
                .forEach(Event::print);
    }

    public void printAll () {
        events.forEach(Event::print);
    }

    //매겨변수로 새로 들어오는 이벤트의 시간과 종료시간이 기존 이벤트들과 겹치는지 확인
    private boolean hasScheduleConflictWith(AbstractEvent event) {
        return events.stream()
                .anyMatch(each ->
                        (event.getStartAt().isBefore(each.getEndAt()) && event.getStartAt().isAfter(each.getStartAt()))
                        || (event.getEndAt().isAfter(each.getStartAt())) && event.getEndAt().isBefore(each.getEndAt()));

    }


}
