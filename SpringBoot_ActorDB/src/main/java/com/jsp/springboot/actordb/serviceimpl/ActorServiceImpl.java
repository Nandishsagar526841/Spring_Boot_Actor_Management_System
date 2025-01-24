package com.jsp.springboot.actordb.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.actordb.entity.Actor;
import com.jsp.springboot.actordb.exception.ActorNotFoundByIdException;
import com.jsp.springboot.actordb.exception.ActorNotFoundException;
import com.jsp.springboot.actordb.repository.ActorRepository;
import com.jsp.springboot.actordb.service.ActorService;
import com.jsp.springboot.actordb.utility.ResponseStructure;
@Service
public class ActorServiceImpl implements ActorService{
	// Autowired means it automatically generates the object just we are using the field reference.instead of creating of object of it.
	@Autowired
	private ActorRepository actorRepository;

	@Override
	public ResponseEntity<ResponseStructure<Actor>> addActor(Actor actor) {
		Actor actor2=	actorRepository.save(actor);
		ResponseStructure<Actor> responseStructure=new ResponseStructure<Actor>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Actor Object Added Successfully..!");
		responseStructure.setObject(actor2);
		return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.CREATED);
 
		//		return "Actor Added SuccessFully!!";
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findAllActors() {
		List<Actor> actors=actorRepository.findAll();
		if(actors.isEmpty()) {
			throw new ActorNotFoundException("Actor Not Found");
		}
		else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actor Data's are Found..!");
			responseStructure.setObject(actors);
			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> findActorById(int actorId) {// findById() it always return optional type data (Optional Class is present in java 8)Know the Methods.
		Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor actor=optional.get();// get() is a method in optional class it returns the whole Object that given.
			ResponseStructure<Actor> responseStructure=new  ResponseStructure<Actor>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully fetch the Actor Object...!");
			responseStructure.setObject(actor);
			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new ActorNotFoundByIdException("Actor Object Not Found..!!");
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> updateById(int actorId, Actor updatedActor) {
		Optional<Actor> optional=actorRepository.findById(actorId);

		if(optional.isPresent()) {
			Actor existingActor= optional.get();
			updatedActor.setActorId(existingActor.getActorId());
			Actor actor=actorRepository.save(updatedActor);
			ResponseStructure<Actor> responseStructure=new ResponseStructure<Actor>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Actor Object Successfully Updated..!");
			responseStructure.setObject(actor);

			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.ACCEPTED);

		}
		else
		{
			return null;
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<Actor>> deleteById(int actorId) {
		Optional<Actor> optional=actorRepository.findById(actorId);
		if(optional.isPresent()) {
			Actor existingActor=optional.get();
			actorRepository.delete(existingActor);
			ResponseStructure<Actor> responseStructure=new ResponseStructure<Actor>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Actor Object Successfully deleted..!");
			responseStructure.setObject(existingActor);

			return new ResponseEntity<ResponseStructure<Actor>>(responseStructure,HttpStatus.ACCEPTED);
		}
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Actor>>> findByActorName(String actorName) {
		List<Actor> actors=actorRepository.findByActorName(actorName);
		if(actors.isEmpty()) {
			return null;
		}else {
			ResponseStructure<List<Actor>> responseStructure=new ResponseStructure<List<Actor>>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Actor Object Found Successfully By Name..!");
			responseStructure.setObject(actors);

			return new ResponseEntity<ResponseStructure<List<Actor>>>(responseStructure,HttpStatus.FOUND);
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
