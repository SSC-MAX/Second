import java.util.Scanner;
import java.util.ArrayList;

import java.util.List;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    double money = 100;   //余额
    static List<Drinks> beerList = new ArrayList<Drinks>();   //啤酒列表
    static List<Drinks> juiceList = new ArrayList<>();  //果汁列表

    static {
        List<String> meal = new ArrayList<>();
        meal.add("套餐1");
        meal.add("套餐2");
    }

    @Override
    //卖套餐
    public void sellMeal(String meal) {
        if (meal.equals("套餐1")){
            if (use((Beer) SetMeal.beer1 ) && use((Juice)SetMeal.juice1)){
                System.out.println("炸鸡一号出锅！");
                System.out.println("套餐1准备完毕！");
            }else{
                System.out.println("原料不足，无法准备套餐1");
            }
        }

        if (meal.equals("套餐2")){
            if (use((Beer) SetMeal.beer2 ) && use((Juice)SetMeal.juice2)){
                System.out.println("炸鸡二号出锅！");
                System.out.println("套餐2准备完毕！");
            }else{
                System.out.println("原料不足，无法准备套餐2");
            }
        }
    }

    @Override
    //进货方法
    public void getMeal(Drinks drinks) {
       try {
           System.out.println("货物金额："+drinks.cost);
           if (money - drinks.cost>=0){
               money = money-drinks.cost;
               System.out.println("账户余额："+money);
               System.out.println("进货成功！");
               if (drinks instanceof Beer){
                   beerList.add(drinks);
               }else{
                   juiceList.add(drinks);
               }
           }else{
               throw new OverdraftBalanceException("警告！货款不足！");
           }
       }catch (OverdraftBalanceException o){
           o.printError(money,drinks);
       }
    }

    //判断啤酒是否剩余，若有则在列表中删去且返回true,若无则抛出异常
    public boolean use(Beer beer) throws IngredientSortOutException{
        boolean left = false;  //判断是否有啤酒剩余
        try {
            for (int i = 0; i <beerList.size() ; i++) {
                if (beerList.get(i).name == beer.name){
                    left = true;  //查找到有啤酒剩余，设定true
                    beerList.remove(i);
                    System.out.println("饮料:"+beer.name+"准备完毕！");
                    i--;
                    break;
                }
            }
            if (left == false){
                throw new IngredientSortOutException("------警告！啤酒不足！------");
            }
        }catch (IngredientSortOutException i){
            i.printErrorBeer(beer);
        }
        return left;
    }

    //判断果汁是否剩余，若有则在列表中删去且返回true,若无则抛出异常
    public boolean use(Juice juice) throws IngredientSortOutException{
        boolean left = false;  //判断是否有啤酒剩余
        try {

            for (int i = 0; i <juiceList.size() ; i++) {
                if (juiceList.get(i).name == juice.name){
                    left = true;  //查找到有啤酒剩余，设定true
                    juiceList.remove(i);
                    System.out.println("饮料"+juice.name+"准备完毕！");
                    i--;
                    break;
                }
            }
            if (left == false){
                throw new IngredientSortOutException("------警告！果汁不足！------");
            }
        }catch (IngredientSortOutException i){
            i.printErrorJuice(juice);
        }
        return left;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        West2FriedChickenRestaurant restaurant = new West2FriedChickenRestaurant();
        beerList.add(SetMeal.beer1);
        beerList.add(SetMeal.beer2);
        juiceList.add(SetMeal.juice1);
        juiceList.add(SetMeal.juice2);
        System.out.println(beerList.size());

        System.out.println("开张！");
        System.out.println("请选择输入：");
        System.out.println("A:进货；B:售卖套餐");

        String input1 = sc.next();


        LOOP:while (!input1.equalsIgnoreCase("exit")){
            while (!input1.equals("A")&&!input1.equals("B")){
                System.out.println("输入不是A,B中的一个，请重新输入：");
                input1 = sc.next();
            }
            while (input1.equals("A")){
                System.out.println("请选择购进物品:");
                System.out.println("1:啤酒A   2:啤酒B   3:果汁A   4:果汁B");
                int input2 = sc.nextInt();
                if (input2==1){
                    restaurant.getMeal(SetMeal.beer1);
                }else{
                    if (input2==2){
                        restaurant.getMeal(SetMeal.beer2);
                    }else{
                        if (input2==3){
                            restaurant.getMeal(SetMeal.juice1);
                        }else{
                            if (input2==4){
                                restaurant.getMeal(SetMeal.juice2);
                            }else{
                                System.out.println("输入不是1，2，3，4中的一个，请重试：");
                                continue;
                            }
                        }
                    }
                }
                System.out.println("请选择：");
                System.out.println("A:进货 B:售卖套餐");
                String input3 = sc.next();
                if (input3.equalsIgnoreCase("exit")){
                    break LOOP;
                }
                while (!input3.equals("A") && !input3.equals("B")){
                    System.out.println("输入不是A，B中的一个，请重试：");
                    System.out.println("请选择：");
                    System.out.println("A:进货   B:售卖套餐");
                    input3 = sc.next();
                }
                input1 = input3;
            }

            while (input1.equals("B")){
                System.out.println("请选择售卖的套餐：");
                System.out.println("1：套餐1   2：套餐2");
                int input4 = sc.nextInt();
                if (input4 == 1){
                    restaurant.sellMeal("套餐1");
                }else{
                    if (input4 == 2){
                        restaurant.sellMeal("套餐2");
                    }else{
                        System.out.println("非法输入，请重试");
                        continue;
                    }
                }
                System.out.println("请选择：");
                System.out.println("A:进货   B:售卖套餐");
                String input5 = sc.next();
                if (input5.equalsIgnoreCase("exit")){
                    break LOOP;
                }
                while (!input5.equals("A") && !input5.equals("B")){
                    System.out.println("输入不是A,B中的一个，请重试：");
                    System.out.println("请选择：");
                    System.out.println("A:进货   B:售卖套餐");
                    input5 = sc.next();
                }
                input1 = input5;
            }
        }

        System.out.println("程序已退出");
        System.out.println("营业结束！");




    }
}
