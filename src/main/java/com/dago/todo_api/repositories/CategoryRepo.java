package com.dago.todo_api.repositories;

import com.dago.todo_api.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    List<Category> findCategoriesByUser_Id(long userId);

    @Query("select c from Category c inner join Todo t on t.category.id= c.id where t.startDate >= :startDate and t.startDate <= :endDate and c.user.id = :userId ")
    List<Category> getAllTodosByCategoriesForToday(@Param("startDate")ZonedDateTime startDate,
                                                   @Param("endDate") ZonedDateTime endDate, @Param("userId") Long userId);


}
