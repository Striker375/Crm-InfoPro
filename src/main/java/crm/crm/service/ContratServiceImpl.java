package crm.crm.service;
import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.Contrat;
import crm.crm.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContratServiceImpl implements ContratService {
    @Autowired
    private ContratRepository contractRepository;

    @Override
    public List<Contrat> getAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contrat getContractById(Long id) {
        return contractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
    }

    @Override
    public Contrat saveContract(Contrat contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void deleteContract(Long id) {
        Contrat contract = contractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
        contractRepository.delete(contract);
    }

    @Override
    public Contrat updateContract(Long id, Contrat contractDetails) {
        Contrat contract = contractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
        contract.setDetails(contractDetails.getDetails());
        contract.setStartDate(contractDetails.getStartDate());
        contract.setEndDate(contractDetails.getEndDate());
        // autres champs
        return contractRepository.save(contract);
    }
}
