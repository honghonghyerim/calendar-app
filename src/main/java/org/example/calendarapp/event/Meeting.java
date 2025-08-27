package org.example.calendarapp.event;

import org.example.calendarapp.event.update.AbstractAuditableEvent;
import org.example.calendarapp.event.update.UpdateMeeting;

import java.time.ZonedDateTime;
import java.util.Set;

public class Meeting extends AbstractEvent { //AbstractEvent 상속받는 클래스
    
    //멤버변수

    /* Set<String>
    컬렉션(자료구조) 중 하나
    중복 없는 데이터 집합을 나타냄
    <String> → 문자열만 담겠다는 제네릭(Generic) 표기 */
    private Set<String> participants; //미팅 참석자
    private String meetingRoom;
    private String agenda;


    //메서드       //매개변수
    public Meeting(int id, String title,
                   ZonedDateTime startAt, ZonedDateTime endAt,
                   Set<String> participants, String meetingRoom, String agenda) {
      super(id, title, startAt,endAt);
    
      //생성자 선언      //Meeting 메서드의 매개변수 
      this.participants = participants; //participants 매개변수의값을 participants 생성자에 넣는다 
      this.meetingRoom = meetingRoom;
      this.agenda = agenda;


    }

    @Override
    public void print() { //출력하는메서드 이걸 호출하면 아래 출력물이나옴
        System.out.printf("[회의] %s : %s%n", getTitle(),agenda);
    }

    @Override
    public boolean support(EventType type) { //매개변수의 타입이
        return type == EventType.MEETING; // 이벤트타입이 미팅이면 true 아니면 false
    }

    @Override
    protected void update(AbstractAuditableEvent update) {
        UpdateMeeting meetingUpdate = (UpdateMeeting) update;

        this.participants = meetingUpdate.getParticipants();
        this.meetingRoom = meetingUpdate.getMeetingRoom();
        this.agenda = meetingUpdate.getAgenda();
    }
}
