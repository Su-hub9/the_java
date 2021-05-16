package me.baesu.java8to11;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App4 {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        OnlineClass spring_boot = new OnlineClass(1, "spring boot",true);
        /*Progress progress = spring_boot.getProgress();
        if (progress != null) {
            System.out.println(progress.getStudyDuration());
        }*/
        Optional<Progress> progress = spring_boot.getProgress();
        progress.ifPresent(p -> System.out.println(p.getStudyDuration()));

    }
}
