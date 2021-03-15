package meb.software;

/**
 * Created by Morris on 8/8/2016.
 * Test Tree Classs
 */
public class TreeNodeTest {
    private Tree TestTree = new Tree();
    private boolean testResults = false;
    private String testStringResults = "";
    private String insertString = "";

    private void ResetTestResults(){
        testResults = false;
        testStringResults = "";
        insertString = "";

    }

    /**
     * Created method to remove repetition from main test class
     * @param insertString String being inserted
     * @param testResults boolean passed, results of test
     * @param testCaseNumber integer value of test case number
     */
    public void InsertCase(String insertString, boolean testResults, int testCaseNumber){
        System.out.println("Tree Node Insert Test Case " + testCaseNumber + ": " + System.lineSeparator()
            + "Insert: " + insertString + System.lineSeparator()
            + "Insert Results Worked?: " + testResults + System.lineSeparator());
        ResetTestResults();
    }

    /**
     * method to remove redundancy for lookup results
     * @param searchString String used to search for data
     * @param compareString Original data being searched for
     * @param testResults Results for this test case
     * @param testCaseNumber test case number
     * @param foundString String returned from tree
     */
    public void LookupCase(String searchString, String compareString, boolean testResults, int testCaseNumber, String foundString){
        System.out.println("Tree Node Lookup Test Case " + testCaseNumber + ": " + System.lineSeparator()
                + "Search String: " + searchString + System.lineSeparator()
                + "FIND : " + compareString + System.lineSeparator()
                + "FOUND: " + foundString + System.lineSeparator()
                + "Lookup Results Worked?: " + testResults + System.lineSeparator());
        ResetTestResults();
    }

    /**
     * method to remove redundancy for Delete results
     * @param searchString String used to delete data
     * @param testResults boolean if test results passed
     * @param testCaseNumber test case number
     */
    public void DeleteCase(String searchString, boolean testResults, int testCaseNumber){
        System.out.println("Tree Node Delete Test Case " + testCaseNumber + ": " + System.lineSeparator()
                + "Delete: " + searchString + System.lineSeparator()
                + "Delete Results Worked?: " + testResults + System.lineSeparator());
        ResetTestResults();
    }

