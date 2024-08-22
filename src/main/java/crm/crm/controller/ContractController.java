package crm.crm.controller;

import crm.crm.entity.Contract;
import crm.crm.service.ClientService;
import crm.crm.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping("/contracts") @RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;
    private final ClientService clientService;

    @GetMapping("/list")
    public String getAllContracts(Model model) {
        model.addAttribute("contracts", contractService.getAllContracts());
        return "contracts-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("clients", clientService.getAllClients());
        return "create-contract";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute Contract contract) {
        contractService.createContract(contract);
        return "redirect:/contracts/list";
    }
}
