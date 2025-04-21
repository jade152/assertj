package org.assertj.core.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class myArraysTest {

  //boundary test
  @Test
  public void sizeOfTestSmallest(){ assertEquals(0, Arrays.sizeOf(new char[0])); }

  @Test
  public void sizeOfTestSecondSmallest(){ assertEquals(1, Arrays.sizeOf(new char[1])); }

  @Test
  public void sizeOfTestTypical(){ assertEquals(500, Arrays.sizeOf(new char[500])); }

  @Test
  public void sizeOfTestSecondBiggest(){ assertEquals(Integer.MAX_VALUE - 3, Arrays.sizeOf(new char[Integer.MAX_VALUE - 3])); }

  @Test
  public void sizeOfTestBiggest(){ assertEquals(Integer.MAX_VALUE - 2, Arrays.sizeOf(new char[Integer.MAX_VALUE - 2])); }

}
