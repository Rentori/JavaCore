package chapter20;

import java.util.Scanner;

public class FindInLineDemo {
    public static void main(String[] args) {
        String instr = "Name: Tom Age: 28 ID: 77";
        Scanner conin = new Scanner(instr);

        conin.findInLine("Age:");
        if(conin.hasNext()) {
            System.out.printf("Age: %s", conin.next());
        } else {
            System.out.println("Error!");
        }
    }
}
