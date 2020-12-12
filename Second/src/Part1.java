import java.util.Scanner;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Part1 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("请输入1~10之间的一个数：");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        long maxNumber=100000000L;
        int n = 10;
        long size=maxNumber/n;
        ExecutorService threads = Executors.newFixedThreadPool(n);
        CompletionService<Long> cs = new ExecutorCompletionService<Long>(threads);
        long time1 = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            cs.submit(new Part2(x, (i*size+1), (i+1)*size));
        }
        threads.shutdown();//关闭service
        long ans = 0L;
        for(int i=0;i<n;i++){
            try {
                ans += cs.take().get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long time2 = System.currentTimeMillis();


        System.out.println("结果："+ans);
    }

    public static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}





