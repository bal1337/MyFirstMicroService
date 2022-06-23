package com.tsi.balwant.rai.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
    @GetMapping("/Get_All_Actors")//get all actors within the actor table
    public @ResponseBody
    Iterable<Actor>getAllActors(){
        return  actorRepository.findAll();
    }

    @GetMapping("/Get_By_Actor")//get an actor from actor table with id given
    public ResponseEntity<Actor>getByActor(@RequestParam Integer id){
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No actor found with ID" ));
        return ResponseEntity.ok(actor);
    }

    // Adds Actor
    @PostMapping("/Add_A_Actor")
    public @ResponseBody String addActor (@RequestParam String first_name, @RequestParam String last_name){
        Actor addActor = new Actor(first_name, last_name);
        actorRepository.save(addActor);
        return  "Actor has been successfully added";
    }


    @PutMapping("/Update_A_Actor")
    public @ResponseBody ResponseEntity<Actor> updateActor(@RequestBody Actor UpdateActor){
        Actor updateActor = actorRepository.findById(UpdateActor.getActorId()).orElseThrow(() -> new ResourceNotFoundException("Actor failed to update with specified ID "));
        updateActor.firstName = UpdateActor.firstName;
        updateActor.lastName = UpdateActor.lastName;
        actorRepository.save(updateActor);
        return ResponseEntity.ok(updateActor);
    }

    @DeleteMapping("/Delete_A_Actor")
    public ResponseEntity<Actor> deleteActor(@RequestBody Actor DeleteActor){
        Actor deleteActor = actorRepository.findById(DeleteActor.getActorId()).orElseThrow(() -> new ResourceNotFoundException("Failed to delete actor with specified ID"));
        actorRepository.deleteById(deleteActor.getActorId());
        return ResponseEntity.ok(deleteActor);
    }
    //--------------------Categories------------------//
    // Returns a list of all categories and their ids
    @GetMapping("/Get_All_Categories")
    public @ResponseBody Iterable<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/Get_By_Category")
    public ResponseEntity<Category>getByCategory(@RequestParam Integer id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No category found with ID" ));
        return ResponseEntity.ok(category);
    }

    // ---------------------Films---------------------//
    // Returns a list of all films
    @GetMapping("/Get_All_Films")
    public @ResponseBody Iterable<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    @GetMapping("/Get_By_Film")
    public ResponseEntity<Film>getByFilm(@RequestParam Integer id){
        Film film = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No film found with film ID" ));
        return ResponseEntity.ok(film);
    }
    // ---------------------Film Actors---------------------//
    @GetMapping("/Get_All_FilmActor")
    public @ResponseBody Iterable<FilmActor> getAllFilmActors() {
        return filmActorRepository.findAll();
    }

    @GetMapping("/Get_By_FilmActor")
    public ResponseEntity<FilmActor> getByFilmActor(@RequestParam int id){
        FilmActor filmActor = filmActorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No film actor retrieved with ID" ));
        return ResponseEntity.ok(filmActor);
    }

    //-------------------------------- FILM CATEGORY ---------------------------/////
    // Finds a list of films based on specifying a specific category name
    @GetMapping("/Get_All_FilmCategory")
    public @ResponseBody Iterable<FilmCategory> getAllFilmCategories(){
        return filmCategoryRepository.findAll();
    }

    @GetMapping("/Get_By_FilmCategory")
    public ResponseEntity<FilmCategory> getByFilmCategory(@RequestParam int id){
        FilmCategory filmCategory = filmCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No film category found with ID" ));
        return ResponseEntity.ok(filmCategory);
    }

    @GetMapping("/Get_Film_By_Category_Name")
    public List<FilmCategory> getFilmByCategoryName(@PathVariable String name){
        return filmCategoryRepository.findByCategoryId(categoryRepository.findByName(name).getCategoryId());
    }

    // ---------------------Keyword Search ---------------------//
    // Finds a list of films based on the keyword based off titles and descriptions of the films
    @GetMapping("/film/filmByKeyword/{keyword}")
    public List<Film> getFilmByKeyword(@PathVariable String keyword){
        // Used for the SQL query:
        keyword = "%" + keyword + "%";
        return filmRepository.findByTitleLikeOrDescriptionLike(keyword,  keyword);
    }
    // ---------------------Languages---------------------//

    // Returns all languages
    @GetMapping("/Get_All_Language")
    public @ResponseBody Iterable<Language> getAllLanguages(){
        return languageRepository.findAll();
    }

    @GetMapping("/Get_By_Language")
    public ResponseEntity<Language> getByLanguageName(@RequestParam int id){
        Language language = languageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No language found with ID" ));
        return ResponseEntity.ok(language);
    }



}