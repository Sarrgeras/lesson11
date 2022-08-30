import java.util.Comparator;

public class LambdaRunner {

    public static void main(String[] args) {
        Comparator<Integer> integerComparator = new IntegerComparator();
        System.out.println(integerComparator.compare(25, 100));
    }

    private static class IntegerComparator implements Comparator<Integer>{



        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

}
