package Unicam.IDS.Controllers;
import Unicam.IDS.AccountSystem.Customer;
import Unicam.IDS.Repo.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }


    // SELEZIONARE TUTTI I CUSTOMER

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/customers")
    List<Customer> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    // AGGIUNGERE UN CUSTOMER
    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    // SELEZIONARE UN CUSTOMER

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }
    //AGGIORNARE UN CUSTOMER
    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

        return repository.findById(id)
                .map(customer -> {
                    customer.setCellNumber(newCustomer.getCellNumber());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setPassword(newCustomer.getPassword());
                    customer.setName(newCustomer.getName());
                    customer.setSurname(newCustomer.getSurname());
                    return repository.save(customer);
                })
                .orElseGet(() -> {
                   //TODO newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

//RIMUOVERE UN CUSTOMER
    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
