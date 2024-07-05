package crm.crm.service;

import crm.crm.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client saveClient(Client client);
    void deleteClient(Long id);
    Client updateClient(Long id, Client clientDetails);
}