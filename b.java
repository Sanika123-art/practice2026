
class BTree {
    static class Node {
        int[] key = new int[3];
        Node[] child = new Node[4];
        int n = 0;
        boolean leaf;

        Node(boolean leaf) {
            this.leaf = leaf;
        }
    }

    Node root = new Node(true);

    void split(Node parent, int i) {
        Node y = parent.child[i];
        Node z = new Node(y.leaf);

        z.n = 1;
        z.key[0] = y.key[2];

        if (!y.leaf) {
            z.child[0] = y.child[2];
            z.child[1] = y.child[3];
        }

        y.n = 1;

        for (int j = parent.n; j >= i + 1; j--)
            parent.child[j + 1] = parent.child[j];

        parent.child[i + 1] = z;

        for (int j = parent.n - 1; j >= i; j--)
            parent.key[j + 1] = parent.key[j];

        parent.key[i] = y.key[1];
        parent.n++;
    }

    void insert(int k) {
        if (root.n == 3) {
            Node s = new Node(false);
            s.child[0] = root;
            split(s, 0);
            root = s;
        }

        add(root, k);
    }

    void add(Node x, int k) {
        int i = x.n - 1;

        if (x.leaf) {
            while (i >= 0 && k < x.key[i]) {
                x.key[i + 1] = x.key[i];
                i--;
            }

            x.key[i + 1] = k;
            x.n++;
        } else {
            while (i >= 0 && k < x.key[i])
                i--;

            i++;

            if (x.child[i].n == 3) {
                split(x, i);

                if (k > x.key[i])
                    i++;
            }

            add(x.child[i], k);
        }
    }

    void display(Node x) {
        int i;

        for (i = 0; i < x.n; i++) {
            if (!x.leaf)
                display(x.child[i]);

            System.out.print(x.key[i] + " ");
        }

        if (!x.leaf)
            display(x.child[i]);
    }

    public static void main(String[] args) {
        BTree t = new BTree();

        int[] a = {10, 20, 5, 6, 12, 30, 7, 17};

        for (int x : a)
            t.insert(x);

        System.out.println("B-Tree Traversal:");
        t.display(t.root);
    }
}
