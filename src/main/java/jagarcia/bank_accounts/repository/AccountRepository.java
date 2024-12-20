package jagarcia.bank_accounts.repository;

import jagarcia.bank_accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
