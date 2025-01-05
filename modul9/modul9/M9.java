package modul9;

import java.util.Objects;

public class M9 {
    public static void main(String[] args) {
        M9 m9 = new M9();
        CustomerInquiryRequest request = new CustomerInquiryRequest();
        
        Customer customer = new Customer();
        customer.setCustomerID("12345"); // Set a valid CustomerID
        request.setCustomer(customer);
        
        CustomerProduct customerProduct = new CustomerProduct();
        customerProduct.setProductNumber("67890"); // Set a valid ProductNumber
        request.setCustomerProduct(customerProduct);
        
        m9.validateRequest(request, 10, 10);
        
        // Print hasil akhir
        System.out.println("CustomerID (padded): " + request.getCustomer().getCustomerID());
        System.out.println("ProductNumber (padded): " + request.getCustomerProduct().getProductNumber());
    }

    private void validateRequest(CustomerInquiryRequest request, int customerFieldLength, int productFieldLength) {
        // 1. Check both parameters are not null and not empty strings
        checkCustomerInquiryNotNullOrEmpty(request);

        // 2. Check both parameters are not both empty
        checkCustomerInquiryNullOrEmpty(request);

        // 3. Check CustomerID for field length and pad the parameter
        checkCustomerIDValid(request, customerFieldLength);

        // 4. Check ProductNumber for field length and pad the parameter
        checkProductNumberValid(request, productFieldLength);
    }

    private void checkCustomerInquiryNotNullOrEmpty(CustomerInquiryRequest request) {
        Objects.requireNonNull(request, "Request tidak boleh null");

        if (request.getCustomer() == null || request.getCustomerProduct() == null ||
            request.getCustomer().getCustomerID() == null || request.getCustomerProduct().getProductNumber() == null) {
            throw new BusinessException(HandledErrors.InvalidBothParameterMessage);
        }
    }

    private void checkCustomerInquiryNullOrEmpty(CustomerInquiryRequest request) {
        if (request.getCustomer() == null || request.getCustomerProduct() == null) {
            throw new BusinessException(HandledErrors.CustomerEmptyMessage);
        }

        String customerID = request.getCustomer().getCustomerID();
        String productNumber = request.getCustomerProduct().getProductNumber();

        if ((customerID == null || customerID.isEmpty()) && (productNumber == null || productNumber.isEmpty())) {
            throw new BusinessException(HandledErrors.CustomerEmptyMessage);
        }
    }

    private void checkCustomerIDValid(CustomerInquiryRequest request, int customerIDFieldLength) {
        String customerID = request.getCustomer().getCustomerID();
        if (customerID != null && !customerID.isEmpty()) {
            if (customerID.length() > customerIDFieldLength) {
                throw new BusinessException(HandledErrors.CustomerInvalidLengthMessage);
            }
            request.getCustomer().setCustomerID(String.format("%" + customerIDFieldLength + "s", customerID).replace(' ', '0'));
        }
    }

    private void checkProductNumberValid(CustomerInquiryRequest request, int productFieldLength) {
        String productNumber = request.getCustomerProduct().getProductNumber();
        if (productNumber != null && !productNumber.isEmpty()) {
            if (productNumber.length() > productFieldLength) {
                throw new BusinessException(HandledErrors.ProductInvalidLengthMessage);
            }
            request.getCustomerProduct().setProductNumber(String.format("%" + productFieldLength + "s", productNumber).replace(' ', '0'));
        }
    }
}

class CustomerInquiryRequest {
    private Customer customer;
    private CustomerProduct customerProduct;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerProduct getCustomerProduct() {
        return customerProduct;
    }

    public void setCustomerProduct(CustomerProduct customerProduct) {
        this.customerProduct = customerProduct;
    }
}

class Customer {
    private String customerID;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}

class CustomerProduct {
    private String productNumber;

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }
}

class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}

class HandledErrors {
    public static final String InvalidBothParameterMessage = "Both CustomerID and ProductNumber cannot be null";
    public static final String CustomerEmptyMessage = "CustomerID and ProductNumber cannot both be empty";
    public static final String CustomerInvalidLengthMessage = "CustomerID length is invalid";
    public static final String ProductInvalidLengthMessage = "ProductNumber length is invalid";
}
