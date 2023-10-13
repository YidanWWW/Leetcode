import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Print output to STDOUT. Your class should be named Solution. */
    }
    public static boolean validateDiscounts(List<DiscountAssignment> assignedDiscounts, List<Customer> customers, List<Discount> discounts) {
       //do we need to check input? do we need to consider empty list
       
       //validate 1 2
       //key: customerId, value: this customer's discount number
       Map<Integer, Integer> customerDiscountNumberMap = new HashMap<>(); 
       //HashSet to store assigned discount
       Set<Integer> assignedDiscountSet = new HashSet<>();
       for(DiscountAssignment da : assignedDiscounts) {
           int customerId = da.getCustomerId();
           int discountId = da.getDiscountId();
           customerDiscountNumberMap.put(customerId, customerDiscountNumberMap.getOrDefault(customerId, 0)+1);
           assignedDiscountSet.add(discountId);
           if(customerDiscountNumberMap.get(customerId)>3) return false;
        } 
        
        HashMap<Integer, Discount> discountMap = new HashMap<>();
        //go through discounts list, to check if there is unassigned discount
        for(Discount d : discounts) {
            int discountId = d.getDiscountId();
            discountMap.put(discountId, d); //build discountMap
            //check if this set countain current discountId,
            if(!assignedDiscountSet.contains(discountId)) return false;
        }
        
        //build customerMap
        HashMap<Integer, Customer> customerMap = new HashMap<>();
        for(Customer c : customers) {
            customerMap.put(c.getCustomerId(), c);
        }
        
        //validate 3
        //HashMap key:customerId, value: total discount value
        HashMap<Integer, Float> customerDiscountValueMap = new HashMap<>();
        for(DiscountAssignment da: assignedDiscounts) {
            int discountId = da.getDiscountId();
            int customerId = da.getCustomerId();
            //we wanna know this discount' value, and add it to custimerDiscountValueMap
            //so we need Discount
            Discount discount = discountMap.get(discountId);
            float value = discount.getValue();
            customerDiscountValueMap.put(customerId, customerDiscountValueMap.getOrDefault(customerId, 0.0f)+value);
            Customer customer = customerMap.get(customerId);
            float yearlySpend = customer.getYearlySpend();
            //compare total discount value with this customer's yearly spend
            if(customerDiscountValueMap.get(customerId)>yearlySpend*0.2) {
                return false;
            }
        }
        
        //validate 4
        // use customerDiscountValueMap and customers list，sort 
    
    }
    
  

    //inner class
    class Customer {
        private int customerId;
        private float yearlySpend; //means money spent pre year
        
        public Customer(int customerId, float yearlySpend) {
            this.customerId = customerId;
            this.yearlySpend = yearlySpend;
        }
        //get method
        public int getCustomerId() {
            return customerId;
        }
        public float getYearlySpend() {
            return yearlySpend;
        }
    }
    
    class Discount {
        private int discountId;
        private float dollarValue;
        
        public Discount(int discountId, float value) {
            this.discountId = discountId;
            this.dollarValue = value;
            //this.productId = productId;
        }
        
        public int getDiscountId() {
            return discountId;
        }
        public float getValue() {
            return dollarValue;
        }
        
    }
    
    class DiscountAssignment {
        private int customerId;
        private int discountId;
        
        public DiscountAssignment(int customerId, int discountId) {
            this.customerId = customerId;
            this.discountId = discountId;
        }
        
        public int getCustomerId() {
            return customerId;
        }
        public int getDiscountId() {
            return discountId;
        }
    }
}
