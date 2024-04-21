package edu.ithillel.generics;

import edu.ithillel._common.person.Person;
import edu.ithillel._common.person.PersonWorker;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        //List<String> strings = new ArrayList<>();
        /**
         * simple examples
         */
        Container c1 = new Container("sadsada");
        Container c2 = new Container(3);
        Container c3 = new Container(new Person());
        List<Container> containers = List.of(c1, c2, c3);
        for (Container c : containers){
            if(c.getObj().getClass().equals(String.class)){
                System.out.println(c.getObj().getClass().equals(Object.class));
            }
            System.out.println(c.getObj().getClass());
        }
        //for each instanceof

        GenericContainer<String> strings = new GenericContainer<String>("safdsaf");
        //since java 7 we can not specify generic type in constructor
        GenericContainer<String> strings2 = new GenericContainer<>("safdsaf");
        System.out.println(strings2.getClass());
        System.out.println(GenericContainer.class);
        GenericContainer<String> string3 = new GenericContainer<>(String.class);

        //Object
        //java 10
        final var stringsVar = new GenericContainer<String>();
        final var var2 = new GenericContainer<>(2);


        /**
         * why cannot we transfer primitives in generic
         */
        Object iObj = 1000;

//        int i = 1000;
//        Integer i1 = Integer.valueOf(i);
//        Object iObj = i1; //auto boxing

//        Integer integer = 1000;
//        int i = 1000; //auto unboxing

        /**
         * wildcards below by hierarchy
         */

//        List<Number> list = new ArrayList<>();
//        list.add("sadsa");
//        list.add(11.2);
//        list.add(11);
//        list.add(new Person());

        NumberContainer numberContainer = new NumberContainer<Double>(2.0);
        GenericContainer<? extends Number> numberContainer2 = new GenericContainer<>(2.5);//wildcard

        GenericContainer<Double> createNumberContainerEx1 = ContainerUtils.createNumberContainer(2.4);
        GenericContainer<String> str = ContainerUtils.<Integer>createStringContainer(2);
        GenericContainer<Integer> createNumberContainerEx2 = ContainerUtils.createNumberContainer(2);
        var createNumberContainerEx3 = ContainerUtils.<Double>createNumberContainer(2.0);
        /**
         * wildcards above by hierarchy
         */

        GenericContainer<? super PersonWorker> superGenericWildCard
                = new GenericContainer<>(new PersonWorker());//or new PersonWorker()

    }
}
