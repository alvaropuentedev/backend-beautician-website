package es.dianagarciaestetica.backendbeauticianwebsite.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dianagarciaestetica.backendbeauticianwebsite.models.ClientDTO;
import es.dianagarciaestetica.backendbeauticianwebsite.services.ClientService;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = { "https://dianagarciaestetica.es", "http://localhost:4200/" })
@AllArgsConstructor
@RequestMapping("/api")
public class ClientController {

	private final ClientService clientService;

	@GetMapping("/listClient")
	public ResponseEntity<?> getClients() {
		Map<String, Object> map = new HashMap<>();
		try {
			List<ClientDTO> result = clientService.getClients();
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PostMapping("createClient")
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        return clientService.save(clientDTO);
    }
	
    @DeleteMapping("/deleteClient/{idClient}")
    public ResponseEntity<?> deleteClient(@PathVariable Long idClient) {
        if (clientService.existById(idClient)) {
            clientService.delete(idClient);
            Map<String, String> message = new HashMap<>();
            message.put("message", idClient + " client removed");
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } else {
            Map<String, String> message = new HashMap<>();
            message.put("message", idClient + " item not found or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
