/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose">
 *   Copyright (c) 2018 Aspose.Words for Cloud
 * </copyright>
 * <summary>
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 * </summary>
 * --------------------------------------------------------------------------------
 */

package com.aspose.words.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Container for the footnotes statistical data
 */
@ApiModel(description = "Container for the footnotes statistical data")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-04T13:21:14.416Z")
public class FootnotesStatData {
  @JsonProperty("WordCount")
  private Integer wordCount = null;

  @JsonProperty("ParagraphCount")
  private Integer paragraphCount = null;

  public FootnotesStatData wordCount(Integer wordCount) {
    this.wordCount = wordCount;
    return this;
  }

   /**
   * Total count of words in footnotes
   * @return wordCount
  **/
  @ApiModelProperty(required = true, value = "Total count of words in footnotes")
  public Integer getWordCount() {
    return wordCount;
  }

  public void setWordCount(Integer wordCount) {
    this.wordCount = wordCount;
  }

  public FootnotesStatData paragraphCount(Integer paragraphCount) {
    this.paragraphCount = paragraphCount;
    return this;
  }

   /**
   * Total count of paragraphs in footnotes
   * @return paragraphCount
  **/
  @ApiModelProperty(required = true, value = "Total count of paragraphs in footnotes")
  public Integer getParagraphCount() {
    return paragraphCount;
  }

  public void setParagraphCount(Integer paragraphCount) {
    this.paragraphCount = paragraphCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FootnotesStatData footnotesStatData = (FootnotesStatData) o;
    return Objects.equals(this.wordCount, footnotesStatData.wordCount) &&
        Objects.equals(this.paragraphCount, footnotesStatData.paragraphCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wordCount, paragraphCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FootnotesStatData {\n");
    
    sb.append("    wordCount: ").append(toIndentedString(wordCount)).append("\n");
    sb.append("    paragraphCount: ").append(toIndentedString(paragraphCount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

