import java.time.LocalDate;

public class SetMeal {
    String SetMeal1 = "套餐1";   //套餐1包括炸鸡1，啤酒A，果汁B
    String SetMeal2 = "套餐2";  //套餐2包括炸鸡2，啤酒A，果汁B
    double mealprice1 = 10;
    double mealprice2 = 10;
    String firedchicken1 = "炸鸡1";
    String firedchicken2 = "炸鸡2";
    static Drinks beer1 = new Beer("Beer:A",30,LocalDate.of(2020,11,5),Beer.save_time,55);
    static Drinks beer2 = new Beer("Beer:B",30,LocalDate.of(2020,11,5),Beer.save_time,60);
    static Drinks juice1 = new Juice("Juice:A",20,LocalDate.of(2020,11,5),Juice.save_time);
    static Drinks juice2 = new Juice("Juice:B",20,LocalDate.of(2020,11,5),Juice.save_time);

    public String toString(){
        return null;
    }

    public static void main(String args[]){
        System.out.println(SetMeal.beer1.name);
        System.out.println(SetMeal.beer1.cost);
        System.out.println(SetMeal.beer1.cost);
        System.out.println(SetMeal.beer1.cost);
        System.out.println(SetMeal.beer1.cost);
        System.out.println(SetMeal.beer1.cost);

    }


}
