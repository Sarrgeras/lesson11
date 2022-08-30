import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRunner {
    public static void main(String[] args) {
        Set<Integer> collect = Stream.of(1, 2, 3, 3, 54, 5, 6, 67, 8, 6)
                .sorted()
                .collect(Collectors.toSet());


        List<Integer> integers = List.of(1, 2, 3, 3, 54, 5, 6, 67, 8, 6);
        IntSummaryStatistics intSummaryStatistics = integers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();

        System.out.println(intSummaryStatistics);


        IntStream.rangeClosed(0, 10).forEach(System.out::println);
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

        IntStream.iterate(0, operand -> operand < 10 ,operand -> operand + 3)
                .forEach(System.out::println);

        List<String> strings = List.of("11", "22", "33", "44");
        parallelStreamStyle();
        streamOptional();
        streamStyle(strings);
        oldStyle(strings);
    }

    public static void parallelStreamStyle(){

        Stream.of(
                        new Student(23, "SVETA"),
                        new Student(44, "Vasya"),
                        new Student(33, "Aleksandr"),
                        new Student(65, "Biba"),
                        new Student(101, "Boba")
                )
                .parallel()
                .map(Student::getAge)
                .reduce(Math::max)
                .ifPresent(System.out::println);


    }



    public static void streamOptional(){

        Optional<Student> student = Stream.of(
                        new Student(23, "SVETA"),
                        new Student(44, "Vasya"),
                        new Student(33, "Aleksandr"),
                        new Student(65, "Biba"),
                        new Student(101, "Boba")
                )
                .reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);

        student
                .orElseThrow(RuntimeException::new);
    }


    /*продублировать каждую строку
          перевести в Интержер
          вывести четные
         */

    public static void streamStyle(List<String> strings){


        strings.stream()
                .map((str) -> str + str)
                .map(Integer::valueOf)
                .filter(value -> value % 2 == 0)
                .forEach(System.out::println);
    }

    public static void oldStyle(List<String> strings){


        for (String string: strings) {
            String value = string + string;
            Integer integer = Integer.valueOf(value);
            if (integer % 2 == 0){
                System.out.println(integer);
            }
        }
    }
}
