package com.agile.agile_project.strategy.moscow;

import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.MoscowPriority;
import org.springframework.stereotype.Component;

@Component("COULD")
public class CouldPriorityStrategy implements MoscowPriorityStrategy {
    @Override
    public void apply(UserStory userStory) {
        userStory.setMoscowPriority(MoscowPriority.COULD);
        userStory.setPriority(3);
    }
}
