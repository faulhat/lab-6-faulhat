/*
 * Author: Tom Faulhaber
 * Date: February 18th, 2023
 * Description: Find number of connected subgraphs within a given graph.
 */
package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Components {
    public static void traverse(boolean[][] adjacencies, int k, Set<Integer> visited) {
        visited.add(k);
        boolean[] row = adjacencies[k];
        for (int i = 0; i < row.length; i++) {
            if (row[i] && !visited.contains(i)) traverse(adjacencies, i, visited);
        }
    }

    public static int getSubgraphs(Scanner scanner) {
        int nodes = scanner.nextInt();
        boolean[][] adjacencies = new boolean[nodes][nodes];
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt(), b = scanner.nextInt();
            adjacencies[a - 1][b - 1] = true;
            adjacencies[b - 1][a - 1] = true;
        }

        Set<Integer> visited = new TreeSet<>();
        int subgraphs = 0;
        for (int i = 0; i < nodes; i++) {
            if (!visited.contains(i)) {
                traverse(adjacencies, i, visited);
                subgraphs++;
            }
        }

        // Return the number of detected subgraphs + the number of isolated graph nodes.
        return subgraphs;
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Fatal: no input file provided.");
            System.exit(-1);
        }

        File input = new File(args[0]);
        try (Scanner scanner = new Scanner(input)) {
            System.out.println(getSubgraphs(scanner));
        }
    }
}
