package 심화과제;

public class CarFactory {

    private static CarFactory instanse = new CarFactory();

    private CarFactory() {}

    static CarFactory getInstance() {
        return instanse;
    }

    public Car createCar(String model, int year, String color, boolean isRelease) {
        Car car = new Car();
        car.model = model;
        car.year = year;
        car.color = color;
        car.isRelease = isRelease;

        return car;
    }
}
