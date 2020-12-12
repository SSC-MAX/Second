import java.time.LocalDate;

public  class Beer extends Drinks {
    float degree;     //度数
    static int save_time = 30; //保质期




    public Beer(String name, double cost, LocalDate product_date, int save_time, float degree) {
        super(name, cost, product_date, save_time);
        this.name = name;
        this.cost = cost;
        this.product_date = LocalDate.now();
        save_time = this.save_time;
    }


    @Override
    public String toString() {
        return null;
    }


}