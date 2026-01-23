package com.agile.agile_project.observer;

import com.agile.agile_project.event.UserStoryStatusChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserStoryStatusObserver {

    @EventListener
    public void onStatusChanged(UserStoryStatusChangedEvent event) {
        System.out.println(
                "📢 UserStory " + event.getUserStoryId()
                        + " changed status to " + event.getNewStatus()
        );
    }
}
