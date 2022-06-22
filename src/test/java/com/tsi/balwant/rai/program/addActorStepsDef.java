package com.tsi.balwant.rai.program;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)

public class addActorStepsDef {


    //Creates mock or fake data
    @Mock
    Actor mockActor = new Actor ("First", "Last");

    @Mock
    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;
    @Mock
    private FilmActorRepository filmActorRepository;




    //Used for Assertions
    String Expected;
    String Actual;

    @BeforeEach
    void setup(){

        // sets up the mock data
        actorRepository= mock(ActorRepository.class);
        categoryRepository= mock(CategoryRepository.class);
        filmRepository= mock(FilmRepository.class);
        filmCategoryRepository= mock(FilmCategoryRepository.class);
        filmActorRepository = mock(FilmActorRepository.class);
        languageRepository = mock(LanguageRepository.class);



        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, filmCategoryRepository,
                filmActorRepository, categoryRepository, languageRepository);

    }

    @Given("I have the actor information")
    public void i_have_the_actor_information() {
        setup();
    }

    @When("I input the data into the database for adding an actor")
    public void i_input_the_data_into_the_database_for_adding_an_actor() {
        Actual = myFirstMicroserviceApplication.addActor(mockActor.getFirstName(), mockActor.getLastName());
    }

    @Then("I get the success return string for adding an actor")
    public void i_get_the_success_return_string_for_adding_an_actor() {
        Expected = "Actor has been successfully added";
        Assertions.assertEquals(Expected, Actual, "Actor has not been added.");
    }

}