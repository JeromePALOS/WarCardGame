/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jerome
 */
public class StoreTEST {
    
    public StoreTEST() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void changeStoreTest(){
        Game game = new Game();
        
        Store store = new Store();
        for(int i=0; i<=6; i++){
            //store.changeStore(game.returnCards());
            System.out.println(store.viewCard(1));
        }
    }
}
