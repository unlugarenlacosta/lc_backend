package com.unlugarenlacosta.interfaces;

import com.unlugarenlacosta.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Metodo para buscar un usuario por su username
    User findByUsername(String username);
    // metodo para buscar un usuario por su email
    User findByEmail(String email);

}
