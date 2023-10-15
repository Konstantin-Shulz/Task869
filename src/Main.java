import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] mas = readNumberFromF("INPUT.TXT");
        int n = mas.length;
        int d = mas[0];
        int k = 0; //кол-во байдарок
        System.out.println(Arrays.toString(mas));

        if (!((n <= 1) || (d <= 1) || (n >= 15000) || (d >= 15000))) {
            //bubbleSort(mas);
            System.out.println(Arrays.toString(mas));
            for (int i = 0; i < mas.length-1; i++) {
                if ( (mas[i + 1] + mas[i]) > n) {
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
            int n = scan.nextInt()+1;
            int[] mas = new int[n];
            for (int i = 0; i < mas.length; i++) {
                mas[i] = scan.nextInt();
            }
            return mas;
        }

    public static void bubbleSort(int[] arr)    {
        boolean isSorted=false;
        for (int i=0; i< arr.length-1 && !isSorted; i++ )  {
            isSorted = true;
            for (int k=0; k+1< arr.length-i; k++) {
                if( arr[k] > arr[k+1])
                {
                    int tmp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = tmp;
                    isSorted=false;
                }
            }
        }
    }
}