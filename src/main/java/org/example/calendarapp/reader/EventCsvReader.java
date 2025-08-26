package org.example.calendarapp.reader;

import org.example.calendarapp.event.Meeting;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import com.opencsv.CSVReader;

public class EventCsvReader {

   //csv 경로가 제공됐을때 그 파일을 자바객체로 바꿔서 반환하는 메소드

    public List<Meeting> readMeetings(String path)throws IOException {
        List<Meeting> result = new ArrayList<>();

        // 데이터를 읽는부분
        List<String[]> read = readAll(path);

        for (int i=0; i<read.size(); i++) {
            if (skipHeader(i)) {
                continue;
            }
            String[] each = read.get(i);


            // 미팅으로 변환 부분
            result.add(
                    new Meeting(
                            Integer.parseInt(each[0]),
                            each[2],
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[6], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            ),
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[7], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            ),
                            new HashSet<>(Arrays.asList(each[3].split(","))),
                            each[4],
                            each[5]
                    )
            );
        };

        return result;

    }
    //헤더부분 스킵 메소드
    private boolean skipHeader (int i) {
        return i == 0;
    }

    private List<String[]> readAll(String path)throws IOException {
        InputStream in = getClass().getResourceAsStream(path);
        InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);

        CSVReader csvReader = new CSVReader(reader);
        return csvReader.readAll();
    }

}
