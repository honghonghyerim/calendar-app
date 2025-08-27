package org.example.calendarapp.explanation;

import java.util.Arrays;

public class Foreach {


    public static void main(String[] args) {

        //for each
        //조건문에 자료형과 변수명
        //반복하고자하는 배열
        //단순출력

        String[] arrayOfStrings = {"홍", "김", "박", "이", "장"};
        for(String name : arrayOfStrings) {
            System.out.println(name);
        }

        //stream API 사용
        //원본데이터 변경안된
        //일회용임
        //생성 가공 결과의 구숭요로로 만들어져 있음
        String[] arrayOfStrings2 = {"홍ㅇ", "김ㅇ", "박ㅇ", "이ㅇ", "장ㅇ"};
        Arrays.stream(arrayOfStrings2)
                .forEach(System.out::println);


        //ABC 에서 B는 제거하고 긱 element 에 Hi 를 붙여서 출력해라
        String[] arrayOfString = {"A", "B", "C"};
        Arrays.stream(arrayOfString)
                .filter(name -> !name.equals("B"))
                .map(name -> "Hi, "+ name)
                .forEach(System.out::println);




    }
}
