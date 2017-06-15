/**
 * Simple TripApp API
 * This is a simple TripApp API
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.swagger.client.model;

import io.swagger.client.model.TicketType;
import io.swagger.client.model.User;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;
import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class TicketPurchase implements Serializable {
  
  @SerializedName("id")
  private Integer id = null;
  @SerializedName("code")
  private UUID code = null;
  @SerializedName("price")
  private Double price = null;
  @SerializedName("startDateTime")
  private Date startDateTime = null;
  @SerializedName("endDateTime")
  private Date endDateTime = null;
  @SerializedName("numberOfPassangers")
  private Integer numberOfPassangers = null;
  @SerializedName("type")
  private TicketType type = null;
  @SerializedName("user")
  private User user = null;
  @SerializedName("userId")
  private Long userId = null;
  @SerializedName("typeId")
  private Integer typeId = null;

  public TicketPurchase(){

  }

  public TicketPurchase(String guid){
    code = UUID.fromString(guid);
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Integer getTypeId() {
    return typeId;
  }
  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public UUID getCode() {
    return code;
  }
  public void setCode(UUID code) {
    this.code = code;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Date getStartDateTime() {
    return startDateTime;
  }
  public void setStartDateTime(Date startDateTime) {

    this.startDateTime = startDateTime;
  }
  public String getStartDateTimeString(){
    DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    // Uncomment for testing:
    // df.setTimeZone(TimeZone.getTimeZone("UTC"));

    // DateFormat dfLokal = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    // dfLokal.setTimeZone(TimeZone.getDefault());
    // String gmtTime = df.format(startDateTime);
    // String lokalTime = dfLokal.format(startDateTime);
    return df.format(startDateTime);
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public Date getEndDateTime() {
    return endDateTime;
  }
  public void setEndDateTime(Date endDateTime) {
    this.endDateTime = endDateTime;
  }
  public String getEndDateTimeString(){
    DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    return df.format(endDateTime);
  }

  /**
   * Number of passangers allowed to travel with buyer and including buyer too.
   **/
  @ApiModelProperty(value = "Number of passangers allowed to travel with buyer and including buyer too.")
  public Integer getNumberOfPassangers() {
    return numberOfPassangers;
  }
  public void setNumberOfPassangers(Integer numberOfPassangers) {
    this.numberOfPassangers = numberOfPassangers;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public TicketType getType() {
    return type;
  }
  public void setType(TicketType type) {
    this.type = type;
  }

  /**
   **/
  @ApiModelProperty(required = true, value = "")
  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TicketPurchase ticketPurchase = (TicketPurchase) o;
    return (this.id == null ? ticketPurchase.id == null : this.id.equals(ticketPurchase.id)) &&
        (this.code == null ? ticketPurchase.code == null : this.code.equals(ticketPurchase.code)) &&
        (this.price == null ? ticketPurchase.price == null : this.price.equals(ticketPurchase.price)) &&
        (this.startDateTime == null ? ticketPurchase.startDateTime == null : this.startDateTime.equals(ticketPurchase.startDateTime)) &&
        (this.endDateTime == null ? ticketPurchase.endDateTime == null : this.endDateTime.equals(ticketPurchase.endDateTime)) &&
        (this.numberOfPassangers == null ? ticketPurchase.numberOfPassangers == null : this.numberOfPassangers.equals(ticketPurchase.numberOfPassangers)) &&
        (this.type == null ? ticketPurchase.type == null : this.type.equals(ticketPurchase.type)) &&
        (this.user == null ? ticketPurchase.user == null : this.user.equals(ticketPurchase.user));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.id == null ? 0: this.id.hashCode());
    result = 31 * result + (this.code == null ? 0: this.code.hashCode());
    result = 31 * result + (this.price == null ? 0: this.price.hashCode());
    result = 31 * result + (this.startDateTime == null ? 0: this.startDateTime.hashCode());
    result = 31 * result + (this.endDateTime == null ? 0: this.endDateTime.hashCode());
    result = 31 * result + (this.numberOfPassangers == null ? 0: this.numberOfPassangers.hashCode());
    result = 31 * result + (this.type == null ? 0: this.type.hashCode());
    result = 31 * result + (this.user == null ? 0: this.user.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketPurchase {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  code: ").append(code).append("\n");
    sb.append("  price: ").append(price).append("\n");
    sb.append("  startDateTime: ").append(startDateTime).append("\n");
    sb.append("  endDateTime: ").append(endDateTime).append("\n");
    sb.append("  numberOfPassangers: ").append(numberOfPassangers).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  user: ").append(user).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
