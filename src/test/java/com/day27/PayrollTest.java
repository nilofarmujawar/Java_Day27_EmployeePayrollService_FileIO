package com.day27;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@SuppressWarnings("deprecation")
public class PayrollTest {

    @Test
    public void given3EmployeesWhenWrittenToFileShouldMatchEmployeesEntries() {
        EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, 25000.56, "Devnandan Kumar"),
                new EmployeePayrollData(2, 15000.65, "Manoj Kumar"),
                new EmployeePayrollData(3, 22000.67, "Abhishek sinha") };
       EmployeePayrollService EmployeePayrollService;
        EmployeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
        EmployeePayrollService.write(com.day27.EmployeePayrollService.IOService.FILE_IO);
        long entriesCount=EmployeePayrollService.countEntries(com.day27.EmployeePayrollService.IOService.FILE_IO);
        EmployeePayrollService.printData(com.day27.EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3, entriesCount);
    }

    @Test
    public void givenFileOnReadingFromFileShouldMatchEmployeeCount() {
        EmployeePayrollService payrollService=new EmployeePayrollService();
        long entries=payrollService.readEmployeeData(EmployeePayrollService.IOService.FILE_IO);
    }

}
