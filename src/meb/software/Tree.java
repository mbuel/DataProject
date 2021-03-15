/**MEB
 * Binary Tree class developed from scratch:
 * Done: Create class global variables to deal with root node for data
 * Done: Create add (insertion) method to add data to HashTable - Needs to deal with possible duplication
 * DONE: Create First Name and Last Name reference to Hash - Need to review requirements, if required i'll need to add.
 * DONE: Create Delete Function - remap incremented Hash table.
 * Done: Lookup function that works off of first, last or first and last name. (Currently only works on Total Name) - Fixed to return string!
 */
package meb.software;

/**MEB
 * Created by Morris Buel on 8/3/2016.
 */
public class Tree {
    private String className = "Tree"; //MEB used for ErrorHandler
    private String methodName = ""; //MEB used for ErrorHandler
    private int averageKey = 0;
    private int treeCount = 0;
    private int span = 25;
    Node root;
    private int currentKey = 0; //MEB Convered totalName hash
    private String firstName = ""; //MEB Carry over from HashTable not currently used
    private String lastName = ""; //MEB Carry over from HashTable not currently used
    private String totalName = ""; //MEB totalName from name

    /**
     * MEB
     * initialize Tree root to null
     */
    public Tree() {
        root = null;
    }

    /**
     * MEB
     * getters for class variables
     *
     * @return currentKey or Key values
     */
    public int GetCurrentKey() {
        return currentKey;
    }

    //MEB - public int GetKey(){return Key;}
    public String GetTotalName() {
        return totalName;
    }

    /**
     * MEB
     * setters for class variables
     */
    private void SetFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void SetLastName(String lastName) {
        this.lastName = lastName;
    }

    private void SetTotalName(String totalName) {
        this.totalName = totalName;
    }

    private void SetCurrentKey(int key) {
        this.currentKey = key;
    }

    /**
     * MEB
     * SetNames - Parses names from string. Sets class variables, firstName, LastName and TotalName
     *
     * @param name
     */
    private void SetNames(String name) {
        SetTotalName(DecodeName(name, 0, 2));
        SetFirstName(DecodeName(name, 0, 1));
        SetLastName(DecodeName(name, 1, 2));
    }

    /**
     * MEB
     * parses totalName to convert it into a number. Set the class variable to the number equivalent of the current string.
     *
     * @param name of person being added
     * @return integer value of current key
     */
    private int DecodeKey(String name) {
        methodName = "DecodeKey";
        int InterimKey = 0;
        try {
            for (char C : name.toCharArray()) {
                InterimKey = InterimKey + C;
            }
        } catch (Exception e) {
            ErrorHandler(e);
        }
        return InterimKey;
    }

    /**
     * MEB
     * DecodeName takes First and Last, First or Last and decodes string sent to set clas variables
     *
     * @param name   Data string sent, i.e. search string: 'John Doe', or total string, 'John Doe phone email'
     * @param start  starting location of string 0 equal first word, 1 equal second
     * @param finish do you want both words, (2) or first (1)
     * @return parsed string, i.e. 'JOHNDOE'
     */
    private String DecodeName(String name, int start, int finish) {
        methodName = "DecodeName";
        String returnString = "";
        String returnTotalName = "";
        try {
            String splitName[] = name.split(" ");
            for (int i = start; i < finish; i++) {
                returnString += splitName[i].toUpperCase();
            }
            //System.out.println("Result from GetTotalName: " + returnString); //Debug line

        } catch (Exception e) {
            ErrorHandler(e);
        }

        return returnString;
    }

    /**
     * MEB
     * Class ErrorHandler, takes class variables className and methodName and appends the error that is passed
     *
     * @param e - error passed from sender
     */
    private void ErrorHandler(Exception e) {
        System.out.println("ClASS: " + className + System.lineSeparator()
                + "METHOD: " + methodName + System.lineSeparator()
                + "ERROR: " + e.getMessage() + System.lineSeparator()
                + e.getLocalizedMessage());
    }

    /**
     * MEB
     * Insert (add) name (and it's related data) into the node
     *
     * @param name - name string of person to be inserted into tree
     * @return true/false for success or failure
     */
    public boolean Insert(String name) {
        methodName = "Insert";
        boolean insertSuccess = false;
        SetNames(name); //MEB - Sets class variables for this insert (totalName,firstName,totalName)
        SetCurrentKey(DecodeKey(GetTotalName())); //MEB - Sets class variables for this insert (currentKey)

        if (Lookup(this.firstName + " " + this.lastName).isEmpty() && !(Lookup(this.firstName + " " + this.lastName).equalsIgnoreCase(name))) //MEB - Checks to make sure we're not adding a duplicate string
        {
            Node nameNode = new Node(name); //MEB - initializes Node with value to insert
            try {
                if (root == null) {
                    root = nameNode;
                } else {
                    root = getRoot();
                    Node parentNode = root;
                    AddInOrderTraverse(parentNode, nameNode);
                    treeCount++;
                    averageKey = (averageKey + this.currentKey)/treeCount;

                }
                insertSuccess = true;
            } catch (Exception e) {
                ErrorHandler(e);
            }

        }
        return insertSuccess;
    }

