package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean returnLog(int a) {
        if ((a != 0) && (a != 1)) {
            System.err.println("Ошибка: нелогическое значение");
            System.exit(-1);
            return false;
        }
        else {
            return (a == 0) ? false : true;
        }
    }
    public static boolean[] halfSum(boolean a, boolean b) {
        boolean[] result = new boolean[2];
        result[1] = a & b;
        result[0] = (a | b) & !(result[1]);
        return result;

    }

    public static void deCoder(boolean a, boolean b, boolean c) {
        List<Boolean> list = new ArrayList<>(9);
        list.add(a&b&c);
        list.add(a&b&!c);
        list.add(a&!b&c);
        list.add(a&!b&!c);
        list.add(!a&b&c);
        list.add(!a&b&!c);
        list.add(!a&!b&c);
        list.add(!a&!b&!c);
        System.out.println(list);
    }
    static boolean q = false;
    static boolean qn = false;
    public static void rsTrigger(boolean r,boolean s) {

        if (r&!s) {
            q = false;
            qn = true;
            System.out.println("Q: " + q + ", Q': " + qn);
        } else if (!r&s) {
            q = true;
            qn = false;
            System.out.println("Q: " + q + ", Q': " + qn);
        } else if (!r&!s) {
            System.out.println("Q: " + q + ", Q': " + qn);
        } else if (r&s) {
            System.err.println("Работа в хаотичном режиме");
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<=1;i++) {
            for(int j=0;j<=1;j++) {
                System.out.println("Задание номер 1:" + " Сумма= " + halfSum(returnLog(i), returnLog(j))[0] + "; Перенос= " + halfSum(returnLog(i), returnLog(j))[1]);
            }
        }

        System.out.println();

        for(int i=0;i<=1;i++){
            for(int j =0; j<=1;j++){
                for(int x =0; x<=1;x++) {
                    deCoder(returnLog(i),returnLog(j),returnLog(x));
                }
            }
        }

        System.out.println();

        for(int i=0;i<=1;i++) {
            for(int j=0;j<=1;j++) {
                rsTrigger(returnLog(i),returnLog(j));
            }
        }
    }
}