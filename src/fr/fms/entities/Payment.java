/**
 * Classe qui représente des paiements réalisés par un client ayant passé commande via l'appli.
 * 
 * @author Le-porcherS
 */
package fr.fms.entities;

import java.util.Date;

public class Payment {
public int idPayment;
public Date datePayment;
public double amount;

public Payment(int idPayment, Date datePayment, double amount) {

	this.idPayment = idPayment;
	this.datePayment = datePayment;
	this.amount = amount;
}

public int getIdPayment() {
	return idPayment;
}

public void setIdPayment(int idPayment) {
	this.idPayment = idPayment;
}

public Date getDatePayment() {
	return datePayment;
}

public void setDatePayment(Date datePayment) {
	this.datePayment = datePayment;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

@Override
public String toString() {
	return "Payment [idPayment=" + idPayment + ", datePayment=" + datePayment + ", amount=" + amount + "]";
}


}
