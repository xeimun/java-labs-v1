package chapter5.labs.lab3;

import java.util.ArrayList;

/**
 * Lab 3: 인터페이스 활용하기
 * <p>
 * ShoppingCart 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현한 다양한 상품을 담는 장바구니 역할을 합니다.
 */
public class ShoppingCart {
    // TODO: 상품 목록을 저장할 리스트 선언
    ArrayList<Buyable> cart = new ArrayList<>();

    // TODO: 생성자 정의

    // TODO: 장바구니에 상품 추가하는 메소드 구현
    public void addProduct(Buyable product) {
        cart.add(product);
    }

    // TODO: 장바구니에서 상품 제거하는 메소드 구현
    public void removeProduct(Buyable product) {
        cart.remove(product);
    }

    // TODO: 장바구니의 총 금액을 계산하는 메소드 구현
    public int getTotalPrice() {
        int totalPrice = 0;

        for (Buyable product : cart) {
            if (product instanceof Discountable) {
                totalPrice += ((Discountable) product).getDiscountedPrice();
            } else {
                totalPrice += product.getPrice();
            }
        }

        return totalPrice;
    }

    // TODO: 장바구니 상품 목록을 출력하는 메소드 구현
    public void printCartList() {
        System.out.println("====장바구니 목록====");

        System.out.println("----일반 상품----");
        for (Buyable product : cart) {
            if (!(product instanceof Discountable)) {
                product.printProductInfo();
            }
        }

        System.out.println("----할인 상품----");
        for (Buyable product : cart) {
            if (product instanceof Discountable discountable) {
                discountable.printDiscountInfo();
            }
        }
    }
}
