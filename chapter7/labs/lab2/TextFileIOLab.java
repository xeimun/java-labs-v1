package chapter7.labs.lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 텍스트 파일을 생성하고 처리하는 실습
 * <p>
 * 이 실습에서는 Java의 파일 입출력 기능을 활용하여
 * 텍스트 파일을 생성, 읽기, 검색, 수정하는 다양한 작업을 수행합니다.
 * <p>
 * 생성, 읽기까지는 필수로 풀기(메뉴 2번까지 - createTextFile(), readTextFile())
 */
public class TextFileIOLab {
    // 파일 경로 상수
    private static final String FILE_PATH = "chapter7/labs/lab2/sample.txt";

    public static void main(String[] args) {
        // TODO: 사용자 입력을 받기 위한 Scanner 객체를 생성하세요.
        Scanner scanner = new Scanner(System.in);

        // TODO: 프로그램 메인 루프를 구현하세요.
        // 1. showMenu() 메소드를 호출하여 메뉴 표시
        // 2. getIntInput() 메소드를 호출하여 사용자 선택 받기 (1~7 사이의 값)
        // 3. switch 문을 사용하여 사용자 선택에 따른 메소드 호출
        //    - 1: createTextFile()
        //    - 2: readTextFile()
        //    - 3: searchTextInFile()
        //    - 4: replaceTextInFile()
        //    - 5: countFileStats()
        //    - 6: appendToFile()
        //    - 7: 프로그램 종료
        // 4. 계속하려면 Enter 키를 누르도록 안내 메시지 출력
        boolean flag = true;
        while (flag) {
            showMenu();
            int menuChoice = getIntInput(scanner, 1, 7);

            switch (menuChoice) {
                case 1:
                    createTextFile(scanner);
                    break;
                case 2:
                    readTextFile();
                    break;
                case 3:
                    searchTextInFile(scanner);
                    break;
                case 4:
                    replaceTextInFile(scanner);
                    break;
                case 5:
                    countFileStats();
                    break;
                case 6:
                    appendToFile(scanner);
                    break;
                case 7:
                    flag = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
            }

            if (flag) {
                System.out.println("\n계속하려면 Enter 키를 누르세요...");
                scanner.nextLine(); // 이전 nextInt()의 개행 제거
                scanner.nextLine(); // 대기
            }
        }
    }

    /**
     * 메뉴 출력
     */
    private static void showMenu() {
        // TODO: 텍스트 파일 처리 프로그램의 메뉴를 출력하세요.
        // 1. 텍스트 파일 생성하기
        // 2. 텍스트 파일 읽기
        // 3. 텍스트 파일에서 검색하기
        // 4. 텍스트 파일에서 문자열 치환하기
        // 5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)
        // 6. 파일에 내용 추가하기
        // 7. 종료
        System.out.println("========메뉴========");
        System.out.println("1. 텍스트 파일 생성하기");
        System.out.println("2. 텍스트 파일 읽기");
        System.out.println("3. 텍스트 파일에서 검색하기");
        System.out.println("4. 텍스트 파일에서 문자열 치환하기");
        System.out.println("5. 파일 통계 계산하기 (라인 수, 단어 수, 문자 수)");
        System.out.println("6. 파일에 내용 추가하기");
        System.out.println("7. 종료");
        System.out.println();
    }

