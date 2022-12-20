package shopfoodbe.dto;


public interface ICartDto {
    Integer getId();

    Integer getQuantity();

    String getPrice();

    double getSumPerOne();

    String getImage();

    String getName();

    Integer getProductId();
}