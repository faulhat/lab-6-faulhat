/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab6;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Scanner;

public class ComponentsTest {
    @Test
    public void test00Graphs() {
        String graph1 = "2  1 2";
        try (Scanner scanner = new Scanner(graph1)) {
            assertEquals(1, Components.getSubgraphs(scanner));
        }
    }

    @Test
    public void test01Graphs() {
        /*
         * The graph looks like:
         * 1 - 2 - 5 - 4
         *  \
         *   8 - 10     3 6 7 9
         */

        String graph1 = "10  1 2  5 4  2 5  8 1  8 10";
        try (Scanner scanner = new Scanner(graph1)) {
            assertEquals(5, Components.getSubgraphs(scanner));
        }
    }

    @Test
    public void test02Graphs() {
        /*
         * The graph looks like:
         * 1 - 2 - 5
         *  \ /
         *   8 - 10     4 3 6 7 9
         */

        String graph1 = "10  1 2  2 5  8 1  8 2  8 10";
        try (Scanner scanner = new Scanner(graph1)) {
            assertEquals(6, Components.getSubgraphs(scanner));
        }
    }

    @Test
    public void test03Graphs() {
        /*
         * The graph looks like:
         * 1 - 2 - 5
         *  \     /
         *   8 - 10     4 3 6 7 9
         */

        String graph1 = "10  1 2  2 5  8 1  10 5  8 10";
        try (Scanner scanner = new Scanner(graph1)) {
            assertEquals(6, Components.getSubgraphs(scanner));
        }
    }

    @Test
    public void test04Graphs() {
        /*
         * The graph looks like:
         * 1 - 2 - 5 - 7
         *  \     /   /    
         *   8 - 10 - 4 - 3   6 9
         */

        String graph1 = "10  1 2  2 5  5 7  1 8  5 10  7 4  8 10  10 4  4 3";
        try (Scanner scanner = new Scanner(graph1)) {
            assertEquals(3, Components.getSubgraphs(scanner));
        }
    }
}

