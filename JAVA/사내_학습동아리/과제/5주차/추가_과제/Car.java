package 심화과제;

class Car {

    String model;   //차량 모델명 (예: 아반떼, 소나타)
    int year;   //출시 연도 (예: 2023)
    String color;   //차량 색상 (예: 흰색, 검정)
    boolean isRelease;  //현재 출시 여부

    public void printInfo() {
        System.out.println("[ 차량 정보 ]");
        System.out.println("모델명    : " + this.model);
        System.out.println("연도      : " + this.year);
        System.out.println("색상      : " + color);
        System.out.println("출시여부   : " + isRelease);

        System.out.println();
    }

    public void changeRelease(boolean val) {
        isRelease = val;
    }

}
