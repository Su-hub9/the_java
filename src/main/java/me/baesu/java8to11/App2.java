package me.baesu.java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App2 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("suji");
        names.add("baesu");
        names.add("whiteship");
        names.add("foo");

        List<String> collect = names.stream()
                .map(String::toUpperCase)       // 중개 오퍼레이션
                .collect(Collectors.toList());  // 종료 오퍼레이션
        // 종료 오퍼레이션이 없으면 중개 오퍼레이션은 실제 동작하지 않고 정의만 되어 있는 것이다.
        collect.forEach(System.out::println);

        names.forEach(System.out::println);

        // 병렬처리가 어려움
        for (String name : names) {
            if (name.startsWith("w")) {
                System.out.println(name.toUpperCase());
            }
        }

        // 스레드가 분리되어 병렬처리됨. 병렬처리 된다고 무조건 빠른 것은 아니다.
        // 데이터가 정말 방대한 경우가 아니면 그냥 stream을 쓰는 것이 비용이 덜 들수도 있다.
        List<String> collect1 = names.parallelStream().map((s) -> {
            System.out.println(s + "" + Thread.currentThread().getName());
            return s.toLowerCase();
        }).collect(Collectors.toList());
        collect1.forEach(System.out::println);
    }
}
