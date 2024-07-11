package crm.crm.service;


import crm.crm.entity.Contrat;

import java.util.List;

public interface ContratService {
    List<Contrat> getAllContracts();
    Contrat getContractById(Long id);
    Contrat createContract(Contrat contrat);
    void deleteContract(Long id);
    Contrat updateContract(Long id, Contrat contrat);
}