    /**
     * MEB
     * AddInOrderTraverse - traverses tree by numeric string value to find correct placement for newline
     *
     * @param nodeToTraverse root
     * @param nodeToAdd      node being added
     */
    private void AddInOrderTraverse(Node nodeToTraverse, Node nodeToAdd) {
        methodName = "AddInOrderTraverse";
        try {
            int localKey = DecodeKey(DecodeName(nodeToTraverse.GetName(), 0, 2));
            if (currentKey <= localKey) {
                if (nodeToTraverse.GetLeft() == null) {
                    nodeToTraverse.SetLeft(nodeToAdd);
                    nodeToTraverse.GetLeft().SetParent(nodeToTraverse);
                } else {
                    AddInOrderTraverse(nodeToTraverse.GetLeft(), nodeToAdd);
                }
            } else if (currentKey > localKey) {
                if (nodeToTraverse.GetRight() == null) {
                    nodeToTraverse.SetRight(nodeToAdd);
                    nodeToTraverse.GetRight().SetParent(nodeToTraverse);
                } else {
                    AddInOrderTraverse(nodeToTraverse.GetRight(), nodeToAdd);
                }
            }
        } catch (Exception e) {
            ErrorHandler(e);
        }
    }

    /**
     * MEB
     * Delete - public call to delete node with searchstring
     *
     * @param searchString - string to be removed (node)
     * @return true or false for success or failure
     */
    public boolean Delete(String searchString) {
        methodName = "Delete";
        /** MEB
         case 1: deal with deleted node that has no children
         case 2: deal with deleted node that has one child (leaf)
         case 3: deal with deleted node that has two children or grandchildren
         */


        try {
            SetTotalName(DecodeName(searchString, 0, 2));
            SetCurrentKey(DecodeKey(this.totalName));
            root = getRoot();

            Node nodeToBeDeleted = NodeSearchTraversal(root);
            if (nodeToBeDeleted != null) {
                DeleteInOrderTraversal(root, nodeToBeDeleted);
                treeCount--;
                return Lookup(searchString).isEmpty();

            } else {
                return false;
            }
        } catch (Exception e) {
            ErrorHandler(e);
            return false;
        }
    }

    /**
     * MEB
     * DeleteInOrderTraversal helper class with recursive calls to make sure all nodes are set correctly after delete
     *
     * @param nodeToTraverse root node
     * @param nodeToDelete   Found node with information we're deleting
     */
    private void DeleteInOrderTraversal(Node nodeToTraverse, Node nodeToDelete) {
        methodName = "DeleteInOrderTraversal";
        try {
            if (nodeToTraverse != null) //MEB - makes sure node isn't null before continuing
            {
                int localKey = DecodeKey(DecodeName(nodeToTraverse.GetName(), 0, 2));
                if (localKey == currentKey) //MEB -Checks to see if we're at the Node to be deleted
                {
                    if (nodeToTraverse.GetLeft() == null && nodeToTraverse.GetRight() == null) //MEB -Case 1
                    {
                        if (nodeToTraverse.GetParent().GetLeft() == nodeToDelete) {
                            nodeToTraverse.GetParent().SetLeft(null);
                        } else {
                            nodeToTraverse.GetParent().SetRight(null);
                        }
                    } else if (nodeToTraverse.GetLeft() != null && nodeToTraverse.GetRight() == null) //MEB - Case 2 left not null
                    {
                        if (nodeToTraverse.GetParent().GetLeft() == nodeToDelete) //MEB - Left leaf set to new node
                        {
                            nodeToTraverse.GetParent().SetLeft(nodeToDelete.GetLeft());
                            nodeToTraverse.GetLeft().SetParent(nodeToTraverse);
                        } else //right leaf set to new node
                        {
                            nodeToTraverse.GetParent().SetRight(nodeToDelete.GetLeft());
                            nodeToTraverse.GetRight().SetParent(nodeToTraverse);
                        }
                    } else if (nodeToTraverse.GetLeft() == null && nodeToTraverse.GetRight() != null) //MEB - Case 2 right not null
                    {
                        if (nodeToTraverse.GetParent().GetLeft() == nodeToDelete) {
                            nodeToTraverse.GetParent().SetLeft(nodeToDelete.GetLeft());
                        } else {
                            nodeToTraverse.GetParent().SetRight(nodeToDelete.GetLeft());
                        }
                    } else //MEB -case 3 children not null
                    {
                        nodeToTraverse.GetParent().SetRight(nodeToDelete.GetRight());
                        nodeToDelete = nodeToDelete.GetRight();
                        DeleteInOrderTraversal(nodeToTraverse.GetRight(), nodeToDelete);
                    }

                }
                if (currentKey <= localKey) {
                    DeleteInOrderTraversal(nodeToTraverse.GetLeft(), nodeToDelete);
                } else if (currentKey > localKey) {
                    DeleteInOrderTraversal(nodeToTraverse.GetRight(), nodeToDelete);
                }
            }

        } catch (Exception e) {
            ErrorHandler(e);
        }
    }

