package net.revature.trmsapp.repositories;

import net.revature.trmsapp.models.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepo extends JpaRepository <EventType,Integer>{
}
