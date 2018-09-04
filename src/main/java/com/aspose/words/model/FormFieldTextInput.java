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
import com.aspose.words.model.FormField;
import com.aspose.words.model.WordsApiLink;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * FormField text input element
 */
@ApiModel(description = "FormField text input element")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-04T13:32:20.291Z")
public class FormFieldTextInput {
  @JsonProperty("link")
  private WordsApiLink link = null;

  @JsonProperty("NodeId")
  private String nodeId = null;

  @JsonProperty("CalculateOnExit")
  private Boolean calculateOnExit = null;

  @JsonProperty("Enabled")
  private Boolean enabled = null;

  @JsonProperty("EntryMacro")
  private String entryMacro = null;

  @JsonProperty("ExitMacro")
  private String exitMacro = null;

  @JsonProperty("HelpText")
  private String helpText = null;

  @JsonProperty("Name")
  private String name = null;

  @JsonProperty("OwnHelp")
  private Boolean ownHelp = null;

  @JsonProperty("OwnStatus")
  private Boolean ownStatus = null;

  @JsonProperty("StatusText")
  private String statusText = null;

  @JsonProperty("MaxLength")
  private Integer maxLength = null;

  @JsonProperty("TextInputDefault")
  private String textInputDefault = null;

  @JsonProperty("TextInputFormat")
  private String textInputFormat = null;

  /**
   * Gets or sets the type of a text form field.
   */
  public enum TextInputTypeEnum {
    REGULAR("Regular"),
    
    NUMBER("Number"),
    
    DATE("Date"),
    
    CURRENTDATE("CurrentDate"),
    
    CURRENTTIME("CurrentTime"),
    
    CALCULATED("Calculated");

    private String value;

    TextInputTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TextInputTypeEnum fromValue(String text) {
      for (TextInputTypeEnum b : TextInputTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("TextInputType")
  private TextInputTypeEnum textInputType = null;

  public FormFieldTextInput link(WordsApiLink link) {
    this.link = link;
    return this;
  }

   /**
   * Link to the document.
   * @return link
  **/
  @ApiModelProperty(value = "Link to the document.")
  public WordsApiLink getLink() {
    return link;
  }

  public void setLink(WordsApiLink link) {
    this.link = link;
  }

  public FormFieldTextInput nodeId(String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

   /**
   * Node id
   * @return nodeId
  **/
  @ApiModelProperty(value = "Node id")
  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public FormFieldTextInput calculateOnExit(Boolean calculateOnExit) {
    this.calculateOnExit = calculateOnExit;
    return this;
  }

   /**
   * True if references to the specified form field are automatically updated whenever the field is exited.
   * @return calculateOnExit
  **/
  @ApiModelProperty(value = "True if references to the specified form field are automatically updated whenever the field is exited.")
  public Boolean isCalculateOnExit() {
    return calculateOnExit;
  }

  public void setCalculateOnExit(Boolean calculateOnExit) {
    this.calculateOnExit = calculateOnExit;
  }

  public FormFieldTextInput enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * True if a form field is enabled.
   * @return enabled
  **/
  @ApiModelProperty(value = "True if a form field is enabled.")
  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public FormFieldTextInput entryMacro(String entryMacro) {
    this.entryMacro = entryMacro;
    return this;
  }

   /**
   * Returns or sets an entry macro name for the form field.
   * @return entryMacro
  **/
  @ApiModelProperty(value = "Returns or sets an entry macro name for the form field.")
  public String getEntryMacro() {
    return entryMacro;
  }

  public void setEntryMacro(String entryMacro) {
    this.entryMacro = entryMacro;
  }

  public FormFieldTextInput exitMacro(String exitMacro) {
    this.exitMacro = exitMacro;
    return this;
  }

   /**
   * Returns or sets an exit macro name for the form field.
   * @return exitMacro
  **/
  @ApiModelProperty(value = "Returns or sets an exit macro name for the form field.")
  public String getExitMacro() {
    return exitMacro;
  }

  public void setExitMacro(String exitMacro) {
    this.exitMacro = exitMacro;
  }

  public FormFieldTextInput helpText(String helpText) {
    this.helpText = helpText;
    return this;
  }

   /**
   * Returns or sets the text that&#39;s displayed in a message box when the form field has the focus and the user presses F1.
   * @return helpText
  **/
  @ApiModelProperty(value = "Returns or sets the text that's displayed in a message box when the form field has the focus and the user presses F1.")
  public String getHelpText() {
    return helpText;
  }

  public void setHelpText(String helpText) {
    this.helpText = helpText;
  }

  public FormFieldTextInput name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Gets or sets the form field name.
   * @return name
  **/
  @ApiModelProperty(value = "Gets or sets the form field name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FormFieldTextInput ownHelp(Boolean ownHelp) {
    this.ownHelp = ownHelp;
    return this;
  }

   /**
   * Specifies the source of the text that&#39;s displayed in a message box when a form field has the focus and the user presses F1.
   * @return ownHelp
  **/
  @ApiModelProperty(value = "Specifies the source of the text that's displayed in a message box when a form field has the focus and the user presses F1.")
  public Boolean isOwnHelp() {
    return ownHelp;
  }

  public void setOwnHelp(Boolean ownHelp) {
    this.ownHelp = ownHelp;
  }

  public FormFieldTextInput ownStatus(Boolean ownStatus) {
    this.ownStatus = ownStatus;
    return this;
  }

   /**
   * Specifies the source of the text that&#39;s displayed in the status bar when a form field has the focus.
   * @return ownStatus
  **/
  @ApiModelProperty(value = "Specifies the source of the text that's displayed in the status bar when a form field has the focus.")
  public Boolean isOwnStatus() {
    return ownStatus;
  }

  public void setOwnStatus(Boolean ownStatus) {
    this.ownStatus = ownStatus;
  }

  public FormFieldTextInput statusText(String statusText) {
    this.statusText = statusText;
    return this;
  }

   /**
   * Returns or sets the text that&#39;s displayed in the status bar when a form field has the focus.
   * @return statusText
  **/
  @ApiModelProperty(value = "Returns or sets the text that's displayed in the status bar when a form field has the focus.")
  public String getStatusText() {
    return statusText;
  }

  public void setStatusText(String statusText) {
    this.statusText = statusText;
  }

  public FormFieldTextInput maxLength(Integer maxLength) {
    this.maxLength = maxLength;
    return this;
  }

   /**
   * Maximum length for the text field. Zero when the length is not limited.
   * @return maxLength
  **/
  @ApiModelProperty(value = "Maximum length for the text field. Zero when the length is not limited.")
  public Integer getMaxLength() {
    return maxLength;
  }

  public void setMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
  }

  public FormFieldTextInput textInputDefault(String textInputDefault) {
    this.textInputDefault = textInputDefault;
    return this;
  }

   /**
   * Gets or sets the default string or a calculation expression of a text form field. 
   * @return textInputDefault
  **/
  @ApiModelProperty(value = "Gets or sets the default string or a calculation expression of a text form field. ")
  public String getTextInputDefault() {
    return textInputDefault;
  }

  public void setTextInputDefault(String textInputDefault) {
    this.textInputDefault = textInputDefault;
  }

  public FormFieldTextInput textInputFormat(String textInputFormat) {
    this.textInputFormat = textInputFormat;
    return this;
  }

   /**
   * Returns or sets the text formatting for a text form field.
   * @return textInputFormat
  **/
  @ApiModelProperty(value = "Returns or sets the text formatting for a text form field.")
  public String getTextInputFormat() {
    return textInputFormat;
  }

  public void setTextInputFormat(String textInputFormat) {
    this.textInputFormat = textInputFormat;
  }

  public FormFieldTextInput textInputType(TextInputTypeEnum textInputType) {
    this.textInputType = textInputType;
    return this;
  }

   /**
   * Gets or sets the type of a text form field.
   * @return textInputType
  **/
  @ApiModelProperty(value = "Gets or sets the type of a text form field.")
  public TextInputTypeEnum getTextInputType() {
    return textInputType;
  }

  public void setTextInputType(TextInputTypeEnum textInputType) {
    this.textInputType = textInputType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormFieldTextInput formFieldTextInput = (FormFieldTextInput) o;
    return Objects.equals(this.link, formFieldTextInput.link) &&
        Objects.equals(this.nodeId, formFieldTextInput.nodeId) &&
        Objects.equals(this.calculateOnExit, formFieldTextInput.calculateOnExit) &&
        Objects.equals(this.enabled, formFieldTextInput.enabled) &&
        Objects.equals(this.entryMacro, formFieldTextInput.entryMacro) &&
        Objects.equals(this.exitMacro, formFieldTextInput.exitMacro) &&
        Objects.equals(this.helpText, formFieldTextInput.helpText) &&
        Objects.equals(this.name, formFieldTextInput.name) &&
        Objects.equals(this.ownHelp, formFieldTextInput.ownHelp) &&
        Objects.equals(this.ownStatus, formFieldTextInput.ownStatus) &&
        Objects.equals(this.statusText, formFieldTextInput.statusText) &&
        Objects.equals(this.maxLength, formFieldTextInput.maxLength) &&
        Objects.equals(this.textInputDefault, formFieldTextInput.textInputDefault) &&
        Objects.equals(this.textInputFormat, formFieldTextInput.textInputFormat) &&
        Objects.equals(this.textInputType, formFieldTextInput.textInputType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(link, nodeId, calculateOnExit, enabled, entryMacro, exitMacro, helpText, name, ownHelp, ownStatus, statusText, maxLength, textInputDefault, textInputFormat, textInputType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormFieldTextInput {\n");
    
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    nodeId: ").append(toIndentedString(nodeId)).append("\n");
    sb.append("    calculateOnExit: ").append(toIndentedString(calculateOnExit)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    entryMacro: ").append(toIndentedString(entryMacro)).append("\n");
    sb.append("    exitMacro: ").append(toIndentedString(exitMacro)).append("\n");
    sb.append("    helpText: ").append(toIndentedString(helpText)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownHelp: ").append(toIndentedString(ownHelp)).append("\n");
    sb.append("    ownStatus: ").append(toIndentedString(ownStatus)).append("\n");
    sb.append("    statusText: ").append(toIndentedString(statusText)).append("\n");
    sb.append("    maxLength: ").append(toIndentedString(maxLength)).append("\n");
    sb.append("    textInputDefault: ").append(toIndentedString(textInputDefault)).append("\n");
    sb.append("    textInputFormat: ").append(toIndentedString(textInputFormat)).append("\n");
    sb.append("    textInputType: ").append(toIndentedString(textInputType)).append("\n");
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

