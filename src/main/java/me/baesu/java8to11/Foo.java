package me.baesu.java8to11;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        // 익명 내부 클래스에서 자동완성 키를 누르면 람다식으로 바꿔줌.
        RunSomething runSomething = (number) -> {
            return number + 10;
        };

        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        plus10.apply(1); // 11
        plus10.andThen(multiply2).apply(2); // 24
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        multiply2AndPlus10.apply(2); // 14

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        Predicate<String> startsWithBaesu = (s) -> s.startsWith("baesu");
        Predicate<Integer> isOdd = (i) -> i % 2 == 0;

        UnaryOperator<Integer> plus20 = (i) -> i + 20;
        BinaryOperator<Integer> sum = (a, b) -> a + b;
    }

    private void run() {
        final int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11 : 쉐도잉 발생
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };
        printInt.accept(10);
    }
}
