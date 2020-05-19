package com.option.user.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: LJJ
 * @Program: option-parent
 * @Description:
 * @Create: 2020-03-17 16:15:15
 * @Modified By:
 */
@Data
@ToString
public class User implements Serializable {
        private Long id;
        private String username;
        private String password;

        public User(Long id, String username, String password){
            this.id = id;
            this.username = username;
            this.password = password;
        }
}
