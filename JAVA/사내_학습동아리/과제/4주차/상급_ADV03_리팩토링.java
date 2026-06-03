import java.util.Scanner;

public class 상급_ADV03_리팩토링 {

    static int first, second, third;
    static int userFirst, userSecond, userThird;
    static int strike, ball;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        generateNumber();
        System.out.println("게임을 시작합니다!");

        do {
            inputValue();
            strike = 0;
            ball = 0;
            judge();
            printResult();
        } while (!isSuccess());
    }

    /** 1~9 중 서로 다른 숫자 3개 생성 */
    public static void generateNumber() {
        first = (int) (Math.random() * 9) + 1;

        do {
            second = (int) (Math.random() * 9) + 1;
        } while (second == first);

        do {
            third = (int) (Math.random() * 9) + 1;
        } while (third == first || third == second);
    }

    /** 유효한 입력을 받을 때까지 반복 후 자릿수 분리 */
    public static void inputValue() {
        String input;
        do {
            System.out.print("숫자 3자리를 입력하세요: ");
            input = sc.nextLine();
        } while (!isValidInput(input));

        userFirst  = input.charAt(0) - '0';
        userSecond = input.charAt(1) - '0';
        userThird  = input.charAt(2) - '0';
    }

    /** 입력값이 규칙에 맞는지 검증 */
    public static boolean isValidInput(String input) {
        if (input.length() != 3) {
            System.out.println("[오류] 3자리 숫자를 입력해주세요.");
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) < '1' || input.charAt(i) > '9') {
                System.out.println("[오류] 1~9 사이의 숫자만 입력 가능합니다.");
                return false;
            }
        }
        if (input.charAt(0) == input.charAt(1) ||
            input.charAt(1) == input.charAt(2) ||
            input.charAt(0) == input.charAt(2)) {
            System.out.println("[오류] 서로 다른 숫자 3개를 입력해주세요.");
            return false;
        }
        return true;
    }

    /** 세 자릿수 각각에 대해 판정 수행 */
    public static void judge() {
        checkDigit(userFirst,  first,  second, third);
        checkDigit(userSecond, second, first,  third);
        checkDigit(userThird,  third,  first,  second);
    }

    /** 한 자리 숫자의 스트라이크/볼 여부를 판정 */
    public static void checkDigit(int userVal, int answer, int other1, int other2) {
        if (userVal == answer) {
            strike++;
        } else if (userVal == other1 || userVal == other2) {
            ball++;
        }
    }

    /** 현재 strike/ball 상태를 화면에 출력 */
    public static void printResult() {
        if (strike == 3) {
            System.out.println("정답입니다! 축하합니다!");
        } else if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }

    /** 3스트라이크 달성 여부만 반환 */
    public static boolean isSuccess() {
        return strike == 3;
    }
}
