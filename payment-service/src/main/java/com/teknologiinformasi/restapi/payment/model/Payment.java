package com.teknologiinformasi.restapi.payment.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "payment")
public class Payment {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
  
   private String item;
   private Double amount;
   private String status;
   private LocalDateTime payment_Date;
  
   // Constructor tanpa parameter
   public Payment() {}


   // Constructor dengan parameter
   public Payment(String item, Double amount, String status, LocalDateTime payment_Date) {
       this.item = item;
       this.amount = amount;
       this.status = status;
       this.payment_Date = payment_Date;
   }


   // Getters dan Setters
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
       this.id = id;
   }
   public String getItem() {
       return item;
   }
   public void setItem(String item) {
       this.item = item;
   }
   public Double getAmount() {
       return amount;
   }
   public void setAmount(Double amount) {
       this.amount = amount;
   }
   public String getStatus() {
       return status;
   }
   public void setStatus(String status) {
       this.status = status;
   }
   public LocalDateTime getPayment_Date() {
       return payment_Date;
   }
   public void setPayment_Date(LocalDateTime payment_Date) {
       this.payment_Date = payment_Date;
   }
}