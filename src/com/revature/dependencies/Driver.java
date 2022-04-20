package com.revature.dependencies;

import java.io.BufferedReader;

public class Driver {
    public static void main(String[] args) {
        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[][] dependencies = {{'a','d'}, {'f','b'}, {'b','d'}, {'f','a'}, {'d','c'}};

        Solution solution = new Solution();
        System.out.println(solution.build(projects, dependencies));
    }
}
