package com.agile.agile_project.observer;

import com.agile.agile_project.event.UserStoryStatusChangedEvent;
import com.agile.agile_project.model.enums.UserStoryStatus;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SprintObserver {

    @EventListener
    public void updateSprint(UserStoryStatusChangedEvent event) {
        if (event.getNewStatus() == UserStoryStatus.DONE) {
            System.out.println("Sprint progress updated");
        }
    }
}
