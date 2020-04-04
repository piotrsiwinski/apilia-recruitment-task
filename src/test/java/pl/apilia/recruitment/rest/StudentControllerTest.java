package pl.apilia.recruitment.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.apilia.recruitment.model.Student;
import pl.apilia.recruitment.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class StudentControllerTest {

  @Autowired
  private StudentController studentController;

  @MockBean
  private StudentRepository repository;
  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
  }


  @Test
  public void shouldListAllStudents() throws Exception {
    // Arrange
    Student testUAM = new Student();
    testUAM.setId(1L);
    testUAM.setName("some-test-student");

    Student studentPP = new Student();
    studentPP.setId(2L);
    studentPP.setName("some-pp-student");

    List<Student> studentsList = new ArrayList<>();
    studentsList.add(testUAM);
    studentsList.add(studentPP);
    given(this.repository.findAll()).willReturn(studentsList);


    // Act
    this.mockMvc.perform(get("/api/student"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.[0].id").value(1))
        .andExpect(jsonPath("$.[0].name").value("some-test-student"))
        .andExpect(jsonPath("$.[1].id").value(2))
        .andExpect(jsonPath("$.[1].name").value("some-pp-student"));

  }










}