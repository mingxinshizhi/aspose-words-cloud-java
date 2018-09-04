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
import com.aspose.words.model.LinkElement;
import com.aspose.words.model.PreferredWidth;
import com.aspose.words.model.WordsApiLink;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Represents all formatting for a table row.
 */
@ApiModel(description = "Represents all formatting for a table row.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-04T12:28:34.829Z")
public class TableCellFormat {
  @JsonProperty("link")
  private WordsApiLink link = null;

  @JsonProperty("BottomPadding")
  private Double bottomPadding = null;

  @JsonProperty("FitText")
  private Boolean fitText = null;

  /**
   * Specifies how the cell is merged horizontally with other cells in the row.
   */
  public enum HorizontalMergeEnum {
    NONE("None"),
    
    FIRST("First"),
    
    PREVIOUS("Previous");

    private String value;

    HorizontalMergeEnum(String value) {
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
    public static HorizontalMergeEnum fromValue(String text) {
      for (HorizontalMergeEnum b : HorizontalMergeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("HorizontalMerge")
  private HorizontalMergeEnum horizontalMerge = null;

  @JsonProperty("LeftPadding")
  private Double leftPadding = null;

  /**
   * Returns or sets the orientation of text in a table cell.
   */
  public enum OrientationEnum {
    HORIZONTAL("Horizontal"),
    
    DOWNWARD("Downward"),
    
    UPWARD("Upward"),
    
    HORIZONTALROTATEDFAREAST("HorizontalRotatedFarEast"),
    
    VERTICALFAREAST("VerticalFarEast"),
    
    VERTICALROTATEDFAREAST("VerticalRotatedFarEast");

    private String value;

    OrientationEnum(String value) {
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
    public static OrientationEnum fromValue(String text) {
      for (OrientationEnum b : OrientationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("Orientation")
  private OrientationEnum orientation = null;

  @JsonProperty("PreferredWidth")
  private PreferredWidth preferredWidth = null;

  @JsonProperty("RightPadding")
  private Double rightPadding = null;

  @JsonProperty("TopPadding")
  private Double topPadding = null;

  /**
   * Returns or sets the vertical alignment of text in the cell.
   */
  public enum VerticalAlignmentEnum {
    TOP("Top"),
    
    CENTER("Center"),
    
    BOTTOM("Bottom");

    private String value;

    VerticalAlignmentEnum(String value) {
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
    public static VerticalAlignmentEnum fromValue(String text) {
      for (VerticalAlignmentEnum b : VerticalAlignmentEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("VerticalAlignment")
  private VerticalAlignmentEnum verticalAlignment = null;

  /**
   * Specifies how the cell is merged with other cells vertically.
   */
  public enum VerticalMergeEnum {
    NONE("None"),
    
    FIRST("First"),
    
    PREVIOUS("Previous");

    private String value;

    VerticalMergeEnum(String value) {
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
    public static VerticalMergeEnum fromValue(String text) {
      for (VerticalMergeEnum b : VerticalMergeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("VerticalMerge")
  private VerticalMergeEnum verticalMerge = null;

  @JsonProperty("Width")
  private Double width = null;

  @JsonProperty("WrapText")
  private Boolean wrapText = null;

  public TableCellFormat link(WordsApiLink link) {
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

  public TableCellFormat bottomPadding(Double bottomPadding) {
    this.bottomPadding = bottomPadding;
    return this;
  }

   /**
   * Returns or sets the amount of space (in points) to add below the contents of cell.
   * @return bottomPadding
  **/
  @ApiModelProperty(value = "Returns or sets the amount of space (in points) to add below the contents of cell.")
  public Double getBottomPadding() {
    return bottomPadding;
  }

  public void setBottomPadding(Double bottomPadding) {
    this.bottomPadding = bottomPadding;
  }

  public TableCellFormat fitText(Boolean fitText) {
    this.fitText = fitText;
    return this;
  }

   /**
   * If true, fits text in the cell, compressing each paragraph to the width of the cell.
   * @return fitText
  **/
  @ApiModelProperty(value = "If true, fits text in the cell, compressing each paragraph to the width of the cell.")
  public Boolean isFitText() {
    return fitText;
  }

  public void setFitText(Boolean fitText) {
    this.fitText = fitText;
  }

  public TableCellFormat horizontalMerge(HorizontalMergeEnum horizontalMerge) {
    this.horizontalMerge = horizontalMerge;
    return this;
  }

   /**
   * Specifies how the cell is merged horizontally with other cells in the row.
   * @return horizontalMerge
  **/
  @ApiModelProperty(value = "Specifies how the cell is merged horizontally with other cells in the row.")
  public HorizontalMergeEnum getHorizontalMerge() {
    return horizontalMerge;
  }

  public void setHorizontalMerge(HorizontalMergeEnum horizontalMerge) {
    this.horizontalMerge = horizontalMerge;
  }

  public TableCellFormat leftPadding(Double leftPadding) {
    this.leftPadding = leftPadding;
    return this;
  }

   /**
   * Returns or sets the amount of space (in points) to add to the left of the contents of cell.
   * @return leftPadding
  **/
  @ApiModelProperty(value = "Returns or sets the amount of space (in points) to add to the left of the contents of cell.")
  public Double getLeftPadding() {
    return leftPadding;
  }

  public void setLeftPadding(Double leftPadding) {
    this.leftPadding = leftPadding;
  }

  public TableCellFormat orientation(OrientationEnum orientation) {
    this.orientation = orientation;
    return this;
  }

   /**
   * Returns or sets the orientation of text in a table cell.
   * @return orientation
  **/
  @ApiModelProperty(value = "Returns or sets the orientation of text in a table cell.")
  public OrientationEnum getOrientation() {
    return orientation;
  }

  public void setOrientation(OrientationEnum orientation) {
    this.orientation = orientation;
  }

  public TableCellFormat preferredWidth(PreferredWidth preferredWidth) {
    this.preferredWidth = preferredWidth;
    return this;
  }

   /**
   * Returns or sets the preferred width of the cell.
   * @return preferredWidth
  **/
  @ApiModelProperty(value = "Returns or sets the preferred width of the cell.")
  public PreferredWidth getPreferredWidth() {
    return preferredWidth;
  }

  public void setPreferredWidth(PreferredWidth preferredWidth) {
    this.preferredWidth = preferredWidth;
  }

  public TableCellFormat rightPadding(Double rightPadding) {
    this.rightPadding = rightPadding;
    return this;
  }

   /**
   * Returns or sets the amount of space (in points) to add to the right of the contents of cell.
   * @return rightPadding
  **/
  @ApiModelProperty(value = "Returns or sets the amount of space (in points) to add to the right of the contents of cell.")
  public Double getRightPadding() {
    return rightPadding;
  }

  public void setRightPadding(Double rightPadding) {
    this.rightPadding = rightPadding;
  }

  public TableCellFormat topPadding(Double topPadding) {
    this.topPadding = topPadding;
    return this;
  }

   /**
   * Returns or sets the amount of space (in points) to add above the contents of cell.
   * @return topPadding
  **/
  @ApiModelProperty(value = "Returns or sets the amount of space (in points) to add above the contents of cell.")
  public Double getTopPadding() {
    return topPadding;
  }

  public void setTopPadding(Double topPadding) {
    this.topPadding = topPadding;
  }

  public TableCellFormat verticalAlignment(VerticalAlignmentEnum verticalAlignment) {
    this.verticalAlignment = verticalAlignment;
    return this;
  }

   /**
   * Returns or sets the vertical alignment of text in the cell.
   * @return verticalAlignment
  **/
  @ApiModelProperty(value = "Returns or sets the vertical alignment of text in the cell.")
  public VerticalAlignmentEnum getVerticalAlignment() {
    return verticalAlignment;
  }

  public void setVerticalAlignment(VerticalAlignmentEnum verticalAlignment) {
    this.verticalAlignment = verticalAlignment;
  }

  public TableCellFormat verticalMerge(VerticalMergeEnum verticalMerge) {
    this.verticalMerge = verticalMerge;
    return this;
  }

   /**
   * Specifies how the cell is merged with other cells vertically.
   * @return verticalMerge
  **/
  @ApiModelProperty(value = "Specifies how the cell is merged with other cells vertically.")
  public VerticalMergeEnum getVerticalMerge() {
    return verticalMerge;
  }

  public void setVerticalMerge(VerticalMergeEnum verticalMerge) {
    this.verticalMerge = verticalMerge;
  }

  public TableCellFormat width(Double width) {
    this.width = width;
    return this;
  }

   /**
   * Gets the width of the cell in points.
   * @return width
  **/
  @ApiModelProperty(value = "Gets the width of the cell in points.")
  public Double getWidth() {
    return width;
  }

  public void setWidth(Double width) {
    this.width = width;
  }

  public TableCellFormat wrapText(Boolean wrapText) {
    this.wrapText = wrapText;
    return this;
  }

   /**
   * If true, wrap text for the cell.
   * @return wrapText
  **/
  @ApiModelProperty(value = "If true, wrap text for the cell.")
  public Boolean isWrapText() {
    return wrapText;
  }

  public void setWrapText(Boolean wrapText) {
    this.wrapText = wrapText;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TableCellFormat tableCellFormat = (TableCellFormat) o;
    return Objects.equals(this.link, tableCellFormat.link) &&
        Objects.equals(this.bottomPadding, tableCellFormat.bottomPadding) &&
        Objects.equals(this.fitText, tableCellFormat.fitText) &&
        Objects.equals(this.horizontalMerge, tableCellFormat.horizontalMerge) &&
        Objects.equals(this.leftPadding, tableCellFormat.leftPadding) &&
        Objects.equals(this.orientation, tableCellFormat.orientation) &&
        Objects.equals(this.preferredWidth, tableCellFormat.preferredWidth) &&
        Objects.equals(this.rightPadding, tableCellFormat.rightPadding) &&
        Objects.equals(this.topPadding, tableCellFormat.topPadding) &&
        Objects.equals(this.verticalAlignment, tableCellFormat.verticalAlignment) &&
        Objects.equals(this.verticalMerge, tableCellFormat.verticalMerge) &&
        Objects.equals(this.width, tableCellFormat.width) &&
        Objects.equals(this.wrapText, tableCellFormat.wrapText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(link, bottomPadding, fitText, horizontalMerge, leftPadding, orientation, preferredWidth, rightPadding, topPadding, verticalAlignment, verticalMerge, width, wrapText);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TableCellFormat {\n");
    
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    bottomPadding: ").append(toIndentedString(bottomPadding)).append("\n");
    sb.append("    fitText: ").append(toIndentedString(fitText)).append("\n");
    sb.append("    horizontalMerge: ").append(toIndentedString(horizontalMerge)).append("\n");
    sb.append("    leftPadding: ").append(toIndentedString(leftPadding)).append("\n");
    sb.append("    orientation: ").append(toIndentedString(orientation)).append("\n");
    sb.append("    preferredWidth: ").append(toIndentedString(preferredWidth)).append("\n");
    sb.append("    rightPadding: ").append(toIndentedString(rightPadding)).append("\n");
    sb.append("    topPadding: ").append(toIndentedString(topPadding)).append("\n");
    sb.append("    verticalAlignment: ").append(toIndentedString(verticalAlignment)).append("\n");
    sb.append("    verticalMerge: ").append(toIndentedString(verticalMerge)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    wrapText: ").append(toIndentedString(wrapText)).append("\n");
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

