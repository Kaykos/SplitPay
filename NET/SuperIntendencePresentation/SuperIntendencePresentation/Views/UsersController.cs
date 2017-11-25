using System.Net;
using System.Web.Mvc;
using SuperIntendencePresentation.Models;
using System.Threading.Tasks;
using SuperIntendencePresentation.Facades;

namespace SuperIntendencePresentation.Views
{
    public class UsersController : Controller
    {

        private UsersFacade facade;

        public UsersController()
        {
            facade = new UsersFacade();
        }

        // GET: users
        public async Task<ActionResult> Index()
        {
            return View(facade.Index());
        }

        // GET: users/details/documentType/documentNumber
        public ActionResult Details(string documentType, string documentNumber)
        {
            if (documentType == null || documentNumber == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            User user = facade.getUser(documentType, documentNumber);
            if (user == null)
            {
                return HttpNotFound();
            }
            return View(user);
        }
        
        // GET: users/create
        public ActionResult Create()
        {
            return View();
        }
        
        // POST: users/create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "name,email,password,documentNumber,documentType")] User user)
        {
            System.Diagnostics.Debug.WriteLine("Entró");
            return View("Details", facade.Create(user));
        }
        
        // GET: users/edit/documentType/documentNumber
        public ActionResult Edit(string documentType, string documentNumber) {
            if (documentType == null || documentNumber == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            User user = facade.getUser(documentType, documentNumber);
            if (user == null) {
                return HttpNotFound();
            }
            return View(user);
        }

        // POST: users/edit/documentType/documentNumber
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "name,email,password,documentType,documentNumber")] User user) {
            return View(facade.Update(user));
        }
        
        // GET: users/delete/documentType/documentNumber
        public ActionResult Delete(string documentType, string documentNumber) {
            if (documentType == null || documentNumber == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            User user = facade.getUser(documentType, documentNumber);
            if (user == null) {
                return HttpNotFound();
            }
            return View(user);
        }

        // POST: users/delete/documentType/documentNumber
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(string documentType, string documentNumber) {
            facade.Delete(documentType, documentNumber);
            return RedirectToAction("Index");
        }
    }
}
