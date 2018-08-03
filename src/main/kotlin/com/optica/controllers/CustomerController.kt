package com.optica.controllers

import javax.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

import com.optica.dto.CustomerDto

@Controller
class CustomerController {

    internal var logger = LoggerFactory.getLogger(CustomerController::class.java!!)

    @GetMapping("/customer")
    fun index(customerDto: CustomerDto, model: Model): String {
        return VIEW_CUSTOMER
    }

    @PostMapping("/customer/add")
    fun addCustomer(@Valid customerDto: CustomerDto, errors: BindingResult, model: Model): String {

        if (errors.hasErrors()) {
            logger.error(errors.allErrors.toString())

        }
        return VIEW_CUSTOMER
    }

    @GetMapping("/customer/find/{document}")
    fun findCustomer(@PathVariable document: String, model: Model): String {

        return VIEW_CUSTOMER
    }

    companion object {

        private val VIEW_CUSTOMER = "customer"

        private val CUSTOMER = "customer"
    }
}
