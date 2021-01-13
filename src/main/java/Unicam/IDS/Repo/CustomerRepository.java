package Unicam.IDS.Repo;

import Unicam.IDS.AccountSystem.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {



    }

