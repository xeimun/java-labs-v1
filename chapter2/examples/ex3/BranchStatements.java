/**
 * 자바의 분기문(Branch Statements) 예제 - break와 continue
 */
public class BranchStatements {
    public static void main(String[] args) {
        // 1. break 문
        System.out.println("===== break 문 =====");
        
        // for 반복문에서 break 사용
        System.out.println("for 반복문에서 break:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("i가 5가 되어 반복문을 종료합니다.");
                break; // 반복문 종료
            }
            System.out.println("i = " + i);
        }
        
        // while 반복문에서 break 사용
        System.out.println("\nwhile 반복문에서 break:");
        int count = 1;
        while (count <= 10) {
            if (count == 5) {
                System.out.println("count가 5가 되어 반복문을 종료합니다.");
                break; // 반복문 종료
            }
            System.out.println("count = " + count);
            count++;
        }
        
        // 2. continue 문
        System.out.println("\n===== continue 문 =====");
        
        // for 반복문에서 continue 사용
        System.out.println("for 반복문에서 continue (홀수만 출력):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // 짝수인 경우 아래 코드를 실행하지 않고 다음 반복으로 넘어감
            }
            System.out.println("i = " + i);
        }
        
        // while 반복문에서 continue 사용
        System.out.println("\nwhile 반복문에서 continue (홀수만 출력):");
        int j = 0;
        while (j < 10) {
            j++;
            if (j % 2 == 0) {
                continue; // 짝수인 경우 아래 코드를 실행하지 않고 다음 반복으로 넘어감
            }
            System.out.println("j = " + j);
        }
        
        // 3. 레이블(Label)을 사용한 break
        System.out.println("\n===== 레이블을 사용한 break =====");
        
        // 중첩 반복문에서 외부 반복문 탈출하기
        outerLoop: for (int i = 1; i <= 3; i++) {
            System.out.println("외부 반복 i = " + i);
            
            for (int k = 1; k <= 5; k++) {
                System.out.println("  내부 반복 k = " + k);
                
                if (k == 3) {
                    System.out.println("  k가 3이 되어 외부 반복문을 종료합니다.");
                    break outerLoop; // outerLoop 레이블이 붙은 반복문을 종료
                }
            }
            
            System.out.println("이 메시지는 출력되지 않습니다. (외부 반복문 종료)");
        }
        
        // 4. 레이블(Label)을 사용한 continue
        System.out.println("\n===== 레이블을 사용한 continue =====");
        
        // 중첩 반복문에서 외부 반복문의 다음 반복으로 넘어가기
        outerLoop: for (int i = 1; i <= 3; i++) {
            System.out.println("외부 반복 i = " + i);
            
            for (int k = 1; k <= 3; k++) {
                if (i == 2 && k == 2) {
                    System.out.println("  i가 2이고 k가 2일 때 외부 반복문의 다음 반복으로 넘어갑니다.");
                    continue outerLoop; // outerLoop 레이블이 붙은 반복문의 다음 반복으로 넘어감
                }
                System.out.println("  내부 반복 k = " + k);
            }
            
            System.out.println("외부 반복 " + i + " 종료");
        }
        
        // 5. break와 switch문
        System.out.println("\n===== break와 switch문 =====");
        
        int choice = 2;
        
        switch (choice) {
            case 1:
                System.out.println("1번을 선택했습니다.");
                break; // switch문 종료
            case 2:
                System.out.println("2번을 선택했습니다.");
                break; // switch문 종료
            case 3:
                System.out.println("3번을 선택했습니다.");
                break; // switch문 종료
            default:
                System.out.println("유효하지 않은 선택입니다.");
                break; // switch문 종료
        }
        
        // 6. break가 없는 switch문 (fall-through)
        System.out.println("\n===== break가 없는 switch문 =====");
        
        int operation = 2;
        
        System.out.println("필요한 작업 단계:");
        switch (operation) {
            case 3:
                System.out.println("1. 데이터 백업하기");
                // break 없음 - fall-through 발생
            case 2:
                System.out.println("2. 데이터 검증하기");
                // break 없음 - fall-through 발생
            case 1:
                System.out.println("3. 데이터 저장하기");
                break;
            default:
                System.out.println("유효하지 않은 작업입니다.");
                break;
        }
    }
} 