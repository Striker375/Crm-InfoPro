package crm.crm.service;

import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.Client;
import crm.crm.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;


    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override

        public Client getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        return client;
    }

    @Override
    public Client createClient(Client client) {
        Client savedClient = clientRepository.save(client);
        return savedClient;
    }

    @Override
    public Client updateClient(Long id, Client updatedClient) {
        Client existingClient = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));

        existingClient.setName(updatedClient.getName());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setPhoneNumber(updatedClient.getPhoneNumber());
        existingClient.setAdresse(updatedClient.getAdresse());

        return clientRepository.save(existingClient);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        clientRepository.delete(client);
    }
}
