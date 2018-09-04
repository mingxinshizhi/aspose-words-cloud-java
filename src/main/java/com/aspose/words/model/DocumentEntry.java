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
 * Represents a document which will be appended to the original resource document.
 */
@ApiModel(description = "Represents a document which will be appended to the original resource document.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-04T13:18:23.497Z")
public class DocumentEntry {
  @JsonProperty("Href")
  private String href = null;

  @JsonProperty("ImportFormatMode")
  private String importFormatMode = null;

  public DocumentEntry href(String href) {
    this.href = href;
    return this;
  }

   /**
   * Path to document to append at the server.
   * @return href
  **/
  @ApiModelProperty(value = "Path to document to append at the server.")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public DocumentEntry importFormatMode(String importFormatMode) {
    this.importFormatMode = importFormatMode;
    return this;
  }

   /**
   * Defines which formatting will be used: appended or destination document.Can be KeepSourceFormatting or UseDestinationStyles.
   * @return importFormatMode
  **/
  @ApiModelProperty(value = "Defines which formatting will be used: appended or destination document.Can be KeepSourceFormatting or UseDestinationStyles.")
  public String getImportFormatMode() {
    return importFormatMode;
  }

  public void setImportFormatMode(String importFormatMode) {
    this.importFormatMode = importFormatMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocumentEntry documentEntry = (DocumentEntry) o;
    return Objects.equals(this.href, documentEntry.href) &&
        Objects.equals(this.importFormatMode, documentEntry.importFormatMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, importFormatMode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocumentEntry {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    importFormatMode: ").append(toIndentedString(importFormatMode)).append("\n");
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

