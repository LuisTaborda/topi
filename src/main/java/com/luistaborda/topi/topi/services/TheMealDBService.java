package com.luistaborda.topi.topi.services;

import com.google.gson.Gson;
import com.luistaborda.topi.topi.exception.MealException;
import com.luistaborda.topi.topi.model.response.Meals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TheMealDBService {
    static String URL = " https://www.themealdb.com/api/json/v1/1/search.php?s=";
    static int STATUS_CODE_SUCCESS = 200;

    public static Meals findByName(String name) throws Exception {
        String urlParaChamada = URL + name;

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != STATUS_CODE_SUCCESS)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Meals meals = gson.fromJson(jsonEmString, Meals.class);

            return meals;
        } catch (MealException e) {
            throw new MealException("there was an error consulting the api. " + e);
        }
    }
}

class Util {
    public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}
