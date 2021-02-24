package com.luistaborda.topi.topi.api.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Utils {
    public static String URL = " https://www.themealdb.com/";
    public static int HTTP_SUCESS_CODE = 200;

    public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String response, jsonEmString = "";
        while ((response = buffereReader.readLine()) != null) {
            jsonEmString += response;
        }
        return jsonEmString;
    }
}
