/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.personnel;

import java.sql.Date;
import java.util.Map;

public class EmployeeFactory {
  
  // prevent direct instantiation - this is an all-static factory class
  private EmployeeFactory() {
  }
  
  /**
   * TODO: given the input map, create and return the correct object (with its properties set).
   * If the input map's "type" value is not "HE" or "SE", throw IllegalArgumentException with a suitable message.
   */
  public static Employee createEmployee(Map<String,String> inputMap)
  throws IllegalArgumentException {
    // return value
    Employee emp = null;
    String type = inputMap.get("type");
    if (!type.equals("HE") && !type.equals("SE")) {
      throw new IllegalArgumentException("The type of employee must be HE(hourly) or SE(Salary)");
    }
    Date hireDate = Date.valueOf(inputMap.get("hireDate"));
    String name = inputMap.get("name");
    if(type.equals("SE")){
      double salary = Double.parseDouble(inputMap.get("salary"));
      emp = new SalariedEmployee(name, hireDate, salary);
    } else {
      double rate = Double.parseDouble(inputMap.get("rate"));
      double hours = Double.parseDouble(inputMap.get("hours"));
      emp = new HourlyEmployee(name, hireDate, rate, hours);
    }
    return emp;
  }
}