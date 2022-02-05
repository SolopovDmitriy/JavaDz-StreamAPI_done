package pack;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3, 5, 6, 8, 4, 4};
        //
        IntStream s1 = Arrays.stream(ar);
        s1 = s1.filter(in -> in % 2 == 0)
                .filter(value -> value <= 6);
        s1.forEach(value -> System.out.println(value));
        //
        //IntStream.of(1,2,5,6,4,8,5)
        System.out.println();
        int n = IntStream.of(ar).max().getAsInt();
        System.out.println(n);
        //
        List<Integer> list = Arrays.asList(10, 5, 6, 8, 8, 5);
        list.stream().forEach(System.out::println);
        //
        "qwerty".chars()
                .forEach(value -> System.out.println((char) value));
        //
        list.stream()
                //.distinct()
                //.limit(3)
                //.skip(3)
                //.sorted()
                //.sorted(Comparator.reverseOrder())
                //.unordered()//!!!
                .forEach(System.out::println);
        System.out.println();
        //User
        //Object[] array =
        User[] array = Stream.of(
                        new User("a", 18, true),
                        new User("b", 12, false),
                        new User("c", 30, true)
                )
                //.filter(user -> user.getAge() >= 18)
                //.forEach(System.out::println);
                //.toArray();
                /*.toArray(new IntFunction<User[]>() {
                    @Override
                    public User[] apply(int value) {
                        return new User[value];
                    }
                });*/
                .toArray(User[]::new);//сокращенная запись для создания массива юзеров
        //
        System.out.println(Arrays.toString(array));
        System.out.println(array.getClass());
        //
        System.out.println();
        List<User> users = Arrays.asList(
                new User("a", 18, true),
                new User("b2", 12, false),
                new User("c", 30, false)
        );
        //
        ArrayList<User> collect = (ArrayList<User>) users.stream()
                .collect(Collectors.toList());
        HashSet<User> hashSet = (HashSet<User>) users.stream()
                .collect(Collectors.toSet());
        //
        HashMap<String, User> hashMap =
                (HashMap<String, User>) users.stream()
                        .collect(Collectors.toMap(
                                User::getName, user -> user
                        ));
        System.out.println(hashMap);
        //
        List<User> collect1 = users.stream()
                .peek(user -> user.setName(user.getName() + "*"))
                .collect(Collectors.toList());
        System.out.println(collect1);
        //
        System.out.println();
        List<String> collect2 = users.stream()
                .map(User::getName)
                .filter(s -> s.matches("^[A-Za-z*]+"))
                .collect(Collectors.toList());
        System.out.println(collect2);
        System.out.println();
        //
        OptionalInt min = users.stream()
                .mapToInt(User::getAge)
                .min();
        if (min.isPresent())
            System.out.println(min.getAsInt());
        //
        int asInt = users.stream()
                .mapToInt(User::getAge).min().getAsInt();
        //
        Optional<User> first = users.stream()
                //.filter(user -> !user.isActivated())
                .filter(((Predicate<User>) User::isActivated).negate())
                .findFirst();
        if (first.isPresent())
            first.get().setActivated(true);
        System.out.println();
        //
        String s3 = users.stream()
                .map(User::getName)
                .reduce((s, s2) -> s + "\n" + s2)
                .get();
        System.out.println(s3);
        System.out.println();
        //
        list.stream()
                .map(integer -> integer * 10)
                .forEach(System.out::println);
        System.out.println();
        //
        int sum = list.stream()
                .mapToInt(value -> value)
                .sum();
        System.out.println(sum);
        System.out.println();
        //
        double av = list.stream()
                .mapToInt(value -> value)
                .average().getAsDouble();
        System.out.println(av);
        //
        Integer integer1 = list.stream()
                .reduce((integer, integer2) -> integer * integer2)
                .get();
        System.out.println(integer1);
        //
        Stream.of(
                        "Hello Java. StreamAPI".split("\\.")
                )
                .map(String::trim)
                .forEach(System.out::println);
    }
}














