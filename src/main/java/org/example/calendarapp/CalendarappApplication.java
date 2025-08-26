package org.example.calendarapp;

import org.example.calendarapp.event.*;
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
        schedule.printAll();

    }
}
