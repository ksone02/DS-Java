package DS9;

public class AVL <Key extends Comparable<Key>, Value>{
    public Node root;

    public AVL(Key newId, Value newName) {
        root = new Node(newId, newName, 1);
    }

    public void put(Key k, Value v) { root = put(root, k, v); }

    private Node put(Node n, Key k, Value v) {
        if ( n == null ) return new Node(k, v, 1);

        int t = k.compareTo((Key) n.id);
        if( t  < 0 ) n.left = new Node(k, v, n.height+1);
        else if ( t > 0 ) n.right = new Node(k, v, n.height+1);
        else {
            n.name = v;
            return n;
        }
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;

        return balance(n);
    }

    // 중요
    private Node balance(Node n) {
        if(bf(n) > 1) {
            if(bf(n.left) < 0) {
                n.left = rotateLeft(n.left);
            }
            n = rotateRight(n);
        }
        else if(bf(n) < -1) {
            if(bf(n.right) > 0) {
                n.right = rotateRight(n.right);
            }
            n = rotateLeft(n);
        }
        return n;
    }

    // balance factor 왼쪽 서브트리와 오른쪽 서브트리 높이 비교
    private int bf(Node n) {
        return height(n.left) - height(n.right);
    }

    public int height(Node n) {
        if (n == null) return 0;
        return n.height;
    }

    private int tallerHeight(int x, int y) {
        if ( x > y ) return x;
        else return y;
    }

    public void delete(Key k) { root = delete(root, k); }

    private Node delete(Node n, Key k) {
        if(n == null) return null;
        int t = k.compareTo((Key)n.id);

        if(t<0) n.left = delete(n.left, k);
        else if(t>0) n.right = delete(n.right, k);
        else {
            if(n.left == null) return n.right;
            else if(n.right == null) return n.left;
            else {
                Node target = n;
                n = min(target.right);
                n.right = deleteMin(target.right);
                n.left = target.left;
            }
        }
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        return balance(n);
    }

    public void deleteMin() {
        if(root == null) System.out.println("empty 트리");

        root = deleteMin(root);
    }

    private Node deleteMin(Node n) {
        if(n.left == null) return n.right;

        n.left = deleteMin(n.left);
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;

        return balance(n);
    }

    public Key min() {
        if(root == null) return null;
        return (Key) min(root).id;
    }

    private Node min(Node n) {
        if(n.left == null) return n;
        return min(n.left);
    }

    private Node rotateRight(Node n) {
        Node x = n.left;
        n.left = x.right;
        x.right = n;

        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node rotateLeft(Node n) {
        Node x = n.right;
        n.right = n.left;
        x.left = n;

        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;

        return x;
    }
}