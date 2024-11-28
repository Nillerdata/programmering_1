package opgaver;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class opg_8 {
    public static int max(String filename)throws IOException{
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        int maximum = Integer.MIN_VALUE;
        int next = scan.nextInt();
        while(scan.hasNext()){
            if(next > maximum){
                maximum = next;
            }
            next= scan.nextInt();
        }return maximum;
    }
    public static int min(String fileName) throws IOException{
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        int minimum = Integer.MAX_VALUE;
        int next = scan.nextInt();
        while(scan.hasNext()){
            if(next<minimum){
                minimum = next;
            }
            next = scan.nextInt();
        }return minimum;
    }
    public static double gennemsnit(String fileName) throws IOException{
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        int counter = 0;
        double gns = 0;
        while(scan.hasNext()){
            int next = scan.nextInt();
            gns += next;
            counter++;
        }return gns/counter;
    }

    public static void main(String[] args) throws IOException {
        try {
            max("tal2500.txt");
            min("tal10.txt");
            System.out.println(gennemsnit("tal10.txt"));

            System.out.println(max("tal2500.txt"));
            System.out.println(min("tal10.txt"));
        } catch (IOException e) {
            throw new IOException("we fucked up friend");
        }

    }
}
