package crm.crm.controller;

import crm.crm.entity.Client;
import crm.crm.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/list")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "clients-list";
    }

    @GetMapping("/{id}")
    public String getClientById(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "client-details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("client", new Client());
        return "create-client";
    }

    @PostMapping("/create")
    public String createClient(@ModelAttribute Client client) {
        clientService.createClient(client);
        return "redirect:/clients/list";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            throw new RuntimeException("Client not found for id :: " + id);
        }
        model.addAttribute("client", client);
        return "update-client";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable Long id, @ModelAttribute Client updatedClient) {
        clientService.updateClient(id, updatedClient);
        return "redirect:/clients/list";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id);
        if (client == null) {
            throw new RuntimeException("Client not found for id :: " + id);
        }
        model.addAttribute("client", client);
        return "delete-client";
    }

    @PostMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients/list";
    }
}