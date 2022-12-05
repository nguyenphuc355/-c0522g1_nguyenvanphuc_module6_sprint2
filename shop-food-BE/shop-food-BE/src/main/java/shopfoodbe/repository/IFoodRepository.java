package shopfoodbe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shopfoodbe.dto.IFoodDto;
import shopfoodbe.model.Food;

import java.util.Optional;

@Repository
public interface IFoodRepository extends JpaRepository<Food, Integer> {
    @Query(value = "select food.id as id , food.name as name ,food.status as status, " +
            "food.manufacturing as manufacturing,food.content as content, food.price as price," +
            "food.image as image from food where name like %:nameSearch% and is_delete = 0",
            countQuery = "select count(*)",
            nativeQuery = true)
    Page<IFoodDto> findAllFood(@Param("nameSearch") String name, Pageable pageable);
    @Query(value = "select * from food where id=:id and is_delete=0", nativeQuery = true)
    Optional<Food> findFoodById(@Param("id") int id);
}
