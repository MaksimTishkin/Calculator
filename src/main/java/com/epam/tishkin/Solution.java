package com.epam.tishkin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String task = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            task = reader.readLine();
        } catch (IOException e) {
            System.out.println("Input error" + e.getMessage());
        }
        System.out.println(calculator.getCalculationResult(task));
    }
}
