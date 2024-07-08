package crm.crm.service;

import crm.crm.DTO.ClientDTO;
import crm.crm.entity.Client;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    ClientDTO createClient(ClientDTO clientDTO);
    void deleteClient(Long id);
    ClientDTO updateClient(Long id, ClientDTO clientDTO);
}