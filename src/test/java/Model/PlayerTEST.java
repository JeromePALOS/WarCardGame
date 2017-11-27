package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.TestCase.assertTrue;


/**
 *
 * @author Jerome
 */
public class PlayerTEST {
    
    public PlayerTEST() {
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

    
    
    //a verfier si ça fonctionne
    @Test 
    public void PlayerTestContruct(){
        Player player1 = new Player("test", 200, 50);
        assertNotNull(player1);
        assertTrue(200==player1.viewHp());
    }
}
