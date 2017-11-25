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
    public class UsersController : ApiController
    {
        private SuperIntendenceEntities db = new SuperIntendenceEntities();

        //Solicitar todos los usuarios
        // GET: api/Users
        public IQueryable<UserSet> GetUserSet()
        {
            System.Diagnostics.Debug.WriteLine($" - [GET] users/");
            return db.UserSet;
        }

        //Solicitar un usuario por la llave (tipo de documento y número de documento)
        // GET: api/Users/CC/123456
        [ResponseType(typeof(UserSet))]
        [Route("api/users/{documentType}/{documentNumber}")]
        public IHttpActionResult GetUserSet(string documentType, string documentNumber)
        {
            System.Diagnostics.Debug.WriteLine($" - [GET] users/{documentType}/{documentNumber}");
            UserSet userSet = db.UserSet.Find(documentNumber, documentType);
            if (userSet == null)
            {
                return NotFound();
            }

            return Ok(userSet);
        }

        //Crear un usuario
        // POST: api/Users
        [ResponseType(typeof(UserSet))]
        public IHttpActionResult PostUserSet(UserSet userSet)
        {
            System.Diagnostics.Debug.WriteLine($" - [POST] users/");
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.UserSet.Add(userSet);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (UserSetExists(userSet.documentNumber, userSet.documentType))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }
            UserSet newUser = db.UserSet.Find(userSet.documentNumber, userSet.documentType);
            return Ok(newUser);
        }

        //Modificar un usuario
        // PUT: api/Users/
        [ResponseType(typeof(void))]
        public IHttpActionResult PutUserSet(UserSet userSet)
        {
            System.Diagnostics.Debug.WriteLine($" - [PUT] users/");
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Entry(userSet).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!UserSetExists(userSet.documentNumber, userSet.documentType))
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

        //Eliminar un usuario
        // DELETE: api/Users/
        [ResponseType(typeof(UserSet))]
        [Route("api/users/{documentType}/{documentNumber}")]
        public IHttpActionResult DeleteUserSet(string documentType, string documentNumber)
        {
            System.Diagnostics.Debug.WriteLine($" - [DELETE] users/");
            System.Diagnostics.Debug.WriteLine($" Type: {documentType}, Number: {documentNumber}");
            UserSet userSet = db.UserSet.Find(documentNumber, documentType);
            System.Diagnostics.Debug.WriteLine($" Nombre: {userSet.name}");
            if (userSet == null)
            {
                return NotFound();
            }

            db.UserSet.Remove(userSet);
            db.SaveChanges();

            return Ok(userSet);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool UserSetExists(string documentNumber, string documentType)
        {
            return db.UserSet.Count(e => e.documentNumber == documentNumber && e.documentType == documentType) > 0;
        }
    }
}