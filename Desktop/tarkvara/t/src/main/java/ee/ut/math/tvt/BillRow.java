package ee.ut.math.tvt;

import java.security.InvalidParameterException;

public class BillRow {

    private SaleItem saleItem;

    private int soldQuantity;
    
    private double unitPrice;

    private double discountPercentage;
    
    /**
     * With no discount
     */
    public BillRow(SaleItem i, int quantity) {
        this.saleItem = i;
        this.soldQuantity = quantity;
        this.unitPrice = saleItem.getCurrentPrice();
        this.discountPercentage = 0.0;
        if (quantity < 0){
            throw new IllegalArgumentException("invalid quantity! has to be > 0!");
        }
        if (this.unitPrice < 0){
            throw new InvalidParameterException("ei!");
        }
    }
    

    /**
     * With specified discount.
     * 
     * @param discountPercentage - double value between 0.0 and 100.0
     */
    public BillRow(SaleItem i, int quantity, double _discountPercentage) {
        this.saleItem = i;
        this.soldQuantity = quantity;
        this.unitPrice = saleItem.getCurrentPrice();
        this.discountPercentage = _discountPercentage;
        if (_discountPercentage < 0.0  || _discountPercentage > 100.0) {
            throw new IllegalArgumentException("invalid discount! has to be between 0.0 and 100.0!");
        }
        if (quantity < 0){
            throw new IllegalArgumentException("invalid quantity! has to be > 0!");
        }
        if (this.unitPrice < 0){
            throw new InvalidParameterException("ei!");
        }
    }
 
    public double getRowPrice() {
        return unitPrice * (double) soldQuantity * (1.0 - discountPercentage / 100.0);
    }
    
    
}