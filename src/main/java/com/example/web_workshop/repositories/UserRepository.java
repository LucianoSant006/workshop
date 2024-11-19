package com.example.web_workshop.repositories;

import com.example.web_workshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value =
            "SELECT * FROM TB_USER " +
                    "WHERE (:id IS NOT NULL AND ID = :id) " +
                    "OR (:name IS NOT NULL AND LOWER(NAME) LIKE LOWER(CONCAT('%', :name, '%')))")
    List<User> findByIdOrNameLike(@Param("id") Long id, @Param("name") String name);
}
