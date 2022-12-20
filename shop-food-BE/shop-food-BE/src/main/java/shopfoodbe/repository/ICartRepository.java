package shopfoodbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import shopfoodbe.dto.ICartDto;
import shopfoodbe.dto.ITotalDto;
import shopfoodbe.model.Cart;

import java.util.List;

@Transactional
public interface ICartRepository extends JpaRepository<Cart, Integer> {
    @Query(value = "select (cart.quantity*food.price) as sumPerOne, cart.id, cart.quantity, " +
            "food.name, food.price, food.image as image, food.id as productId " +
            "from cart " +
            "join food on cart.food_id = food.id " +
            "where cart.is_delete = 0 " +
            "group by food.id", nativeQuery = true)
    List<ICartDto> getCartList();

    @Query(value = "select sum(cart.quantity*food.price) as totalBill " +
            "from cart " +
            "join food on cart.food_id = food.id " +
            "where cart.is_delete = 0 ", nativeQuery = true)
    ITotalDto getTotalBill();

    @Modifying
    @Query(value = "update cart set quantity = quantity + 1 " +
            "where food_id = :id and is_delete = 0", nativeQuery = true)
    void updateCart(@Param("id") Integer id);

    @Modifying
    @Query(value = "insert into cart(food_id, quantity) values(:id, 1) ", nativeQuery = true)
    void insertToCart(@Param("id") Integer id);

    @Query(value = "select * from cart where food_id = :id and is_delete=0", nativeQuery = true)
    ICartDto findByIdCosmetic(@Param("id") Integer id);

    @Modifying
    @Query(value = "update cart set quantity = :qty " +
            "where id = :id and is_delete = 0", nativeQuery = true)
    void updateQty(Integer id, Integer qty);

    @Modifying
    @Query(value = "delete from cart " +
            "where id = :id", nativeQuery = true)
    void deleteProduct(Integer id);
}
