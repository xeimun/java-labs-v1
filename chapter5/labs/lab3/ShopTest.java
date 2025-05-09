package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * <p>
 * 인터페이스 구현과 다형성을 테스트하는 클래스입니다.
 */
public class ShopTest {
    public static void main(String[] args) {
        System.out.println("Lab 3: 인터페이스 활용하기 실습");

        // TODO: Book 객체 생성
        Book book1 = new Book("청춘의 독서", "유시민", 18900);

        // TODO: Electronics 객체 생성
        Electronics electronics1 = new Electronics("갤럭시 버즈3 프로", "삼성", 215000);

        // TODO: DiscountedBook 객체 생성
        DiscountedBook discountedBook1 = new DiscountedBook("위버멘쉬", "프리드리히 니체", 17800, 0.1);

        // TODO: ShoppingCart 객체 생성
        ShoppingCart shoppingCart = new ShoppingCart();

        // TODO: 장바구니에 상품 추가하기
        shoppingCart.addProduct(book1);
        shoppingCart.addProduct(electronics1);
        shoppingCart.addProduct(discountedBook1);

        // TODO: 장바구니 내용과 총액 출력하기
        shoppingCart.printCartList();
        System.out.println("총 금액: " + shoppingCart.getTotalPrice() + "원");

        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        //       - 모든 상품의 정보 출력하기
        System.out.println("\n=====다형성 테스트=====");
        Buyable[] products = {book1, electronics1, discountedBook1};
        for (Buyable product : products) {
            product.printProductInfo();

            if (product instanceof Discountable discountable) {
                discountable.printDiscountInfo();
            }

            System.out.println();
        }

        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        System.out.println("=====할인 상품 목록=====");
        for (Buyable product : products) {
            if (product instanceof Discountable discountable) {
                System.out.println("상품명: " + product.getTitle());
                System.out.println("할인율: " + discountable.getDiscount());
                System.out.println("할인가: " + discountable.getDiscountedPrice());
                System.out.println();
            }
        }
    }
} 
