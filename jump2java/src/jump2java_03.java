import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;

import java.util.HashSet;

import java.util.List;

public class jump2java_03 {
    public static void main(String[] args) {
        // jump2java_030(args);
        jump2java_0301(args);
        jump2java_0304(args);
        jump2java_0305(args);
        jump2java_0307(args);
        jump2java_0308(args);
        jump2java_0309(args);
        jump2java_0310(args);
        jump2java_0311(args);
    }

    // 03-01 숫자
    public static void jump2java_0301(String[] args) {
        // 정수: int(8진수, 16진수도 사용o), long (범위 밖 접미사 L)
        // 실수: double(기본값), float(접미사 F), 123.4 = 1.234e2

        // i++ : 값을 참조한 후에 증가
        // ++i : 값을 참조하기 전에 증가
        int a = 10;
        int b = 5;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
    }

    // 03-02 불
    //
    // 03-03 문자
    // char를 이용, 표현 방식(문자, 아스키코드, 유니코드) 다양하므로 주의

    // 03-04 문자열
    public static void jump2java_0304(String[] args) {
        // equals
        String a = "hello";
        String b = "java";
        String c = "hello";
        System.out.println(a.equals(b));  // false 출력
        System.out.println(a.equals(c));  // true 출력

        // indexOf
        String d = "Hello Java";
        System.out.println(d.indexOf("Java")); // 6출력, 0부터 시작

        // contains
        String e = "Hello Java";
        System.out.println(e.contains("Java"));  // true 출력

        // charAt
        String f = "Hello Java";
        System.out.println(f.charAt(6));  // "J" 출력

        // replaceALL
        String g = "Hello Java";
        System.out.println(g.replaceAll("Java", "World"));  // Hello World 출력

        // substring
        String h = "Hello Java";
        System.out.println(h.substring(0, 4));  // Hell 출력, 시작위치 <= a < 끝위치

        // toUpperCase, toLowerCase
        String i = "Hello Java";
        System.out.println(i.toUpperCase());  // HELLO JAVA 출력

        // split
        String j = "a:b:c:d";
        String[] result = j.split(":");  // result는 {"a", "b", "c", "d"}
        for (String res : result) {
            System.out.println(res); // 각 문자 출력
        }

        // 문자열 포맷팅
        // %d: 숫자, %s: 문자열
        // %s: 어떤 형태의 값이든 변환해 넣을 수 있음(문자열로 바꾸어 사용하기 때문)
        int number = 10;
        String day = "three";
        System.out.println(String.format("I ate %d apples. so I was sick for %s days.", number, day));

        // %10s: 전체 길이가 10인 문자열 공간에서 대입되는 값(hi)을 가장 오른쪽으로 정렬하고 나머지는 공백으로 남겨 두라는 의미
        // 왼쪽 정렬은 %-10s
        System.out.println(String.format("%-10sjane.", "hi"));  // "hi        jane." 출력

        // 소수점 표현
        System.out.println(String.format("%10.4f", 3.42134234));  // '    3.4213' 출력
    }

    // 03-05 StringBuffer
    public static void jump2java_0305(String[] args) {
        // 문자열을 추가하거나 변경할 때 주로 사용
        // string 자료형을 사용해도 결과는 같지만, string 자료형에서는 매번 새로운 객체 생성

        // append
        StringBuffer sb = new StringBuffer();  // StringBuffer 객체 sb 생성
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        String result = sb.toString();
        System.out.println(result);  // "hello jump to java" 출력

        // 이뮤터블(immutable) vs 뮤터블(mutable)
        //  StringBuffer 자료형은 String 자료형보다 무거움

        // insert
        sb.insert(0, "hello ");
        System.out.println(sb.toString());  // "hello hello jump to java" 출력
    }

    // 03-06 배열 (크기 정해져 있음!!!)
    // int[] odds = {1, 3, 5, 7, 9};
    // String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};
    // 배열이란 자료형의 종류x, 자료형의 집합o

    // 배열의 길이 설정 (없으면 컴파일 오류 발생
    // String[] weeks = new String[7];

    // 배열의 길이: length 사용

    // 03-07 리스트
    // 자료형의 개수가 계속 변하는 상황이라면 리스트를 사용
    public static void jump2java_0307(String[] args) {
        // add
        ArrayList pitches = new ArrayList();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        // get
        System.out.println(pitches.get(1)); // "129" 출력

        // size
        System.out.println(pitches.size());

        // contains
        System.out.println(pitches.contains("142")); // true

        // remove
        System.out.println(pitches.remove("129"));  // 129를 리스트에서 삭제하고, true를 리턴한다.
        System.out.println(pitches.remove(0));  // pitches의 첫 번째 항목이 138이므로, 138을 삭제한 뒤 138을 리턴한다.

        // 제네릭스
        // 자료형을 강제로 바꿀 때 생기는 캐스팅 오류 줄일 수 있음
        // ex. ArrayList<String> pitches = new ArrayList<>();

        // String.join
        ArrayList<String> pitches2 = new ArrayList<>(Arrays.asList("138", "129", "142"));
        String result = String.join(",", pitches2);
        System.out.println(result);  // 138,129,142 출력

        // 리스트 정렬하기
        // import java.util.Comparator;
        // 오름차순(순방향) 정렬 - Comparator.naturalOrder()
        // 내림차순(역방향) 정렬 - Comparator.reverseOrder()
    }

