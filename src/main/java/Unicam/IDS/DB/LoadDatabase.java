package Unicam.IDS.DB;


import Unicam.IDS.AccountSystem.Customer;
import Unicam.IDS.Repo.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {

        return args -> {
            //TODO REMOVE l'intera classe
            log.info("Preloading " + repository.save(new Customer(0000000000,"admin@admin.it", "admin", "admin","admin","")));
             };
    }
}