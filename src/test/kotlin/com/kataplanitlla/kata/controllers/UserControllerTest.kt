package com.kataplanitlla.kata.controllers

import CommonTests
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class UserControllerTest : CommonTests() {

    @Test
    fun getTestUnit5() {
        val name = "david"
        val age = 30
        val url = "/user/testUnit5/$name?age=$age"

        val result = mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn()
        // val resultActual = ObjectMapper().readValue<Object>(result.response.contentAsString)
        assertThat("Hello World david, by 30").isEqualTo(result.response.contentAsString)
    }
}
