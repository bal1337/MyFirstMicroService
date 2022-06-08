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


	private String save="Save";


	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository) {

		this.actorRepository = actorRepository;
	}

	//****--ACTORS--****//
	//Reads all actors
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	// Finds specific actor based off ID
	@GetMapping("/Actor/{actor_id}")
	public @ResponseBody
	Optional<Actor> getActorByID(@PathVariable int actor_id) {
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
	@PostMapping("/newActors")
	public @ResponseBody
	String addActors(@RequestParam String first_name, String last_name){
		Actor addActors = new Actor(first_name, last_name);
		actorRepository.save(addActors);
		return save;
	}

	//Update Actor
	@PutMapping("/Update_Actor")
	public ResponseEntity<Actor> Update_Actor(@RequestParam Integer id, String first_name, String last_name){
		Actor Update_Actor = actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor does not exist with this id: " +id));
		Update_Actor.setFirst_name(first_name);
		Update_Actor.setLast_name(last_name);
		return ResponseEntity.ok(Update_Actor);
	}

	// Delete Actor
	@DeleteMapping("/removeActor/{actor_id}")
	public String deleteActor(@PathVariable("actor_id") int actor_id) {
		actorRepository.deleteById(actor_id);
		return "Actor Removed Successfully";
	}
}




