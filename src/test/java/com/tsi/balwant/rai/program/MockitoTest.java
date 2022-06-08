//package com.tsi.balwant.rai.program;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;

////
//@ExtendWith(MockitoExtension.class)
//public class MockitoTest {
//    // Duplicates database for testing
//    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
//    @Mock
//    private ActorRepository actorRepository;
//    @Mock
////
//    @BeforeEach
//    void setUp(){
//        // Define the temporary mockito application
//        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository);
//    }
//
//      @Test
//    public void testAddActor(){
//        Actor addActor = new Actor("First name", "Last name");
//        String expected = "save";
//        String actual = sakilaDbApplication.addActors(addActor.getFirst_name(), addActor.getLast_name());
//        ArgumentCaptor<Actor>actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//        verify(actorRepository).save(actorArgumentCaptor.capture());
//        actorArgumentCaptor.getValue();
//        Assertions.assertEquals(expected, actual,"Actor data not found in the duplicate database");
//    }
//
//  @Test
//    public void test_GetAllActors(){
//        Actor testActorCast = new Actor("TestFirstName", "TestLastName", 1);
//        List<Actor> actorList = new ArrayList<>();
//        actorList.add(testActorCast);
//
//        when(sakilaDbApplication.getAllActors()).thenReturn(actorList);
//        Assertions.assertEquals(actorList, sakilaDbApplication.getAllActors(), "Actor data was not added to the duplicate database");
//    }
//
//
//}
