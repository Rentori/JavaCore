package chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

class  NamePhoneEmail {
    String name;
    String phonenum;
    String email;

    NamePhoneEmail (String name,  String phonenum, String email) {
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}

class NamePhone {
    String name;
    String phonenum;

    public NamePhone(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}

public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@gmail.com"));
        myList.add(new NamePhoneEmail("James", "555-4444", "James@gmail.com"));
        myList.add(new NamePhoneEmail("Mary", "444-5445", "Mary@gmail.com"));

        System.out.println("Original list elements: ");;
        myList.stream().forEach((a) -> {
           System.out.println(a.name + " " + a.phonenum + " " + a.email);
        });
        System.out.println();

        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
        System.out.println("List of names and phonenums: ");
        nameAndPhone.forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum);
        });
    }
}
