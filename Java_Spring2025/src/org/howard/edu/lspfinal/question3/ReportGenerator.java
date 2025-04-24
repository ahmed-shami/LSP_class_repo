package org.howard.edu.lspfinal.question3;

/**
 * Abstract class defining the template method for generating reports.
 */
public abstract class ReportGenerator {

    /**
     * Template method that defines the report generation workflow.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Loads the report data.
     */
    protected abstract void loadData();

    /**
     * Formats the report data.
     */
    protected abstract void formatData();

    /**
     * Prints the report.
     */
    protected abstract void printReport();
}
