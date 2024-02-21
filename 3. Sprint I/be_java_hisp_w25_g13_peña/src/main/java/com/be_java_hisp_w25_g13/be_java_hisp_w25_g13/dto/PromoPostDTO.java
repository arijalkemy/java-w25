package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PromoPostDTO extends PostDTO {
  private Double discount;
  private Boolean hasPromo;
}
