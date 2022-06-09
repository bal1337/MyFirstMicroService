package com.tsi.balwant.rai.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@CrossOrigin(origins = "*") // required for receiving a request through API
@SpringBootApplication
@RestController // manages GET, POST, DELETE and PUT requests
@RequestMapping("/Home") // URL base
public class MyFirstMicroserviceApplication {

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private LanguageRepository languageRepository;

	private String save="Save";


	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, FilmRepository filmRepository,
										  CategoryRepository categoryRepository,LanguageRepository languageRepository) {

		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.categoryRepository = categoryRepository;
		this.languageRepository = languageRepository;
	}

	//****--ACTORS--****//
	//Reads all actors
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	// Finds specific actor based off ID
	@GetMapping("/Get_Actor/{actor_id}")
	public @ResponseBody
	Optional<Actor> getActorByID(@PathVariable int actor_id){
		return actorRepository.findById(actor_id);
	}
	//Build create actor REST API
//	@PostMapping("/Add_Actor")
//	public @ResponseBody
//	String addActor(@RequestParam String first_name, @RequestParam String last_name) {
//		Actor newActor = new Actor(first_name, last_name);
//		actorRepository.save(newActor);
//		return save;
//	}

	//CRUD Methods for Actors//
	@PostMapping("/addActor")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return save;
	}

	//Update Actor
	@PutMapping("/updateActor")
	public ResponseEntity<Actor> updateActor(@RequestParam Integer id, String first_name, String last_name){
		Actor updateActor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with this id: " +id));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		return ResponseEntity.ok(updateActor);
	}

	// Delete Actor
	@DeleteMapping("/deleteActor/{actor_id}")
	public String deleteActor(@PathVariable("actor_id") int actor_id) {
		actorRepository.deleteById(actor_id);
		return "Actor has been deleted successfully";
	}

	//CRUD Methods for Films//
//	@PostMapping("/newFilms")
//	public @ResponseBody
//	String addNewFilm(@RequestParam String title, int release_year, String rating, String description){
//		Film addNewFilm = new Film(title, release_year, rating, description);
//		filmRepository.save(addNewFilm);
//		return save;
//	}

	@GetMapping("/Films")
	public @ResponseBody
	Iterable<Film> getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/GetFilm/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmByID(@PathVariable int film_id){
		return filmRepository.findById(film_id);
	}

}




