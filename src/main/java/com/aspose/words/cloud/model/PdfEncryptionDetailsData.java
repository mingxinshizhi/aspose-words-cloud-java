/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose" file="PdfEncryptionDetailsData.java">
 *   Copyright (c) 2021 Aspose.Words for Cloud
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

package com.aspose.words.cloud.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;
import com.aspose.words.cloud.model.*;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Container class for details of encryption.
 */
@ApiModel(description = "Container class for details of encryption.")
public class PdfEncryptionDetailsData {
    @SerializedName("EncryptionAlgorithm")
    private String encryptionAlgorithm = null;

    @SerializedName("OwnerPassword")
    private String ownerPassword = null;

    @SerializedName("Permissions")
    private String permissions = null;

    @SerializedName("UserPassword")
    private String userPassword = null;
    public PdfEncryptionDetailsData encryptionAlgorithm(String encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
        return this;
    }

    /**
     * Gets or sets the encryption algorithm to use.
    * @return encryptionAlgorithm
    **/
    @ApiModelProperty(value = "Gets or sets the encryption algorithm to use.")
    public String getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }

    public void setEncryptionAlgorithm(String encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public PdfEncryptionDetailsData ownerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
        return this;
    }

    /**
     * Gets or sets the owner password for the encrypted PDF document.
    * @return ownerPassword
    **/
    @ApiModelProperty(value = "Gets or sets the owner password for the encrypted PDF document.")
    public String getOwnerPassword() {
        return ownerPassword;
    }

    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }

    public PdfEncryptionDetailsData permissions(String permissions) {
        this.permissions = permissions;
        return this;
    }

    /**
     * Gets or sets the operations that are allowed to a user on the encrypted PDF document.
    * @return permissions
    **/
    @ApiModelProperty(value = "Gets or sets the operations that are allowed to a user on the encrypted PDF document.")
    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public PdfEncryptionDetailsData userPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    /**
     * Gets or sets the user password required for opening the encrypted PDF document.
    * @return userPassword
    **/
    @ApiModelProperty(value = "Gets or sets the user password required for opening the encrypted PDF document.")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PdfEncryptionDetailsData pdfEncryptionDetailsData = (PdfEncryptionDetailsData) o;
        return
            Objects.equals(this.encryptionAlgorithm, pdfEncryptionDetailsData.encryptionAlgorithm) &&
            Objects.equals(this.ownerPassword, pdfEncryptionDetailsData.ownerPassword) &&
            Objects.equals(this.permissions, pdfEncryptionDetailsData.permissions) &&
            Objects.equals(this.userPassword, pdfEncryptionDetailsData.userPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encryptionAlgorithm, ownerPassword, permissions, userPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PdfEncryptionDetailsData {\n");
    sb.append("    encryptionAlgorithm: ").append(toIndentedString(encryptionAlgorithm)).append("\n");
    sb.append("    ownerPassword: ").append(toIndentedString(ownerPassword)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    userPassword: ").append(toIndentedString(userPassword)).append("\n");
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
