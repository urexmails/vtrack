package com.vtrack.vtrack.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamLearn {
    public  static void main(String[] args){
        System.out.println("test");
        String input = "Java Hungry Blog Alive is Awesome";

      String s =   Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(c->c.getValue()==1 && !c.getKey().equals(" ")).map(c->c.getKey()).findFirst().get();


        List<String> collect = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(c -> c.getValue() == 1 && !c.getKey().equals(" ")).map(c -> c.getKey()).collect(Collectors.toList());


        String collect1 = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(c->c.getValue()==1).map(c->c.getKey()).findFirst().get();
        String[] split  = input.split("");

        //Arrays.stream(split).forEach(n->System.out.println(n));

      System.out.println(collect1);

       // System.out.println(split[0]+" "+split[1]+" "+split[3]);
    }
}
