package meb.software;

/**
 * Created by Morris on 8/8/2016.
 * Node helper class for Tree class
 * This Node stores a string (the name, telephone number and email address for this project)
 */
class Node {
    private Node parent;
    private Node left;
    private Node right;
    private Node root;
    private String name;
    //private int nameKey;

    /**
     * Node Method sets root to name, and left and right 'leafs' to null
     * @param name data set being set to root node
     */
    public Node(String name){
        this.name = name;
        left = null;
        right = null;
    }

    /**
     * setters and getters for the Node class
     */
    public void SetLeft(Node left){
        this.left = left;
    }
    public void SetRight(Node right){
        this.right = right;
    }
    public void SetParent(Node parent) {this.parent = parent;}
    public Node GetLeft(){return left;}
    public Node GetRight(){return right;}
    public Node GetParent(){return parent;}
    public Node GetRoot(){return root;}
    public String GetName(){return name;}
}
