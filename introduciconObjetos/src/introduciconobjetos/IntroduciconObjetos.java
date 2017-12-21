package introduciconobjetos;

import java.util.ArrayList;

public class IntroduciconObjetos {

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<Integer>(5);
        myList.add(1);
        myList.add(5);
        myList.add(3);
        myList.add(25);
        myList.add(93);
        
        for (Integer x : myList){
            System.out.println(x);
        }
    }
    
}
