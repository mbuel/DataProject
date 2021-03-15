/**
 * HashTable class developed from scratch:
 * DONE: Create class global variables to deal with HashTable data
 * DONE: Create add (insertion) method to add data to HashTable - Needs to deal with possible duplication
 * DONE: Create First Name and Last Name reference to Hash
 * DONE: Create Delete Function.
 * DONE: Lookup function that works off of first, last or first and last name.
 * DONE: Lookup needs better error handling if entry is not found.
 */
package meb.software;

/**
 * Created by Morris on 8/3/2016.
 */
public class HashTable {
    private String[] hashList = new String[1000];
    private int hashPointer=0;
    private int[] firstNamePointer = new int[1000];
    private int[] lastNamePointer = new int[1000];
    private int firstPointer = 0;
    private int lastPointer = 0;
    private String firstName = "";
    private String lastName = "";
    private String totalName = "";
    private int hashPrime = 31; //Constant

    /**
     * getters for hashPointer an totalName
     * @return hashPointer or totalName
     */
    public int GetHashPointer(){return  hashPointer;}
    public String GetTotalName(){return totalName;}
    /**
     * Insert, takes one line of data and inserts it into the HashTable It calls sub methods to
     * help locate the pointer.
     * @param newLine
     * @return true if able to add line, false if something went wrong.
     */
    public boolean Insert(String newLine) {
        boolean returnValue = false;
        if (newLine.length() > 1) {
            try {
                SetNames(newLine);
                int tempPointer = 0;
                hashPointer = GetHashValue(totalName); //set main hash value
                while (hashList[hashPointer] != null && tempPointer < hashList.length) {
                    hashPointer++;
                }
                hashList[hashPointer] = newLine; //record newLine of data to hashList

                tempPointer = GetHashValue(firstName); //set temporary hash value for first name
                while (firstNamePointer[tempPointer] != 0 && tempPointer < firstNamePointer.length) {
                    tempPointer++;
                }
                firstNamePointer[tempPointer] = hashPointer;

                //Set last name hash pointer
                tempPointer = GetHashValue(lastName);
                while (lastNamePointer[tempPointer] != 0 && tempPointer < lastNamePointer.length) {
                    tempPointer++;
                }
                lastNamePointer[tempPointer] = hashPointer;

                returnValue = hashList[hashPointer].equalsIgnoreCase(newLine);


            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
        {
            //Place error exception here for passing an empty string
        }


        return returnValue;
    }

    /**
     * SetNames, takes 'names' from NewLine and parses the data to pass to the SetHashPointer method
     * @param names
     */
    private void SetNames(String names){
        String splitName[] = names.split(" ");
        firstName = splitName[0].toUpperCase();
        if (splitName.length > 1){
            lastName = splitName[1].toUpperCase();
            totalName =splitName[0].toUpperCase() + splitName[1].toUpperCase();
        }
        else
        {
            lastName = splitName[0].toUpperCase();
        }


    }

    /**
     * GetHashValue is a generic calculation to generate a hash value for all name combinations
     * @param name
     */
    private int GetHashValue(String name){
        int hashInterim = 0;

        for(char C : name.toCharArray()){
            hashInterim = hashInterim + C;
        }
        return hashInterim % hashPrime;

    }

    /**
     * Lookup, lookups contact info from first name, last name or total name.
     * @param searchString
     * @return contact info for search string
     */
    public String Lookup(String searchString) {
        String returnString = "";
        try {
            SetNames(searchString);
            if (firstName.equalsIgnoreCase(lastName)) {

                //int mainPointer = 0;
                firstPointer = firstNamePointer[GetHashValue(firstName)];
                lastPointer = lastNamePointer[GetHashValue(lastName)];

                while (!hashList[firstPointer].contains(searchString) && !hashList[lastPointer].contains(searchString) && lastPointer < hashList.length) {
                    firstPointer++;
                    lastPointer++;
                }
                if (hashList[firstPointer].contains(searchString)) {
                    hashPointer = firstPointer;
                } else {
                    hashPointer = lastPointer;
                }

                return hashList[hashPointer];
            } else {
                hashPointer = GetHashValue(totalName);
                //System.out.println("Status, looking for: " + searchString); //debug line
                boolean stringFound = false;
                while (stringFound != true && hashPointer < hashList.length-1) {
                    if (hashList[hashPointer] != null){
                        //System.out.println(hashList[hashPointer]); //debug line
                        if (hashList[hashPointer].contains(searchString)) {
                            //System.out.println(hashPointer); //debug line
                            returnString = hashList[hashPointer];
                            stringFound = true;
                        }
                        else {
                            hashPointer++;
                        }
                    }
                    else
                    {
                        hashPointer++;
                    }
                    //hashPointer++;
                    //System.out.println(hashPointer); //debug line

                }
                //returnString = "";
            }
            //System.out.println("hashPointer Value: " + hashPointer); //debug line


        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage() + System.lineSeparator()
            + "searchString: " + searchString + System.lineSeparator()
            + "hashPointer: " + hashPointer);
            System.out.println(returnString);
        }
        return returnString;
    }

    /**
     * Delete method - looks up removeName (name to remove), determines if it is the first or last name, then sets that hashPointer to null
     * @param removeName name to remove from table
     * @return returns true or false, if able to remove entry or not.
     */
    public boolean Delete(String removeName){
        boolean returnState = false;
        String testString = "";

        testString = Lookup(removeName);
        //System.out.println("String Returned: " + testString); //debug string
        try {
            if (!(testString.isEmpty())) {

                SetNames(testString);
                firstPointer = GetHashValue(firstName);
                lastPointer = GetHashValue(lastName);
                //System.out.println("SET NULL - Pointer: " + hashPointer); //debug string
                hashList[hashPointer] = null;
                //System.out.println(hashList[hashPointer]); //debug string
                //System.out.println("NULL SET"); //debug string
                firstNamePointer[firstPointer] = 0;
                lastNamePointer[lastPointer] = 0;
                returnState = true;

            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return returnState;
    }
}
