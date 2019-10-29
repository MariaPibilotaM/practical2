package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

public class BillRowTest {

  private SaleItem item1;
  private SaleItem item2;
  /**
   * Methods with @Before annotations will be invoked before each test is run.
   */
  @Before
  public void setUp() {
    item1 = new SaleItem("Lauaviin", 3.50);
    item2 = new SaleItem("Lauaviin", -3.50);
  }

  @Test
  public void testRowSumWithZeroQuantity() {
    BillRow r = new BillRow(item1, 0);
    
    assertEquals(r.getRowPrice(), 0.0, 0.0001);
  }
  
  @Test
  public void testRowSumWithoutDiscount() {
    BillRow r = new BillRow(item1,7);

    assertEquals(r.getRowPrice(), item1.getCurrentPrice()*7, 0.0001);
  }

  @Test
  public void testRowSumWithDiscount() {
    BillRow r = new BillRow(item1,3,20.0);

    assertEquals(r.getRowPrice(), 2.8*3, 0.0001);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRowSumWithInvalidDiscount() {
    BillRow r = new BillRow(item1,3,2000);
    r.getRowPrice();
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRowSumWithNegativeQuantity() {
    BillRow r = new BillRow(item1,-3);
    r.getRowPrice();
  }

  @Test (expected = InvalidParameterException.class)
  public void testRowSumWithNegativePrice() {
    BillRow r = new BillRow(item2, 3);
    r.getRowPrice();
  }
}
