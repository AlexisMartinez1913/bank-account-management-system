package jagarcia.bank_accounts.controller;

import jagarcia.bank_accounts.model.Account;
import jagarcia.bank_accounts.service.impl.AccountService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {
    @Autowired
    AccountService accountService;

    private List<Account> accounts;

    //mandar info a la consola
    private  static final Logger logger =
            LoggerFactory.getLogger(IndexController.class);
    @PostConstruct
    public void init() {
        loadData();
    }

    //traer datos
    public void loadData() {
        this.accounts = accountService.getAllAccounts();
        accounts.forEach((account -> logger.info(account.toString())));
    }


}
