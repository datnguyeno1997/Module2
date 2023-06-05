package ArrayAndLinkedList;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    private boolean isAscending = true;
    public PriceComparator(boolean isAscending){
        this.isAscending = isAscending;
    }
    @Override
    public int compare(Product o1, Product o2) {
        if (isAscending)
            return Integer.compare(o1.getPrice(), o2.getPrice());
        else return Integer.compare(o2.getPrice(),o1.getPrice());
    }
}