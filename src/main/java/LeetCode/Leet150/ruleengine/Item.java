package LeetCode.Leet150.ruleengine;

class Item {
    private final int productId;
    private final Categroy categroy;
    private  int quantity;

    public Item(Categroy categroy, int productId, int quantity) {
        this.categroy = categroy;
        this.productId = productId;
        this.quantity = quantity;
    }

    public void incrementQuatity() {
        this.quantity++;
    }

    public int getProductId() {
        return productId;
    }

    public Categroy getCategroy() {
        return categroy;
    }

    public int getQuantity() {
        return quantity;
    }

}

