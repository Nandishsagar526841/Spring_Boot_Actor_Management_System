package com.jsp.springboot.actordb.service;



import java.util.List;

import com.jsp.springboot.actordb.entity.Actor;

public interface ActorService {
	
	public Actor addActor(Actor actor);
	
	
	public List<Actor> findAllActors();
	
	public Actor findActorById(int actorId);
	
	public Actor updateById(int actorId,Actor updatedActor);
	
	public Actor deleteById(int actorId);
	
	public List<Actor> findByActorName(String actorName);
	
	public List<Actor> findByAge(int age);
	
	public List<Actor> findByIndustry(String industry);
}
