package com.bootcamp.linkTracker.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Link {
     private Long linkId;
     private String url;
     private Long visitas;
     private String password;
     private Boolean active;
     public Link(long linkId, String url, String password){
          this.visitas = 0L;
          this.url = url;
          this.linkId = linkId;
          this.password = password;
          this.active = true;
     }
     public long agregarVisita(){
          return ++this.visitas;
     }
     public boolean validate(){
          if(url.contains("http://")){
               return true;
          }
          return false;
     }


}
