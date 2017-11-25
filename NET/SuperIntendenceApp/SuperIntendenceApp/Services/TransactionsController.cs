using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using SuperIntendenceApp.Models;

namespace SuperIntendenceApp.Services
{
    public class TransactionsController : ApiController
    {
        private SuperIntendenceEntities db = new SuperIntendenceEntities();

        //Solicitar todas las transacciones de un usuario
        // GET: api/Transactions/CC/123456
        [Route("api/transactions/{documentType}/{documentNumber}")]
        public IQueryable<TransactionSet> GetTransactionSet(string documentType, string documentNumber)
        {
            System.Diagnostics.Debug.WriteLine($" - [GET] transactions/{documentType}/{documentNumber}");
            UserSet user = db.UserSet.Find(documentNumber, documentType);
            return user.TransactionSet.AsQueryable();
        }

        //Solicitar una transacción por la llave
        // GET: api/Transactions/5
        [ResponseType(typeof(TransactionSet))]
        public IHttpActionResult GetTransactionSet(int id)
        {
            System.Diagnostics.Debug.WriteLine($" - [GET] transactions/{id}");
            TransactionSet transactionSet = db.TransactionSet.Find(id);
            if (transactionSet == null)
            {
                return NotFound();
            }

            return Ok(transactionSet);
        }

        //Crear una transacción
        // POST: api/Transactions
        [ResponseType(typeof(TransactionSet))]
        public IHttpActionResult PostTransactionSet(TransactionSet transactionSet)
        {
            System.Diagnostics.Debug.WriteLine($" - [POST] transactions/");
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.TransactionSet.Add(transactionSet);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = transactionSet.id }, transactionSet);
        }

        //Actualizar una transacción
        // PUT: api/Transactions/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutTransactionSet(TransactionSet transactionSet)
        {
            System.Diagnostics.Debug.WriteLine($" - [PUT] transactions/");
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Entry(transactionSet).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TransactionSetExists(transactionSet.id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // DELETE: api/Transactions/
        [ResponseType(typeof(TransactionSet))]
        public IHttpActionResult DeleteTransactionSet(int id)
        {
            System.Diagnostics.Debug.WriteLine($" - [DELETE] transactions/");
            TransactionSet transactionSet = db.TransactionSet.Find(id);
            if (transactionSet == null)
            {
                return NotFound();
            }

            db.TransactionSet.Remove(transactionSet);
            db.SaveChanges();

            return Ok(transactionSet);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool TransactionSetExists(int id)
        {
            return db.TransactionSet.Count(e => e.id == id) > 0;
        }
    }
}