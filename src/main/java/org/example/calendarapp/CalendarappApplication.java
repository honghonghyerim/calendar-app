package org.example.calendarapp;

import ch.qos.logback.classic.spi.IThrowableProxy;
import org.example.calendarapp.event.*;
import org.example.calendarapp.event.update.UpdateMeeting;
import org.example.calendarapp.reader.EventCsvReader;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//실행파일
public class CalendarappApplication {
    public static void main(String[] args) throws IOException {

        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader();
        String meetingCsvPath = "/date/meeting.csv";


        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(schedule::add);

        Meeting meeting = meetings.get(0);
        meeting.print();

        System.out.println("수정후 ...");

        meetings.get(0).validateUpdate(
                new UpdateMeeting(
                        "new title",
                        ZonedDateTime.now().plusHours(1),
                        ZonedDateTime.now(),
                        null,
                        "A",
                        "new agenda"

                )

        );

//        meeting.delete(true);
//        System.out.println("삭제후 수정 시도 ...");
//
//        meetings.get(0).validateUpdate(
//                new UpdateMeeting(
//                        "new title2",
//                        ZonedDateTime.now().plusHours(1),
//                        ZonedDateTime.now(),
//                        null,
//                        "B",
//                        "new agenda 2"
//
//                )
//
//        );
        schedule.printAll();

    }
}
