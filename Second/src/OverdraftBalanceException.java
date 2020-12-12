//过期异常类
public class OverdraftBalanceException extends RuntimeException{
    public OverdraftBalanceException(String ErrorMessage){
        super(ErrorMessage);
        System.out.println(ErrorMessage);
    }

    public void printError(double money, Drinks drinks){
        double subtract = drinks.cost - money;
        System.out.println("差额："+subtract);
    }
}
