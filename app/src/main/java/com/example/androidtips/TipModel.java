package com.example.androidtips;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/*TipModel.java
 *
 * Creates setters and getters for calculating the Total Bill
 *
 * @Author Luke Vakasisikakala
 * @Version 03/12/2019
 *
 *
 */
public class TipModel {
private String totalBill;
private double tipCalc;
private double roundedTotal;
private String roundedTip;
private String final1;

public String getTotalBill() {
	return totalBill;
}

public void setTotalBill(double totalBill, int decimalDigits) {
	if (decimalDigits < 0) throw new IllegalArgumentException();

	   BigDecimal bd = new BigDecimal(Double.toString(totalBill));

	   bd = bd.setScale(decimalDigits, RoundingMode.HALF_UP);
	this.totalBill = bd.toString();
}

public double getTipPerc() {
	return tipCalc;
}

public void setTipPerc(double baseAmount, double percentage) {
    double tip = baseAmount * percentage;
	this.tipCalc = tip;
}

public double getRoundedTotal() {
	return roundedTotal;
}

public void setRoundedTotal(double amountToRound, double quantum) {

	double total;
	total = amountToRound;

	while (amountToRound > quantum)
	{
		amountToRound = amountToRound - quantum;
	}

	if (amountToRound >= quantum / 2)
	{
		amountToRound = total + (quantum - amountToRound);
	}

	if (amountToRound <= quantum / 2)
	{
		amountToRound = total - amountToRound;
	}

	this.roundedTotal = amountToRound;
}
	public String getRoundedTip() {

	return roundedTip;
	}

	public void setRoundedTip(double percentage) {
		BigDecimal bd1 = BigDecimal.valueOf(percentage);
		bd1 = bd1.movePointRight(2);

		this.roundedTip = bd1.toString();


	}
	public void setString(double finalamt) {
		DecimalFormat df = new DecimalFormat("#.00");
		String amt1 = df.format(finalamt);
		this.final1 = amt1;
	}

	public String getString(){
	return final1;
	}



}
