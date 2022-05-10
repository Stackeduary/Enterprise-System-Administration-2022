package com.adilsdeals.employee;

import com.adilsdeals.employee.dto.EmployeeCreateDto;
import com.adilsdeals.employee.dto.EmployeeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EmployeeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @Sql({"classpath:db/data.sql"})
    void createEmployee() {
        EmployeeCreateDto employee = new EmployeeCreateDto(
                "testname", "password", "password", "Test"
        );
        ResponseEntity<EmployeeDto> responseEntity = this.restTemplate
                .postForEntity("http://localhost:" + port + "/employee/create", employee, EmployeeDto.class);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(employee.getUsername(), responseEntity.getBody().getUsername());
        assertEquals(employee.getName(), responseEntity.getBody().getName());
    }

    @WithMockUser(value = "test", password = "password")
    @Test
    @Sql({"classpath:db/data.sql"})
    void delete() throws Exception {
        ResponseEntity<?> responseEntity = this.restTemplate
                .exchange("http://localhost:" + port + "/employee/delete/1",
                        HttpMethod.DELETE,
                        HttpEntity.EMPTY, ResponseEntity.class);
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }

    @Test
    @Sql({"classpath:db/data.sql"})
    void update() {
        EmployeeDto employee = new EmployeeDto(1, "NewTest", "newtest");
        ResponseEntity<EmployeeDto> responseEntity = this.restTemplate

                .exchange("http://localhost:" + port + "/employee/update/1",
                        HttpMethod.PUT,
                        new HttpEntity<>(employee), EmployeeDto.class );
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}