package chapter9.labs.lab2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 스트림 API 활용 실습
 * <p>
 * 이 실습에서는 스트림 API를 사용하여 데이터를 효율적으로 처리하는 방법을 연습합니다.
 */
public class StreamLab {

    // 연습을 위한 학생 클래스
    static class Student {
        private String name;
        private String department;
        private int grade;
        private int score;

        public Student(String name, String department, int grade, int score) {
            this.name = name;
            this.department = department;
            this.grade = grade;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getGrade() {
            return grade;
        }

        public int getScore() {
            return score;
        }

        @Override
        public String toString() {
            return name + "(" + department + ", " + grade + "학년, " + score + "점)";
        }
    }

    public static void main(String[] args) {
        // TODO: 아래 작업을 완성하세요.

        // 1. 다양한 소스에서 스트림 생성
        System.out.println("===== 다양한 소스에서 스트림 생성 =====");

        // TODO: 1에서 20까지의 정수 스트림을 생성하여 출력하세요.
        // 힌트: IntStream.rangeClosed(1, 20)...
        IntStream.rangeClosed(1, 20)
                 .forEach(num -> System.out.print(num + " "));

        System.out.println();

        // TODO: 문자열 배열에서 스트림을 생성하여 출력하세요.
        String[] subjects = {"국어", "영어", "수학", "과학", "사회"};
        // 힌트: Arrays.stream(subjects)...
        Arrays.stream(subjects)
              .forEach(s -> System.out.print(s + " "));

        System.out.println();

        // TODO: 리스트에서 스트림을 생성하여 출력하세요.
        List<String> cities = Arrays.asList("서울", "부산", "인천", "대구", "대전", "광주", "울산", "세종", "city");
        // 힌트: cities.stream()...
        cities.stream()
              .forEach(c -> System.out.print(c + " "));

        System.out.println();

        // 2. 중간 연산과 최종 연산 활용
        System.out.println("\n===== 중간 연산과 최종 연산 =====");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO: 짝수만 필터링하여 제곱한 후 평균을 계산하세요.
        // 힌트: numbers.stream().filter(...).map(...).average()
        OptionalDouble averageOfEven = numbers.stream()
                                              .filter(x -> x % 2 == 0)
                                              .mapToInt(x -> x * x)
                                              .average();

        if (averageOfEven.isPresent()) {
            System.out.println("\n짝수 평균: " + averageOfEven.getAsDouble());
        } else {
            System.out.println("\n짝수 평균: 없음");
        }

        // TODO: 문자열 리스트에서 길이가 3 이상인 문자열만 대문자로 변환하세요.
        // 힌트: cities.stream().filter(...).map(...)
        System.out.println("\n문자열 길이가 3이상인 문자를 대문자로 변환");
        cities.stream()
              .filter(x -> x.length() >= 3)
              .map(String::toUpperCase)
              .forEach(s -> System.out.print(s + " "));

        // 3. 객체 스트림 처리
        System.out.println("\n===== 객체 스트림 처리 =====");

        // 학생 객체 리스트 생성
        List<Student> students = Arrays.asList(
                new Student("윤학생", "컴퓨터공학", 1, 87),
                new Student("김학생", "경영학", 2, 92),
                new Student("이학생", "컴퓨터공학", 3, 95),
                new Student("박학생", "경제학", 1, 79),
                new Student("손학생", "경영학", 2, 88),
                new Student("서학생", "컴퓨터공학", 4, 96),
                new Student("장학생", "체육학", 3, 85),
                new Student("최학생", "체육학", 4, 88)
        );

        // TODO: 학과별로 그룹화하여 학생 수를 계산하세요.
        // 힌트: students.stream().collect(Collectors.groupingBy(..., Collectors.counting()))
        Map<String, Long> studentCnt = students.stream()
                                               .collect(Collectors.groupingBy(Student::getDepartment,
                                                       Collectors.counting()));
        System.out.println("\n학과별 학생수");
        for (Map.Entry<String, Long> entry : studentCnt.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // TODO: 학과별로 그룹화한 후 평균 점수를 계산하세요.
        // 힌트: students.stream().collect(Collectors.groupingBy(..., Collectors.averagingInt(...)))
        Map<String, Double> averageScore = students.stream()
                                                   .collect(Collectors.groupingBy(Student::getDepartment,
                                                           Collectors.averagingDouble(Student::getScore)));

        System.out.println("\n학과별 평균 점수");
        for (Map.Entry<String, Double> entry : averageScore.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // TODO: 학년별로 그룹화한 후 최고 점수를 받은 학생을 찾으세요.
        // 힌트: students.stream().collect(Collectors.groupingBy(..., Collectors.maxBy(...)))
        Map<Integer, Optional<Student>> topStudentsByGrade = students.stream()
                                                                     .collect(Collectors.groupingBy(Student::getGrade,
                                                                             Collectors.maxBy(Comparator.comparingInt(
                                                                                     Student::getScore))));
        System.out.println("\n학년별 최고 점수를 받은 학생");
        for (Map.Entry<Integer, Optional<Student>> entry : topStudentsByGrade.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue()
                                                            .get());
        }

        // 4. 텍스트 파일 단어 빈도수 계산
        System.out.println("\n===== 텍스트 파일 단어 빈도수 =====");

        // 샘플 텍스트 (실제 파일이 없으므로 문자열로 대체)
        String text = "스트림은 자바 8에서 추가된 기능으로, 컬렉션의 요소를 "
                + "람다식으로 처리할 수 있게 해줍니다. 스트림을 이용하면 "
                + "복잡한 데이터 처리 작업을 간결하게 표현할 수 있습니다. "
                + "스트림은 원본 데이터를 변경하지 않고, 새로운 결과를 만들어냅니다.";

        // TODO: 텍스트에서 단어를 추출하여 빈도수를 계산하세요. (대소문자 구분 없이)
        // 힌트: Arrays.stream(text.split("\\s+|\\.|,")).filter(...).collect(Collectors.groupingBy(...))
        Map<String, Long> wordCount = Arrays.stream(text.split("\\s+|\\.|,"))
                                            .map(String::toLowerCase)
                                            .filter(s -> !s.isBlank())
                                            .collect(Collectors.groupingBy(
                                                    s -> s,
                                                    Collectors.counting()
                                            ));

        System.out.println("\n단어 빈도수 계산");
        for (Map.Entry<String, Long> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
} 