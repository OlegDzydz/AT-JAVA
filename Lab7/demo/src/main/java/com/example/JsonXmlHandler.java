package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class JsonXmlHandler {

    public static Person readJson(String fileName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Отримуємо файл з resources як InputStream
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("Файл не знайдено: " + fileName);
        }

        return mapper.readValue(inputStream, Person.class);
    }

    public static void writeJson(String path, Person person) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), person);
    }

    public static Person readXml(String fileName) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Файл не знайдено: " + fileName);
            }
            return xmlMapper.readValue(inputStream, Person.class);
        }
    }

    public static void writeXml(String path, Person person) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), person);
    }
}
