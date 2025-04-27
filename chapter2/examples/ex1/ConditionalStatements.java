package chapter2.examples.ex1;

/**
 * 자바의 조건문(Conditional Statements) 예제
 */
public class ConditionalStatements {
    public static void main(String[] args) {
        // 1. if 문
        System.out.println("===== if 문 =====");
        int number = 10;
        
        if (number > 0) {
            System.out.println("양수입니다.");
        }
        
        // 2. if-else 문
        System.out.println("\n===== if-else 문 =====");
        int temperature = 30;
        
        if (temperature >= 25) {
            System.out.println("더운 날씨입니다.");
        } else {
            System.out.println("덥지 않은 날씨입니다.");
        }
        
        // 3. if-else if-else 문
        System.out.println("\n===== if-else if-else 문 =====");
        int score = 85;
        
        if (score >= 90) {
            System.out.println("A 학점");
        } else if (score >= 80) {
            System.out.println("B 학점");
        } else if (score >= 70) {
            System.out.println("C 학점");
        } else if (score >= 60) {
            System.out.println("D 학점");
        } else {
            System.out.println("F 학점");
        }
        
        // 4. 중첩된 if 문
        System.out.println("\n===== 중첩된 if 문 =====");
        int age = 22;
        boolean hasID = true;
        
        if (age >= 19) {
            if (hasID) {
                System.out.println("입장이 가능합니다.");
            } else {
                System.out.println("신분증이 필요합니다.");
            }
        } else {
            System.out.println("미성년자는 입장할 수 없습니다.");
        }
        
        // 5. switch 문
        System.out.println("\n===== switch 문 =====");
        int day = 3;
        
        switch (day) {
            case 1:
                System.out.println("월요일");
                break;
            case 2:
                System.out.println("화요일");
                break;
            case 3:
                System.out.println("수요일");
                break;
            case 4:
                System.out.println("목요일");
                break;
            case 5:
                System.out.println("금요일");
                break;
            case 6:
                System.out.println("토요일");
                break;
            case 7:
                System.out.println("일요일");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
        
        // 6. switch 문 - 문자열 케이스
        System.out.println("\n===== switch 문 (문자열) =====");
        String fruit = "apple";
        
        switch (fruit.toLowerCase()) {
            case "apple":
                System.out.println("사과는 빨간색입니다.");
                break;
            case "banana":
                System.out.println("바나나는 노란색입니다.");
                break;
            case "grape":
                System.out.println("포도는 보라색입니다.");
                break;
            default:
                System.out.println("해당 과일의 색상 정보가 없습니다.");
                break;
        }
        
        // 7. 삼항 연산자
        System.out.println("\n===== 삼항 연산자 =====");
        int x = 10;
        int y = 20;
        
        // 삼항 연산자: 조건 ? 참일 때 값 : 거짓일 때 값
        int max = (x > y) ? x : y;
        System.out.println("두 수 중 큰 값은: " + max);
        
        // 삼항 연산자 중첩
        int num = 5;
        String result = (num > 0) ? "양수" : (num < 0) ? "음수" : "0";
        System.out.println(num + "은(는) " + result + "입니다.");
        
        // 8. Java 12 이상의 Enhanced switch (참고용)
        /*
        System.out.println("\n===== Enhanced switch (Java 12+) =====");
        int month = 4;
        
        String season = switch (month) {
            case 12, 1, 2 -> "겨울";
            case 3, 4, 5 -> "봄";
            case 6, 7, 8 -> "여름";
            case 9, 10, 11 -> "가을";
            default -> "잘못된 월";
        };
        
        System.out.println(month + "월은 " + season + "입니다.");
        */
    }
} 