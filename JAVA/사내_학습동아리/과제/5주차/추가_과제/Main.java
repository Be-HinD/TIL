package 심화과제;

/**
 * 싱글톤 패턴을 적용한 CarFactory 클래스를 추가하고, 객체 생성은 해당 클래스에서만 진행한다.
 * */

public class Main {

    public static void main(String[] args) {

//        CarFactory carFactory = new CarFactory();   // private 접근 오류

        Car 투싼 = new Car();
        Car 모델3 = new Car();

        CarFactory carFactory = CarFactory.getInstance();

        Car 소나타 = carFactory.createCar("소나타", 2023, "흰색", true);
        Car 아반떼 = carFactory.createCar("아반떼", 2021, "회색", true);

        System.out.println("차량 정보를 출력합니다.");
        소나타.printInfo();
        아반떼.printInfo();

    }
}
