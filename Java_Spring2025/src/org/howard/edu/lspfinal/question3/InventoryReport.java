package org.howard.edu.lspfinal.question3;

/**
 * Concrete implementation of an inventory report.
 */
public class InventoryReport extends ReportGenerator {

    @Override
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing inventory report.");
    }
}
