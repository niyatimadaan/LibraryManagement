package com.niyati.library;

import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.niyati.library.service.FakeBookServiceImpl;
import java.lang.NumberFormatException;


@Component
@ConditionalOnNotWebApplication
public class LibraryConsoleApplication implements CommandLineRunner {
  @Autowired
  private FakeBookServiceImpl fakeBookService;

  @Override
  public void run(String... args) {
    if ( !args[0].equals("seed") ) {
      System.err.println(args[0] + " flag not found.");
      return;
    }

    try {
      int count = Integer.parseInt(args[1]);
      this.fakeBookService.seedDatabase(count);
    } catch ( NumberFormatException e ) {
      System.err.println("\"" + args[1] + "\"" + " is not a number");
    }
  }
}