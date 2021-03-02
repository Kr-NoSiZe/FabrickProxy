package com.fabrick.controller;

import com.fabrick.exception.FabrickException;
import com.fabrick.persistence.model.*;
import com.fabrick.persistence.repository.AccountRepository;
import com.fabrick.persistence.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${fabrick.host}")
    private String host;

    @Value("${fabrick.api-key}")
    private String apiKey;

    @PostMapping(value = "{accountId}/money-transfer", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<MoneyTransferResponse> postMoneyTransfer(@PathVariable("accountId") Long accountId, @RequestBody MoneyTransferRequest request) {
        List<MoneyTransferResponse> payload = null;
        try {
            final String uri = host + "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";

            HttpHeaders headers = getHttpHeaders();

            HttpEntity<MoneyTransferRequest> entity = new HttpEntity<>(request, headers);
            ParameterizedTypeReference<FabrickResponse<ElementList<MoneyTransferResponse>>> responseType = new ParameterizedTypeReference<>() {
            };
            log.info("Executing call to {}", uri);
            ResponseEntity<FabrickResponse<ElementList<MoneyTransferResponse>>> result ;

            result = restTemplate.exchange(uri, HttpMethod.POST, entity, responseType, accountId);
            log.info("result {}", result.getBody());

            payload = result.getBody().getPayload().getList();

        } catch (HttpClientErrorException e) {
            log.error("Exception:", e);
            if (e.getRawStatusCode() == HttpStatus.BAD_REQUEST.value()) {
                String message = String.format("Errore tecnico  La condizione %s non e' prevista per il conto id %s", "BP049", accountId);
                throw new FabrickException(HttpStatus.BAD_GATEWAY, "API000", message);
            }
        }
        return payload;
    }


    @GetMapping(value = "{accountId}/balance", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Balance getBalance(@PathVariable("accountId") long accountId) {

        final String uri = host + "/api/gbs/banking/v4.0/accounts/{accountId}/balance";

        HttpHeaders headers = getHttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ParameterizedTypeReference<FabrickResponse<Balance>> responseType = new ParameterizedTypeReference<>() {
        };

        log.info("Executing call to {}", uri);
        ResponseEntity<FabrickResponse<Balance>> result = restTemplate.exchange(uri, HttpMethod.GET, entity, responseType, accountId);
        log.info("result {}", result.getBody());

        return result.getBody().getPayload();
    }


    @GetMapping(value = "{accountId}/transactions",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ElementList<Transaction> getTransactions(@PathVariable("accountId") long accountId, @RequestParam String from, @RequestParam String to) {

        final String url = host + "/api/gbs/banking/v4.0/accounts/{accountId}/transactions";
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("fromAccountingDate", from)
                .queryParam("toAccountingDate", to).build();

        String uri = uriComponents.toString();

        HttpHeaders headers = getHttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("", headers);

        ParameterizedTypeReference<FabrickResponse<ElementList<Transaction>>> responseType = new ParameterizedTypeReference<>() {
        };

        log.info("Executing call to {}", uriComponents.toString());
        ResponseEntity<FabrickResponse<ElementList<Transaction>>> result;

        result = restTemplate.exchange(uri, HttpMethod.GET, entity, responseType, accountId);

        transactionRepository.saveAll(result.getBody().getPayload().getList());

        List<Transaction> transactionsList = transactionRepository.findAll();
        log.info("Data saved on DB :");
        transactionsList.forEach(a -> log.info(a.toString()));

        log.info("result {}", result.getBody());

        return result.getBody().getPayload();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Auth-Schema", "S2S");
        headers.set("Api-Key", apiKey);
        return headers;
    }

}