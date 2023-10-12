package OOD;

public static boolean validateDiscounts(List<DiscountAssignment> assignedDiscounts, List<Customer> custoners, List<Discount> discount) {

}

class Customer {
    private int customerId;
    private float yearlySpend;
    public Customer(int customerId, float yearlySpend) {
        this.customerId = customerId;
        this.yearlySpend = yearlySpend;
    }

    public int getCustomer() {
        return customerId;
    }

    public float getYearlySpend() {
        return yearlySpend;
    }

}

class Discount{
    private int discountId;
    private int productId;
    private float dollarValue;

    public Discount(int discountId, int productId, float value) {
        this.discountId = discountId;
        this.productId = productId;
        this.dollarValue = value;
    }

    public int getDiscountId() {
        return discountId;
    }

    public int getProductId(){
        return productId;
    }

    public float getDollarValue(){
        return dollarValue;
    }

}

class DiscountAssignment{
    private int discountId;
    private int customerId;

    public DiscountAssignment(int discountId, int customerId) {
        this.discountId = discountId;
        this.customerId = customerId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public int getCustomerId() {
        return customerId;
    }
}