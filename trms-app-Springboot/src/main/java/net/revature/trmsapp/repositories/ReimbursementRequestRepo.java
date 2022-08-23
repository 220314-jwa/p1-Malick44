package net.revature.trmsapp.repositories;

import net.revature.trmsapp.models.ReimbursementRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementRequestRepo extends JpaRepository<ReimbursementRequest, Integer> {

}
