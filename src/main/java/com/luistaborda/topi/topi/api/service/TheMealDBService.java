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
        String urlParaChamada = Utils.URL + name;

        try {
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != Utils.HTTP_SUCESS_CODE)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Utils.converteJsonEmString(resposta);

            Gson gson = new Gson();
            Meals meals = gson.fromJson(jsonEmString, Meals.class);

            return meals;
        } catch (MealException e) {
            throw new MealException("there was an error consulting the api. " + e);
        }
    }
}

