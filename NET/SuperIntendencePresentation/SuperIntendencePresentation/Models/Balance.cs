namespace SuperIntendencePresentation.Models
{
    using System;
    using System.Collections.Generic;

    public partial class Balance
    {
        public int id { get; set; }
        public int currentValue { get; set; }
        public int group { get; set; }
        public string User_documentNumber { get; set; }
        public string User_documentType { get; set; }

        public virtual User UserSet { get; set; }
    }
}
