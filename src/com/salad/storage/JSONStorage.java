package com.salad.storage;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONStorage implements StorageSource {

    private JSONObject object;
    private FileReader fileReader;

    public JSONStorage() {
        try {
            fileReader = new FileReader("json.txt");
            object = (JSONObject) new JSONParser().parse(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("JSON файл не найден");
        } catch (IOException e) {
            System.out.println("Проблемы с открытием файла");
        } catch (ParseException e) {
            System.out.println("Неправильный формат файла");
        }
    }

    @Override
    public int getTomatoAmount() {
        Long value = (Long) object.get("tomatoAmount");
        return value.intValue();
    }

    @Override
    public int getCucumberAmount() {
        Long value = (Long) object.get("cucumberAmount");
        return value.intValue();
    }

    @Override
    public int getPepperAmount() {
        Long value = (Long) object.get("pepperAmount");
        return value.intValue();
    }

    @Override
    public void cleanUp() {
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Проблемы с закрытием файла");
            }
        }
    }
}
