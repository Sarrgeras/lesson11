import java.util.Comparator;

public class LambdaRunner {

    public static void main(String[] args) {
        //Comparator<Integer> integerComparator = (o1, o2) -> Integer.compare(o1, o2);

        Comparator<Integer> integerComparator = Integer::compare;

        System.out.println(integerComparator.compare(215, 100));
    }

//    private static class IntegerComparator implements Comparator<Integer>{



//        @Override
//
//        //[модификаторы] возвращение название ([параметры])
//        compare(Integer o1, Integer o2) ->  {
//            return Integer.compare(o1, o2);
//        }
//    }

}
