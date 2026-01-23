package com.agile.agile_project.service;

import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.UserStoryStatus;
import com.agile.agile_project.repository.UserStoryRepository;
import com.agile.agile_project.service.Impl.UserStoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserStoryServiceTest {

    @Mock
    private UserStoryRepository userStoryRepository;

    @InjectMocks
    private UserStoryServiceImpl userStoryService;

    @Test
    void shouldChangeUserStoryStatus() {
        // GIVEN
        UserStory us = new UserStory();
        us.setId(1L);
        us.setStatus(UserStoryStatus.TODO);

        Mockito.when(userStoryRepository.findById(1L))
                .thenReturn(Optional.of(us));

        // WHEN
        UserStory result =
                userStoryService.changeStatus(1L, UserStoryStatus.DONE);

        // THEN
        assertEquals(UserStoryStatus.DONE, result.getStatus());
        Mockito.verify(userStoryRepository).save(us);
    }
}
