package crm.crm.service;


import crm.crm.entity.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> getAllContracts();
    Contract getContractById(Long id);
    Contract createContract(Contract contract);
    void deleteContract(Long id);
    Contract updateContract(Long id, Contract contract);
}

