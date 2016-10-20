/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.WebScrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author welcome
 */
public class program {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://leapfrog.academy/course");
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\r\n");
            }
            reader.close();

            String regPattern = "<a href=\"(.*?)\" (.*?) (.*?) (.*?)\"(.*?)\">";
            Pattern pattern = Pattern.compile(regPattern);
            Matcher matcher = pattern.matcher(content.toString());
            while (matcher.find()) {
                System.out.println("Link=" + matcher.group(1));
                System.out.println("Title=" + matcher.group(5));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
