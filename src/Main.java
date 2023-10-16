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
        int i_light = 0; // самый легкий по весу человек TODO:после сортировки
        int i_heavy = n-1;// самый тяжелый по весу человек TODO:после сортировки

        System.out.println(Arrays.toString(mas));

            if (!((n <= 1) || (d <= 1) || (n >= 15000) || (d >= 15000)||(mas[i_heavy])>d)) {

                while ((i_light <= i_heavy)){

                    if ((mas[i_light] + mas[i_heavy]) <= d) {
                        k++;
                        i_light++;
                        i_heavy--;
                    }
                    else{
                        k++;
                        i_heavy--;
                    }
                }
                System.out.println("Байдарок нужно = "+k);
            }
            else
            System.out.println("Конец истории или все не уедут");
        String outputFName = "OUTPUT.TXT";//запись в файл результата
        //Integer.toString(k);            // преобразование числа в строку
        //String.valueOf(k);              // преобразование числа в строку
        Files.writeString(Path.of(outputFName), String.valueOf(k));
    }
}