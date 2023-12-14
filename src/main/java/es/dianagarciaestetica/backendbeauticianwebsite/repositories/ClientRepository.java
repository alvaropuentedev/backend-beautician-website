package es.dianagarciaestetica.backendbeauticianwebsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.dianagarciaestetica.backendbeauticianwebsite.models.ClientDTO;

@Repository
public interface ClientRepository extends JpaRepository<ClientDTO, Long>{

}
