package org.example.calendarapp.event;

import org.example.calendarapp.exception.InvalidEventException;

import java.time.Duration;
import java.time.ZonedDateTime;

//클래스
public abstract class AbstractEvent implements Event {

    //멤버변수
    private final int id;
    private String title;

    private ZonedDateTime startAt;
    private ZonedDateTime endAt;
    private Duration duration;

    private final ZonedDateTime createdAt; //생성된 날짜
    private ZonedDateTime modifiedAt; // 수정된 날짜

    private boolean deletedYn;

    //메서드                //매개변수
    protected AbstractEvent(int id, String title,
                            ZonedDateTime startAt, ZonedDateTime endAt) {

        //validation
        // 만약누군가가 AbstractEvent 값에 시작시간과 종료시간을 잘못입력했을때, 뜨는 메시지
        if (startAt.isAfter(endAt)) {
            throw new InvalidEventException(
                    String.format("시작일은 종료일보다 이전이어야 합니다. 시작일=%s, 종료일=%s",startAt,endAt ));
        }

        //멤버변수 = 매개변수
        this.id = id; //“매개변수 id 값을 **멤버 변수 id**에 넣겠다” 라는 뜻이에요.
        this.title = title;
        this.startAt = startAt;
        this.endAt = endAt;

        //멤버변수      //자바기본제공 Duration 클래스 안에 between 메서드 (매개변수)
        this.duration = Duration.between(startAt, endAt);

        // ZonedDateTime 메서드 선언 ZonedDateTime 이클래스안에 now 메서드사용
        ZonedDateTime now = ZonedDateTime.now();
        this.createdAt = now; //  “객체의 멤버 변수 createdAt에 지금 시각을 넣겠다”
        this.modifiedAt = now;

        this.deletedYn = false; //초기상태는 삭제하지않았기때문에

    }

    public String getTitle() {
        return this.title;
    }


    public ZonedDateTime getStartAt() {
        return startAt;
    }

    public ZonedDateTime getEndAt() {
        return endAt;
    }
}
