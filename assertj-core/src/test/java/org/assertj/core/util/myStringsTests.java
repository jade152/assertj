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

  @BeforeAll
  static public void setUp(){
    escapeCharacters = new String[] {"\n", "\t", "\b", "\'", "\""};
    typicalStrings = new String[] {"Writing strings is so much fun", Character.toString(0)};


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
}

