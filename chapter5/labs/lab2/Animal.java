package chapter5.labs.lab2;

/**
 * Lab 2: 추상 클래스 활용하기
 * <p>
 * Animal 추상 클래스를 정의하세요.
 * 이 클래스는 이름, 나이 등의 속성과 함께, 추상 메소드인 sound()를 가지고 있어야 합니다.
 */
public abstract class Animal {
    // TODO: 동물의 기본 속성 정의 (예: 이름, 나이)
    private String name;
    private int age;

    // TODO: 생성자 정의
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // TODO: sound() 추상 메소드 선언
    public abstract void sound();

    // TODO: 동물 정보를 출력하는 메소드 정의
    public void printAnimalInfo() {
        System.out.println("이름: " + this.name + " 나이: " + this.age);
    }
}
