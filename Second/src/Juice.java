import java.sql.Time;
import java.time.LocalDate;

public  class Juice extends Drinks {
    static int save_time = 2;   //保质期

    public Juice(String name, double cost, LocalDate product_date, int save_time) {
        super(name, cost, product_date, save_time);
        this.name = name;
        this.cost = cost;
        this.product_date = product_date;
        save_time = this.save_time;
    }

    @Override
    public String toString() {
        return null;
    }
}