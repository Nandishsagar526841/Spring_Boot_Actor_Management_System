package com.jsp.springboot.actordb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.service.ActorService;
@Controller
@ResponseBody
// this annotation is responsible for bundle the return data of a method into a http response
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	// here We can give (ActorServiceImpl actorServiceImpl)also because here just we are getting the reference .
	// but internally the object of ActorServiceImpl class has created by Spring.
	// ActorService actorService = new ActorServiceImpl(); or ActorServiceImpl actorServiceImpl = new ActorServiceImpl();
	
	@RequestMapping(value = "/actors", method=RequestMethod.POST)
	public Actor addActor(@RequestBody Actor actor) {
		return actorService.addActor(actor);
	}
	// @RequestBody is responsible for accepting the request from http request (It required only when whole Object is sent not for the single parameters)
	
	@RequestMapping(value = "/actors", method=RequestMethod.GET)
	public List<Actor> findAllActors(){
		return actorService.findAllActors();
	}
	
	@RequestMapping(value = "/actors/id", method=RequestMethod.GET)
	public Actor findActorbyId(int actorId) {
		return actorService.findActorById(actorId);
	}
	
	
	@RequestMapping(value = "/actors", method=RequestMethod.PUT)
	public Actor updateById(int actorId, @RequestBody Actor updatedActor) {
		return actorService.updateById(actorId,updatedActor);
		}
	
	@RequestMapping(value = "/actors", method=RequestMethod.DELETE)
	public Actor deleteById(int actorId) {
		return actorService.deleteById(actorId);
		}
	
	@RequestMapping(value = "/actors/name", method=RequestMethod.GET)
	public List<Actor> findByIdActorName(String actorName) {
		return actorService.findByActorName(actorName);
		}
	
	@RequestMapping(value = "/actors/age", method=RequestMethod.GET)
	public List<Actor> findByIdAge(int age) {
		return actorService.findByAge(age);
		}
	
	@RequestMapping(value = "/actors/indus", method=RequestMethod.GET)
	public List<Actor> findByIndustry(String indus){
		return actorService.findByIndustry(indus);
	}
	
	
}
