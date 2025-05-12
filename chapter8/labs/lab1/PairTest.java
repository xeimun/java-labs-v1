package chapter8.labs.lab1;

/**
 * Lab 1: 제네릭 클래스 구현 테스트
 * <p>
 * Pair 클래스와 PairUtils 클래스의 기능을 테스트합니다.
 */
public class PairTest {
    public static void main(String[] args) {
        System.out.println("=== Pair 클래스 테스트 ===");

        // TODO: Pair 클래스의 다양한 타입 매개변수를 사용하여 객체를 생성하고 테스트하세요.
        // Integer와 String 타입의 Pair
        Pair<Integer, String> p1 = new Pair<>(1, "자바");
        System.out.println("p1: " + p1);

        // Double과 Double 타입의 Pair
        Pair<Double, Double> p2 = new Pair<>(2.0, 3.0);
        System.out.println("p2: " + p2);

        // 사용자 정의 클래스를 사용한 Pair
        Pair<Test, Test> p3 = new Pair<>(new Test(), new Test());
        System.out.println("p3: " + p3);

        System.out.println("\n=== PairUtils 클래스 테스트 ===");

        // TODO: PairUtils 클래스의 메소드를 테스트하세요.
        // of 메소드 테스트
        Pair<String, Integer> ofPair = PairUtils.of("key", 100);
        System.out.println("of(): " + ofPair);

        // swap 메소드 테스트
        Pair<Integer, String> swapped = PairUtils.swap(ofPair);
        System.out.println("swap(): " + swapped);

        // 숫자 타입의 sum 메소드 테스트
        Double sum = PairUtils.sum(p2);
        System.out.println("sum(): " + sum);

        // 타입 제한 테스트 (Number 하위 클래스만 가능)
        Pair<String, String> invalid = new Pair<>("a", "b");
        // Double invalidSum = PairUtils.sum(invalid); // 오류

        // compare 메소드 테스트
        Pair<Integer, String> p4 = new Pair<>(1, "자바스크립트");
        System.out.println("p1 vs p4: " + PairUtils.compare(p1, p4));

        // 와일드카드 메소드 테스트
        PairUtils.print(p1);
        PairUtils.print(p2);
        PairUtils.print(p3);
        PairUtils.print(ofPair);
    }

    public static class Test {
    }
} 
