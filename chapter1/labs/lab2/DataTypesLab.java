package chapter1.labs.lab2;

/**
 * Lab 2: 자바 데이터 타입 실습
 * <p>
 * 이 실습은 자바의 기본 데이터 타입을 이해하고 사용하는 것을 목표로 합니다.
 */
public class DataTypesLab {
    public static void main(String[] args) {
        // TODO: 다음 기본 데이터 타입의 변수를 선언하고 값을 할당하세요.
        // 1. 정수형(byte, short, int, long) 변수 선언 및 할당
        byte a = 127; // -128 ~ 127
        short b = 32767; // -32,768 ~ 32,767
        int c = 2147483647; // -2,147,483,648 ~ 2,147,483,647
        long d = 9223372036854775807L; // -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807

        // TODO: 2. 실수형(float, double) 변수 선언 및 할당
        float e = 1.1f; // -3.4E+38 ~ 3.4E+38
        double f = 1.1; // -1.7E+308 ~ 1.7E+308

        // TODO: 3. 문자형(char) 변수 선언 및 할당
        char g = 'A';

        // TODO: 4. 논리형(boolean) 변수 선언 및 할당
        boolean h = true;

        // TODO: 5. 모든 변수 값을 출력하세요.
        System.out.println(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h);

        // TODO: 6. 자신의 키(cm)와 몸무게(kg)를 저장하는 변수를 선언하고 
        // BMI 지수를 계산하여 출력하세요. (BMI = 몸무게(kg) / (키(m) * 키(m)))
        short weight = 69;
        short height = 178;
        double BMI = (double) weight / (height * height); // 정수끼리 나누면 소수점 이하가 모두 버려지기 때문에 명시적 형변환
        System.out.println(BMI);
    }
} 
