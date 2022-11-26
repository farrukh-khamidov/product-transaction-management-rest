package com.example.producttransactionmanagementrest.service.impl;

import com.example.producttransactionmanagementrest.dto.EvaluateReqDto;
import com.example.producttransactionmanagementrest.dto.OfferReqDto;
import com.example.producttransactionmanagementrest.dto.TransactionReqDto;
import com.example.producttransactionmanagementrest.entity.*;
import com.example.producttransactionmanagementrest.exceptions.*;
import com.example.producttransactionmanagementrest.repository.*;
import com.example.producttransactionmanagementrest.service.OfferService;
import com.example.producttransactionmanagementrest.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final CarrierRepository carrierRepository;
    private final OfferRepository offerRepository;
    private final RequestRepository requestRepository;
    private final TransactionRepository transactionRepository;


    @Override
    public Transaction addTransaction(TransactionReqDto reqDto) {

        Optional<Carrier> optionalCarrier = carrierRepository.findByName(reqDto.getCarrierName());
        if (optionalCarrier.isEmpty())  throw new CarrierNotFoundException();

        Optional<Offer> optionalOffer = offerRepository.findByOfferId(reqDto.getOfferId());
        if (optionalOffer.isEmpty())  throw new OfferNotFoundException();

        Optional<Request> optionalRequest = requestRepository.findByRequestId(reqDto.getRequestId());
        if (optionalRequest.isEmpty())  throw new RequestNotFoundException();

        Carrier carrier = optionalCarrier.get();
        Offer offer = optionalOffer.get();
        Request request = optionalRequest.get();

        Optional<Transaction> optional = transactionRepository.findByOffer(offer);
        if (optional.isPresent()) throw new TransactionAlreadyExistsException();

        optional = transactionRepository.findByRequest(request);
        if (optional.isPresent()) throw new TransactionAlreadyExistsException();

        if (!offer.getProductId().equals(request.getProductId())) throw new ProductIdsMusBeSameException();

        if (!carrier.getRegions().contains(offer.getPlace().getRegion()) ||
                !carrier.getRegions().contains(request.getPlace().getRegion()))
            throw new CarrierShouldServeException();

        Transaction transaction = new Transaction();
        transaction.setTransactionId(reqDto.getTransactionId());
        transaction.setCarrier(carrier);
        transaction.setOffer(offer);
        transaction.setRequest(request);

        return transactionRepository.save(transaction);

    }

    @Override
    public Boolean evaluateTransaction(EvaluateReqDto reqDto) {
        if (reqDto.getScore() < 1 || reqDto.getScore() > 10) return false;
        Optional<Transaction> optional = transactionRepository.findByTransactionId(reqDto.getTransactionId());
        if (optional.isEmpty()) throw new TransactionNotFoundException();

        Transaction transaction = optional.get();
        transaction.setScore(reqDto.getScore());
        transactionRepository.save(transaction);
        return true;
    }
}
