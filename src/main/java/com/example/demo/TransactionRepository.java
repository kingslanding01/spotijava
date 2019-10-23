package com.example.demo;

import org.hibernate.Transaction;
import org.springframework.data.repository.CrudRepository;

public class TransactionRepository extends CrudRepository<Transaction, Long> {
}
