package jagarcia.bank_accounts.service.impl;

import jagarcia.bank_accounts.model.Account;
import jagarcia.bank_accounts.repository.AccountRepository;
import jagarcia.bank_accounts.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> getAllAccounts() {

        return accountRepository.findAll();
    }

    @Override
    public Account searchAccountById(Integer id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);

    }

    @Override
    public void deleteAccount(Account account) {
        accountRepository.delete(account);

    }
}
