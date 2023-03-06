package com.bilgeadam.repository;
import com.bilgeadam.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    List<User> findAllByOrderByName();
    List<User> findByNameContainingIgnoreCase(String value);
    List<User> findByEmailContainingIgnoreCase(String value);
    List<User> findByEmailEndingWith(String value);
    Optional<User> findOptionalByEmailAndPassword(String email,String password);
    @Query(value = "select u from User u where length(u.password)>?1")
    List<User> passwordLongerThan(int value);
    @Query(value = "select u from User u where length(u.password)>:x")
    List<User> passwordLongerThan2(@Param("x") int value);
    @Query(value = "select * from tbl_user  where length(password)>:x",nativeQuery = true)
    List<User> passwordLongerThan3(@Param("x") int value);

}
