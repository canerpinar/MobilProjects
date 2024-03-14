package org.Prime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrimeApplication {
    public static void main(String[] args) {
        /*
        bir sayı asal olması için kendisinden ve birden başka sayıya kalansız bölünemiyor olması
        gerekir.Kendisinden küçük olan her sayıya bölümden kalan 0 diye kontrol etmeye kalksak gereksiz
        CPU kullanımına sebep oluruz. Bu durumnda bir sayının asal olması için kendisinden küçük olan asal
        sayılara da bölünemiyor olması gerekir. Kendisinden küçük asal sayılara kalansız bölünemiyorsa
        asal olmayan sayılara bölünmesi mümkün değildir.
         */

        List<Integer> primeNumbers = new ArrayList();
        boolean loopState = true;int i = 2;long starting = System.currentTimeMillis();
        while(loopState){
            int finalI = i;
            AtomicBoolean control = new AtomicBoolean(false);
            for(int t = 0; t < primeNumbers.size();t++){
                if(finalI % primeNumbers.get(t) == 0){
                    control.set(true);
                    break;
                }
            }
            if(control.get() == false){
                primeNumbers.add(i);
                if(i > 500_000){//500_000 için kontrol
                    loopState = false;
                }
            }
            i++;
        }
        long ending = System.currentTimeMillis();
        System.out.println("Çalışma zamanı süresi : " + TimeUnit.MILLISECONDS.toSeconds(ending - starting));
        int maxNumber = primeNumbers.stream().max(Integer::compareTo).orElse(null);
        int underFive = primeNumbers.get(primeNumbers.size() -2);
        int difference = maxNumber - underFive;
        System.out.printf("En büyük asal sayı %,d ve aradaki fark %d %n", maxNumber,difference);
    }
}
