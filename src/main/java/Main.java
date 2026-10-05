import java.util.Scanner;

class Car {
    private final String name;
    private final int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

class Race {
    private static final int RACE_DURATION_HOURS = 24;

    public Car winner(Car[] cars) {

        Car winner = null;
        int maxDistance = 0;

        for (Car car : cars) {
            int distance = car.getSpeed() * RACE_DURATION_HOURS;
            if (distance > maxDistance) {
                maxDistance = distance;
                winner = car;
            }
        }
        return winner;
    }

}

public class Main {
    static final int MIN_SPEED = 0;
    static final int MAX_SPEED = 250;
    static final int CAR_COUNTS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car[] cars = new Car[CAR_COUNTS];
        for (int i = 0; i < CAR_COUNTS; i++) {
            System.out.println("Машина №" + (i + 1));
            String name = nameCar(scanner);
            int speed = speedCar(scanner);
            cars[i] = new Car(name, speed);
        }

        Race race = new Race();
        Car winner = race.winner(cars);
        System.out.println("Самая быстрая машина -" + winner.getName());
        scanner.close();
    }

    private static String nameCar(Scanner scanner) {
        while (true) {
            System.out.println("Введите название машины");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Ошибка: - Название машины не может быть пустым");
            } else {
                return name;
            }
        }
    }

    private static int speedCar(Scanner scanner) {
        while (true) {
            System.out.println("Введите скорость машины в пределах от " + MIN_SPEED + " до " + MAX_SPEED);

            if (scanner.hasNextInt()) {
                int speed = scanner.nextInt();
                scanner.nextLine();

                if (speed >= MIN_SPEED && speed <= MAX_SPEED) {
                    System.out.println("Скорость " + speed + "!");
                    return speed;
                } else {
                    System.out.println("Ошибка: - Скорость введена неверно, необходимо ввести в пределах от " + MIN_SPEED + " до " + MAX_SPEED);
                    scanner.next();
                }
            }
        }
    }
}