import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(new File("INPUT.TXT"));
        int n = scan.nextInt();
        final int d = scan.nextInt(); //значение, которое не подлежит изменению
        int[] mas = new int[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(mas));
        System.out.println("Грузоподъёмность d = "+d);
        System.out.println("Всего человек = "+n);

        int k = 0; //кол-во байдарок
        Arrays.sort(mas);

        System.out.println(Arrays.toString(mas));

        if (!((n <= 1) || (d <= 1) || (n >= 15000) || (d >= 15000))) {

            for (int i = 0; i < n - 1; i++) {
                int i_light = i;
                int i_heavy = n-1;
                if ((mas[i_light] + mas[i_heavy]) >= d) {
                    k++; i_light++;
                    i_heavy--;
                }
                else{
                    k++; i_heavy--;
                }

            }
            System.out.println("Байдарок нужно " + k);
            //String str = Integer.toString(k); // преобразование числа в строку
            String str = String.valueOf(k);    // преобразование числа в строку
            String outputFName = "OUTPUT.TXT";
            Files.writeString(Path.of(outputFName), str);
        }
        else
        System.out.println("Конец истории");
    }

}