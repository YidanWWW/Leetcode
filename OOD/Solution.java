import java.util.*;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Print output to STDOUT. Your class should be named Solution. */
        
    }
    public static boolean validateDiscounts(List<DiscountAssignment> assignedDiscounts, List<Customer> customers, List<Discount> discounts) {
        //should we check input?
        //validation 1
        Map<Integer, Integer> customerDiscountNumberMap = new HashMap<>();
        Set<Integer> assignedDiscountSet = new HashSet<>();
        for(DiscountAssignment da : assignedDiscounts) {
            int customerId = da.getCustomerId();
            int discountId = da.getDiscountId();
            customerDiscountNumberMap.put(customerId, customerDiscountNumberMap.getOrDefault(customerId, 0)+1);
            assignedDiscountSet.add(discountId);
            //check the value
            if(customerDiscountNumberMap.get(customerId)>3) return false;
        }
        
        //HashSet to store all the assigned discounts, then go through discounts list, if there is any discount did't contain in this hashset, return false
        for(Discount d : discounts) {
            int discountId = d.getDiscountId();
            if(!assignedDiscountSet.contains(discountId)) return false;
        }
        //hashmap, key: discountId value:discount Object
        Map<Integer, Discount> discountMap = new HashMap<>();
        for(Discount d : discounts) {
            discountMap.put(d.getDiscountId(), d);
        }
        
        Map<Interger, Customer> customerMap = new HashMap<>();
        for(Customer c : customers) {
            customerMap.put(c.getCustomerId(), c);
        }
        
        //HashMap key:customerId, value:this customer's total discount value
        //go through assignedDiscount list
        Map<Integer, Float> customerDiscountValueMap = new HashMap<>();
        for(DiscountAssignment da : assignedDiscounts) {
            //we should add assigned discount value, and add it to this map' value
            int discountId = da.getDiscountId();
            int customerId = da.getCustomerId();
            //find this discount's value
            Discount discount = discountMap.get(discountId);
            float value = discount.getValue();
            Customer customer = customerMap.get(customerId); 
            float yealySpend = customer.getYearlySpend();
            //add this value to map'value
            customerDiscountValueMap.put(customerId, customerDiscountValueMap.getOrDefault(customerId, 0.0f)+value);
            //compare total discount value with 20% yealy spend 
            if(customerDiscountValueMap.get(customerId)>0.2*yealySpend) return false;
        }
        
        //validation 4
        //sort customer arraylist based on the yealyspend in ascending order
        Collections.sort(customers, (a,b)->Float.compare(a.getYearlySpend(), b.getYearlySpend()));
        //sort hashmap based on the total discount value
        
        List<Map.Entry<Integer, Float>> sortByValue = new ArrayList<>(customerDiscountValueMap.entrySet());
        Collections.sort(sortByValue, (a,b)->Float.compare(a.getValue(), b.getValue()));
        
        // Collections.sort(customers, (a,b)->Float.compare(a.getYearlySpend(), b.getYearlySpend()));
        // Collections.sort(sortByValue, (a,b)->Float.compare(a.getValue(), b.getValue()));
        
        
        //compare this two list, check if the customer order is same
        for(int i=0; i<customers.size(); i++) {
            int customerId1 = customers.get(i).getCustomerId();
            int customerId2 = sortByValue.get(i).getKey();
            if(customerId1 != customerId2 ) return false;
        }
        
        return true;
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
