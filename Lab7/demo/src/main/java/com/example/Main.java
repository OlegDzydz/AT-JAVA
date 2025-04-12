package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        int count = args.length > 0 ? Integer.parseInt(args[0]) : 10;

        // === JSON
        Person p = JsonXmlHandler.readJson("input.json");
        p.setName("Updated Name");
        JsonXmlHandler.writeJson("output.json", p);

        // === XML
        Person p2 = JsonXmlHandler.readXml("input.xml");
        p2.setEmployed(false);
        JsonXmlHandler.writeXml("output.xml", p2);

        // === Stream processing
        List<Person> generated = StreamProcessor.generateRandomPeople(count);
        List<Person> result = StreamProcessor.process(generated);

        System.out.println("Filtered & Sorted:");
        result.forEach(System.out::println);
    }
}
// Use this command to genarative 10 example mvn exec:java -Dexec.args="10" I
// used builder in VS Code (Maven) and genarative only one example
