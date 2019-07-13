package restovoteApp.repository;

import org.springframework.stereotype.Repository;
import restovoteApp.model.Meal;
import restovoteApp.repository.repositoryInterfaces.MealRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MockInterfaceImpl implements MealRepositoryInterface {

    @Override
    public Meal save(Meal meal, Long userId, Long restoId) {
        return null;
    }

    @Override
    public boolean delete(Long id, Long userId) {
        return false;
    }

    @Override
    public Meal get(Long id) {
        return null;
    }

    @Override
    public List getByRestaurant(Long restoId) {
        List<String> ls = new ArrayList<>();
        String s = "getByRestaurant function";
        String anotherString = "Another String";
        ls.add(s);
        ls.add(anotherString);
        return ls;
    }
}
