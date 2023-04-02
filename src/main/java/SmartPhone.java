public class SmartPhone extends Product {
    private String vendor;

    public SmartPhone(int id, String title, int price, String vendor) {
        super(id, title, price);
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }
}
