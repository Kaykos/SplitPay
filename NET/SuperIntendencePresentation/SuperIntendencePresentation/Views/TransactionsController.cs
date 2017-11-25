using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web.Mvc;
using SuperIntendencePresentation.Models;
using SuperIntendencePresentation.Facades;

namespace SuperIntendencePresentation.Views
{
    public class TransactionsController : Controller
    {
        private TransactionsFacade facade;

        public TransactionsController()
        {
            facade = new TransactionsFacade();
        }

        // GET: transactions
        public ActionResult Index(string documentType, string documentNumber)
        {
            TempData["documentType"] = documentType;
            TempData["documentNumber"] = documentNumber;
            return View(facade.Index(documentType, documentNumber));
        }

        // GET: transactions/details/id
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Transaction transaction = facade.getTransaction(id.Value);
            if (transaction == null)
            {
                return HttpNotFound();
            }
            return View(transaction);
        }

        // GET: transactions/create
        public ActionResult Create()
        {
            return View();
        }

        // POST: transactions/create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "id,date,value,description,title")] Transaction transaction)
        {
            return View("Details", facade.Create(transaction, @TempData["documentType"] as string, @TempData["documentNumber"] as string));
        }

        // GET: transactions/edit/id
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Transaction transaction = facade.getTransaction(id.Value);
            if (transaction == null)
            {
                return HttpNotFound();
            }
            return View(transaction);
        }

        // POST: transactions/edit/id
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "id,date,value,description,title,User_documentNumber,User_documentType")] Transaction transaction)
        {
            return View(facade.Update(transaction));
        }

        // GET: transactions/delete/id
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Transaction transaction = facade.getTransaction(id.Value);
            if (transaction == null)
            {
                return HttpNotFound();
            }
            return View(transaction);
        }

        // POST: transactions/delete/id
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            facade.Delete(id);
            return RedirectToAction("../Users/Index");
        }
    }
}