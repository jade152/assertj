/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2025 the original author or authors.
 */

package org.assertj.core.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.util.DateUtil.parse;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class myDateUtilTests {
  private static SimpleDateFormat dateFormatter;

  private static String[] unparsableDates;
  private static String[] parsibleDates;

  @BeforeAll
  public static void setupForTests(){
    dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    unparsableDates = new String[] {"00/00/0000", "1.2/1.1/15.63", "99/99/9999", "gr/eg/milk"};
    parsibleDates = new String[] {"01/01/0001", "01/12/1970", "20/01/2038", "31/12/9999"};

  }

  //partition equivalence
  @Test
  public void parseTestExtremeMinimum() throws ParseException { assertThrows(RuntimeException.class, () -> parse(unparsableDates[0])); }

  @Test
  public void parseTestFloats() throws ParseException { assertThrows(RuntimeException.class, () -> parse(unparsableDates[1])); }

  @Test
  public void parseTest() throws ParseException { assertThrows(RuntimeException.class, () -> parse(unparsableDates[2])); }

  @Test
  public void parseTestExtremeMaximum() throws ParseException { assertThrows(RuntimeException.class, () -> parse(unparsableDates[3])); }

  @Test
  public void parseTestMinimum() throws ParseException { assertEquals(parse("0001-01-01"), dateFormatter.parse(parsibleDates[0])); }

  @Test
  public void parseTestTypical() throws ParseException{ assertEquals(parse("1970-12-01"), dateFormatter.parse(parsibleDates[1])); }

  @Test
  public void parseTestEpoch() throws ParseException{ assertEquals(parse("2038-01-20"), dateFormatter.parse(parsibleDates[2])); }

  @Test
  public void parseTestMax() throws ParseException{ assertEquals(parse("9999-12-31"), dateFormatter.parse(parsibleDates[3])); }
}


