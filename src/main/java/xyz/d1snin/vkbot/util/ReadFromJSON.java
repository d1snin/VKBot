package xyz.d1snin.vkbot.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;

public class ReadFromJSON {
    public static String readJson(String file, String  object) {
        try {

            JSONParser parser = new JSONParser();
            File tokenFile = new File(file);
            BufferedReader reader = new BufferedReader(new FileReader(tokenFile.getAbsoluteFile()));
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return (String) jsonObject.get(object);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}


