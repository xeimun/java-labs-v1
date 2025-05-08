package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * <p>
 * Car 클래스 정의하기 (Engine을 포함하는 관계)
 */
public class Car {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (모델명, 색상, 속도, Engine 타입의 필드 등)
    private String modelName;
    private String color;
    private int speed;
    private Engine engine;

    // TODO: 생성자를 정의하세요.
    // (Engine 객체를 생성하여 포함관계 구현)
    public Car(String modelName, String color, String engineType, int horsePower) {
        this.modelName = modelName;
        this.color = color;
        this.speed = 0;
        this.engine = new Engine(engineType, horsePower);
    }

    // TODO: 자동차를 시동하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 메소드 호출)
    public void powerOn() {
        System.out.println(modelName + " power on");
        engine.powerOn();
    }

    // TODO: 자동차를 정지하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 메소드 호출)
    public void powerOff() {
        if (speed > 0) {
            System.out.println("차가 멈춘 상태에서 시동을 끌 수 있습니다.");
            return;
        }
        System.out.println(modelName + " power off");
        engine.powerOff();
    }

    // TODO: 자동차의 속도를 증가시키는 메소드를 정의하세요.
    public void increaseSpeed(int amount) {
        if (!engine.isPowerOn()) {
            System.out.println("시동이 꺼져어 속도를 증가시킬 수 없습니다.");
            return;
        }
        speed += amount;
        System.out.println(amount + "km/h 가속했습니다. 현재 속도: " + speed + "km/h");
    }

    // TODO: 자동차의 속도를 감소시키는 메소드를 정의하세요.
    public void decreaseSpeed(int amount) {
        if (speed - amount < 0) {
            speed = 0;
        } else {
            speed -= amount;
        }
        System.out.println(amount + "km/h 감속했습니다. 현재 속도: " + speed + "km/h");
    }

    // TODO: 자동차의 정보를 출력하는 메소드를 정의하세요.
    // (내부적으로 Engine 객체의 정보도 출력)
    public void printCarInfo() {
        System.out.println("\n===== 자동차 정보 =====");
        System.out.println("모델: " + modelName);
        System.out.println("색상: " + color);
        System.out.println("현재 속도: " + speed + "km/h");
        System.out.println("------ 엔진 정보 ------");
        engine.printEngineInfo();
        System.out.println("=====================");
    }

    // TODO: 필요한 getter/setter 메소드를 정의하세요.
    public String getModelName() {
        return modelName;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public Engine getEngine() {
        return engine;
    }
}
