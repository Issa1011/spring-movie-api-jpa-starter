package ek.osnb.starter.service;

import ek.osnb.starter.exceptions.NotFoundException;
import ek.osnb.starter.model.Actor;
import ek.osnb.starter.model.ActorDTO;
import ek.osnb.starter.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public ActorDTO getActorById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new NotFoundException("Actor not found with id" + id));

        return new ActorDTO(
                actor.getName(),
                actor.getBirthYear()
        );
    }
}
