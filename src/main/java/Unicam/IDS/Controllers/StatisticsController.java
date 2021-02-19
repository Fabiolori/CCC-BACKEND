package Unicam.IDS.Controllers;

import Unicam.IDS.Model.Statistics;
import Unicam.IDS.Service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @RequestMapping (value = "/statistics", method = RequestMethod.GET)
    Statistics getStatistics(long id){
    return statisticsService.getStatistics(id);

    }



}
