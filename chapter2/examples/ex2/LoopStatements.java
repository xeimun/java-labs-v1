/**
 * 자바의 반복문(Loop Statements) 예제
 */
public class LoopStatements {
    public static void main(String[] args) {
        // 1. for 반복문
        System.out.println("===== for 반복문 =====");

        // 1부터 5까지 출력
        System.out.println("1부터 5까지 출력:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
        
        // 0부터 10까지 짝수 출력
        System.out.println("\n0부터 10까지 짝수 출력:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.println("i = " + i);
        }
        
        // 2. 중첩 for 반복문
        System.out.println("\n===== 중첩 for 반복문 =====");
        
        // 구구단 일부 출력 (2단, 3단)
        System.out.println("구구단 일부 출력:");
        for (int i = 2; i <= 3; i++) {
            System.out.println(i + "단:");
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
            System.out.println();
        }
        
        // 별 찍기
        System.out.println("별 찍기:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        // 3. 향상된 for 반복문 (for-each)
        System.out.println("\n===== 향상된 for 반복문 (for-each) =====");
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("배열 요소 출력:");
        for (int num : numbers) {
            System.out.println("번호: " + num);
        }
        
        // 4. while 반복문
        System.out.println("\n===== while 반복문 =====");
        int count = 1;
        
        System.out.println("1부터 5까지 출력:");
        while (count <= 5) {
            System.out.println("count = " + count);
            count++;
        }
        
        // 5. do-while 반복문
        System.out.println("\n===== do-while 반복문 =====");
        int num = 1;
        
        System.out.println("1부터 5까지 출력:");
        do {
            System.out.println("num = " + num);
            num++;
        } while (num <= 5);
        
        // while과 do-while의 차이점
        System.out.println("\nwhile과 do-while의 차이점:");
        
        int a = 10;
        System.out.println("while 반복문 (조건이 처음부터 거짓):");
        while (a < 10) {
            System.out.println("이 코드는 실행되지 않습니다.");
            a++;
        }
        
        int b = 10;
        System.out.println("do-while 반복문 (조건이 처음부터 거짓):");
        do {
            System.out.println("이 코드는 최소 한 번 실행됩니다.");
            b++;
        } while (b < 10);
        
        // 6. 무한 루프와 break
        System.out.println("\n===== 무한 루프와 break =====");
        
        System.out.println("1부터 증가하다가 5가 되면 멈춤:");
        int i = 1;
        while (true) { // 무한 루프
            System.out.println("i = " + i);
            if (i == 5) {
                System.out.println("i가 5가 되어 반복문을 종료합니다.");
                break; // 반복문 탈출
            }
            i++;
        }
        
        // 7. for 반복문과 배열
        System.out.println("\n===== for 반복문과 배열 =====");
        
        String[] fruits = {"사과", "바나나", "포도", "오렌지", "망고"};
        
        System.out.println("과일 목록:");
        for (int j = 0; j < fruits.length; j++) {
            System.out.println((j + 1) + ". " + fruits[j]);
        }
    }
} 