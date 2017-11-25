using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using SuperIntendencePresentation.Models;
using SuperIntendencePresentation.Facades;

namespace SuperIntendencePresentation.Views
{
    public class PayPalsController : Controller
    {
        private TestContext db = new TestContext();

        private PayPalsFacade facade;

        public PayPalsController()
        {
            facade = new PayPalsFacade();
        }

        // GET: payPals/create
        public ActionResult Create()
        {
            return View();
        }

        // POST: payPals/create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id,documentType,documentNumber,password,value")] PayPal payPal)
        {
            return View(facade.Create(payPal));
        }
    }
}
