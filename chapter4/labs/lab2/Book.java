package chapter4.labs.lab2;

import java.time.LocalDate;

/**
 * Lab 2: 생성자 활용하기
 * <p>
 * Book 클래스 정의하기
 */
public class Book {
    // TODO: 제목, 저자, 가격, 출판연도를 저장할 수 있는 필드를 정의하세요.
    private String title;
    private String author;
    private int price;
    private LocalDate date;

    // TODO: 기본 생성자를 정의하세요.
    Book() {
        this.title = "제목 없음";
        this.author = "저자 없음";
        this.price = 0;
        this.date = null;
    }

    // TODO: 제목만 인자로 받는 생성자를 정의하세요. (this() 사용)
    Book(String title) {
        this.title = title;
        this.author = "저자 없음";
        this.price = 0;
        this.date = null;
    }

    // TODO: 제목과 저자를 인자로 받는 생성자를 정의하세요. (this() 사용)
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0;
        this.date = null;
    }

    // TODO: 제목, 저자, 가격을 인자로 받는 생성자를 정의하세요. (this() 사용)
    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.date = null;
    }

    // TODO: 모든 필드를 인자로 받는 생성자를 정의하세요.
    Book(String title, String author, int price, LocalDate date) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.date = date;
    }

    // TODO: 책의 정보를 출력하는 메소드를 정의하세요.
    public void showBookInfo() {
        System.out.println("도서명: " + this.title);
        System.out.println("저자명: " + this.author);
        System.out.println("가격: " + this.price);
        if (this.date == null) {
            System.out.println("출판일: 정보 없음");
        } else {
            System.out.println("출판일: " + this.date);
        }
    }

    public void changePrice(int price) {
        this.price = price;
    }
}
