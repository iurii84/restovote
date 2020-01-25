//package restovote;
//
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import restovote.controller.MealController;
//import restovote.model.Meal;
//import restovote.repository.MealRepository;
//
//public class Runner {
//    private static ClassPathXmlApplicationContext springContext;
//    private static MealController mealController;
//
//
//    private static Meal meal_1 = new Meal(null, "description_1", 2000L);
//    private static Meal meal_2 = new Meal(null, "description_2", 3000L);
//    private static Meal meal_3 = new Meal(null, "description_3", 4000L);
//
//    public static void main(String[] args) {
////        springContext = new ClassPathXmlApplicationContext("spring-db.xml");
////        mealController = springContext.getBean(MealRestController.class);
//
//
//
//
//
//        MealRepository repo = new MealRepository();
//        repo.save(meal_1, 1L, 1L);
//        repo.save(meal_2, 2L, 2L);
//        repo.save(meal_3, 3L, 3L);
//    }
//
//}
