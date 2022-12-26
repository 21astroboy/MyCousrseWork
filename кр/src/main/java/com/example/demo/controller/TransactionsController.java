package com.example.demo.controller;

import com.example.demo.Entity.Transactions;
import com.example.demo.Service.FinderService;
import com.example.demo.Service.SaverService;
import com.example.demo.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("blog-Transactions")
public class TransactionsController {


    private final TransactionsRepository transact;
    SaverService saverServ = new SaverService();

    @Autowired
    public TransactionsController(
        TransactionsRepository transact
    ) {
        this.transact = transact;
    }

    @GetMapping("")
    public ModelAndView Transaction(){
        Iterable<Transactions> transactions = transact.findAll();
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("transactions", transactions);
        return modelAndView;
    }

    @GetMapping("{id}")
    public String TransDetails(@PathVariable(value = "id") int id, Model model){
        if(!transact.existsById(id)) {
            return "redirect:";
        }
        Optional<Transactions> type =transact.findById(id);
        ArrayList<Transactions> res = new ArrayList<>();
        type.ifPresent(res::add);
        model.addAttribute("transactions",res);
        return "Transactions-details";
    }

    @GetMapping("{id}/edit")
    public String BlogEdit(@PathVariable(value = "id") int id, Model model){
        if(!transact.existsById(id))
            return "redirect:";

//        RedirectView();
        Optional<Transactions> type =transact.findById(id);
        ArrayList<Transactions> res = new ArrayList<>();
        type.ifPresent(res::add);
        model.addAttribute("transactions",res);
        return "Transactions-edit";
    }

    @PostMapping("{id}/edit")
    public String TransactUpdate(
        @PathVariable(value = "id") Integer id,
        @RequestParam(required = false, defaultValue = "14 13:12:11") String datetime,
        @RequestParam Integer mcc_code,
        @RequestParam Integer tr_type,
        @RequestParam Integer amount,
        @RequestParam Integer term_id

    ){

        transact.save(saverServ.Save(id,datetime,mcc_code,tr_type,amount,term_id));
        return "redirect:";


    }

    @PostMapping("{id}/remove")
    public String TransactDelete(
        @PathVariable(value = "id") Integer customerId
    ) {

        try {
            transact.deleteById(customerId);
        }

        finally {
            return "redirect:";
        }
    }
}
