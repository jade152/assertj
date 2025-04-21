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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class myStringsTests {

  private static String[] escapeCharacters;
  private static String[] typicalStrings;
  private static String[] stringsForPercentEscape;

  @BeforeAll
  static public void setUp(){
    escapeCharacters = new String[] {"\n", "\t", "\b", "\'", "\""};
    typicalStrings = new String[] {"Writing strings is so much fun", Character.toString(0)};
    stringsForPercentEscape = new String[] {"This is a string", "%", "This sentence %has a percent in it", "%This %sentence %has %lots of percents %in it", "╫╦£æ₧", "%╫%╦£æ%₧", "\b%Backspaced character"};
  }

  @Test
  public void isNullOrEmptyTestTypical(){ assertEquals(false, Strings.isNullOrEmpty(typicalStrings[0])); }

  @Test
  public void isNullOrEmptyTestNumber(){ assertEquals(false, Strings.isNullOrEmpty(typicalStrings[1])); }

  @Test
  public void isNullOrEmptyTestNewline(){ assertEquals(false, Strings.isNullOrEmpty(escapeCharacters[0])); }

  @Test
  public void isNullOrEmptyTestTab(){ assertEquals(false, Strings.isNullOrEmpty(escapeCharacters[1])); }

  @Test
  public void isNullOrEmptyTestBackspace(){ assertEquals(false, Strings.isNullOrEmpty(escapeCharacters[2])); }

  @Test
  public void isNullOrEmptyTestApostropphe(){ assertEquals(false, Strings.isNullOrEmpty(escapeCharacters[3])); }

  @Test
  public void isNullOrEmptyTestQuote(){ assertEquals(false, Strings.isNullOrEmpty(escapeCharacters[4]));}

  @Test
  public void quotesAroundObjectsTestBool(){ assertEquals(true, Strings.quote(true)); }

  @Test
  public void quotesAroundObjectsTestShort(){ assertEquals(Short.MIN_VALUE, Strings.quote(Short.MIN_VALUE)); }

  @Test
  public void quotesAroundObjectsTestDoubleMin() { assertEquals(Double.MIN_VALUE, Strings.quote(Double.MIN_VALUE)); }

  @Test
  public void quotesAroundObjectsTestDoubleMax(){ assertEquals(Double.MAX_VALUE, Strings.quote(Double.MAX_VALUE)); }

  @Test
  public void quotesAroundObjectsEmptyString(){ assertEquals("''", Strings.quote("")); }

  @Test
  public void escapePercentTestNull(){ assertEquals(null, Strings.escapePercent(null)); }

  @Test
  public void escapePercentTestNoPercent(){ assertEquals("This is a string", Strings.escapePercent(stringsForPercentEscape[0])); }

  @Test
  public void escapePercentTestSinglePercent(){ assertEquals("%%", Strings.escapePercent(stringsForPercentEscape[1])); }

  @Test
  public void escapePercentTestPercentInString(){ assertEquals("This sentence %%has a percent in it", Strings.escapePercent(stringsForPercentEscape[2])); }

  @Test
  public void escapePercentTestPercentsInString(){ assertEquals("%%This %%sentence %%has %%lots of percents %%in it", Strings.escapePercent(stringsForPercentEscape[3])); }

  @Test
  public void escapePercentTestSpecialString(){ assertEquals("╫╦£æ₧", Strings.escapePercent(stringsForPercentEscape[4])); }

  @Test
  public void escapePercentTestSpecialStringWithPercents(){ assertEquals("%%╫%%╦£æ%%₧", Strings.escapePercent(stringsForPercentEscape[5])); }

  @Test
  public void escapePercentTestEscapeSequenceString(){ assertEquals("\b%%Backspaced character", Strings.escapePercent(stringsForPercentEscape[6])); }
}

