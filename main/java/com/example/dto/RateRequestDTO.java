package com.example.dto;

    import java.util.List;

    public class RateRequestDTO { 
        public int sourcePincode; 
        public int destPincode;
         public List<BoxDTO> boxes; 
         public int paymentModeId; 
         public int invoiceValue; 
         public int codAmount; 
         public int riskTypeId; 
        }
