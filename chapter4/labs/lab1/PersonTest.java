package chapter4.labs.lab1;

/**
 * Lab 1: 클래스와 객체 만들기
 * <p>
 * Person 클래스를 테스트하는 메인 클래스
 */
public class PersonTest {
    public static void main(String[] args) {
        System.out.println("Person 클래스 테스트를 시작합니다.");

        // TODO: 이름이 John, 나이가 20, 성별이 Male인 Person 객체를 생성하세요.
        Person person1 = new Person("John", 20, "Male");

        // TODO: 생성한 객체의 정보를 출력하세요.
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
        System.out.println(person1.getGender());

        // TODO: 생일이 지나 나이가
        System.out.println("\n생일이 지나 나이가 한 살 증가했습니다. ");
        person1.addOneYear();
        System.out.println("축하합니다! 나이가 한 살 드셨네요;) " + person1.getAge());

        // TODO: 이름이 Emily, 나이가 25, 성별이 Female인 두 번째 Person 객체를 생성하세요.
        Person person2 = new Person("Emily", 25, "Female");

        // TODO: 두 번째 객체의 정보를 출력하세요.
        System.out.println("\n" + person2.getName());
        System.out.println(person2.getAge());
        System.out.println(person2.getGender());

        // TODO: 두 번째 객체의 나이를 증가시키고 정보를 다시 출력하세요.
        System.out.println("\n생일이 지나 나이가 한 살 증가했습니다. ");
        person2.addOneYear();
        System.out.println("축하합니다! 나이가 한 살 드셨네요;) " + person2.getAge());

        // TODO: 추가로 여러 Person 객체를 생성하여 배열로 관리하고 모든 객체의 정보를 출력하세요.
        Person person3 = new Person("Tom", 28, "Male");
        Person[] people = new Person[3];
        people[0] = person1;
        people[1] = person2;
        people[2] = person3;

        System.out.println("\n---기본 정보---");
        for (Person p : people) {
            System.out.println("이름: " + p.getName());
            System.out.println("나이" + p.getAge());
            System.out.println("성별" + p.getGender());
            System.out.println();
        }

    }
} 
