package Graph;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MyGraph implements Graph {

    private final List<String> vertexes = new ArrayList<>();
    private final List<List<Integer>> adjMatrix = new ArrayList<>();
    private int path;
    private ArrayList<Integer> paths;

    @Override
    public boolean addVertex(String label) {
        Objects.requireNonNull(label);
        if (indexOf(label) >= 0) {
            return false;
        }
        vertexes.add(label);
        for (List<Integer> row : adjMatrix) {
            row.add(-1);
        }
        int size = vertexes.size();
        List<Integer> newRow = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            newRow.add(-1);
        }
        adjMatrix.add(newRow);
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexes.size(); i++) {
            if (label.equals(vertexes.get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(String from, String to, int weight) {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
        Objects.requireNonNull(weight);
        int indexOfFrom = indexOf(from);
        int indexOfTo = indexOf(to);
        if (indexOfFrom == -1 || indexOfTo == -1) {
            return false;
        }
        if (indexOfFrom == indexOfTo) {
            return false;
        }
        List<Integer> fromEdges = adjMatrix.get(indexOfFrom);
        fromEdges.set(indexOfTo, weight);
      /*  List<Boolean> toEdges = adjMatrix.get(indexOfTo);
        fromEdges.set(indexOfFrom, true);*/
        return true;
    }

    @Override
    public String toString() {
        StringBuilder adjMatrixString = new StringBuilder();
        for (List<Integer> row : adjMatrix) {
            String routes = row.stream().map(String::valueOf).collect(Collectors.joining("\t\t"));
            adjMatrixString.append(routes).append("\n");
        }
        if (adjMatrixString.length() > 0) {
            adjMatrixString.deleteCharAt(adjMatrixString.length() - 1);
        }
        return adjMatrixString.toString();
    }

    public void dfs(String start, Consumer<String> visitor) {
        Objects.requireNonNull(start);
        dfs(start, new HashSet<>(), visitor);
    }

    private void dfs(String current, Set<String> visited, Consumer<String> visitor) {
        if (visited.contains(current)) {
            return;
        }
        visitor.accept(current);
        visited.add(current);
        List<String> siblings = getSiblings(current);
        for (String sibling : siblings) {
            dfs(sibling, visited, visitor);
        }
    }

    public void bfs(String start, Consumer<String> visitor) {
        Objects.requireNonNull(start);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String next = queue.poll();
            visitor.accept(next);
            List<String> siblings = getSiblings(next);
            for (String sibling : siblings) {
                if (visited.add(sibling)) {
                    queue.add(sibling);
                }
            }
        }


    }

    private List<String> getSiblings(String label) {
        int indexOfLabel = indexOf(label);
        List<Integer> labelRow = adjMatrix.get(indexOfLabel);
        List<String> siblings = new ArrayList<>();
        for (int i = 0; i < labelRow.size(); i++) {
            if (labelRow.get(i) > (-1)) {
                String sibling = vertexes.get(i);
                siblings.add(sibling);
            }
        }
        return siblings;
    }

    public int findShortestPath(String from, String to) {
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
        path = 0;
        paths = new ArrayList<>();
        findAllPaths(from, to);
        System.out.println("Array of paths: " + paths);
        return paths.stream().min(Comparator.comparing(Integer::valueOf)).get();
    }

    private void findAllPaths(String current, String to) {
        List<String> siblings = getSiblings(current);
        for (String sibling : siblings) {
            if (sibling.equals(to)) {
                path += findWeight(current, sibling);
                paths.add(path);
                path -= findWeight(current, sibling);
                return;
            }
            path += findWeight(current, sibling);
            findAllPaths(sibling, to);
            path -= findWeight(current, sibling);
        }
    }

    private int findWeight(String current, String sibling) {
        int indexOfCurrent = indexOf(current);
        List<Integer> labelRow = adjMatrix.get(indexOfCurrent);
        return labelRow.get(indexOf(sibling));
    }
}
