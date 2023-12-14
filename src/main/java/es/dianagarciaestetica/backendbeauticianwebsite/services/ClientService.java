package es.dianagarciaestetica.backendbeauticianwebsite.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.dianagarciaestetica.backendbeauticianwebsite.models.ClientDTO;
import es.dianagarciaestetica.backendbeauticianwebsite.repositories.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
	
	
	private final ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> getClients() {
		return clientRepository.findAll();
	}
	
	@Transactional
	public ClientDTO save(ClientDTO clientDTO) {
		return clientRepository.save(clientDTO);
	}
	
	@Transactional
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
	
    @Transactional(readOnly = true)
    public boolean existById(Long id) {
        return clientRepository.existsById(id);
    }
}
