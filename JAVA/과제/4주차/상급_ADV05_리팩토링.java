import java.util.Scanner;

/**
 * 객체지향 설계 흐름
 * 1. 어떤 협력이 있어야 하는지 정의
 * 2. 협력관계에서 각각의 역할을 탐색
 * 3. 역할이 수행해야 할 책임을 정의
 * 4. 3에서 정의된 책임을 수행할 수 있는 객체에게 책임을 할당.
 * 주의사항 : 구체적인 책임은 객체의 자율성을 흐리게 만들고, 너무 추상적인 책임은 명확하지 않은 협력을 만들게 된다.
 * Game - Player - Computer를 각각 심판(abs) - 타자 - 투수
 * 검사는
 * */
public class 상급_ADV05_리팩토링 {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}


/**
 * [Result] 값 객체 (Value Object)
 * ─────────────────────────────────────────────────────────────
 * 상태 : 스트라이크 수, 볼 수 (불변)
 * 행동 : 정답 여부 판단(isSuccess), 결과 출력(print)
 * ─────────────────────────────────────────────────────────────
 * Guess와 달리 Result는 행동(print, isSuccess)을 가지므로
 * 객체로 분리하는 것이 명확히 정당하다.
 * 이 행동들이 Game이나 Computer에 있으면 책임이 흐트러진다.
 */
class Result {

    private final int strike;
    private final int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball   = ball;
    }

    public boolean isSuccess() {
        return strike == 3;
    }

    public void print() {
        if (isSuccess()) {
            System.out.println("정답입니다! 축하합니다!");
        } else if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
    }
}


/**
 * [Computer] 컴퓨터 객체
 * ─────────────────────────────────────────────────────────────
 * 상태 : 비밀 숫자 세 자리 (외부에 완전 비공개)
 * 행동 : 플레이어의 추측을 판정하여 Result 반환 (judge)
 */
class Computer {

    private int first, second, third;

    public Computer() {
        generateNumber();
    }

    private void generateNumber() {
        first = (int) (Math.random() * 9) + 1;

        do {
            second = (int) (Math.random() * 9) + 1;
        } while (second == first);

        do {
            third = (int) (Math.random() * 9) + 1;
        } while (third == first || third == second);
    }

    /**
     * "이 추측을 판정해줘" 라는 메시지를 받아
     * 자신의 비밀 숫자와 내부에서 비교 후 Result만 반환한다.
     * 비밀 숫자는 끝까지 외부에 노출되지 않는다.
     */
    public Result judge(int f, int s, int t) {
        int strike = 0, ball = 0;

        if (f == first)                  strike++;
        else if (f == second || f == third) ball++;

        if (s == second)                 strike++;
        else if (s == first || s == third)  ball++;

        if (t == third)                  strike++;
        else if (t == first || t == second) ball++;

        return new Result(strike, ball);
    }
}


/**
 * [Player] 플레이어 객체
 * ─────────────────────────────────────────────────────────────
 * 상태 : 입력한 추측 숫자 세 자리 (외부에 비공개)
 * 행동 : 유효한 추측 입력(inputGuess), 각 자릿수 제공(getFirst/Second/Third)
 */
class Player {

    private int first, second, third;
    private final Scanner sc = new Scanner(System.in);

    public void inputGuess() {
        String input;
        do {
            System.out.print("숫자 3자리를 입력하세요: ");
            input = sc.nextLine();
        } while (!isValidInput(input));

        first  = input.charAt(0) - '0';
        second = input.charAt(1) - '0';
        third  = input.charAt(2) - '0';
    }

    public int getFirst()  { return first; }
    public int getSecond() { return second; }
    public int getThird()  { return third; }

    private boolean isValidInput(String input) {
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
 * [Game] 게임 진행 객체
 * ─────────────────────────────────────────────────────────────
 * 상태 : Computer, Player 참조
 * 행동 : 게임 흐름 조율 — 각 객체에 메시지를 보내는 역할만 수행
 *
 * [협력 흐름]
 *   Game → player.inputGuess()                   입력 요청
 *   Game → computer.judge(f, s, t)               판정 요청 → Result 수신
 *   Game → result.print()                         출력 요청
 *   Game → result.isSuccess()                     성공 여부 문의
 */
class Game {
    private final Computer computer;
    private final Player   player;

    public Game() {
        computer = new Computer();
        player   = new Player();
    }

    public void play() {
        System.out.println("게임을 시작합니다!");
        Result result;
        do {
            player.inputGuess();
            result = computer.judge(player.getFirst(), player.getSecond(), player.getThird());
            result.print();
        } while (!result.isSuccess());
    }
}
