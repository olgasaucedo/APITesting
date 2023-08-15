package schemas;

public class Order {

    private Integer id;
    private Integer petId;
    private Integer quantity;

    public Order(Integer id, Integer petId, Integer quantity) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
    }
}