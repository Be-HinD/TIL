import java.util.Scanner;

public class 기본_요구사항_구현 {
    public static void main(String[] args) {

        /**
         * REQ-01 : 컴퓨터는 1~9 중 중복 없는 3개의 숫자를 Math.random()으로 생성한다
         * */
        int first = (int) (Math.random() * 9) + 1;

        int second;
        do {
            second = (int) (Math.random() * 9) + 1;
        } while (second == first);  //같은 값이면 계속 진행

        int third;
        do {
            third = (int) (Math.random() * 9) + 1;
        } while (third == first || third == second);


        System.out.println("게임을 시작합니다!");

        while(true) {
            System.out.println("사용자 입력 : ");

            /**
             * Scanner : 내부적으로 입력을 버퍼에 담아두고, 구분자(delimiter) 기준으로 토큰을 잘라서 반환
             * */
            Scanner input = new Scanner(System.in);
            String val = input.nextLine();
            //val = 1234567889

            /** 사용자 입력 정제 -> ASCII코드 변환 */
            int userFirst = val.charAt(0) - '0';
            int userSecond = val.charAt(1) - '0';
            int userThird = val.charAt(2) - '0';

            int strike = 0; int ball = 0;

            /** 첫째 자리 비교 */
            if(userFirst == first) {
                strike++;
            }
            else if(userFirst == second || userFirst == third) {
                ball++;
            }
            /** 둘째 자리 비교 */
            if(userSecond == second) {
                strike++;
            }
            else if(userSecond == first || userSecond == third) {
                ball++;
            }
            /** 셋째 자리 비교 */
            if(userThird == third) {
                strike++;
            }
            else if(userThird == first || userThird == second) {
                ball++;
            }

            /** 결과 추론 */
            if(strike == 3) {
                System.out.println("정답입니다!");
                break;
            }
            else if(strike == 0 && ball == 0) { // 아무것도 맞추지 못한 경우
                System.out.println("아웃");
            }
            else {
                System.out.println("스트라이크 : " + strike + ", 볼 : " + ball);
            }
        }
    }
}
