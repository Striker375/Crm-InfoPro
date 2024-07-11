package crm.crm.controller;
import crm.crm.entity.Contrat;

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

    @GetMapping("/List")
    public List<Contrat> getAllContracts() {
        return contractService.getAllContracts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getContractById(@PathVariable Long id) {
        Contrat contract = contractService.getContractById(id);
        return ResponseEntity.ok(contract);
    }

    @PostMapping("/createContrat")
    public Contrat createContract(@RequestBody Contrat contractDTO) {
        return contractService.createContract(contractDTO);
    }

    @PutMapping("/updateContrat/{id}")
    public Contrat updateContract(@PathVariable Long id, @RequestBody Contrat contract) {
        return contractService.updateContract(id, contract);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
        return ResponseEntity.noContent().build();
    }
}
