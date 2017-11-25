using SuperIntendencePresentation.Integration;
using SuperIntendencePresentation.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SuperIntendencePresentation.Facades
{
    public class PayPalsFacade
    {
        ProxyWSPayPals proxy;

        public PayPalsFacade()
        {
            proxy = new ProxyWSPayPals();
        }

        public bool Create(PayPal payPal)
        {
            return proxy.CreatePayPal(payPal);
        }
    }
}