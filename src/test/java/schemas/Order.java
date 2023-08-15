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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}