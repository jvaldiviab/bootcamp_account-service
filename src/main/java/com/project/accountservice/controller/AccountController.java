package com.project.accountservice.controller;

import com.project.accountservice.models.dto.Transaction;
import com.project.accountservice.models.entity.AccountEntity;
import com.project.accountservice.models.request.AccountCreateRequest;
import com.project.accountservice.models.request.AccountDoTransactionRequest;
import com.project.accountservice.models.request.AccountUpdateRequest;
import com.project.accountservice.models.response.AccountFindBalancesResponse;
import com.project.accountservice.models.response.ClientClientServiceResponse;
import com.project.accountservice.service.IAccountService;
import com.project.accountservice.utilities.errors.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/passive")
public class AccountController {

    private final IAccountService accountService;

    @PostMapping("/create")
    public Mono<ResponseEntity<AccountEntity>> createAccount(@RequestBody AccountCreateRequest accountDTO) {
        return accountService.create(accountDTO)
                .flatMap(createdAccount -> Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(createdAccount)))
                .onErrorResume(ElementBlockedException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.LOCKED).build()))
                .onErrorResume(EnterpriseLogicException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build()))
                .onErrorResume(PersonalLogicException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()))
                .onErrorResume(IllegalArgumentException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build()))
                .onErrorResume(NoSuchElementException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build()))
                .onErrorResume(NullPointerException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build()))
                .onErrorResume(ClientNotFoundException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build()))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body(null)));
    }

    @GetMapping("/getAll")
    public Flux<AccountEntity> findAllAccounts(){
        log.info("Get all accounts in /accounts");
        return accountService.findAll();
    }

    @GetMapping("/getById/{id}")
    public Mono<ResponseEntity<AccountEntity>> findAccountById(@PathVariable("id") String id) {
        return accountService.findById(id)
                .flatMap(retrievedAccount -> Mono.just(ResponseEntity.ok(retrievedAccount)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/getByClientId/{id}")
    public Flux<AccountEntity> findAccountsByClientId(@PathVariable("id") String id) {
        return accountService.findByClientId(id);
    }

    @GetMapping("/getByAccountNumber/{number}")
    public Mono<AccountEntity> findAccountsByAccountNumber(@PathVariable("number") String number) {
        return accountService.findByAccountNumber(number);
    }

    @PutMapping("/update")
    public Mono<ResponseEntity<AccountEntity>> updateAccount(@RequestBody AccountUpdateRequest accountDTO) {
        return accountService.update(accountDTO)
                .flatMap(updatedAccount -> Mono.just(ResponseEntity.ok(updatedAccount)))
                .onErrorResume(ElementBlockedException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.LOCKED).build()))
                .onErrorResume(IllegalArgumentException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build()))
                .onErrorResume(NoSuchElementException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build()))
                .onErrorResume(NullPointerException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build()))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<AccountEntity>> deleteAccount(@PathVariable("id") String id) {
        return accountService.removeById(id)
                .flatMap(removedAccount -> Mono.just(ResponseEntity.ok(removedAccount)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    // ##################################

    @PostMapping("/transactions")
    public Mono<ResponseEntity<AccountEntity>> doTransaction(@RequestBody AccountDoTransactionRequest account) {
        log.info("Post operation in /accounts/transaction");
        return accountService.doTransaction(account)
                .flatMap(createdAccount -> Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(createdAccount)))
                .onErrorResume(ElementBlockedException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.LOCKED).build()))
                .onErrorResume(AccountLoginException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()))
                .onErrorResume(IllegalArgumentException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build()))
                .onErrorResume(NoSuchElementException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build()))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body(null)));
    }

    // ####################################

    @GetMapping("/client-service/{id}")
    public Mono<ResponseEntity<ClientClientServiceResponse>> findByIdCustomerService(@PathVariable("id") String id) {
        return accountService.findByIdClientService(id)
                .flatMap(retrievedCustomer -> Mono.just(ResponseEntity.ok(retrievedCustomer)));
    }

    /*@GetMapping("active-service/customers/{id}/credits")
    public Flux<CreditActiveServiceResponseDTO> findCreditsByCustomerIdActiveService(@PathVariable("id") String id) {
        log.info("Get operation in active-service/customers/{}/credits", id);
        return accountService.findCreditsByCustomerIdActiveService(id)
                .onErrorResume(CircuitBreakerException.class, error -> Flux.empty());
    }*/


    /*
    @PutMapping("/accounts/{id}/reset-operations-number")
    public Mono<ResponseEntity<Account>> resetDoneOperationsInMonth(@PathVariable("id") String id) {
        log.info("Get operation in /accounts/{id}/reset-operations-number", id);
        return accountService.resetDoneOperationsInMonth(id)
                .flatMap(createdAccount -> Mono.just(ResponseEntity.status(HttpStatus.OK).body(createdAccount)))
                .onErrorResume(NoSuchElementException.class, error -> Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).build()))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.CONFLICT).body(null)));
    }
*/

    @GetMapping("/accounts/{id}/operations")
    public Flux<Transaction> findOperationsByAccountId(@PathVariable("id") String id) {
        log.info("Get operation in /accounts/{}/operations", id);
        return accountService.findTransactionsByAccountId(id);
    }
/*
    @GetMapping("/accounts/{id}/commissions")
    public Flux<OperationCommissionResponseDTO> findCommissionsBetweenDatesByAccountId(@RequestParam(value = "date-from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFrom,
                                                                                       @RequestParam(value = "date-to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTo,
                                                                                       @PathVariable("id") String id) {
        log.info("Get operation in /accounts/{}/commissions", id);
        return accountService.findCommissionsBetweenDatesByAccountId(dateFrom, dateTo, id);
    }

*/

    @GetMapping("client/{id}/accounts/balance")
    public Mono<AccountFindBalancesResponse> findBalancesByCustomerId(@PathVariable("id") String id) {
        return accountService.findBalancesByAccountId(id);
    }

    @GetMapping("clientTest")
    public Flux<ClientClientServiceResponse> findBalan() {
        return accountService.clientTest();
    }
}