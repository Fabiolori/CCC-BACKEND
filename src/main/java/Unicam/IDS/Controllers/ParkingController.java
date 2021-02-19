package Unicam.IDS.Controllers;


import Unicam.IDS.Model.Parking;
import Unicam.IDS.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingController {


    @Autowired
    ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }


    @GetMapping("/parking")
    List<Parking> all() {
        return service.getParking();
    }
    // end::get-aggregate-root[]

    // AGGIUNGERE UN PARKING
    @PostMapping("/parking")
    Parking newParking(@RequestBody  Parking newParking) {
        return service.createParking(newParking);
    }

    // SELEZIONARE UN PARKING
    @GetMapping("/parking/{id}")
    Parking one(@PathVariable Long id) {

        return service.getParkingbyID(id);
    }



    //AGGIORNARE UN PARKING
    @RequestMapping( value = "/parking/{id}", method = RequestMethod.PUT)
    Parking replaceParking(@RequestBody Parking newParking, @PathVariable Long id) {

        return service.updateParking(newParking,id);
    }

    //RIMUOVERE UN PARKING
    @DeleteMapping("/parking/{id}")
    void deleteParking(@PathVariable Long id) {
        service.deleteParking(id);
    }


}


