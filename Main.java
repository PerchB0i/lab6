import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new CustomList<>();
        list.add(3);
        list.add(4);
        list.add(5);

        List<Integer> list2 = list.stream().filter((item) -> item > 3).collect(Collectors.toList());

        for(Integer e : list2){
            System.out.println(e);
        }

        Integer x = 4;
        Double y = 4.5;
        Class xClass = x.getClass();
        Class yClass = y.getClass();
        if(xClass.equals(yClass)) {

        }
    }
}
