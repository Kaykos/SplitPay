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

namespace SuperIntendenceApp {
    public class UsersController : ApiController {
        private SuperIntendenceDBEntities db = new SuperIntendenceDBEntities();

        // GET: api/Users
        public IQueryable<UserSet> GetUserSet() {
            System.Diagnostics.Debug.WriteLine($"KEEEK!");
            return db.UserSet;
        }

        // GET: api/Users/5
        [ResponseType(typeof(UserSet))]
        [Route("api/users/{documentType}/{documentNumber}")]
        public IHttpActionResult GetUserSet(string documentType, string documentNumber) {
            //System.Diagnostics.Debug.WriteLine($"Id: {documentType} + {documentNumber}");
            UserSet userSet = db.UserSet.Find(documentNumber, documentType);
            if (userSet == null) {
                return NotFound();
            }

            return Ok(userSet);
        }


        // PUT: api/Users/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutUserSet(string id, UserSet userSet) {
            if (!ModelState.IsValid) {
                return BadRequest(ModelState);
            }

            if (id != userSet.documentNumber) {
                return BadRequest();
            }

            db.Entry(userSet).State = EntityState.Modified;

            try {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException) {
                if (!UserSetExists(id)) {
                    return NotFound();
                }
                else {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Users
        [ResponseType(typeof(UserSet))]
        public IHttpActionResult PostUserSet(UserSet userSet) {
            if (!ModelState.IsValid) {
                return BadRequest(ModelState);
            }

            db.UserSet.Add(userSet);

            try {
                db.SaveChanges();
            }
            catch (DbUpdateException) {
                if (UserSetExists(userSet.documentNumber)) {
                    return Conflict();
                }
                else {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = userSet.documentNumber }, userSet);
        }

        // DELETE: api/Users/5
        [ResponseType(typeof(UserSet))]
        public IHttpActionResult DeleteUserSet(string id) {
            UserSet userSet = db.UserSet.Find(id);
            if (userSet == null) {
                return NotFound();
            }

            db.UserSet.Remove(userSet);
            db.SaveChanges();

            return Ok(userSet);
        }

        protected override void Dispose(bool disposing) {
            if (disposing) {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool UserSetExists(string id) {
            return db.UserSet.Count(e => e.documentNumber == id) > 0;
        }
    }
}