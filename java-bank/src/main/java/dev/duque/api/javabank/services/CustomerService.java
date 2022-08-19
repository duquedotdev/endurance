package dev.duque.api.javabank.services;

import dev.duque.api.javabank.model.CustomerModel;
import dev.duque.api.javabank.repositories.CustomerRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public CustomerModel save(CustomerModel customerModel) { return customerRepository.save(customerModel); }

    @Lock(LockModeType.PESSIMISTIC_READ)
    public Optional<CustomerModel> findByIdWithLock(UUID id) { return customerRepository.findById(id); }

}
