using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SuperIntendencePresentation.Models
{
    using System;
    using System.Collections.Generic;

    public partial class User
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public User()
        {
            this.Balances = new HashSet<Balance>();
            this.Transactions = new HashSet<Transaction>();
        }

        public int id { get; set; }
        public string name { get; set; }
        public string email { get; set; }
        public string password { get; set; }
        public string documentNumber { get; set; }
        public string documentType { get; set; }
        public int balance { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Balance> Balances { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Transaction> Transactions { get; set; }
    }
}