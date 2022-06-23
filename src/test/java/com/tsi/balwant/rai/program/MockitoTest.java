package com.tsi.balwant.rai.program;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    // @Mock - Makes a duplicate for which tests will be simulated
    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;

    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;
    @Mock
    private FilmActorRepository filmActorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private LanguageRepository languageRepository;

    //Used for Assertions
    String Expected;
    String Actual;


    // Ran before each Test, setting up mock repositories for initialising the test
    @BeforeEach
    void setUp(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, filmCategoryRepository, filmActorRepository,categoryRepository, languageRepository);
    }

    // ---------------------Actors--------------------- //

    @Test
    void testAddActor(){
        Actor newActor1 = new Actor("Bal", "Rai");
        Actual = myFirstMicroserviceApplication.addActor(newActor1.getFirstName(), newActor1.getLastName());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class); //Allows you to capture arguments passed to a method in this case, its catching the Actor class
        verify(actorRepository).save(actorArgumentCaptor.capture()); // Verify checks to make sure the method has run
        actorArgumentCaptor.getValue(); // From my understanding, it would get the last value added to the actorArgumentCaptor, in this case the Actor class
        Expected = "Actor has been successfully added";
        Assertions.assertEquals(Expected, Actual, "Actor not saved in Database");
    }
    @Test
    void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }

    @Test//tests whether the get actor feature functions
    void getByActor(){
        Actor testActor = new Actor("Bal", "Rai");
        testActor.setActorId(1);
        when(actorRepository.findById(1)).thenReturn(Optional.of(testActor));
        Actor Actual = myFirstMicroserviceApplication.getByActor(testActor.getActorId()).getBody();
        Actor Expected = testActor;
        Assertions.assertEquals(Expected,Actual,"Could not find actor with ID");
    }

    @Test//tests whether the update actor function works
    void updateActor(){
        Actor testActor = new Actor("Bal", "Rai");
        testActor.setActorId(1);
        Actor testUpdateActor = new Actor("NewFirstName" , "NewLastName");
        testUpdateActor.setActorId(1);
        when(actorRepository.findById(testActor.getActorId())).thenReturn(Optional.of(testUpdateActor));
        Actor Actual = myFirstMicroserviceApplication.updateActor(testUpdateActor).getBody();
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor Expected = actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected,Actual,"Actor failed to update with specified ID");
    }

    @Test//tests whether a dummy actor can be deleted
    void deleteActor(){
        Actor testActor = new Actor("DeleteFirstName", "DeleteLastName");
        testActor.setActorId(1);
        Actor testActorDelete = new Actor("DeleteFirstName", "DeleteLastName");
        testActorDelete.setActorId(1);
        when(actorRepository.findById(testActorDelete.getActorId())).thenReturn(Optional.of(testActorDelete));
        doNothing().when(actorRepository).deleteById(1);
        Actor Actual = myFirstMicroserviceApplication.deleteActor(testActorDelete).getBody();
        actorRepository.deleteById(testActorDelete.getActorId());
        Actor Expected = testActorDelete;
        Assertions.assertEquals(Expected,Actual,"Failed to delete actor with specified ID");
    }




    //----------------------Categories----------------//
    @Test
    void getAllCategories(){
        myFirstMicroserviceApplication.getAllCategories();
        verify(categoryRepository).findAll();
    }

    @Test
    void testGetByCategory (){
        Category testCategoryAction = new Category(1, "Action");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(testCategoryAction);
        when(myFirstMicroserviceApplication.getAllCategories()).thenReturn(categoryList);
        Assertions.assertEquals(categoryList, myFirstMicroserviceApplication.getAllCategories(), "No category found with category ID");
    }
    // ---------------------Films--------------------- //
    @Test
    void getAllFilms() {
        myFirstMicroserviceApplication.getAllFilms();
        verify(filmRepository).findAll();
    }
    @Test//get method for a film
    void getByFilm(){
        Film testFilm = new Film("DeadPool", "Film by Marvel",  "1",  120, "18");
        testFilm.setFilmId(1);
        when(filmRepository.findById(1)).thenReturn(Optional.of(testFilm));
        Film Actual = myFirstMicroserviceApplication.getByFilm(testFilm.getFilmId()).getBody();
        Film Expected = testFilm;
        Assertions.assertEquals(Expected,Actual,"No film found with film ID");
    }

    //-------------------Film Actors--------------------//
    @Test//tests whether all film actors can be retrieved
    void getAllFilmActors(){
        myFirstMicroserviceApplication.getAllFilmActors ();
        verify(filmActorRepository).findAll();
    }

    @Test//get method for a filmActors
    void getByFilmActor(){
        FilmActor testFilmActor = new FilmActor(1,1);
        when(filmActorRepository.findById(1)).thenReturn(Optional.of(testFilmActor));
        FilmActor Actual = myFirstMicroserviceApplication.getByFilmActor(testFilmActor.getFilmId()).getBody();
        FilmActor Expected = testFilmActor;
        Assertions.assertEquals(Expected,Actual,"No film actor retrieved with ID");
    }

    //-------------------Film Categories---------------//
    @Test
    void getAllFilmCategories(){
        myFirstMicroserviceApplication.getAllFilmCategories();
        verify(filmCategoryRepository).findAll();
    }




    //-------------------Search By Keyword--------------//
    @Test
    public void testKeyWord(){
        Film testFilm1 = new Film ("Deadpool", "FilmByMarvel", "1", 120, "18");

        when(filmRepository.findByTitleLikeOrDescriptionLike("%DeadPool%", "%DeadPool%")).thenReturn(List.of(testFilm1));
        List<Film>testFilm=myFirstMicroserviceApplication.getFilmByKeyword("DeadPool");
        Assertions.assertEquals(testFilm1,testFilm.get(0));
    }
    //------------------Languages-----------------------//
    @Test
    void getAllLanguages(){
        myFirstMicroserviceApplication.getAllLanguages();
        verify(languageRepository).findAll();
    }


}
















