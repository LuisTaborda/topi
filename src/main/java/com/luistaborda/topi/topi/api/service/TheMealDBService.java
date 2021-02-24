package com.luistaborda.topi.topi.api.service;

import com.google.gson.Gson;
import com.luistaborda.topi.topi.api.utils.Utils;
import com.luistaborda.topi.topi.exception.MealException;
import com.luistaborda.topi.topi.model.vo.Meals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TheMealDBService {

    public static Meals findByName(String name) throws Exception {
        String urlStr = Utils.URL + "api/json/v1/1/search.php?s=" + name;

        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if (con.getResponseCode() != Utils.HTTP_SUCESS_CODE)
                throw new RuntimeException("HTTP error code : " + con.getResponseCode());

            BufferedReader response = new BufferedReader(new InputStreamReader((con.getInputStream())));
            String jsonEmString = Utils.converteJsonEmString(response);

            Gson gson = new Gson();
            Meals meals = gson.fromJson(jsonEmString, Meals.class);

            return meals;
        } catch (MealException e) {
            throw new MealException("there was an error consulting the api. " + e);
        }
    }
}

