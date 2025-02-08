package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLPipeline {
    private static final String INPUT_FILE = "data/products.csv";
    private static final String OUTPUT_FILE = "data/transformed_products.csv";
    
    public static void main(String[] args) {
        List<String[]> products = extract(INPUT_FILE);
        if (products.isEmpty()) {
            System.err.println("No data found or error reading the input file.");
            return;
        }
        List<String[]> transformedProducts = transform(products);
        load(transformedProducts, OUTPUT_FILE);
    }

    private static List<String[]> extract(String filePath) {
        List<String[]> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) { 
                    isHeader = false; 
                    continue; 
                }
                if (line.trim().isEmpty()) { // Skip empty lines
                    continue;
                }
                String[] columns = line.split(",");
                if (columns.length < 4) { // Ensure it has the expected number of fields
                    System.err.println("Skipping invalid row: " + Arrays.toString(columns));
                    continue;
                }
                products.add(columns);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return products;
    }

    private static List<String[]> transform(List<String[]> products) {
        List<String[]> transformedList = new ArrayList<>();
        transformedList.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"}); // Add header

        for (String[] product : products) {
            if (product.length < 4) {
                System.err.println("Skipping malformed product data: " + Arrays.toString(product));
                continue;
            }
            try {
                int id = Integer.parseInt(product[0].trim());
                String name = product[1].trim().toUpperCase();
                double price = Double.parseDouble(product[2].trim());
                String category = product[3].trim();
                
                if (category.equals("Electronics")) {
                    price *= 0.90; // Apply 10% discount
                    price = Math.round(price * 100.0) / 100.0; // Round to 2 decimals
                    if (price > 500) {
                        category = "Premium Electronics";
                    }
                }
                
                String priceRange = getPriceRange(price);
                
                transformedList.add(new String[]{String.valueOf(id), name, String.format("%.2f", price), category, priceRange});
            } catch (Exception e) {
                System.err.println("Error processing product: " + Arrays.toString(product) + " - " + e.getMessage());
            }
        }
        return transformedList;
    }

    private static void load(List<String[]> transformedProducts, String outputFilePath) {
        try {
            File file = new File(outputFilePath);
            file.getParentFile().mkdirs(); // Ensure the "data" directory exists

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (String[] product : transformedProducts) {
                    bw.write(String.join(",", product));
                    bw.newLine();
                }
            }

            System.out.println("Transformation completed. File saved at: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    private static String getPriceRange(double price) {
        if (price <= 10) return "Low";
        if (price <= 100) return "Medium";
        if (price <= 500) return "High";
        return "Premium";
    }
}