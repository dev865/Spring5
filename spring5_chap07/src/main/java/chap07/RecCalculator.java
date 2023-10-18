package chap07;

public class RecCalculator implements Calculator{

    @Override
    public long factorial(long num){
        long start = System.currentTimeMillis();
        try {
            if (num == 0){
                System.out.println("마지막 정수1까지 계산하는중. factorial 계산 끝");
                return 1;
            } else {
                return num * factorial(num - 1);
            }
        } finally {
//            long end = System.currentTimeMillis();
//            System.out.printf("RecCalculator.factorial(%d) 실행 시간 = %d\n", num, (end - start));
        }
    }
}