    /**
     * MEB
     * getRoot method returns the root of the current node
     *
     * @return root position of tree, or node.
     */
    private Node getRoot() {
        return root;
    }

    /**
     * MEB
     * InorderTraversal helper method for Lookup (and Delete?)
     *
     * @param NodeToTraverse Node set to search
     * @return node with data
     */
    private Node NodeSearchTraversal(Node NodeToTraverse) {
        methodName = "NodeSearchTraversal";
        try {
            Node traverseNode;
            if (NodeToTraverse != null) {
                if (DecodeKey(DecodeName(NodeToTraverse.GetName(), 0, 2)) == GetCurrentKey()) {
                    if (DecodeName(NodeToTraverse.GetName(),0,2).equalsIgnoreCase(this.totalName)){
                        return NodeToTraverse;
                    }
                    else
                    {
                        if (GetCurrentKey() <= DecodeKey(DecodeName(NodeToTraverse.GetName(), 0, 2))) {
                            traverseNode = NodeSearchTraversal(NodeToTraverse.GetLeft());

                        } else {
                            traverseNode = NodeSearchTraversal(NodeToTraverse.GetRight());
                        }
                        return traverseNode;
                    }

                } else {

                    if (GetCurrentKey() <= DecodeKey(DecodeName(NodeToTraverse.GetName(), 0, 2))) {
                        traverseNode = NodeSearchTraversal(NodeToTraverse.GetLeft());

                    } else {
                        traverseNode = NodeSearchTraversal(NodeToTraverse.GetRight());
                    }
                    return traverseNode;

                }
            }
        } catch (Exception e) {
            ErrorHandler(e);
        }

        return NodeToTraverse;
    }

    /**
     * MEB
     * Lookup - finds name in tree after calling helper method above (NodeTraversal)
     *
     * @param nameToFind string of name to find, i.e., 'Tom Jones'
     * @return complete data string matching nameToFind
     */
    public String Lookup(String nameToFind) {
        methodName = "Lookup";
        String returnValue = "";
        root = getRoot();
        try {
            if (!nameToFind.isEmpty() && root != null) {
                SetTotalName(DecodeName(nameToFind, 0, 2));
                currentKey = DecodeKey(this.totalName);
                root = getRoot();
                Node nodeToFind = NodeSearchTraversal(root);
                if (nodeToFind != null) {
                    returnValue = nodeToFind.GetName();
                }
            }
        } catch (Exception e) {
            ErrorHandler(e);
        }
        return returnValue;
    }


    public boolean ReBalanceTree()
    {
        this.currentKey = this.averageKey;
        boolean success =false;
        int tempTreeCount = treeCount;
        //HashTable HelperHashTable = new HashTable();
        root = getRoot();
        Node copyData = new Node(null);

        BalanceTraversal(root,copyData);

        treeCount = tempTreeCount;
        success = true;
        return success;
    }
    public void BalanceTraversal(Node old, Node sorted)
    {
        if (old != null) {


            if (DecodeKey(DecodeName(old.GetName(), 0, 2)) < averageKey && sorted == null) {
                BalanceTraversal(old.GetRight(), sorted);
            } else if ((DecodeKey(DecodeName(old.GetName(), 0, 2)) < averageKey - span) || (DecodeKey(DecodeName(old.GetName(), 0, 2)) > averageKey + span)) {
                if (sorted == null) {
                    sorted = old;
                    Delete(DecodeName(old.GetName(), 0, 1) + " " + DecodeName(old.GetName(), 1, 2));
                    treeCount--;
                    old.GetRoot();
                    span = span + 25;
                    BalanceTraversal(old, sorted);
                } else {
                    treeCount--;
                    treeCount--;
                    span = span + 25;
                    AddInOrderTraverse(sorted, old);
                    //Delete(old.GetName());
                    Delete(DecodeName(old.GetName(), 0, 1) + " " + DecodeName(old.GetName(), 1, 2));
                    old.GetRoot();
                }


            } else {
                span = span + 25;
                BalanceTraversal(old, sorted);
            }
            old = sorted;
        }
    }

}
