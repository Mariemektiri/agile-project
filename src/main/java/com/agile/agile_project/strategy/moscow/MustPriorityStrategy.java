package com.agile.agile_project.strategy.moscow;

import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.MoscowPriority;
import org.springframework.stereotype.Component;

@Component("MUST")
public class MustPriorityStrategy implements MoscowPriorityStrategy {

    @Override
    public void apply(UserStory userStory) {
        userStory.setMoscowPriority(MoscowPriority.MUST);
        userStory.setPriority(1);
    }
}
