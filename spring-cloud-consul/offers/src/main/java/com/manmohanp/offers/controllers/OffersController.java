package com.manmohanp.offers.controllers;


import com.manmohanp.offers.models.Offer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@RestController
@Api(description = "Set of endpoints for offers APIs.")
public class OffersController {

    private static Logger logger = LogManager.getLogger(OffersController.class);

    @RequestMapping(value = "/offers/{accountId}", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("${offerscontroller.getalloffersbyaccountid}")
    @HystrixCommand(commandKey = "offersService")
    List<Offer> getAllOffersByAccountId(@ApiParam("accountId for which offers to be obtained. Cannot be empty.")
                                       @PathVariable String accountId) {

        logger.debug("getAllOffersByAccountId - entry");

        Offer offer = new Offer();
        offer.setId("NEW_OFFER");
        offer.setName("Golden Bonanza");
        offer.setDetail("Offer description, price, etc");
        Date currentDate = new Date();
        // convert date to localdatetime
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime fromDt = localDateTime.minusMonths(1);
        LocalDateTime toDt = localDateTime.plusMonths(2);
        offer.setValidFrom(Date.from(fromDt.atZone(ZoneId.systemDefault())
                .toInstant()));
        offer.setValidTo(Date.from(toDt.atZone(ZoneId.systemDefault())
                .toInstant()));

        List<Offer> offers = new ArrayList<Offer>();
        offers.add(offer);

        logger.debug("offers: "+ offers.toString());

        logger.debug("getAllOffersByAccountId - exit");

        return offers;
    }
}
