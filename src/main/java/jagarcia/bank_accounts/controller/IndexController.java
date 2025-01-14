package jagarcia.bank_accounts.controller;

import jagarcia.bank_accounts.model.Account;
import jagarcia.bank_accounts.service.impl.AccountService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
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
    //atributo para cargar y crear cuenta especifica
    private Account selectedAccount;

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

    public void addAccount() {
        this.selectedAccount = new Account();

    }

    public void saveAccount() {
        logger.info("Account to save:" + this.selectedAccount);
        if (this.selectedAccount.getIdAccount() == null) {
            this.accountService.saveAccount(this.selectedAccount);
            this.accounts.add(this.selectedAccount);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Account Added!"));
        }
        else { //modificar
            this.accountService.saveAccount(this.selectedAccount);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Updated Account!"));
        }
        //ocultar vendana
        PrimeFaces.current().executeScript("PF('windowModalAccount').hide()");
        //actualizar tabla
        PrimeFaces.current().ajax().update("form-accounts:messages",
                "form-accounts:table-accounts");
    }


}
