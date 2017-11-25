using SuperIntendencePresentation.Integration;
using SuperIntendencePresentation.Models;
using System.Collections.Generic;

namespace SuperIntendencePresentation.Facades
{
    public class UsersFacade
    {
        ProxyWSUsers proxy;

        public UsersFacade()
        {
            proxy = new ProxyWSUsers();
        }

        public List<User> Index()
        {
            return proxy.GetUsers();
        }

        public User getUser(string documentType, string documentNumber)
        {
            return proxy.GetUserDetails(documentType, documentNumber);
        }

        public User Create(User user)
        {
            return proxy.CreateUser(user);
        }

        public User Update(User user)
        {
            return proxy.UpdateUser(user);
        }

        public void Delete(string documentType, string documentNumber)
        {
            proxy.DeleteUser(documentType, documentNumber);
        }
    }
}