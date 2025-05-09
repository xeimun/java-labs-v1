package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * <p>
 * Electronics 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현합니다.
 */
public class Electronics implements Buyable {
    // TODO: 전자제품의 속성 정의 (예: 이름, 가격, 제조사)
    String title;
    String company;
    int price;

    // TODO: 생성자 정의
    public Electronics(String title, String company, int price) {
        this.title = title;
        this.company = company;
        this.price = price;
    }

    // TODO: Buyable 인터페이스의 메소드 구현
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    // TODO: 전자제품만의 고유한 메소드 추가

} 
