package crm.crm.service;

import crm.crm.Exception.ResourceNotFoundException;
import crm.crm.entity.Contract;

import crm.crm.entity.Employee;
import crm.crm.repository.ContratRepository;
import crm.crm.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;


@Service @RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {
    private final EmployeeRepository employeeRepository;
    private final ContratRepository contratRepository;

    @Override

    public List<Contract> getAllContracts() {
        return contratRepository.findAll();
    }
    @Override
    public Contract getContractById(Long id) {
        Contract contract = contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
        return contract;
    }

    @Override
    public Contract createContract(Contract contract) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String username = userDetails.getUsername();
            Employee employee = employeeRepository.findByUsername(username);

            contract.setEmployee(employee);
        }

        Contract savedContract = contratRepository.save(contract);
        return savedContract;
    }
    @Override
    public void deleteContract(Long id) {
        Contract contract = contratRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not found"));
        contratRepository.delete(contract);
    }

    @Override
    public Contract updateContract(Long id, Contract contrat) {
        Contract contract = contratRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found"));

        // Map the DTO fields to the existing contract entity
        contract.setStartDate(contract.getStartDate());
        contract.setEndDate(contract.getEndDate());


        Contract updatedContract = contratRepository.save(contract);
        return updatedContract;
    }
}
