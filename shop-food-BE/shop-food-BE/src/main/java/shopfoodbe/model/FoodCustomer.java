package shopfoodbe.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class FoodCustomer {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_food", referencedColumnName = "id")
    private Food food;

    @Column(name = "is_delete")
    private boolean isDelete;

    public FoodCustomer() {
    }

    public FoodCustomer(Customer customer, Food food, boolean isDelete) {
        this.customer = customer;
        this.food = food;
        this.isDelete = isDelete;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
