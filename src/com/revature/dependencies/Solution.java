package com.revature.dependencies;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Character> build(char[] projects, ArrayList<ArrayList<Character>> dependenciesList) {
        // sample input
        // projects: a, b, c, d, e, f
        // dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)

        // sample output: e, f, b, a, d, c

        // convert arrays into ArrayLists to allow for easier manipulation
        ArrayList<Character> projectList = new ArrayList<>(projects.length);
        for (char p : projects)
            projectList.add(p);

//        ArrayList<ArrayList<Character>> dependenciesList = new ArrayList<>(dependencies.length);
//        for (char[] arr : dependencies) {
//            ArrayList<Character> dependency = new ArrayList<>(arr.length);
//            for (char d : arr) {
//                dependency.add(d);
//            }
//            dependenciesList.add(dependency);
//        }

        ArrayList<Character> solution = new ArrayList<>(projects.length);
        solution.addAll(projectList);

        // look for projects that aren't dependencies of other projects
        for (Character p : projectList) {
            for (ArrayList<Character> arr : dependenciesList) {
                for (Character d : arr) {
                    if (p.equals(d))
                        solution.remove(p);
                }
            }
        }

        for (Character p : solution)
            projectList.remove(p);

        // check if each project appears in index 1 of each dependency array
        // if it doesn't, add it to solutions list
        for (Character p : projectList) {
            solution.add(p);

            for (ArrayList<Character> arr : dependenciesList) {
                if (arr.get(1).equals(p))
                    solution.remove(p);
            }
        }

        for (Character p : solution)
            projectList.remove(p);

        ArrayList<Character> newSolution = new ArrayList<>(solution);
        for (Character p : solution) {
            for (ArrayList<Character> arr : dependenciesList) {
                if (p.equals(arr.get(0))) {
                    newSolution.add(arr.get(1));
                    projectList.remove(arr.get(1));
                }
            }
        }
        solution = newSolution;

        // check if remaining projects are dependent on other remaining projects
        // if they are not, add them to the solutions list
        for (Character p : projectList) {
            for (ArrayList<Character> arr : dependenciesList) {
                if (arr.get(0).equals(p)) {
                    solution.add(p);
                }
            }
        }

        for (Character p : solution)
            projectList.remove(p);

        // add remaining projects to solutions list
        solution.addAll(projectList);
        projectList.removeAll(solution);

        return solution;
    }
}
