import java.math.BigDecimal;

public class Device  extends  Product {
    private String brand;
    private String color;
    private boolean isNew;
    private String memory;

    public Device(String name, String description, BigDecimal price, String brand, String color, boolean isNew, String memory) {
        super(name, description, price);
        this.brand = brand;
        this.color = color;
        this.isNew = isNew;
        this.memory = memory;
    }

    public Device() {
    }

    @Override
    public Product[] addNewProduct(Product[] products) {
        return new Product[0];
    }

    @Override
    public void getProducts(Product[] products) {
        for (Product product : products) {
            if (product instanceof Device device){
                System.out.println(device);
            }

        }

    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}
