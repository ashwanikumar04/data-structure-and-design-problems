package in.ashwanik.programming.coding.graph;

import java.util.Arrays;

public class UnionFind {

    private int[] parent;
    private int[] sz;

    public UnionFind(int n) {
        parent = new int[n];
        sz = new int[n];
        for (int index = 0; index < n; index++) {
            parent[index] = index;
            sz[index] = 1;
        }
    }

    private int root(int index) {
        while (index != parent[index]) {
            //Path compression
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void connect(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            parent[i] = j;
            sz[j] += sz[i];
        } else {
            parent[j] = i;
            sz[i] += sz[j];
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(sz));
        System.out.println("*********************");

    }

}
