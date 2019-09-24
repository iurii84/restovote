package restovoteApp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import restovoteApp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public User save (User user) {
        if(!user.isNew() && get(user.getId()) == null) {
            return null;
        }
        if (user.isNew()) {
            entityManager.persist(user);
            return user;
        }
        else return entityManager.merge(user);
    }



    public User get(Long userId) {
        Query query = entityManager.createNamedQuery(User.GET_BY_ID)
                .setParameter("id", userId);
        return (User) query.getSingleResult();
    }

    public User getByEmail(String email) {
        Query query = entityManager.createNamedQuery(User.GET_BY_EMAIL)
                .setParameter("email", email);
        return (User) query.getSingleResult();
    }
}
