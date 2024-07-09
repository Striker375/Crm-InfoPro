package crm.crm.service;

import crm.crm.DTO.ContratDTO;
import crm.crm.entity.Contrat;

import java.util.List;

public interface ContratService {
    List<ContratDTO> getAllContracts();
    ContratDTO getContractById(Long id);
    ContratDTO createContract(ContratDTO contratDTO);
    void deleteContract(Long id);
    ContratDTO updateContract(Long id, ContratDTO contractDTO);
}

