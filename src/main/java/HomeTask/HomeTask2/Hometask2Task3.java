package HomeTask.HomeTask2;
//Инициализировать две переменные. Поменять их значения местами
public class Hometask2Task3 {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int c = a;
        a = b;
        b = c;
        System.out.printf("a = %d, b = %d%n", a, b);
//* Инициализировать две переменные. Поменять их значения местами(не вводя третью)
        int d = 1;
        int e = 10;
        d = d + e;
        e = d - e;
        d = d - e;
        System.out.printf("d = %d, e = %d", d, e);


    }


}
