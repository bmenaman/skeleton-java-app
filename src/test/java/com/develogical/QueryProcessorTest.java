package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void knowsWhoWroteRomeoAndJuliet() throws Exception {
    assertThat(queryProcessor.process("Who wrote Romeo And Juliet"), containsString("Shakespeare"));
  }

  @Test
  public void isNotCaseSensitive() throws Exception {
    assertThat(queryProcessor.process("who wrote romeo and juliet"), containsString("Shakespeare"));
  }

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void largest() throws Exception {
    String x = "1";
    String y = "2";
    assertThat(queryProcessor.process("which of the following numbers is the largest: 13, 148, 103, 93"), is("148"));
  }

  @Test
  public void xplusy() throws Exception {
    Integer x = 1;
    Integer y = 2;
    String q = "what is "+x.toString()+" plus "+y.toString();
    System.out.println(q);
    assertThat(queryProcessor.process(q), is("3"));
  }

  @Test
  public void isprime() throws Exception {
    String q = "which of the following numbers are primes: 229, 870";
    System.out.println(q);
    assertThat(queryProcessor.process(q), is("229"));
  }
}
