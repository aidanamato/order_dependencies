package com.revature.dependencies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("What are your projects? Projects are a single character, separated by spaces \n" +
                         "> ");
        String projectsString = bufferedReader.readLine().replaceAll(" ", "");
        char[] projects = projectsString.toCharArray();

        String userInput = "";
        ArrayList<ArrayList<Character>> dependenciesList = new ArrayList<>();
        while (!userInput.equals("done")) {
            System.out.print("What are your project dependencies? Dependencies are written as \"a b\". When you've added your dependencies, type \"done\" \n" +
                             "> ");
            userInput = bufferedReader.readLine();

            if (!userInput.equals("done")) {
                char[] userInputArr = userInput.replace(" ", "").toCharArray();
                ArrayList<Character> dependency = new ArrayList<>();

                for (Character c : userInputArr)
                    dependency.add(c);

                dependenciesList.add(dependency);
            }
        }

        System.out.println(new Solution().build(projects, dependenciesList));
    }
}
