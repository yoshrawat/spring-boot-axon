/* (C)2020 */
package com.yogesh.axon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateDTO {
    private double startingBalance;
    private String currency;
}
