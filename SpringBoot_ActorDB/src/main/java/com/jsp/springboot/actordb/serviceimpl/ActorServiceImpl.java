package com.jsp.springboot.actordb.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.repository.ActorRepository;
import com.jsp.springboot.actordb.service.ActorService;
@Service
public class ActorServiceImpl implements ActorService{
	// Autowired means it automatically generates the object just we are using the field reference.instead of creating of object of it.
	@Autowired
	private ActorRepository actorRepository;

	@Override
	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);
		//		return "Actor Added SuccessFully!!";
	}

	@Override
	public List<Actor> findAllActors() {
		List<Actor> actors=actorRepository.findAll();
		if(actors.isEmpty()) {
			return null;
		}
		else {
			return actors;
		}

	}

	@Override
	public Actor findActorById(int actorId) {// findById() it always return optional type data (Optional Class is present in java 8)Know the Methods.
		Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor actor=optional.get();// get() is a method in optional class it returns the whole Object that given.
			return actor;
		}
		else {
			return null;
		}

	}

	@Override
	public Actor updateById(int actorId, Actor updatedActor) {
		Optional<Actor> optional=actorRepository.findById(actorId);

		if(optional.isPresent()) {
			Actor existingActor= optional.get();
			updatedActor.setActorId(existingActor.getActorId());
			return actorRepository.save(updatedActor);
		}
		else
		{
			return null;
		}

	}

	@Override
	public Actor deleteById(int actorId) {
		Optional<Actor> optional=actorRepository.findById(actorId);
		 if(optional.isPresent()) {
			 Actor existingActor=optional.get();
			 actorRepository.delete(existingActor);
			 return existingActor;
		 }
		return null;
	}

	@Override
	public List<Actor> findByActorName(String actorName) {
	List<Actor> actors=actorRepository.findByActorName(actorName);
	   if(actors.isEmpty()) {
		   return null;
	   }else {
		   return actors;
	   }
		
	
	}

	@Override
	public List<Actor> findByAge(int age) {
		List<Actor>actors=actorRepository.findByAge(age);
		if(actors.isEmpty()) {
			return null;
		}else {
			return actors;
		}
	}

	@Override
	public List<Actor> findByIndustry(String industry) {
		List<Actor> actors=actorRepository.findByIndustry(industry);
		if(actors.isEmpty()) {
			return null;
		}else {		
		return actors;
		}
	}

	
}
