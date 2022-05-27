package DS9;

public class Node <Key extends Comparable<Key>, Value> {
    Key id;
    Value name;
    int height;
    Node left, right;

    public Node(Key newId, Value newName, int height) {
        id = newId;
        name = newName;
        height = height;
        left = right = null;
    }

    //get set method 는 X.


}
