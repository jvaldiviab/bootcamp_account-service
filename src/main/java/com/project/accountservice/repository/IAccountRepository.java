package com.project.accountservice.repository;

import com.project.accountservice.models.entity.AccountEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IAccountRepository extends ReactiveMongoRepository<AccountEntity, String> {
    Flux<AccountEntity> findAccountsByClientId(String id);
}