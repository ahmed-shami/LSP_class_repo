package org.howard.edu.lspfinal.question3;

/**
 * Driver class for demonstrating the report generation system.
 */
public class Driver {
    public static void main(String[] args) {
        ReportGenerator sales = new SalesReport();
        sales.generateReport();

        System.out.println();

        ReportGenerator inventory = new InventoryReport();
        inventory.generateReport();
    }
}
