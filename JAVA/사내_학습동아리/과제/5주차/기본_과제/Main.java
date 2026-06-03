package 기본과제;

public class Main {

    public static void main(String[] args) {

        /**
         * 1. 기본과제.Car 객체를 N개 생성하고 각 필드에 값을 할당
         * */

        Car 소나타 = new Car();
        소나타.model = "소나타";
        소나타.year = 2023;
        소나타.color = "흰색";
        소나타.isRelease = true;

        Car 아반떼 = new Car();
        아반떼.model = "아반떼";
        아반떼.year = 2021;
        아반떼.color = "회색";
        아반떼.isRelease = true;

        /**
         * 2. 각 객체의 printInfo()를 호출하여 정보 출력
         * */

        소나타.printInfo();
        아반떼.printInfo();

        /**
         * 3. 특정 차량의 출시 여부를 changeRelease()를 호출하여 변경 후 정보 출력
         * */

        소나타.changeRelease(false);
        소나타.printInfo();

        /**
         * 4. (선택) isRelease가 true인 차량만 조건문으로 골라서 별도 출력
         * */
        System.out.println("isRelease가 true인 차량의 정보를 출력합니다.");
        if(소나타.isRelease) { //소나타.isRelease = false
            소나타.printInfo();
        }
        if(아반떼.isRelease) {
            아반떼.printInfo();
        }
    }
}