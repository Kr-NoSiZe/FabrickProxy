package com.fabrick;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testBalance() throws Exception {
        String expectedJson ="""
                      {"date":"2021-03-02",
                      "balance":"11.89",
                      "availableBalance":"11.89",
                      "currency":"EUR"}""".replace("\n","");

        mvc.perform(MockMvcRequestBuilders.get("/14537780/balance").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expectedJson)));
    }
    @Test
    public void testTransactions() throws Exception {
        String expectedJson ="""
                {"list":[
                {"transactionId":"282831",
                "operationId":"00000000282831",
                "accountingDate":"2019-11-29",
                "valueDate":"2019-12-01",
                "amount":-343.77,
                "type":{"enumeration":"GBS_TRANSACTION_TYPE",
                "value":"GBS_ACCOUNT_TRANSACTION_TYPE_0050"},
                "currency":"EUR",
                "description":"PD VISA CORPORATE 10"
                }]}""".replace("\n","");

        mvc.perform(MockMvcRequestBuilders.get("/14537780/transactions?from=2019-11-28&to=2019-12-01").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expectedJson)));
    }
    @Test
    public void moneyTransfer() throws Exception {
        String requestJson ="""
                {"creditor": {
                 "name": "John Doe",
                 "account": {
                   "accountCode": "IT23A0336844430152923804660",
                   "bicCode": "SELBIT2BXXX"
                 },
                   "address": {
                     "address": null,
                     "city": null,
                     "countryCode": null
                   }
                 },
                 "executionDate": "2019-04-01",
                 "uri": "REMITTANCE_INFORMATION",
                 "description": "Payment invoice 75/2017",
                 "amount": 800,
                 "currency": "EUR",
                 "isUrgent": false,
                 "isInstant": false,
                 "feeType": "SHA",
                 "feeAccountId": "14537780",
                 "taxRelief": {
                   "taxReliefId": "L449",
                   "isCondoUpgrade": false,
                   "creditorFiscalCode": "56258745832",
                   "beneficiaryType": "NATURAL_PERSON",
                   "naturalPersonBeneficiary": {
                     "fiscalCode1": "MRLFNC81L04A859L",
                     "fiscalCode2": null,
                     "fiscalCode3": null,
                     "fiscalCode4": null,
                     "fiscalCode5": null
                   },
                   "legalPersonBeneficiary": {
                     "fiscalCode": null,
                     "legalRepresentativeFiscalCode": null
                   }
                 }
                }""".replace("\n","");

        String expectedJson ="""
                {"code":"API000",
                "description":"Errore tecnico  La condizione BP049 non e' prevista per il conto id 14537780"
                }""".replace("\n","");

        mvc.perform(MockMvcRequestBuilders.post("/14537780/money-transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().is5xxServerError())
                .andExpect(content().string(equalTo(expectedJson)));
    }
}