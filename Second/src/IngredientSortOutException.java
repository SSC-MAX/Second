// 果汁或啤酒售完的异常类
public class IngredientSortOutException extends RuntimeException {
    public IngredientSortOutException(String ErrorMessage){
        super(ErrorMessage);
        System.out.println(ErrorMessage);
    }

    public void printErrorBeer(Beer beer){
        System.out.println(beer.name+"不足！");
    }

    public void printErrorJuice(Juice juice){
        System.out.println(juice.name+"不足！");
    }

}
