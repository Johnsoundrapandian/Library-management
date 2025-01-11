package comMyclass;

import java.util.Scanner;
public class DisignPattern {
    private static Scanner scanner  ;
    private DisignPattern(){

    }
    public static Scanner getInstance(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

}
