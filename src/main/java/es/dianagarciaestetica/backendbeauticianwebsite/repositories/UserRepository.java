package es.dianagarciaestetica.backendbeauticianwebsite.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.dianagarciaestetica.backendbeauticianwebsite.models.User;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
