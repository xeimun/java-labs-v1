package chapter1.labs.lab4;

/**
 * Lab 4: 자바 연산자 실습
 * <p>
 * 이 실습은 자바의 다양한 연산자를 이해하고 활용하는 것을 목표로 합니다.
 */
public class OperatorsLab {
    public static void main(String[] args) {
        // TODO: 1. 산술 연산자 사용하기
        // 두 개의 정수형 변수를 선언하고 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산을 수행하세요.
        int a = 2;
        int b = 3;
        System.out.println("덧셈: " + (a + b));
        System.out.println("뺄셈: " + (a - b));
        System.out.println("곱셈: " + (a * b));
        System.out.println("나눗셈: " + (a / b));
        System.out.println("나눗셈: " + (a % b));

        // TODO: 2. 증감 연산자 사용하기
        // 변수를 선언하고 전위 증가, 후위 증가, 전위 감소, 후위 감소 연산을 수행하세요.
        // 각 단계별로 변수의 값을 출력하여 변화를 확인하세요.
        int tmp = 1;
        int prefixIncrement = ++tmp;
        int postfixIncrement = tmp++;
        int prefixDecrement = --tmp;
        int postfixDecrement = tmp--;
        System.out.println(prefixIncrement);
        System.out.println(postfixIncrement);
        System.out.println(prefixDecrement);
        System.out.println(postfixDecrement);

        // TODO: 3. 비교 연산자 사용하기
        // 두 변수를 비교하여 결과를 출력하세요 (==, !=, >, <, >=, <=).
        int intValue = 10;
        int intValue2 = 20;

        System.out.println(intValue == intValue2);
        System.out.println(intValue != intValue2);
        System.out.println(intValue > intValue2);
        System.out.println(intValue < intValue2);
        System.out.println(intValue >= intValue2);
        System.out.println(intValue <= intValue2);

        // TODO: 4. 논리 연산자 사용하기
        // boolean 변수를 사용하여 AND(&&), OR(||), NOT(!) 연산을 수행하세요.
        boolean booleanT = true;
        boolean booleanF = false;

        System.out.println(booleanF || booleanT && booleanF);

        // TODO: 5. 대입 연산자 사용하기
        // 변수를 선언하고 복합 대입 연산자(+=, -=, *=, /=, %=)를 사용하여 값을 변경하세요.
        int tmp2 = 2;
        tmp2 += 2;
        tmp2 -= 2;
        tmp2 *= 3;
        tmp2 /= 3;
        tmp2 %= 3;
        System.out.println(tmp2);

        // TODO: 6. 삼항 연산자 사용하기
        // 조건에 따라 다른 값을 할당하는 예제를 작성하세요.
        int time = 9;
        String status = (time > 10) ? "지각" : "출석";
        System.out.println(status);
    }
} 
