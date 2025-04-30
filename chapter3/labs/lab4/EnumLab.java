package chapter3.labs.lab4;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Enum(열거형) 활용하기 실습
 */
public class EnumLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 요일 Enum 활용하기
        System.out.println("===== 요일 Enum 활용하기 =====");
        System.out.println("요일을 입력하세요 (월, 화, 수, 목, 금, 토, 일): ");
        String input = scanner.nextLine();

        // TODO: 입력받은 요일에 해당하는 DayOfWeek Enum 상수를 찾아 switch 문에서 활용하세요.
        // 평일(월~금)인 경우 "평일입니다."를, 주말(토, 일)인 경우 "주말입니다."를 출력하세요.
        Map<String, DayOfWeek> days = new HashMap<>();
        days.put("월", DayOfWeek.MONDAY);
        days.put("화", DayOfWeek.TUESDAY);
        days.put("수", DayOfWeek.WEDNESDAY);
        days.put("목", DayOfWeek.THURSDAY);
        days.put("금", DayOfWeek.FRIDAY);
        days.put("토", DayOfWeek.SATURDAY);
        days.put("일", DayOfWeek.SUNDAY);

        DayOfWeek day = days.get(input);

        switch (day) {
            case SATURDAY:
            case SUNDAY:
                System.out.println("주말입니다.");
                break;
            default:
                System.out.println("평일입니다.");
        }

        // 2. 계절 Enum 활용하기
        System.out.println("\n===== 계절 Enum 활용하기 =====");
        System.out.println("월을 입력하세요 (1-12): ");
        int month = scanner.nextInt();

        // TODO: 입력받은 월에 해당하는 Season Enum 상수를 찾아 해당 계절의 특징을 출력하세요.
        // Season Enum에 평균 기온과 특징을 필드로 추가하고, 이를 활용하세요.
        enum SeasonEnum {
            SPRING("봄", 13.5, "날씨가 따뜻해진다."),
            SUMMER("여름", 26.3, "덥고 습하다."),
            AUTUMN("가을", 17.8, "하늘이 맑고 선선해진다."),
            WINTER("겨울", 2.1, "춥고 눈이 온다.");

            private String name;
            private double avgTemp;
            private String description;

            SeasonEnum(String name, double avgTemp, String description) {
                this.name = name;
                this.avgTemp = avgTemp;
                this.description = description;
            }

            public String getName() {
                return name;
            }

            public double getAvgTemp() {
                return avgTemp;
            }

            public String getDescription() {
                return description;
            }
        }

        SeasonEnum season = null;

        if (month >= 3 && month <= 5) {
            season = SeasonEnum.SPRING;
        }
        if (month >= 6 && month <= 8) {
            season = SeasonEnum.SUMMER;
        }
        if (month >= 9 && month <= 11) {
            season = SeasonEnum.AUTUMN;
        }
        if (month == 12 || month == 1 || month == 2) {
            season = SeasonEnum.WINTER;
        }

        if (season != null) {
            System.out.println("계절: " + season.getName());
            System.out.println("평균 기온: " + season.getAvgTemp());
            System.out.println("특징: " + season.getDescription());
        } else {
            System.out.println("1 ~ 12 사이의 숫자를 입력해주세요.");
        }

        // 3. 상태 전이 Enum 활용하기
        System.out.println("\n===== 상태 전이 Enum 활용하기 =====");
        scanner.nextLine(); // 버퍼 비우기
        // TODO: TaskStatus Enum을 구현하고, 상태 전이 로직을 활용하여 작업 상태를 변경하세요.
        // TaskStatus는 PENDING, IN_PROGRESS, COMPLETED, ARCHIVED 상태를 가지며,
        // nextStatus() 메소드를 통해 다음 상태로 전이할 수 있어야 합니다.
        // 사용자가 "next"를 입력할 때마다 상태를 다음 단계로 변경하고, 현재 상태를 출력하세요.
        // 사용자가 "exit"를 입력하면 종료합니다.

        enum TaskStatus {
            PENDING {
                @Override
                public TaskStatus nextStatus() {
                    return TaskStatus.IN_PROGRESS;
                }
            }, IN_PROGRESS {
                @Override
                public TaskStatus nextStatus() {
                    return TaskStatus.COMPLETED;
                }
            }, COMPLETED {
                @Override
                public TaskStatus nextStatus() {
                    return TaskStatus.ARCHIVED;
                }
            }, ARCHIVED {
                @Override
                public TaskStatus nextStatus() {
                    return TaskStatus.PENDING;
                }
            };

            public abstract TaskStatus nextStatus();
        }

        TaskStatus status = TaskStatus.PENDING;

        while (true) {
            System.out.println("현재: " + status);
            String input2 = scanner.nextLine();
            if ("exit".equals(input2)) {
                break;
            }
            if ("next".equals(input2)) {
                status = status.nextStatus();
                continue;
            }
            System.out.println("next 또는 exit을 입력해주세요.");
        }

        // 4. 연산자 Enum 활용하기
        System.out.println("\n===== 연산자 Enum 활용하기 =====");
        // scanner.nextLine(); // 버퍼 비우기
        System.out.print("연산할 숫자(x)를 입력해주세요.");
        int x = scanner.nextInt();
        System.out.print("연산할 숫자(y)를 입력해주세요.");
        int y = scanner.nextInt();

        // TODO: Operator Enum을 구현하고, 두 수에 대한 사칙연산을 수행하세요.
        // Operator는 ADD(+), SUBTRACT(-), MULTIPLY(*), DIVIDE(/) 연산을 가지며,
        // calculate() 메소드를 통해 두 수에 대한 연산을 수행할 수 있어야 합니다.
        // 사용자로부터 두 수와 연산자를 입력받아 계산 결과를 출력하세요.
        enum Operator {
            ADD("+") {
                @Override
                public int calculate(int a, int b) {
                    return a + b;
                }
            },
            SUBTRACT("-") {
                @Override
                public int calculate(int a, int b) {
                    return a - b;
                }
            },
            MULTIFLY("*") {
                @Override
                public int calculate(int a, int b) {
                    return a * b;
                }
            },
            DIVIDE("/") {
                @Override
                public int calculate(int a, int b) {
                    return a / b;
                }
            };

            private final String symbol;

            Operator(String symbol) {
                this.symbol = symbol;
            }

            public abstract int calculate(int x, int y);

            public String getSymbol() {
                return symbol;
            }
        }

        Operator[] operators = Operator.values();
        for (Operator operator : operators) {
            System.out.println(x + operator.getSymbol() + y + "=" + operator.calculate(x, y));
        }

        scanner.close();
    }
}
