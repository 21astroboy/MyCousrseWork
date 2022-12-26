package com.example.demo.controller;

import com.example.demo.Entity.Transactions;
import com.example.demo.repo.TransactionsRepository;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.record.Record;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {
@Autowired
private TransactionsRepository transact;
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/Users/new/Desktop/Лабы";


@GetMapping("/blog-Transactions/add")
public String AAA(){
    return "upload";
}


    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }

        try {

            List<Transactions> transaction = new ArrayList<>();
            InputStream inputStream = file.getInputStream();
            CsvParserSettings settings = new CsvParserSettings();
            settings.setHeaderExtractionEnabled(true);
            CsvParser parser = new CsvParser(settings);
            List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
            parseAllRecords.forEach(record -> {
                Transactions trans = new Transactions();
                trans.setCustomer_id(Integer.parseInt(record.getString("customer_id")));
                trans.setTr_datetime(record.getString("tr_datetime"));
                trans.setMcc_code(Integer.parseInt(record.getString("mcc_code")));
                trans.setAmount(Integer.parseInt(record.getString("amount")));
                trans.setTr_type(Integer.parseInt(record.getString("tr_type")));
                trans.setTerm_id(Integer.parseInt(record.getString("term_id")));
                transaction.add(trans);
            });
            transact.saveAll(transaction);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}
