/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

  public static void main(String[] args) {
    // TODO: create two instances of your thread subclass and start them up
    MessagePrinter printer1 = new MessagePrinter("MARCO", 0);
    MessagePrinter printer2 = new MessagePrinter("POLO");
    MessagePrinter printer3 = new MessagePrinter("LUCAS", 1500);

//    printer1.run();
//    printer2.run();
//    printer3.run();

    printer1.start();
    printer2.start();
    printer3.start();
  }
}