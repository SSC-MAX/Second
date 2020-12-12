import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Drinks {
    protected String name;    //名字
    protected double cost;    //成本
    protected LocalDate product_date;  //生产日期
    protected int save_time;      // 保质期

    //全参构造方法：
    public Drinks(String name,double cost, LocalDate product_date,int save_time){}

    //判断是否过期方法，参数依次为生产日期，保质期与当前日期，若过期则返回true,否则返回false
    public boolean save_flag(LocalDate product_date, int save_time,LocalDate today){
        if (ChronoUnit.DAYS.between(product_date,today) > save_time){
            return true;
        }else {
            return false;
        }
    }

    public abstract String toString();
}
