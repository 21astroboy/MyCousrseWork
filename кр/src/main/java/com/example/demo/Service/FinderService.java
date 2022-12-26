package com.example.demo.Service;

import com.example.demo.Entity.Transactions;
import com.example.demo.repo.TransactionsRepository;
import java.util.ArrayList;
import java.util.Optional;

public class FinderService {
    private TransactionsRepository transact;
    public ArrayList<Transactions> Find(int id) {
        Optional<Transactions> type = transact.findById(id);
        ArrayList<Transactions> res = new ArrayList<>();
        type.ifPresent(res::add);
return res;
    }
}
