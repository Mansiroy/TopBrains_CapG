//package com.hackerrank.restcontrolleradvice.enums;
//
//public enum FizzBuzzEnum {
//  FIZZ("fizz"),
//  BUZZ("buzz"),
//  FIZZBUZZ("fizzbuzz");
//
//  private final String value;
//
//  private FizzBuzzEnum(String value) {
//    this.value = value;
//  }
//
//  public String getValue() {
//    return value;
//  }
//
//  public static FizzBuzzEnum getStatus(String value) {
//    switch (value) {
//      case "Fizz":
//        return FizzBuzzEnum.FIZZ;
//      case "Buzz":
//        return FizzBuzzEnum.BUZZ;
//      case "FizzBuzz":
//        return FizzBuzzEnum.FIZZBUZZ;
//      default:
//        return null;
//    }
//  }
//}


package com.hackerrank.restcontrolleradvice.enums;

public enum FizzBuzzEnum {
  FIZZ("fizz"),
  BUZZ("buzz"),
  FIZZBUZZ("fizzbuzz");

  private final String value;

  private FizzBuzzEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static FizzBuzzEnum getStatus(String value) {
    switch (value.toLowerCase()) {   // 
      case "fizz":
        return FizzBuzzEnum.FIZZ;
      case "buzz":
        return FizzBuzzEnum.BUZZ;
      case "fizzbuzz":
        return FizzBuzzEnum.FIZZBUZZ;
      default:
        return null;
    }
  }
}