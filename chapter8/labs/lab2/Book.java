package chapter8.labs.lab2;

import java.util.Objects;

/**
 * Lab 2: 컬렉션 프레임워크 활용하기
 * <p>
 * 도서 관리 시스템에서 사용할 도서 클래스입니다.
 */
public class Book implements Comparable<Book> {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private int publicationYear;
    private double price;

    /**
     * 생성자
     */
    public Book(String isbn, String title, String author, String category, int publicationYear, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    // TODO: getter와 setter 메소드를 구현하세요.

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // TODO: toString 메소드를 오버라이드하세요.
    @Override
    public String toString() {
        return "도서명: " + title + ", 저자: " + author + ", 출판일:" + publicationYear + ", 가격: " + price;
    }

    // TODO: equals 메소드를 오버라이드하세요.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return this.isbn.equals(book.isbn);
    }

    // TODO: hashCode 메소드를 오버라이드하세요.
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    /**
     * Comparable 인터페이스의 compareTo 메소드 구현
     * 기본적으로 ISBN 기준으로 비교합니다.
     */
    @Override
    public int compareTo(Book other) {
        // TODO: ISBN 기준으로 비교하도록 구현하세요.
        return isbn.compareTo(other.isbn);
    }
} 
