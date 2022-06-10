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
        languageRepository = mock(LanguageRepository.class);
        filmRepository= mock(FilmRepository.class);
        filmCategoryRepository= mock(FilmCategoryRepository.class);
        filmActorRepository = mock(FilmActorRepository.class);



            myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, languageRepository, categoryRepository, filmCategoryRepository, filmActorRepository);

    }

    @Given("I have Actor information")
    public void i_have_actor_information() {
        setup();
    }

    @When("The actor information is inputted")
    public void the_actor_information_is_inputted() {
        Actual = myFirstMicroserviceApplication.addActor(mockActor.getFirst_name(), mockActor.getLast_name());
    }

    @Then("I get a return string confirming the success")
    public void i_get_a_return_string_confirming_the_success() {
        Expected = "Actor has been added.";
        Assertions.assertEquals(Expected, Actual, "Actor has not been added.");
    }

}

