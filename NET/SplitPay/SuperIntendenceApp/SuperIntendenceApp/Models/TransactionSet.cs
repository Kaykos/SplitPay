//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SuperIntendenceApp.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class TransactionSet
    {
        public int id { get; set; }
        public string date { get; set; }
        public int value { get; set; }
        public string description { get; set; }
        public string title { get; set; }
        public string User_documentNumber { get; set; }
        public string User_documentType { get; set; }
    
        public virtual UserSet UserSet { get; set; }
    }
}