    // 03-08 맵 (associative array, hash)
    // 키(key)와 값(value)을 한 쌍으로 갖는 자료형
    public static void jump2java_0308(String[] args) {
        // put
        HashMap<String, String> map = new HashMap<>();
        map.put("people", "사람");
        map.put("baseball", "야구");

        // get
        System.out.println(map.get("people")); // "사람" 출력
        // value 없으면 null 리턴, getOrDefault 메서드를 사용하면 default
        // System.out.println(map.getOrDefault("java", "자바"));

        // containsKey
        System.out.println(map.containsKey("people"));

        // remove
        System.out.println(map.remove("people"));

        // size
        System.out.println(map.size());

        // keySet
        System.out.println(map.keySet()); // [baseball] 출력
    }

    // 03-09 집합
    // 중복 허용x, 순서x
    public static void jump2java_0309(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
        System.out.println(set);  //  [e, H, l, o] 출력

        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        // 교집합
        HashSet<Integer> intersection = new HashSet<>(s1);  // s1으로 intersection 생성
        intersection.retainAll(s2);  // 교집합 수행
        System.out.println(intersection);  // [4, 5, 6] 출력
        // 합집합
        HashSet<Integer> union = new HashSet<>(s1);  // s1으로 union 생성
        union.addAll(s2); // 합집합 수행
        System.out.println(union);  // [1, 2, 3, 4, 5, 6, 7, 8, 9] 출력
        // 차집합
        HashSet<Integer> substract = new HashSet<>(s1);  // s1으로 substract 생성
        substract.removeAll(s2); // 차집합 수행
        System.out.println(substract);  // [1, 2, 3] 출력

        // 집합 자료형 관련 메서드
        // add, addALL(여러 개 추가), remove
    }

    // 03-10 상수 집합
    // 서로 연관 있는 여러 개의 상수 집합을 정의할 때 사용
    public static void jump2java_0310(String[] args) {
        enum CoffeeType {
            AMERICANO,
            ICE_AMERICANO,
            CAFE_LATTE
        };

        System.out.println(CoffeeType.AMERICANO);
        System.out.println(CoffeeType.ICE_AMERICANO);
        System.out.println(CoffeeType.CAFE_LATTE);

    }

    // 03-11 형 변환과 final
    public static void jump2java_0311(String[] args) {
        // 문자열을 정수로 변환
        String num = "123";
        int n = Integer.parseInt(num);  // 문자열을 정수로 바꿔주기
        System.out.println(n);  // 123 출력

        // 정수를 문자열로 변환하는 방법
        // 방법 1: 정수 앞에 빈 문자열 "" 더하기
        int n1 = 123;
        String num1 = "" + n1;
        System.out.println(num1);

        // 방법 2: 메서드를 사용하여 변환
        String num2 = String.valueOf(n1);
        String num3 = Integer.toString(n1);
        System.out.println(num2);
        System.out.println(num3);

        // 소수점이 포함된 문자열을 실수로 변환
        String decimalStr = "123.456";
        String floatStr = "1.234F";
        double d = Double.parseDouble(decimalStr);  // 문자열을 실수(double)로 변환
        float f = Float.parseFloat(floatStr);  // 문자열을 실수(float)로 변환
        System.out.println(d);  // 123.456 출력
        System.out.println(f);  // 1.234 출력

        // 정수와 실수 간의 형 변환
        int intValue = 123;
        double doubleValue = intValue;  // 정수 -> 실수
        System.out.println(doubleValue);  // 123.0 출력

        double doubleValue2 = 123.456;
        int intValue2 = (int) doubleValue2;  // 실수 -> 정수 (소수점 이하 버림)
        System.out.println(intValue2);  // 123 출력

        // 실수형 문자열을 정수로 변환하려고 할 경우
        // 오류를 방지하려면 실수로 먼저 변환 후 정수로 변환
        try {
            String decimalStr2 = "123.456";
            int errorExample = Integer.parseInt(decimalStr2);  // 오류 발생
        } catch (NumberFormatException e) {
            System.out.println("형변환 오류 발생: 실수형 문자열을 바로 정수로 변환할 수 없습니다.");
        }

        // final
        // 한번 값을 설정하면 변경 불가능

        final int finalInt = 123;  // final로 선언된 변수는 값을 변경할 수 없음
        // finalInt = 456;  // 오류 발생: final 변수는 변경할 수 없음

        // ArrayList도 final로 선언하면 참조 변경 불가능
        final ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b"));
        // list = new ArrayList<>(Arrays.asList("c", "d"));  // 오류 발생: final 참조는 변경 불가능

        // 하지만 요소 추가 및 삭제는 가능
        list.add("c");
        System.out.println(list);  // [a, b, c] 출력

        // 리스트의 변경까지 막고 싶다면 List.of()를 사용
        final List<String> unmodifiableList = List.of("a", "b");
        // unmodifiableList.add("c");  // UnsupportedOperationException 오류 발생
    }
}