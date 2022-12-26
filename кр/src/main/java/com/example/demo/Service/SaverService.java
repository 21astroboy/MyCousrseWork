package com.example.demo.Service;

import com.example.demo.Entity.Transactions;
import com.example.demo.repo.TransactionsRepository;

public class SaverService {
    private TransactionsRepository transactionsRepository;
public Transactions Save(int id, String datetime,
                         int mcc_code, int tr_type,
                         int amount, int term_id)
{
    Transactions type = transactionsRepository.findById(id).orElseThrow();

    if(transactionsRepository.existsById(id))
     {
        type.setCustomer_id(id);
        type.setTr_datetime(datetime);
        type.setMcc_code(mcc_code);
        type.setTr_type(tr_type);
        type.setAmount(amount);
        type.setTerm_id(term_id);
        return type;
    }
    return type;
}
}
