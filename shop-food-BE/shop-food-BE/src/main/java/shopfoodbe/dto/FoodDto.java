package shopfoodbe.dto;

public class FoodDto {
    private int id;
    private String name;
    private String status;
    private String manufacturing;
    private String content;
    private String price;
    private String image;

    public FoodDto() {
    }

    public FoodDto(int id, String name, String status, String manufacturing, String content, String price, String image) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.manufacturing = manufacturing;
        this.content = content;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(String manufacturing) {
        this.manufacturing = manufacturing;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
