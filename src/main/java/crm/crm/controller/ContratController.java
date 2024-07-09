package crm.crm.controller;

import crm.crm.DTO.ContratDTO;
import crm.crm.mapper.ContratMapper;
import crm.crm.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContratController {

    @Autowired
    private ContratService contractService;

    @Autowired
    private ContratMapper contractMapper;

    @GetMapping
    public List<ContratDTO> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratDTO> getContractById(@PathVariable Long id) {
        ContratDTO contractDTO = contractService.getContractById(id);
        return ResponseEntity.ok(contractDTO);
    }

    @PostMapping
    public ContratDTO createContract(@RequestBody ContratDTO contractDTO) {
        return contractService.createContract(contractDTO);
    }

    @PutMapping("/{id}")
    public ContratDTO updateContract(@PathVariable Long id, @RequestBody ContratDTO contractDTO) {
        return contractService.updateContract(id, contractDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
        return ResponseEntity.noContent().build();
    }
}