    /**
     * main method for all tree test cases
     */
    public void TestTree()
    {

        int testCase = 1;
        String searchString = "";

        //Test Case 1: Insert Bob Smith 555-235-1111 bsmith@somewhere.com
        insertString = "Bob Smith 555-235-1111 bsmith@somewhere.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString,testResults,testCase);
        testCase++;

        //Test Case 2: Insert Jane Williams 555-235-1112 jw@something.com
        insertString = "Jane Williams 555-235-1112 jw@something.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 3: Insert Mohammed al-Salam 555-235-1113 mas@someplace.com
        insertString = "Mohammed al-Salam 555-235-1113 mas@someplace.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 4: Insert Pat Jones 555-235-1114 pjones@homsweethome.com
        insertString = "Pat Jones 555-235-1114 pjones@homsweethome.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 5: Insert Billy Kidd 555-235-1115 billy_the_kid@nowhere.com
        insertString="Billy Kidd 555-235-1115 billy_the_kid@nowhere.com";
        testResults = TestTree.Insert("Billy Kidd 555-235-1115 billy_the_kid@nowhere.com");
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 6: Insert H. Houdini 555-235-1116 houdini@noplace.com
        insertString = "H. Houdini 555-235-1116 houdini@noplace.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 7: Insert Jack Jones 555-235-1117 jjones@hill.com
        insertString = "Jack Jones 555-235-1117 jjones@hill.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 8: Insert Jill Jones 555-235-1118 jillj@hill.com
        insertString = "Jill Jones 555-235-1118 jillj@hill.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 9: Insert John Doe 555-235-1119 jdoe@somedomain.com
        insertString = "John Doe 555-235-1119 jdoe@somedomain.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 10: Insert Jill Doe 555-235-1120 jdoe@somedomain.com
        insertString = "Jill Doe 555-235-1120 jdoe@somedomain.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 11: Lookup Pat Jones
        searchString = "Pat Jones";
        testStringResults = TestTree.Lookup(searchString);
        insertString = "Pat Jones 555-235-1114 pjones@homsweethome.com"; //expected results
        testResults = (insertString.contentEquals(testStringResults));
        LookupCase(searchString,insertString, testResults,testCase,testStringResults);
        testCase++;

        //Test Case 12: Lookup Billy Kidd
        searchString = "Billy Kidd";
        testStringResults = TestTree.Lookup(searchString);
        insertString = "Billy Kidd 555-235-1115 billy_the_kid@nowhere.com"; //expected results
        testResults = (insertString.contentEquals(testStringResults));
        LookupCase(searchString,insertString,testResults,testCase,testStringResults);
        testCase++;

        //Test Case 13: Delete John Doe
        searchString = "John Doe";
        testResults = TestTree.Delete(searchString);
        DeleteCase(searchString,testResults,testCase);
        testCase++;

        //Test Case 14: Insert Test Case 555-235-1121 Test_Case@testcase.com
        insertString = "Test Case 555-235-1121 Test_Case@testcase.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 15: Insert Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru
        insertString = "Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 16: Insert Jo Wu 555-235-1123 wu@hu.com
        insertString = "Jo Wu 555-235-1123 wu@hu.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 17: Millard Fillmore 555-235-1124 millard@theactualwhitehouse.com
        insertString = "Millard Fillmore 555-235-1124 millard@theactualwhitehouse.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 18: Bob vanDyke 555-235-1125 vandyke@nodomain.com
        insertString = "Bob vanDyke 555-235-1125 vandyke@nodomain.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 19: Upside Down 555-235-1126 upsidedown@rightsideup.com
        insertString = "Upside Down 555-235-1126 upsidedown@rightsideup.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 20: Lookup Jack Jones 555-235-1117 jjones@hill.com
        insertString = "Jack Jones 555-235-1117 jjones@hill.com";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 21: Lookup Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru
        insertString = "Nadezhda Kanachekhovskaya 555-235-1122 dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru";
        testResults = TestTree.Insert(insertString);
        InsertCase(insertString, testResults,testCase);
        testCase++;

        //Test Case 22: Delete Jill Jones 555-235-1120 jdoe@somedomain.com
        searchString = "Jill Jones";
        testResults = TestTree.Delete(searchString);
        DeleteCase(searchString,testResults,testCase);
        testCase++;

        //Test Case 23: Delete John Doe 555-235-1119 jdoe@somedomain.com
        searchString = "John Doe";
        testResults = TestTree.Delete(searchString);
        DeleteCase(searchString,testResults,testCase);
        testCase++;

        //Test Case 24: Lookup Jill Jones 555-235-1118 jillj@hill.com - should return empty string - first test will be false.
        searchString = "Jill Jones";
        testStringResults = TestTree.Lookup(searchString);
        insertString = "Jill Jones 555-235-1118 jillj@hill.com"; //expected results
        testResults = (insertString.contentEquals(testStringResults));
        LookupCase(searchString,insertString, testResults,testCase,testStringResults);
        testCase++;

        //Test Case 25: Lookup John Doe 555-235-1119 jdoe@somedomain.com - should return empty string - first test will be false.
        searchString = "John Doe";
        testStringResults = TestTree.Lookup(searchString);
        insertString = "John Doe 555-235-1119 jdoe@somedomain.com"; //expected results
        testResults = (insertString.contentEquals(testStringResults));
        LookupCase(searchString,insertString, testResults,testCase,testStringResults);
        testCase++;

        //Test Case X: sort and balance tree
        System.out.println(System.currentTimeMillis());
        testResults = TestTree.ReBalanceTree();
        LookupCase(searchString,insertString,testResults,testCase,testStringResults);
        System.out.println(System.currentTimeMillis());

    }
}
