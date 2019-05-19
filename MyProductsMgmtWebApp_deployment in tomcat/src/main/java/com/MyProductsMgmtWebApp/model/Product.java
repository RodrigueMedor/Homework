package com.MyProductsMgmtWebApp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product 
{   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  	private int prodID;
    private String prodName;
    private double price;
    private String productDescription;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate datePrice;

   public Product(){

    }

    /**
     * @return the prodID
     */
    public int getProdID() {
        return prodID;
    }

    /**
     * @param prodID the prodID to set
     */
    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    /**
     * @return the prodName
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * @param prodName the prodName to set
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * @return the datePrice
     */
    public LocalDate getDatePrice() {
        return datePrice;
    }

    /**
     * @param datePrice the datePrice to set
     */
    public void setDatePrice(LocalDate datePrice) {
        this.datePrice = datePrice;
    }


}