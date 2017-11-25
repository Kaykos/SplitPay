using Newtonsoft.Json;
using SuperIntendencePresentation.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Web;

namespace SuperIntendencePresentation.Integration
{
    public class ProxyWSPayPals
    {
        readonly string BASE_URI = "http://10.192.70.21:64698/api/paypals";

        public PayPal CreatePayPal(PayPal user)
        {
            var stringPayload = JsonConvert.SerializeObject(user);
            var httpContent = new StringContent(stringPayload, Encoding.UTF8, "application/json");
            using (HttpClient httpClient = new HttpClient())
            {
                string serviceUri = $"{BASE_URI}";
                var response = httpClient.PostAsync(serviceUri, httpContent);
                return JsonConvert.DeserializeObject<PayPal>(response.Result.Content.ReadAsStringAsync().Result);
            }
        }
    }
}