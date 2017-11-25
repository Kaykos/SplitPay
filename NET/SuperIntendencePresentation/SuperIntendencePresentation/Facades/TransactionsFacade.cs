using SuperIntendencePresentation.Integration;
using SuperIntendencePresentation.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SuperIntendencePresentation.Facades
{
    public class TransactionsFacade
    {
        ProxyWSTransactions proxy;

        public TransactionsFacade()
        {
            proxy = new ProxyWSTransactions();
        }

        public List<Transaction> Index(string documentType, string documentNumber)
        {
            return proxy.GetTransactions(documentType, documentNumber);
        }

        public Transaction getTransaction(int id)
        {
            return proxy.GetTransactionDetails(id);
        }

        public Transaction Create(Transaction transaction, string documentType, string documentNumber)
        {
            transaction.User_documentType = documentType;
            transaction.User_documentNumber = documentNumber;
            return proxy.CreateTransaction(transaction);
        }

        public Transaction Update(Transaction transaction)
        {
            return proxy.UpdateTransaction(transaction);
        }

        public Transaction Delete(int id)
        {
            return proxy.DeleteTransaction(id);
        }
    }
}