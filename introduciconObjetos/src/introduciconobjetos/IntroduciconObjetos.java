package introduciconobjetos;

import java.util.ArrayList;

public class IntroduciconObjetos {

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>(5);
        myList.add(1);
        myList.add(5);
        myList.add(3);
        myList.add(25);
        myList.add(93);

        myList.forEach((x) -> {
            System.out.println(x);
        });
        System.out.println("-" + myList.size());

        myList.trimToSize();
        myList.forEach((x) -> {
            System.out.println(x);
        });

        System.out.println(myList.size());
    }
}
