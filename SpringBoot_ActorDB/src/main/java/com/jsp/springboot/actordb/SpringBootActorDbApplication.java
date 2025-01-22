package com.jsp.springboot.actordb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jsp.springboot.actordb.controller.ActorController;
import com.jsp.springboot.actordb.entity.Actor;

@SpringBootApplication
public class SpringBootActorDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActorDbApplication.class, args);
//		ApplicationContext ac=SpringApplication.run(SpringBootActorDbApplication.class, args);
//		Actor actor =new Actor();
//		actor.setActorId(101);
//		actor.setActorName("Yash");
//		actor.setAge(40);
//		actor.setIndustry("Sandalwood");
//		actor.setNationality("Indian");
//		
//		ActorController actorController=ac.getBean(ActorController.class);
//		actorController.addActor(actor);// here we are passing acotr Object to ActorController Class.
	}

}
