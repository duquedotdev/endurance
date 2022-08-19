package dev.duque.api.javabank.services;

import dev.duque.api.javabank.model.CreditCardModel;
import dev.duque.api.javabank.repositories.CreditCardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class CreditCardService {

    final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Transactional
    public CreditCardModel save(CreditCardModel creditCardModel) {
        return creditCardRepository.save(creditCardModel);
    }

    @Lock(LockModeType.PESSIMISTIC_READ)
    public Optional<CreditCardModel> findByIdWithLock(UUID id) {
        return creditCardRepository.findById(id);
    }

    @Transactional
    public void delete(CreditCardModel creditCardModel) {
        creditCardRepository.delete(creditCardModel);
    }

}
