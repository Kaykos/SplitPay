using SuperIntendenceApp.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;

namespace SuperIntendenceApp.Services
{
    public class PayPalController : ApiController
    {

        private SuperIntendenceEntities db = new SuperIntendenceEntities();

        //Crear un usuario
        // POST: api/Users
        [ResponseType(typeof(bool))]
        public IHttpActionResult PostPayPal(PayPal payPalRequest)
        {
            System.Diagnostics.Debug.WriteLine($" - [POST] paypal/");
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            UserSet user = db.UserSet.Find(payPalRequest.documentNumber, payPalRequest.documentType);

            if(user != null)
            {
                if (payPalRequest.password.Equals(user.password))
                {
                    TransactionSet transaction = new TransactionSet();
                    DateTime time = DateTime.UtcNow.Date;

                    transaction.value = payPalRequest.value;
                    transaction.description = $"Transaction Paypal";
                    transaction.title = $"{user.documentType}: {user.documentNumber}";
                    transaction.User_documentNumber = user.documentNumber;
                    transaction.User_documentType = user.documentType;
                    transaction.date = time.ToString("dd/MM/yyyy");


                    db.TransactionSet.Add(transaction);

                    try
                    {
                        db.SaveChanges();
                    }
                    catch (DbUpdateException)
                    {
                        if (TransactionSetExists(transaction.id))
                        {
                            return Conflict();
                        }
                        else
                        {
                            throw;
                        }
                    }
                    return Ok(true);
                }
            }

            return Ok(false);
        }

        private bool TransactionSetExists(int id)
        {
            return db.TransactionSet.Count(e => e.id == id) > 0;
        }
    }
}
