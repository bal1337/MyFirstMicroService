package com.tsi.balwant.rai.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//
@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    // Duplicates database for testing
    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
//
    @BeforeEach
    void setUp(){
        // Define the temporary mockito application
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository);
    }

    @Test
    public void testAddActor(){
        Actor MockActor = new Actor("First name", "Last name");
        String expected = "save";
        String actual = myFirstMicroserviceApplication.addActor(MockActor.getFirst_name(), MockActor.getLast_name());
        ArgumentCaptor<Actor>actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture()); // ensures mock object is a mock object and acts as one
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual,"Actor failed to add to the mock");
    }

  @Test
    public void testGetAllActors(){
        Actor testActorCast = new Actor("TestFirstName", "TestLastName", 1);
        List<Actor> actorList = new ArrayList<>();
        actorList.add(testActorCast);
        when(myFirstMicroserviceApplication.getAllActors()).thenReturn(actorList);
        Assertions.assertEquals(actorList, myFirstMicroserviceApplication.getAllActors(), "Actor data was not added to the duplicate database");
    }


}
