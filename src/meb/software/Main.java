/* Data Project for WGU
   Started: 8/3/2016
   Revision: 35
   8/7/2016 - MEB
    1) Finished HashTable.java class and it's test case class with all 25 test cases
   TBD: Create code for Tree.java class and create TreeTest.java class
   Developer: Morris Buel
   8/8/2016 - MEB
    1) added Node class and TreeNodeTest class
    2) Implemented insert function and private methods in Tree class to determine numerical value of text. (Determines where in tree to place string)
   8/10/2016 - MEB
    1) Added lookup function to Tree.java, currently only works on Total Name
    2) Next build needs to add Delete Function, and double check requirements for Tree Node. Do I need to add First/Last name search for Tree?
    3) Need to add comments to Node and Tree classes
    4) Need to expand Test Case notation to make testing clearer
   8/11/2016 - MEB
    1) Fixed Lookup method to return current node, instead of relying on class variable to store found data.
    2) Started working on Delete Method
    3) encapsulated test case notation for tree. (need to copy to HashTableTest)
    4) Cleaned up methods in Tree class, need to copy results to HashTable
   8/13/2016 - MEB
    1) Still trying to get the delete Node method to work correctly.
    2) Finished cleaning up TreeNodeTest class - need to copy results to HashTableTest class.
   8/14/2016 - MEB
    1) Greatly simplified Insert Method using new AddInOrderTraverse method.
    2) TODO: Can I implement that method for Delete and Search? - implemented for search.
    3) TODO: Still WIP on Delete method for Tree
    4) Rewrote lookup to use new NodeTraversal technique I'm using for AddInOrderTraverse
    5) TODO: Need to cleanup tree class and HashTableTest class

 */
package meb.software;
public class Main {

    /**
     * Entry point for test project
     * @param args NOT USED
     */
    public static void main(String[] args) {

        HashTableTest testHash = new HashTableTest();
        testHash.HashTest(); //Call test class to run through test cases on HashTable Class

        TreeNodeTest tnt = new TreeNodeTest();

        tnt.TestTree(); //Call test class to run through test cases on tree Class

    }
}
