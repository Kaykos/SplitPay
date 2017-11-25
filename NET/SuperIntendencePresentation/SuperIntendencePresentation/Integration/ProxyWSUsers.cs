using Newtonsoft.Json;
using SuperIntendencePresentation.Models;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace SuperIntendencePresentation.Integration
{
    public class ProxyWSUsers {
        readonly string BASE_URI = "http://10.192.70.21:64698/api/users";

        public List<User> GetUsers() {
            using (HttpClient httpClient = new HttpClient()) {
                string serviceUri = $"{BASE_URI}";
                Task<String> response = httpClient.GetStringAsync(serviceUri);
                return JsonConvert.DeserializeObject<List<User>>(response.Result);
            }
        }

        public User GetUserDetails(string documentType, string documentNumber) {
            using (HttpClient httpClient = new HttpClient()) {
                string serviceUri = $"{BASE_URI}/{documentType}/{documentNumber}";
                Task<String> response = httpClient.GetStringAsync(serviceUri);
                return JsonConvert.DeserializeObject<User>(response.Result);
            }
        }

        public User CreateUser(User user) {
            var stringPayload = JsonConvert.SerializeObject(user);
            var httpContent = new StringContent(stringPayload, Encoding.UTF8, "application/json");
            using (HttpClient httpClient = new HttpClient()) {
                string serviceUri = $"{BASE_URI}";
                var response = httpClient.PostAsync(serviceUri, httpContent);
                return JsonConvert.DeserializeObject<User>(response.Result.Content.ReadAsStringAsync().Result);
            }
        }

        public User UpdateUser(User user)
        {
            var stringPayload = JsonConvert.SerializeObject(user);
            var httpContent = new StringContent(stringPayload, Encoding.UTF8, "application/json");
            using (HttpClient httpClient = new HttpClient())
            {
                string serviceUri = $"{BASE_URI}";
                var response = httpClient.PutAsync(serviceUri, httpContent);
                return JsonConvert.DeserializeObject<User>(response.Result.Content.ReadAsStringAsync().Result);
            }
        }

        public User DeleteUser(string documentType, string documentNumber)
        {
            using (HttpClient httpClient = new HttpClient())
            {
                string serviceUri = $"{BASE_URI}/{documentType}/{documentNumber}";
                var response = httpClient.DeleteAsync(serviceUri);
                return JsonConvert.DeserializeObject<User>(response.Result.Content.ReadAsStringAsync().Result);
            }
        }
    }
}