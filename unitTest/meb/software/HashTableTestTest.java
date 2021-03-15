package meb.software;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTestTest {

    @Test
    void insertCase() {
        HashTableTest htt = new HashTableTest();
        HashTable ht = new HashTable();
        htt.InsertCase("Bob Smith 555-235-1111 bsmith@somewhere.com",ht.Insert("Bob Smith 555-235-1111 bsmith@somewhere.com"),1);
    }

    @Test
    void lookupCase() {
    }

    @Test
    void deleteCase() {
    }

    @Test
    void hashTest() {
    }
}