package DAO;

import models.Account;

public interface IAccountDao {

    void createAccount(Account a);

    Account getAccount(int Accountid);

    void updateAccount(Account account);

    void deleteAcount(int accountId);

}
