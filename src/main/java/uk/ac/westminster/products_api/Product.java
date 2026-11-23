package uk.ac.westminster.products_api;

public abstract class Product {
    private Long id;
    private String name;
    private double price;

    // Still needed: subclasses call these through super(...),
    // and Jackson uses the no-arg one on the subclasses.
    public Product() {
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // No body, no default. Product cannot answer this meaningfully,
    // so every concrete subclass MUST answer it.
    public abstract String getSummary();

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
}
