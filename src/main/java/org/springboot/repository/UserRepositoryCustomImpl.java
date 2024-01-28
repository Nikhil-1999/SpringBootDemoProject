package org.springboot.repository;

import org.springboot.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    // @Autowired can also be used. The @PersistenceContext annotation is part of the JPA specification and is commonly used for injecting the EntityManager in JPA-related components.
    EntityManager entityManager;

    @Transactional
    /*
     @Transactional annotation is used to indicate that a method (or a class) should be executed as a single transaction (ACID)
     Spring framework ensures that a transaction is started before the method execution and that the transaction is committed at the end of the method.
     If an exception occurs during the method execution, the transaction is rolled back.
    */
    @Override
    public User updateEmailByUsername(String username, String email) {
        User user = entityManager.createQuery("SELECT u FROM user WHERE u.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
        if (user != null) {
            user.setEmail(email);
        }
        // No explicit save or merge needed. Changes to user are automatically persisted due to @Transactional
        return user; // return updated user
    }
}
