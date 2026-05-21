import java.util.Scanner;

public class 상급_ADV05 {

    public static void main(String[] args) {

        // 게임 생성
        Game game = new Game();

        game.play();

    }
}


/**
 * Computer 클래스(객체)는 아래와 같은 구성을 가진다.
 * 상태 : 결과값 (세자리)
 * 행동 : 결과 비교
 * */
class Computer {

    int first, second, third;

    // 생성자
    public Computer() {
        generateNumber();
    }

    /** 1~9 중 서로 다른 숫자 3개 생성 */
    public void generateNumber() {
        first = (int) (Math.random() * 9) + 1;

        do {
            second = (int) (Math.random() * 9) + 1;
        } while (second == first);

        do {
            third = (int) (Math.random() * 9) + 1;
        } while (third == first || third == second);
    }

}

/**
 * Player 클래스(객체)는 아래와 같은 구성을 가진다.
 * 상태 : 사용자 입력값 (세자리)
 * 행동 : 행동은 없다.
 * */
class Player {

    int userFirst, userSecond,  userThird;

    /** 유효한 입력을 받을 때까지 반복 후 자릿수 분리 */
    public void inputValue() {
        Scanner sc = new Scanner(System.in);
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
}

/**
 * Game 클래스(객체)는 아래와 같은 구성을 가진다.
 * 상태 : 매 회차의 게임 결과
 * 행동 : 게임 생성, 게임 결과 기록
 * */
class Game {

    int strike, ball;
    Computer computer;
    Player player;
    // 생성자
    public Game() {
        computer = new Computer();
        player = new Player();
    }

    public void play() {
        do {
            player.inputValue();
            strike = 0;
            ball = 0;
            judge();
            printResult();
        } while (!isSuccess());

    }

    /** 세 자릿수 각각에 대해 판정 수행 */
    public void judge() {
        checkDigit(player.userFirst,  computer.first,  computer.second, computer.third);
        checkDigit(player.userSecond, computer.second, computer.first,  computer.third);
        checkDigit(player.userThird,  computer.third,  computer.first,  computer.second);
    }

    /** 한 자리 숫자의 스트라이크/볼 여부를 판정 */
    public void checkDigit(int userVal, int answer, int other1, int other2) {
        if (userVal == answer) {
            strike++;
        } else if (userVal == other1 || userVal == other2) {
            ball++;
        }
    }

    /** 현재 strike/ball 상태를 화면에 출력 */
    public void printResult() {
        if (strike == 3) {
            System.out.println("정답입니다! 축하합니다!");
        } else if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }

    /** 3스트라이크 달성 여부만 반환 */
    public boolean isSuccess() {
        return strike == 3;
    }
}
