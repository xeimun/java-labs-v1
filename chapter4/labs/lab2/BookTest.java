package chapter4.labs.lab2;

import java.time.LocalDate;

/**
 * Lab 2: 생성자 활용하기
 * <p>
 * Book 클래스를 테스트하는 메인 클래스
 */
public class BookTest {
    public static void main(String[] args) {
        System.out.println("Book 클래스 테스트를 시작합니다.");

        // TODO: 기본 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book1 = new Book();
        book1.showBookInfo();
        System.out.println();

        // TODO: 제목만 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book2 = new Book("해리 포터와 비밀의 방");
        book2.showBookInfo();
        System.out.println();

        // TODO: 제목과 저자를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book3 = new Book("해리 포터와 비밀의 방", "J.K. 롤링");
        book3.showBookInfo();
        System.out.println();

        // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book4 = new Book("해리 포터와 비밀의 방", "J.K. 롤링", 11_250);
        book4.showBookInfo();
        System.out.println();

        // TODO: 모든 필드를 인자로 받는 생성자를 사용하여 Book 객체를 생성하고 정보를 출력하세요.
        Book book5 = new Book("해리 포터와 비밀의 방", "J.K. 롤링", 11_250, LocalDate.of(1998, 7, 2));
        book5.showBookInfo();
        System.out.println();

        // TODO: 객체를 생성한 후 필드 값을 변경하고 정보를 출력하세요.
        book5.changePrice(7_000);
        book5.showBookInfo();
    }
}