    /**
     * 사용자로부터 정수 입력 받기
     */
    private static int getIntInput(Scanner scanner, int min, int max) {
        // TODO: 사용자로부터 min과 max 사이의 정수를 입력받아 반환하세요.
        // 1. 사용자 입력을 정수로 변환 시도
        // 2. 입력값이 min과 max 사이의 값인지 확인
        // 3. 잘못된 입력이 들어온 경우 적절한 메시지 출력 후 다시 입력 요청
        // 4. 유효한 입력을 받을 때까지 반복
        while (true) {
            System.out.print("메뉴 선택 (" + min + "~" + max + "): ");

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                if (input >= min && input <= max) {
                    return input;
                }
            } else {
                scanner.nextLine(); // 버퍼 비우기
            }

            System.out.println("잘못된 입력입니다. 다시 시도하세요.");
        }
    }

    /**
     * 텍스트 파일 생성
     */
    private static void createTextFile(Scanner scanner) {
        // TODO: "텍스트 파일 생성하기" 타이틀을 출력하세요.
        System.out.println("텍스트 파일 생성하기");

        // TODO: 파일이 이미 존재하는지 확인하세요.
        // 1. File 객체를 생성하고 exists() 메소드를 사용하여 확인
        // 2. 파일이 이미 존재하면 덮어쓸지 사용자에게 물어보기
        // 3. 사용자가 'n'을 입력하면 메소드 종료
        File file = new File(FILE_PATH);
        if (file.exists()) {
            System.out.print("파일이 이미 존재합니다. 덮어쓰시겠습니까? (y/n): ");
            String answer = scanner.next();
            scanner.nextLine(); // 개행 제거

            if ("n".equalsIgnoreCase(answer)) {
                System.out.println("파일 생성을 취소합니다.");
                return;
            }
        }

        // TODO: 사용자로부터 파일에 저장할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장
        System.out.println("저장할 내용을 입력하세요. (빈 줄 입력 시 종료)");
        List<String> contents = new ArrayList<>();
        int lineNum = 1;

        while (true) {
            System.out.print(lineNum + ": ");
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            contents.add(line);
            lineNum++;
        }

        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter와 BufferedWriter 생성
        // 3. 리스트의 각 줄을 파일에 쓰기 (newLine() 메소드 활용)
        // 4. 예외 처리 및 성공 메시지 출력
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : contents) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("파일이 성공적으로 생성되었습니다: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생: " + e.getMessage());
        }
    }

    /**
     * 텍스트 파일 읽기
     */
    private static void readTextFile() {
        // TODO: "텍스트 파일 읽기" 타이틀을 출력하세요.
        System.out.println("텍스트 파일 읽기");

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴
        File file = new File("chapter7/labs/lab2/sample.txt");

        if (!file.exists()) {
            System.out.println("파일이 존재하지 않습니다");
            return;
        }

        // TODO: BufferedReader를 사용하여 파일 내용을 읽고 출력하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileReader와 BufferedReader 생성
        // 3. readLine() 메소드를 사용하여 한 줄씩 읽기
        // 4. 각 줄 앞에 줄 번호 붙여서 출력
        // 5. 예외 처리 및 완료 메시지 출력
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;

            while ((line = br.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }

            System.out.println("\n파일 읽기를 완료했습니다.");
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
    }

    /**
     * 텍스트 파일에서 문자열 검색
     */
    private static void searchTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 검색하기" 타이틀을 출력하세요.

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴

        // TODO: 사용자로부터 검색할 텍스트와 대소문자 구분 여부를 입력받으세요.

        // TODO: BufferedReader를 사용하여 파일을 읽으면서 검색어 찾기
        // 1. try-with-resources 구문 사용
        // 2. 대소문자 구분 여부에 따라 검색 전략 결정
        // 3. 일치하는 부분 찾으면 해당 줄 출력 (검색어 하이라이트)
        // 4. Pattern, Matcher 클래스를 활용하여 검색어 하이라이트
        // 5. 검색 결과 통계 출력 (몇 개의 일치 항목을 찾았는지)
        // 6. 예외 처리
    }

    /**
     * 텍스트 파일에서 문자열 치환
     */
    private static void replaceTextInFile(Scanner scanner) {
        // TODO: "텍스트 파일에서 문자열 치환하기" 타이틀을 출력하세요.

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴

        // TODO: 사용자로부터 다음 정보를 입력받으세요:
        // 1. 찾을 텍스트
        // 2. 변경할 텍스트
        // 3. 대소문자 구분 여부 (y/n)
        // 4. 모든 일치 항목 변경 또는 첫 일치 항목만 변경 여부 (y/n)

        // TODO: 파일 내용을 List<String>으로 읽어오세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedReader를 사용하여 모든 줄을 리스트에 저장

        // TODO: 각 줄에서 검색어를 찾아 치환하세요.
        // 1. 대소문자 구분 여부와 모든/첫 일치 항목 변경 여부에 따라 적절한 메소드 사용
        //    - String.replace() 또는 String.replaceAll()
        //    - 정규식 패턴 사용 시 Pattern.CASE_INSENSITIVE 플래그 활용
        // 2. 몇 개의 라인이 변경되었는지 카운트

        // TODO: 변경된 내용을 파일에 다시 쓰세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedWriter를 사용하여 수정된 내용 쓰기
        // 3. 변경된 라인 수 출력
        // 4. 예외 처리
    }

    /**
     * 파일 통계 계산 (라인 수, 단어 수, 문자 수)
     */
    private static void countFileStats() {
        // TODO: "파일 통계 계산하기" 타이틀을 출력하세요.

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴

        // TODO: 파일 통계를 계산하세요.
        // 1. try-with-resources 구문 사용
        // 2. BufferedReader를 사용하여 파일 읽기
        // 3. 라인 수 계산 (반복문에서 라인 카운트 증가)
        // 4. 단어 수 계산 (각 라인을 공백으로 분할하여 단어 카운트)
        // 5. 문자 수 계산 (각 라인의 길이 합산)

        // TODO: 계산된 통계 정보를 출력하세요.
        // 1. 라인 수
        // 2. 단어 수
        // 3. 문자 수
        // 4. 예외 처리
    }

    /**
     * 파일에 내용 추가
     */
    private static void appendToFile(Scanner scanner) {
        // TODO: "파일에 내용 추가하기" 타이틀을 출력하세요.

        // TODO: 파일이 존재하는지 확인하세요.
        // 파일이 존재하지 않으면 에러 메시지 출력 후 리턴

        // TODO: 사용자로부터 추가할 내용을 입력받으세요.
        // 1. 빈 줄이 입력될 때까지 사용자 입력을 받기
        // 2. 입력된 각 줄에 줄 번호 표시하기
        // 3. 입력받은 내용을 List<String>에 저장

        // TODO: BufferedWriter를 사용하여 입력받은 내용을 파일에 추가하세요.
        // 1. try-with-resources 구문 사용
        // 2. FileWriter(파일경로, true)를 사용하여 append 모드로 열기
        // 3. 구분선("--- 추가된 내용 ---") 추가
        // 4. 리스트의 각 줄을 파일에 추가
        // 5. 예외 처리 및 성공 메시지 출력
    }
}
