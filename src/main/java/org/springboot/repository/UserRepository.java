package org.springboot.repository;


import org.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

    // Spring Data JPA interprets this method name and automatically generates the appropriate query, retrieving users by their username.
    // In case we have to give custom query we can give it like this - @Query("SELECT u from USER WHERE u.username = "lincoln")
    User findByEmail(String email);

    // The @Query annotation is used to define a JPQL (Java Persistence Query Language) query.
    // The :city parameter in the query is a named parameter that will be replaced with the actual value when the method is called.
    // Ensure that the method name follows the Spring Data JPA naming conventions, which is findAllBy<EmbeddedEntity><EmbeddedEntityProperty>.
    @Query("SELECT u FROM User u WHERE u.address.city = :city")
    List<User> findAllByAddressCity(@Param("city") String city);

}
