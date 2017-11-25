using Newtonsoft.Json;
using SuperIntendencePresentation.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace SuperIntendencePresentation.Integration
{
    public class ProxyWSTransactions
    {
        readonly string BASE_URI = "http://10.192.70.21:64698/api/transactions";

        public List<Transaction> GetTransactions(string documentType, string documentNumber)
        {
            using (HttpClient httpClient = new HttpClient())
            {
                string serviceUri = $"{BASE_URI}/{documentType}/{documentNumber}";
                Task<String> response = httpClient.GetStringAsync(serviceUri);
                return JsonConvert.DeserializeObject<List<Transaction>>(response.Result);
            }
        }

        public Transaction GetTransactionDetails(int id)
        {
            using (HttpClient httpClient = new HttpClient())
            {
                string serviceUri = $"{BASE_URI}/{id}";
                Task<String> response = httpClient.GetStringAsync(serviceUri);
                return JsonConvert.DeserializeObject<Transaction>(response.Result);
            }
        }

        public Transaction CreateTransaction(Transaction transaction)
        {
            var stringPayload = JsonConvert.SerializeObject(transaction);
            var httpContent = new StringContent(stringPayload, Encoding.UTF8, "application/json");
            using (HttpClient httpClient = new HttpClient())
            {
                string serviceUri = $"{BASE_URI}";
                var response = httpClient.PostAsync(serviceUri, httpContent);
                return JsonConvert.DeserializeObject<Transaction>(response.Result.Content.ReadAsStringAsync().Result);
            }
        }

        public Transaction UpdateTransaction(Transaction transaction)
        {
            var stringPayload = JsonConvert.SerializeObject(transaction);
            var httpContent = new StringContent(stringPayload, Encoding.UTF8, "application/json");
            using (HttpClient httpClient = new HttpClient())
            {
                string serviceUri = $"{BASE_URI}";
                var response = httpClient.PutAsync(serviceUri, httpContent);
                return JsonConvert.DeserializeObject<Transaction>(response.Result.Content.ReadAsStringAsync().Result);
            }
        }

        public Transaction DeleteTransaction(int id)
        {
            using (HttpClient httpClient = new HttpClient())
            {
                string serviceUri = $"{BASE_URI}/{id}";
                var response = httpClient.DeleteAsync(serviceUri);
                return JsonConvert.DeserializeObject<Transaction>(response.Result.Content.ReadAsStringAsync().Result);
            }
        }
    }
}