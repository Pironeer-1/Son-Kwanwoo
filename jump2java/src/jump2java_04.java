import java.util.ArrayList;
import java.util.Arrays;

public class jump2java_04 {
    public static void main(String[] args) {
        jump2java_0401(args);
        jump2java_0402(args);
        jump2java_0403(args);
        jump2java_0404(args);
        jump2java_0405(args);
    }

    // 04-01 if 문
    public static void jump2java_0401(String[] args) {
        // x && y : and
        // x || y : or
        // !x : not
        int money = 2000;
        boolean hasCard = true;

        if (money >= 3000 || hasCard) {
            System.out.println("택시를 타고 가라");
        } else {
            System.out.println("걸어가라");
        }

        // contains 사용 예시
        ArrayList<String> pocket = new ArrayList<String>();
        pocket.add("paper");
        pocket.add("handphone");
        pocket.add("money");

        if (pocket.contains("money")) {
            System.out.println("택시를 타고 가라");
        } else {
            System.out.println("걸어가라");
        }

        // else if 사용 예시
        hasCard = true;
        pocket = new ArrayList<String>();  // 새로운 ArrayList로 초기화
        pocket.add("paper");
        pocket.add("handphone");

        if (pocket.contains("money")) {
            System.out.println("택시를 타고 가라");
        } else if (hasCard) {
            System.out.println("택시를 타고 가라");
        } else {
            System.out.println("걸어가라");
        }
    }

    // 04-02 switch/case 문
    public static void jump2java_0402(String[] args) {
        int month = 8;
        String monthString = "";

        // switch 문의 입력값으로 가능한 자료형: byte, short, char, int, enum, String
        switch (month) {
            case 1:  monthString = "January";
                break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid month";
                break;
        }
        System.out.println(monthString);
    }

    // 04-03 while 문
    public static void jump2java_0403(String[] args) {
        int treeHit = 0;
        while (treeHit < 10) {
            treeHit++;  // treeHit += 1 로도 표현 가능
            System.out.println("나무를 " + treeHit + "번 찍었습니다.");
            if (treeHit == 10) {
                System.out.println("나무 넘어갑니다.");
            }
        }

        // 무한루프: while(true), break, continue
        // 파이썬이랑 똑같음
    }

    // 04-04 for 문
    public static void jump2java_0404(String[] args) {
        // 기본 구조
        String[] numbers = {"one", "two", "three"};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // continue 사용 예시
        int[] marks = {90, 25, 67, 45, 80};
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 60) {
                continue;  // 조건문으로 돌아감
            }
            System.out.println((i + 1) + "번 학생 축하합니다. 합격입니다.");
        }

        // 이중 for 문
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println("");  // 줄바꿈
        }
    }

    // 04-05 for-each 문
    /*
    for (type 변수명: iterate) {
        body-of-loop
    }
     */
    public static void jump2java_0405(String[] args) {
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("one", "two", "three"));
        for (String number : numbers) {
            System.out.println(number);
        }
    }
}