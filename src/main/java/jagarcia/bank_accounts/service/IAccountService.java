package jagarcia.bank_accounts.service;

import jagarcia.bank_accounts.model.Account;

import java.util.List;

public interface IAccountService {
    public List<Account> getAllAccounts();
    public  Account searchAccountById(Integer id);
    public void saveAccount(Account account);
    public void deleteAccount(Account account);

}
