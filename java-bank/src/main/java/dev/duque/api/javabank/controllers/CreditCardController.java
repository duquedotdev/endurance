package dev.duque.api.javabank.controllers;

import dev.duque.api.javabank.dtos.CreditCardDTO;
import dev.duque.api.javabank.model.CreditCardModel;
import dev.duque.api.javabank.services.CreditCardService;
import dev.duque.api.javabank.utils.CreditCardNumberGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;
import java.util.stream.IntStream;

@Api(value = "CreditCardController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/credit-card")
public class CreditCardController {

    final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public ResponseEntity<Object> createCreditCard(@RequestBody @Valid CreditCardDTO creditCardDTO) {
        CreditCardModel creditCardModel = new CreditCardModel();

        BeanUtils.copyProperties(creditCardDTO, creditCardModel);

        if(creditCardDTO.getAcquirer() == "CHALLANGER") {

            CreditCardNumberGenerator creditCardNumberGenerator = new CreditCardNumberGenerator();

            creditCardModel.setNumber(creditCardNumberGenerator.challangerGeneration());

        }

        if(creditCardDTO.getAcquirer() == "SIGHT") {
            CreditCardNumberGenerator creditCardNumberGenerator = new CreditCardNumberGenerator();

            creditCardModel.setNumber(creditCardNumberGenerator.sightGeneration());
        }


        creditCardModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));


        return ResponseEntity.status(HttpStatus.CREATED).body(creditCardService.save(creditCardModel));
        
    }




}
