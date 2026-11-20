import java.util.*;

class BPlusTree {
    static final int MAX = 3;

    static class Node {
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Node> child = new ArrayList<>();
        Node next;
        boolean leaf;

        Node(boolean leaf) {
            this.leaf = leaf;
        }
    }

    static class Split {
        int key;
        Node right;

        Split(int key, Node right) {
            this.key = key;
            this.right = right;
        }
    }

    Node root = new Node(true);

    void insert(int key) {
        Split s = add(root, key);

        if (s != null) {
            Node newRoot = new Node(false);
            newRoot.keys.add(s.key);
            newRoot.child.add(root);
            newRoot.child.add(s.right);
            root = newRoot;
        }
    }

    Split add(Node p, int key) {
        if (p.leaf) {
            int i = 0;

            while (i < p.keys.size() && p.keys.get(i) < key)
                i++;

            if (i < p.keys.size() && p.keys.get(i) == key)
                return null;

            p.keys.add(i, key);

            if (p.keys.size() <= MAX)
                return null;

            Node right = new Node(true);

            while (p.keys.size() > 2)
                right.keys.add(p.keys.remove(2));

            right.next = p.next;
            p.next = right;

            return new Split(right.keys.get(0), right);
        }

        int i = 0;

        while (i < p.keys.size() && key >= p.keys.get(i))
            i++;

        Split s = add(p.child.get(i), key);

        if (s == null)
            return null;

        p.keys.add(i, s.key);
        p.child.add(i + 1, s.right);

        if (p.keys.size() <= MAX)
            return null;

        int mid = 2;
        int promote = p.keys.get(mid);

        Node right = new Node(false);

        for (int j = mid + 1; j < p.keys.size(); j++)
            right.keys.add(p.keys.get(j));

        for (int j = mid + 1; j < p.child.size(); j++)
            right.child.add(p.child.get(j));

        while (p.keys.size() > mid)
            p.keys.remove(p.keys.size() - 1);

        while (p.child.size() > mid + 1)
            p.child.remove(p.child.size() - 1);

        return new Split(promote, right);
    }

    void display() {
        Node p = root;

        while (!p.leaf)
            p = p.child.get(0);

        System.out.println("B+ Tree Leaf Nodes:");

        while (p != null) {
            System.out.print(p.keys + " -> ");
            p = p.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        BPlusTree t = new BPlusTree();

        int[] a = {10, 20, 5, 6, 12, 30, 7, 17};

        for (int x : a)
            t.insert(x);

        t.display();
    }
}