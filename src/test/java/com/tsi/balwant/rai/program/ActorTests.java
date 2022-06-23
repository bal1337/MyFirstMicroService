package com.tsi.balwant.rai.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActorTests{
    @Test
    void testGetFirst_name(){
        Actor testActor = new Actor("TestFirstName", "TestLastName");
        Assertions.assertEquals("TestFirstName", testActor.getFirstName(), "Failed to retrieve first name of actor");
    }
    @Test
    void testSetFirst_name(){
        Actor testActor = new Actor("TestFirstName", "TestLastName");
        testActor.setFirstName("TestFirstName");
        Assertions.assertEquals("TestFirstName", testActor.getFirstName(), "First name of actor was not set correctly");
    }
    @Test
    void testGetLast_name(){
        Actor testActor = new Actor("TestFirstName", "TestLastName");
        testActor.getLastName();
        Assertions.assertEquals("TestLastName", testActor.getLastName(), "Failed to retrieve last name of actor");
    }
    @Test
    void testSetLast_name(){
        Actor testActor = new Actor("TestFirstName", "TestLastName");
        testActor.setLastName("TestLastName");
        Assertions.assertEquals("TestLastName", testActor.getLastName(), "Last name of actor not set correctly");
    }
    @Test
    void testGetActor_id(){
        Actor testActor = new Actor("TestFirstName", "TestLastName");
        testActor.setActorId(7);
        Assertions.assertEquals(7, testActor.getActorId(), "Failed to retrieve actor ID");
    }
    @Test
    void testSetActor_id(){
        Actor testActor = new Actor("TestFirstName", "TestLastName");
        testActor.setActorId(7);
        Assertions.assertEquals(7, testActor.getActorId(), "Actor ID not set correctly");
    }

}
