package com.jsp.springboot.actordb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot.actordb.entity.Actor;
// here using @Repository annotation doesnot create a object because this is a interface.
// For ActorRepository interface we have extended jpa Repository interface with some generics containing the entity class detail and primary key detail
// Implementation for ActorRepostiory interface is given by Spring Data Jpa based on generics given
public interface ActorRepository extends JpaRepository<Actor, Integer> {
	// Spring Data Jpa will provide implementation by providing some methods
	// save(Actor actor);
	// findById(int actorId)
	// findAll()
	// delete(Actor a)
	// deleteById(int actorId)
	// it doesnot provide any update methods
	
	
	//if need more methods we need to create it called custom method
	
	public List<Actor> findByActorName(String actorName);
	
	public List<Actor> findByAge(int age);
	
	public List<Actor> findByIndustry(String industry);
	
//	public List<Actor> findByNationality();
}
