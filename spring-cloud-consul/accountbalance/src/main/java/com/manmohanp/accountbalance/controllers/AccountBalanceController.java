package com.manmohanp.accountbalance.controllers;


import com.manmohanp.accountbalance.models.Balance;
import com.manmohanp.accountbalance.models.Offer;
import com.manmohanp.accountbalance.services.OffersService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(description = "Set of endpoints for Account balance APIs.")
public class AccountBalanceController {
    private static Logger logger = LogManager.getLogger(AccountBalanceController.class);

    @Autowired
    OffersService offersService;

    @RequestMapping(value = "/balance/{accountId}", method = RequestMethod.GET, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("${accountbalancecontroller.getaccountbalancebyaccountid}")
    @HystrixCommand(commandKey = "accountBalanceService")
    Balance getAccountBalanceByAccountId(@ApiParam("accountId for which balance to be obtained. Cannot be empty.")
                                       @PathVariable String accountId) {

        logger.debug("getAccountBalanceByAccountId - entry");

        Balance balance = new Balance();
        balance.setAccountId(accountId);
        balance.setBalance(22.5);
        balance.setOnDate(new Date());

        balance.setOffers(offersService.getOffers(accountId));

        logger.debug("balance: "+ balance.toString());

        logger.debug("getAccountBalanceByAccountId - exit");

        return balance;
    }

}
