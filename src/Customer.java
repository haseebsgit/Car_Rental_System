public class Customer {
    private String cusNo;
    private String name;

    public Customer(String cusNo, String name) {
        this.cusNo = cusNo;
        this.name = name;
    }

    public String getCusNo() {
        return cusNo;
    }

    public void setCusNo(String cusNo) {
        this.cusNo = cusNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

