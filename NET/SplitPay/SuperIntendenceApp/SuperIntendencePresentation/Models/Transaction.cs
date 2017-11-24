using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SuperIntendencePresentation.Models
{
    using System;
    using System.Collections.Generic;

    public partial class Transaction
    {
        public int id { get; set; }
        public string date { get; set; }
        public int value { get; set; }
        public string description { get; set; }
        public string title { get; set; }
        public string User_documentNumber { get; set; }
        public string User_documentType { get; set; }

        public virtual User UserSet { get; set; }
    }
}