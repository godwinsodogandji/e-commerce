package bj.highfiveuniversity.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.e_commerce.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
