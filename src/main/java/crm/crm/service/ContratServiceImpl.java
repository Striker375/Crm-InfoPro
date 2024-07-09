package crm.crm.service;
import crm.crm.DTO.ContratDTO;
import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.Contrat;
import crm.crm.mapper.ContratMapper;
import crm.crm.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ContratServiceImpl implements ContratService {
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private ContratMapper contratMapper;
    @Override

    public List<ContratDTO> getAllContracts() {
        return contratRepository.findAll().stream()
                .map(contratMapper::contratToContratDTO)
                .collect(Collectors.toList());
    }
    @Override
    public ContratDTO getContractById(Long id) {
        Contrat contract = contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
        return contratMapper.contratToContratDTO(contract);
    }

    @Override
    public ContratDTO createContract(ContratDTO contractDTO) {
        Contrat contract = contratMapper.contratDTOToContrat(contractDTO);
        Contrat savedContract = contratRepository.save(contract);
        return contratMapper.contratToContratDTO(savedContract);
    }
    @Override
    public void deleteContract(Long id) {
        Contrat contract = contratRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
        contratRepository.delete(contract);
    }

    @Override
    public ContratDTO updateContract(Long id, ContratDTO contractDTO) {
        Contrat contract = contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));

        // Map the DTO fields to the existing contract entity
        contractDTO.setStartDate(contractDTO.getStartDate());
        contractDTO.setEndDate(contractDTO.getEndDate());


        Contrat updatedContract = contratRepository.save(contract);
        return contratMapper.contratToContratDTO(updatedContract);
    }
}
