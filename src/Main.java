import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //int[] mas = readNumberFromF("INPUT.TXT");

        Scanner scan = new Scanner(new File("INPUT.TXT"));
        int n = scan.nextInt();
        int d = scan.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(mas));
        System.out.println("d = "+d);
        System.out.println("n = "+n);
        //int n = mas.length;
        //int d = mas[0];
        int k = 0; //кол-во байдарок


        if (!((n <= 1) || (d <= 1) || (n >= 15000) || (d >= 15000))) {

            for (int i = 1; i < mas.length - 1; i++) {
                if ((mas[i] + mas[i + 1]) < d) {
                    k++;
                    System.out.println("Байдарок Нужно " + k);
                    String str = Integer.toString(k); // преобразование числа в строку
                    String outputFName = "OUTPUT.TXT";
                    Files.writeString(Path.of(outputFName), str);
                }
            }
        }
        else
        System.out.println("Конец истории");
    }
    private static int[] readNumberFromF (String fileName) throws FileNotFoundException {
            Scanner scan = new Scanner(new File(fileName));
            int n = scan.nextInt();
            int[] mas = new int[n];
            for (int i = 0; i < mas.length; i++) {
                mas[i] = scan.nextInt();
            }
            return mas;
        }
}