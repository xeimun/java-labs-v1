package chapter4.labs.lab3;

/**
 * Lab 3: static과 final 키워드 사용하기
 * <p>
 * final 키워드 예제 클래스
 */
public class FinalExample {
    // TODO: final 변수를 선언하고 초기화하세요.
    private final int finalInt = 0;

    // TODO: final 변수를 선언만 하고, 생성자에서 초기화하세요.
    private final int finalInt2;

    // TODO: 생성자를 정의하세요.
    public FinalExample(int num) {
        this.finalInt2 = num;
    }

    // TODO: final 메소드를 정의하세요.
    public final int getFinalInt() {
        return finalInt;
    }

    // TODO: final 매개변수를 받는 메소드를 정의하세요.
    public final void printInput(final int param) {
        // param = 0; // 에러: final 매개변수는 값 변경 불가
        System.out.println(param);
    }

    public static void main(String[] args) {
        System.out.println("Final 키워드 예제를 실행합니다.");

        // TODO: FinalExample 객체를 생성하세요.
        FinalExample finalExample = new FinalExample(3);

        // TODO: 객체의 메소드를 호출하세요.
        System.out.println(finalExample.getFinalInt());
        finalExample.printInput(4);

        // TODO: final 클래스의 객체를 생성하고 메소드를 호출하세요.
        FinalExample2 finalExample2 = new FinalExample2();
        finalExample2.display();

        // TODO: final 지역 변수를 선언하고 사용하세요.
        final int example3 = 6;
        System.out.println(example3);
    }
}

// TODO: final 클래스를 정의하세요.
final class FinalExample2 {
    public void display() {
        System.out.println("이 클래스는 상속할 수 없습니다.");
    }
}

// TODO: 일반 클래스와 하위 클래스를 정의하고, final 메소드 오버라이딩을 시도해보세요.
class Parent {
    public final void cannotOverride() {
        System.out.println("이 메소드는 오버라이딩 할 수 없습니다.");
    }

    public void canOverride() {
        System.out.println("이 메소드는 오버라이딩 가능합니다.");
    }
}

class Child extends Parent {
    // final 메소드 오버라이딩 시도(에러: final 메소드는 오버라이딩 불가)
    // @Override
    // public void cannotOverride(){
    // }

    @Override
    public void canOverride() {
        System.out.println("메소드를 오버라이딩했습니다.");
    }
}
