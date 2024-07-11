package crm.crm.service;

import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.Contrat;

import crm.crm.repository.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service @AllArgsConstructor
public class ContratServiceImpl implements ContratService {

    private ContratRepository contratRepository;

    @Override

    public List<Contrat> getAllContracts() {
        return contratRepository.findAll();
    }
    @Override
    public Contrat getContractById(Long id) {
        Contrat contract = contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
        return contract;
    }

    @Override
    public Contrat createContract(Contrat contrat) {

        Contrat savedContract = contratRepository.save(contrat);
        return savedContract;
    }
    @Override
    public void deleteContract(Long id) {
        Contrat contract = contratRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
        contratRepository.delete(contract);
    }

    @Override
    public Contrat updateContract(Long id, Contrat contrat) {
        Contrat contract = contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));

        // Map the DTO fields to the existing contract entity
        contract.setStartDate(contract.getStartDate());
        contract.setEndDate(contract.getEndDate());


        Contrat updatedContract = contratRepository.save(contract);
        return updatedContract;
    }
}
