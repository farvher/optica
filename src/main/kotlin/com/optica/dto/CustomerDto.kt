package com.optica.dto

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.Email

class CustomerDto {

    @Email
    var name: String? = null

    @NotNull
    @Max(value = 18)
    @Min(15)
    var age: Int? = null


}
