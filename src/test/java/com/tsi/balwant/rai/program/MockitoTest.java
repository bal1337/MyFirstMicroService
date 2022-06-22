package com.tsi.balwant.rai.program;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;


import java.util.ArrayList;
import java.util.List;


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


    @Mock
    Actor newActor1 = new Actor(1, "Bal", "Rai");
    @Mock
    Actor newActor2 = new Actor(2, "Arjun", "Rai");
    @Mock
    Film testFilm1 = new Film (1, "DeadPool", "Film by marvel", 150, 1);
    @Mock
    Film testFilm2 = new Film (2, "Happy Gilmore", "Lucky golfer", 150, 1);
    @Mock
    FilmCategory testFilmCategory1 = new FilmCategory (1, 1);
    @Mock
    FilmCategory testFilmCategory2 = new FilmCategory (2, 2);



    @Mock Category testCategoryAction = new Category(1, "Action");
    @Mock Category testCategoryComedy = new Category(2, "Comedy");

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
    void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();

    }
    @Test
    void testAddActor(){
        Actual = myFirstMicroserviceApplication.addActor(newActor1.getFirstName(), newActor1.getLastName());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class); //Allows you to capture arguments passed to a method in this case, its catching the Actor class
        verify(actorRepository).save(actorArgumentCaptor.capture()); // Verify checks to make sure the method has run
        actorArgumentCaptor.getValue(); // From my understanding, it would get the last value added to the actorArgumentCaptor, in this case the Actor class
        Expected = "Actor has been successfully added";
        Assertions.assertEquals(Expected, Actual, "Actor not saved in Database.");
    }


    // ---------------------Films--------------------- //



    @Test
    void getFilmByActor(){
       myFirstMicroserviceApplication.getFilmByActor(1);
        verify(filmActorRepository).findByActorId(1);
    }
    @Test
    void getAllFilms(){
        List<Film> filmList = new ArrayList<>();
        filmList.add(testFilm1);
        when(myFirstMicroserviceApplication.getAllFilms()).thenReturn(filmList);
        Assertions.assertEquals(filmList, myFirstMicroserviceApplication.getAllFilms());
    }

    @Test
    void getAllFilmCategories(){
        myFirstMicroserviceApplication.getAllFilmCategories();
        verify(filmCategoryRepository).findAll();
    }
    @Test
    void getAllCategories(){
        myFirstMicroserviceApplication.getAllCategories();
        verify(categoryRepository).findAll();
    }

    @Test
    public void testGetCategory (){

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(testCategoryAction);
        when(myFirstMicroserviceApplication.getAllCategories()).thenReturn(categoryList);
        Assertions.assertEquals(categoryList, myFirstMicroserviceApplication.getAllCategories(), "Category has failed");
    }





    // ---------------------Languages--------------------- //
    @Test
    void getAllLanguages(){
        myFirstMicroserviceApplication.getAllLanguages();
        verify(languageRepository).findAll();
    }
}
