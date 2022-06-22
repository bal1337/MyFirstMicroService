package com.tsi.balwant.rai.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@SpringBootApplication
@RestController // Handles GET, POST, DELETE, PUT requests
@RequestMapping("/Home") //base url,  so url would be: localhost:8080/Home/
@CrossOrigin (origins = "*")     //needed for receiving request via api


public class MyFirstMicroserviceApplication {
    //@Autowired - To my understanding links together classes to the database
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmCategoryRepository filmCategoryRepository;
    @Autowired
    private FilmActorRepository filmActorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LanguageRepository languageRepository;



    public static void main(String[] args) {
        SpringApplication.run(MyFirstMicroserviceApplication.class, args);
    }

    public MyFirstMicroserviceApplication(
            ActorRepository actorRepository,
            FilmRepository filmRepository,
            FilmCategoryRepository filmCategoryRepository,
            FilmActorRepository filmActorRepository,
            CategoryRepository categoryRepository,
            LanguageRepository languageRepository){

        this.actorRepository = actorRepository;
        this.filmRepository = filmRepository;
        this.filmCategoryRepository = filmCategoryRepository;
        this.filmActorRepository = filmActorRepository;
        this.categoryRepository = categoryRepository;
        this.languageRepository = languageRepository;

    }


	/*-----------------------------------------------------------
	 					CRUD FUNCTIONS
	@PostMapping - creates, @GetMapping - reads, @PutMapping - updates, @DeleteMapping - deletes
	-----------------------------------------------------------*/
    // ---------------------Actors---------------------//
    @GetMapping("/actor/actors")
    public @ResponseBody
    Iterable<Actor>getAllActors(){
        return actorRepository.findAll();
    }

    // Gets actor by id
    @GetMapping("/actor/{actor_id}")
    public @ResponseBody Optional<Actor> getActorById (@PathVariable int actor_id){
        if (actorRepository.existsById(actor_id)){
            return actorRepository.findById(actor_id);

        } else throw new ResourceNotFoundException("No actor found with this ID");
    }

    // Adds Actor
    @PostMapping("/actor/add")
    public @ResponseBody String addActor (@RequestParam String first_name, @RequestParam String last_name){
        Actor addActor = new Actor(first_name, last_name);
        actorRepository.save(addActor);
        return  "Actor has been successfully added";
    }

    // Deletes an actor and displays the relevant message based on if the actor could or could not be found
    @DeleteMapping("/actor/delete")
    public @ResponseBody String removeActorByID (@RequestParam int actor_id){

        if (actorRepository.existsById(actor_id)){
            actorRepository.deleteById(actor_id);
            return "Actor has been successfully removed";
        } else throw new ResourceNotFoundException("This actor could not be deleted");
    }

    // Updates actor with new names
	@PutMapping ("/updateActor/{actor_id}")
    public @ResponseBody String updateActor(@PathVariable int actorId, @RequestParam String firstName, @RequestParam String lastName){

        if(actorRepository.existsById(actorId)){
            Actor actor = actorRepository.findById(actorId).get();
            actor.setFirstName(firstName);
            actor.setLastName(lastName);
            actorRepository.save(actor);
            return "The actor with this ID:" + actorId + " updated.";
        } else return "The actor with the specified ID:" + actorId + "failed to update";
	}

    // ---------------------Films---------------------//
    // Returns a list of all films
    @GetMapping("/film/films")
    public @ResponseBody
    Iterable<Film>getAllFilms(){
        return filmRepository.findAll();
    }

    // Returns a list of all film ids their category ids
    @GetMapping("/film/filmCategories")
    public @ResponseBody
    Iterable<FilmCategory>getAllFilmCategories(){
        return filmCategoryRepository.findAll();
    }

    // Returns a list of all categories and their ids
    @GetMapping("/film/categories")
    public @ResponseBody
    Iterable<Category>getAllCategories(){
        return categoryRepository.findAll();
    }

    // When a film's id is specified all the relevant information regarding the film is outputted
    @GetMapping("/film/{film_id}")
    public @ResponseBody Optional<Film> getFilmById (@PathVariable int film_id){
         if (filmRepository.existsById(film_id)){
            return filmRepository.findById(film_id);
        } else throw new ResourceNotFoundException("No film exists for the specified ID");

    }
    // ---------------------Keyword Search ---------------------//
    // Finds a list of films based on the keyword based off titles and descriptions of the films
    @GetMapping("/film/filmByKeyword/{keyword}")
    public List<Film> getFilmByKeyword(@PathVariable String keyword){
        // Used for the SQL query:
        keyword = "%" + keyword + "%";
        return filmRepository.findByTitleLikeOrDescriptionLike(keyword,  keyword);
    }
    // ---------------------Film Actors---------------------//
    // Returns a list of actor id's and their film id's
    @GetMapping("/film/actors")
    public @ResponseBody
    Iterable<FilmActor>getAllFilmActors(){
        return filmActorRepository.findAll();
    }

    // Finds a list of films based on the actor ID and returns the relevant information with regard to each film
    @GetMapping("/film/actor/{actorId}")
    public ResponseEntity <List<FilmActor>> getFilmByActor(@PathVariable int actorId){
        return new ResponseEntity<>(filmActorRepository.findByActorId(actorId),HttpStatus.OK);
    }

    // Finds a list of films based on specifying a specific category name
    @GetMapping ("/film/filmByCategory/{name}")
    public List<FilmCategory> getFilmsByCategoryName(@PathVariable String name){
        if (categoryRepository.findByName(name)!= null){
            return filmCategoryRepository.findByCategoryId(categoryRepository.findByName(name).getCategoryId());
        } else throw new ResourceNotFoundException("No film with the category entered could not be found");
    }

    //Returns a list of films based on the actor name search with specified first and last name
    @GetMapping ("/actor/name/{name}")
    public List<Actor> getFilmByActorName(@PathVariable String name){
        return actorRepository.findByFirstNameLikeOrLastNameLike("%" + name + "%", "%" + name + "%");	// The % are Used for the SQL query
    }

    // ---------------------Languages---------------------//

    // Returns all languages
    @GetMapping("/allLanguages")
    public @ResponseBody
    Iterable<Language>getAllLanguages(){
        return languageRepository.findAll();
    }

}