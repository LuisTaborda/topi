package com.luistaborda.topi.topi.api.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Utils {
    public static String URL = " https://www.themealdb.com/api/json/v1/1/search.php?s=";
    public static int HTTP_SUCESS_CODE = 200;

    public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}
