package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user5 = new User("Dima", "Medvedev", "Medved@mail.ru");
        Car car5 = new Car("Aurus", 1);
        userService.add(user5, car5);
        user5.setCar(car5);

        User user1 = new User("Aleksey", "Ivanov", "Aleksey@mail.ru");
        Car car1 = new Car("Mazda", 3);
        user1.setCar(car1);
        userService.add(user1, car1);

        User user2 = new User("Donald", "Tramp", "Trampampam@mail.ru");
        Car car2 = new Car("BMW", 7);
        userService.add(user2, car2);
        user2.setCar(car2);

        User user3 = new User("Tom", "Soyer", "Tom@mail.ru");
        Car car3 = new Car("HAVAL", 7);
        userService.add(user3, car3);
        user3.setCar(car3);

        User user4 = new User("Vova", "Putin", "Putin@mail.ru");
        Car car4 = new Car("Aurus", 1);
        userService.add(user4, car4);
        user4.setCar(car4);
        System.out.println("--------------------------------------------------------------");

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user.getCar());
        }
        System.out.println("--------------------------------------------------------------");

        String searchModel = "Aurus";
        int searchSeries = 1;
        List<User> userByCar = userService.userByCar(searchModel, searchSeries);
        System.out.println("Авто марки " + searchModel + ", серии " + searchSeries + "  есть в автопарке у:");
        for (User user : userByCar) {
            System.out.println(user);
        }

        context.close();
    }
}
