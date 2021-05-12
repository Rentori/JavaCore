package chapter29;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class  NamePhoneEmail2 {
    String name;
    String phonenum;
    String email;

    NamePhoneEmail2 (String name,  String phonenum, String email) {
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}

class NamePhone2 {
    String name;
    String phonenum;

    public NamePhone2(String name, String phonenum) {
        this.name = name;
        this.phonenum = phonenum;
    }
}


public class StreamDemo7 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail2> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail2("Larry", "555-5555", "Larry@gmail.com"));
        myList.add(new NamePhoneEmail2("James", "555-4444", "James@gmail.com"));
        myList.add(new NamePhoneEmail2("Mary", "444-5445", "Mary@gmail.com"));

        System.out.println("Original list elements: ");;
        myList.stream().forEach((a) -> {
            System.out.println(a.name + " " + a.phonenum + " " + a.email);
        });
        System.out.println();

        Stream<NamePhone2> nameAndPhone = myList.stream().map((a) -> new NamePhone2(a.name, a.phonenum));
        System.out.println("List of names and phonenums: ");


        List<NamePhone2> npList = nameAndPhone.collect(Collectors.toList());

        System.out.println("Имена и номера телефонов в списке типа List: ");
        for (NamePhone2 e: npList) {
            System.out.println(e.name + " " + e.phonenum);
        }

        nameAndPhone = myList.stream().map((a) -> new NamePhone2(a.name, a.phonenum));
        Set<NamePhone2> npList2 = nameAndPhone.collect(Collectors.toSet());
        System.out.println("Тип set: ");
        for (NamePhone2 a: npList2) {
            System.out.println(a.name + " " + a.phonenum);

        }
    }
}
