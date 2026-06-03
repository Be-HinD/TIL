import java.util.Scanner;

public class 상급_ADV03 {

    static int first, second, third;
    static int userFirst, userSecond, userThird;
    static int strike, ball;
    public static void main(String[] args) {

        randomValue();  //랜덤 숫자 생성
        System.out.println("게임을 시작합니다!");

        do {

            inputValue(); //사용자 입력

            strike = 0; ball = 0;   //정적 변수는 사용 전 초기화
            isStrikeOrBall(userFirst, first, second, third);   //첫째자리 확인
            isStrikeOrBall(userSecond, second, first, third); //둘째자리 확인
            isStrikeOrBall(userThird, third, first, second);   //셋째자리 확인

        } while(isSuccess());   //결과 확인


    }

    /**
     * 랜덤한 3개의 숫자를 생성하는 함수
     * param No Parameter
     * */
    public static void randomValue() {
        first = (int) (Math.random() * 9) + 1;

        do {
            second = (int) (Math.random() * 9) + 1;
        } while (second == first);  //같은 값이면 계속 진행

        do {
            third = (int) (Math.random() * 9) + 1;
        } while (third == first || third == second);

        System.out.println("최종 생성 -> " + first + ", " + second + ", " + third);
    }

    /**
     * 사용자 입력을 받는 함수
     * */
    public static void inputValue() {
        System.out.println("사용자 입력 : ");
        Scanner sc = new Scanner(System.in);
        String val = sc.nextLine();

        /** 사용자 입력 정제 */
        userFirst = val.charAt(0) - '0';
        userSecond = val.charAt(1) - '0';
        userThird = val.charAt(2) - '0';
    }

    /**
     * 입력으로 받은 두 수에 대해 결과를 추론하는 함수
     * */
    public static void isStrikeOrBall(int userVal, int answer, int another1, int another2) {
        /** Strike 확인 */
        if(userVal == answer) {
            strike++;
        }
        /** Ball 확인 */
        else if(userVal == another1 || userVal == another2) {
            ball++;
        }
    }

    /**
     * 결과 확인하는 함수
     * */
    public static boolean isSuccess() {

        if(strike == 3) {
            System.out.println("정답입니다!");
            return false;
        }

        if(strike == 0 && ball == 0) { // 아무것도 맞추지 못한 경우
            System.out.println("아웃");
        }
        else {
            System.out.println("스트라이크 : " + strike + ", 볼 : " + ball);
        }

        return true;
    }
}
