package com.simbirsoft.belousov.servuce;

import com.simbirsoft.belousov.ProjectManagerApplication;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

//@RunWith(SpringRunner.class)
@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.MOCK,   //надо перепроверить, в доках по другому
        classes = ProjectManagerApplication.class)
//@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")

public class TaskServiceTest {
//    @Autowired
//    private MockMvc mvc;

    @Autowired
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;
    private UserRepository userRepository;

    @BeforeEach
    void prepare() {

    }

    @Test
    void aVoid() {
        Assertions.assertTrue(true);
    }

}
