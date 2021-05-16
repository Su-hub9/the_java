package me.baesu.java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App5 {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean present = optional.isPresent();
        System.out.println(present);

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        OnlineClass onlineClass = optional.orElse(createNewClass());
        System.out.println(onlineClass.getTitle());

        OnlineClass onlineClass2 = optional.orElseGet(App5::createNewClass);
        System.out.println(onlineClass2.getTitle());

        OnlineClass onlineClass3 = optional.orElseThrow(IllegalStateException::new);
        System.out.println(onlineClass3.getTitle());

        Optional<OnlineClass> optionalClass = optional.filter(OnlineClass::isClosed);
        System.out.println(optionalClass.isEmpty());

        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElse(Optional.empty());
        progress1.orElseThrow();

        Optional<Progress> progress2 = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New Class", false);
    }
}
