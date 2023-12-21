package DAO;

import models.BankTransaction;

public interface IBankTransactionDAO {

    void createBanqueTransaction(BankTransaction transaction);

    BankTransaction geTransactionById(int transactionId);
}
