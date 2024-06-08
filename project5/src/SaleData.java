import java.util.ArrayList;
import java.util.List;

public class SaleData 
{
    public int saleId;
    public String title;
    public int quantity;
    public double price;

    public SaleData(int saleId, String title, int quantity, double price) {
        this.saleId = saleId;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
}