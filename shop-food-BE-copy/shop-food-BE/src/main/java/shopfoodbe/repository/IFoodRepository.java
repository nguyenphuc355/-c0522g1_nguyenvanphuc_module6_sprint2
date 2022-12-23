package shopfoodbe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shopfoodbe.dto.ICartDto;
import shopfoodbe.dto.IFoodDto;
import shopfoodbe.dto.ITotalDto;
import shopfoodbe.model.Customer;
import shopfoodbe.model.Food;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IFoodRepository extends JpaRepository<Food, Integer> {
    @Query(value = "select food.id as id , food.name as name ,food.status as status, " +
            "food.manufacturing as manufacturing,food.content as content, food.price as price," +
            "food.image as image from food where name like %:nameSearch% and is_delete = 0",
            countQuery = "select count(*) from food where name like %:nameSearch% and is_delete = 0",
            nativeQuery = true)
    Page<IFoodDto> findAllFood(@Param("nameSearch") String name, Pageable pageable);

    @Query(value = "select * from food where id=:id and is_delete=0", nativeQuery = true)
    Optional<Food> findFoodById(@Param("id") int id);

    @Query(value = "select * from food where food_type_id = 1 and name like %:nameSearch% and is_delete=0", nativeQuery = true)
    Page<IFoodDto> findVegetable(@Param("nameSearch") String name, Pageable pageable);

    @Query(value = "select * from food where food_type_id = 2 and name like %:nameSearch% and is_delete=0", nativeQuery = true)
    Page<IFoodDto> findAllMeat(@Param("nameSearch") String name, Pageable pageable);

    @Query(value = "select * from food where food_type_id = 3  and name like %:nameSearch% and is_delete=0", nativeQuery = true)
    Page<IFoodDto> findAllFruit(@Param("nameSearch") String name, Pageable pageable);

    @Query(value = "select * from food where food_type_id = 4 and name like %:nameSearch% and is_delete=0", nativeQuery = true)
    Page<IFoodDto> findOther(@Param("nameSearch") String name, Pageable pageable);

    @Query(value = "select (order_detail.quantity*food.price) as sumPerOne, food.id, order_detail.quantity, " +
            "food.name, food.price, food.image as image " +
            "from order_detail " +
            "join customer on customer.id = order_detail.id_customer " +
            "join food on order_detail.id_food = food.id " +
            "where order_detail.id_customer = :customerId and order_detail.is_delete = 0 " +
            "and order_detail.is_pay = 0 " +
            "group by food.id ", nativeQuery = true)
    List<ICartDto> getCartList(Integer customerId);

    @Query(value = "select * from customer where username = :username and is_delete = 0", nativeQuery = true)
    Customer findCartId(@Param("username") String username);

    @Query(value = "select sum(order_detail.quantity*food.price) as totalBill, count(order_detail.id_food) as countProduct " +
            "from order_detail " +
            "join food on order_detail.id_food = food.id " +
            "where order_detail.id_customer = :customerId and order_detail.is_delete = 0  ", nativeQuery = true)
    ITotalDto getTotalBill(Integer customerId);

    @Modifying
    @Query(value = "update order_detail set quantity = quantity + 1 " +
            "where order_detail.id_food = :id and is_delete = 0", nativeQuery = true)
    void updateProductCart(@Param("id") Integer id);



    @Modifying
    @Query(value = "insert into order_detail(date_payment, id_customer,id_food, quantity) values(now(),:cartId, :id, 1) ", nativeQuery = true)
    void insertProductToCart(@Param("id") Integer id,
                             @Param("cartId") Integer cartId);

    @Query(value = "select food.id, customer.username as username from order_detail " +
            "join food on order_detail.id_food = food.id " +
            "join customer on customer.id = order_detail.id_customer " +
            "where order_detail.id_food = :id and customer.username = :username and order_detail.is_delete = 0", nativeQuery = true)
    IFoodDto findByIdProduct(@Param("id") Integer id,
                             @Param("username") String username);

    @Modifying
    @Query(value = "update order_detail set quantity = :quantity " +
            "where order_detail.id_food = :id and id_customer = :customerId and is_delete = 0", nativeQuery = true)
    void updateQty(Integer id, Integer quantity, Integer customerId);

    @Modifying
    @Query(value = "delete from order_detail " +
            "where id_food = :id", nativeQuery = true)
    void deleteProduct(Integer id);

    @Modifying
    @Query(value = "update order_detail set is_pay = 1 where id_customer =:customerId ", nativeQuery = true)
    void payment(@Param("customerId") Integer customerId);

    @Query(value = "select customer.name as customerName, food.name , " +
            " order_detail.date_payment as datePayment, food.price as price, " +
            "order_detail.quantity as quantity, food.image as image, " +
            "(food.price * order_detail.quantity) as sumPerOne " +
            "from order_detail " +
            "join customer on order_detail.id_customer = customer.id " +
            "join food on food.id = order_detail.id_food " +
            "where username = :username and order_detail.is_delete = 0 and is_pay = 1 ", nativeQuery = true)
    List<ICartDto> findAllHistory(@Param("username") String username);
}
