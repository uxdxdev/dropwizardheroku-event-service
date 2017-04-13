package com.bitbosh.DropwizardHeroku;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.dropwizard.Application;
import mockit.Mock;
import mockit.MockUp;

public class DropwizardHerokuApplicationUnitTest {

  @Test
  public void main_verifyRunCall_IfApplicationStarted() throws Exception {
    String expected = "test";

    // Mock the ctor for DropwizardHerokuApplication super class Application<DropwizardHerokuConfiguration>
    new MockUp<Application<DropwizardHerokuConfiguration>>() {

      @Mock
      public void $init() {

      }
    };

    // Mock the ctor for DropwizardHerokuApplication
    new MockUp<DropwizardHerokuApplication>() {

      @Mock
      public void run(String... args) {
        String actual = args[0];

        // Assert args contains expected when called from main()
        assertTrue(expected.equals(actual));
      }

    };

    DropwizardHerokuApplication.main(new String[] { expected });
  }
}
