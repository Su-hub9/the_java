package me.baesu.java8to11;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "number";
        UnaryOperator<String> hi = (s) -> "hi " + s;
        UnaryOperator<String> hi2 = Greeting::hi;
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello =  greeting::hello;
        hello.apply("baesu");

        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get(); // get을 해줘야 인스턴스가 만들어짐

        Function<String, Greeting> baeGreeting = Greeting::new;
        Greeting newGreeting2 = baeGreeting.apply("baesu");
        newGreeting2.getName(); // baesu

        // 임의의 객채의 인스턴스 메소드 참조
        String[] names = { "suji", "baesu", "whiteship" };
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

        FooIn foo = new DefaultFoo("baesu");
        foo.printName(); // baesu
        foo.printNameUpperCase(); // BAESU

        FooIn.printAnything();

        List<String> nameList = new ArrayList<String>();
        nameList.add("suji");
        nameList.add("baesu");
        nameList.add("whiteship");
        nameList.add("java8");

        nameList.forEach(System.out::println);

        Spliterator<String> spliterator = nameList.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("==================");
        while (spliterator1.tryAdvance(System.out::println));

        nameList.removeIf(s -> s.startsWith("w"));

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        nameList.sort(compareToIgnoreCase.reversed().thenComparing(String::compareToIgnoreCase));

    }
}
