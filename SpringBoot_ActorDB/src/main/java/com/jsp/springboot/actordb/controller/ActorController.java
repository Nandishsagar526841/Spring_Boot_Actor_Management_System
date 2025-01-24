package com.jsp.springboot.actordb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.service.ActorService;
import com.jsp.springboot.actordb.utility.ResponseStructure;
//@Controller
//@ResponseBody
@RestController
// this annotation is responsible for bundle the return data of a method into a http response
public class ActorController {

	@Autowired
	private ActorService actorService;
	// here We can give (ActorServiceImpl actorServiceImpl)also because here just we are getting the reference .
	// but internally the object of ActorServiceImpl class has created by Spring.
	// ActorService actorService = new ActorServiceImpl(); or ActorServiceImpl actorServiceImpl = new ActorServiceImpl();

	//	@RequestMapping(value = "/actors", method=RequestMethod.POST)
	@PostMapping("/actors")
	public ResponseEntity<ResponseStructure<Actor>> addActor(@RequestBody Actor actor) {
		return actorService.addActor(actor);
	}
	// @RequestBody is responsible for accepting the request from http request (It required only when whole Object is sent not for the single parameters)



	//	@RequestMapping(value = "/actors", method=RequestMethod.GET)
	@GetMapping("/actors")
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors(){
		return actorService.findAllActors();
	}
 
	//	@RequestMapping(value = "/actors/id", method=RequestMethod.GET)
	@GetMapping("/actors/id")
	public ResponseEntity<ResponseStructure<Actor>> findActorbyId(int actorId) {
		return actorService.findActorById(actorId);
	}


	//	@RequestMapping(value = "/actors", method=RequestMethod.PUT)
	@PutMapping("/actors")
	public ResponseEntity<ResponseStructure<Actor>> updateById(int actorId, @RequestBody Actor updatedActor) {
		return actorService.updateById(actorId,updatedActor);
	}

	//	@RequestMapping(value = "/actors", method=RequestMethod.DELETE)
	@DeleteMapping("/actors")
	public  ResponseEntity<ResponseStructure<Actor>> deleteById(int actorId) {
		return actorService.deleteById(actorId);
	}

	//	@RequestMapping(value = "/actors/name", method=RequestMethod.GET)
	@GetMapping("/actors/name")
	public ResponseEntity<ResponseStructure<List<Actor>>> findByIdActorName(String actorName) {
		return actorService.findByActorName(actorName);
	}

	//	@RequestMapping(value = "/actors/age", method=RequestMethod.GET)
	@GetMapping("/actor/age")
	public List<Actor> findByIdAge(int age) {
		return actorService.findByAge(age);
	}

	//	@RequestMapping(value = "/actors/indus", method=RequestMethod.GET)
	@GetMapping( "/actors/indus")
	public List<Actor> findByIndustry(String indus){
		return actorService.findByIndustry(indus);
	}


}
