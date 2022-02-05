package homeTask;

import pack.User;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
        task4();
    }


    public static void task1(){
//        Создайте коллекцию ArrayList<Person> и заполните ее разными
//        объектами Person. Создайте стрим из коллекции.
//        С помощью Stream API, получите коллекцию всех работоспособных
//        людей с учетом того что женщины выходят на пенсию с 60 а мужчины с
//        65. Минимальный рабочий возраст – 18.

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Alex", 35, Person.Gender.MALE));
        persons.add(new Person("Peter", 11, Person.Gender.MALE));
        persons.add(new Person("John", 33, Person.Gender.MALE));
        persons.add(new Person("Tom", 63, Person.Gender.MALE));
        persons.add(new Person("Anna", 63, Person.Gender.FEMALE));

        Stream<Person> stream = persons.stream();
        List<Person> workers = stream.filter(p -> p.getAge() >= 18 &&
                        (p.getAge() < 60 && p.getGender() == Person.Gender.FEMALE ||
                        p.getAge() < 65 && p.getGender() == Person.Gender.MALE))
                .collect(Collectors.toList());

        for(Person p : workers){
            System.out.println(p);
        }
    }

    public static void task2(){
//        Создайте коллекцию ArrayList<User> и заполните ее объектами класса
//        User:
//        Name: Age:
//        Jack1 23
//        Harry 31
//        Charlie12 18
//        Thomas 32
//        Amelia33 30
//        Olivia3 19
//        Emily 18
//        Sophie 25

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Jack1", 23, true));
        users.add(new User("Harry", 31, true));
        users.add(new User("Charlie12", 18, true));
        users.add(new User("Thomas", 32, true));
        users.add(new User("Amelia33", 30, true));
        users.add(new User("Olivia3", 19, true));
        users.add(new User("Emily", 18, true));
        users.add(new User("Sophie", 25, true));

//        Получите из коллекции Stream.
//        Отсортируйте стрим по алфавиту имен.
//        Получите из стрима коллекцию всех пользователей, имена, которых не
//        содержат чисел, выведете содержимое коллекции в консоль.
        Stream<User> stream = users.stream();
        List<User> usersWithoutNumbers = stream
                .sorted(Comparator.comparing(User::getName))
                .filter(u -> Pattern.matches("\\D*", u.getName()))
                .toList();

        System.out.println("usersWithoutNumbers: ");
        for(User u : usersWithoutNumbers){
            System.out.println(u);
        }
        System.out.println();

        // ================================================
        //        С помощью стрима, посчитайте количество юзеров, у которых в именах
        //        есть числа, и выведете их количество в консоль.
        Stream<User> stream2 = users.stream();
        long countUsersWithDigits = stream2
                .filter(u -> Pattern.matches(".*\\d.*", u.getName()))
                .count();

        System.out.println("countUsersWithDigits = " + countUsersWithDigits);

        // ===================================================
        // Получите из стрима, содержащего всех юзеров, коллекцию Map.
        // Ключами должны быть имена, а значениями возраст
        System.out.println();
        System.out.println("Map.  name : age");
        Stream<User> stream3 = users.stream();
        HashMap<String, Integer> hashMap =
                (HashMap<String, Integer>) stream3
                        .collect(Collectors.toMap(
                                User::getName, User::getAge
                        ));
        System.out.println(hashMap);

    }

    public static void task3(){
//        Создайте строку с участком текста. В этом тексте должно быть несколько
//        предложений.
//  С помощью Stream API преобразуйте эту строку в:
//          коллекцию предложений
//          коллекцию слов
//          массив символов
// Выведете коллекции и массив в консоль.
// С помощью Stream API посчитайте количество предложений, слов,
// символов (без пробелов) и выведете эти значения в консоль.

       String s = "Get the String. Create a Regular Expression. " +
               "Match the given string. " +
               "Return true if the string matches.";
        System.out.println("test:");
        System.out.println(s);

        System.out.println();
        System.out.println();



        //          коллекцию предложений
        List<String> sentences = Stream.of(s.split("\\."))
                .map(String::trim).toList();
        System.out.println("sentences: ");
        for(String sentence : sentences){
            System.out.println(sentence);
        }
        System.out.println("count of sentences = " + sentences.stream().count());
        System.out.println();

        //          коллекцию слов
        List<String> words = Stream.of(s.split(" "))
                .map(String::trim).toList();
        System.out.println("words: ");
        for(String word : words){
            System.out.println(word);
        }
        System.out.println("count of words = " + words.stream().count());


        //          массив символов
        char[] chars = s.toCharArray();
        for(char c : chars){
            System.out.println(c);
        }
        long countChars = s.chars()
                .mapToObj(i->(char)i)
                .filter(c -> c != ' ').count();
        System.out.println("count chars without spaces = " + countChars);




    }

    private static void task4() {
//        IntStream stream = new Random().ints(100, 0, 100); // create stream without array

        // Сгенерируйте 100 случайных чисел от 0 до 100. Добавьте их в массив.
        int bound = 100;
        int count = 100;
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * bound);
        }

//        Создайте из массива стрим.
//        Выведете этот стрим в консоль помощью Stream API.
        IntStream stream = Arrays.stream(array);
        stream.forEach(System.out::println);

        // С помощью Stream API найдите и выведете в консоль:
        // количество всех чисел
        System.out.println("count = " + Arrays.stream(array).count());

        // количество четных и нечетных чисел
        System.out.println("count of odd numbers = " + Arrays.stream(array).filter(x -> x % 2 == 1).count());
        System.out.println("count of even numbers = " + Arrays.stream(array).filter(x -> x % 2 == 0).count());

        // максимальное и минимальное значение
        System.out.println("max = " + Arrays.stream(array).max().getAsInt());
        System.out.println("min = " + Arrays.stream(array).min().getAsInt());


        // среднее и сумму всех чисел
        System.out.println("average = " + Arrays.stream(array).average().getAsDouble());
        System.out.println("sum = " + Arrays.stream(array).sum());

    }


}
