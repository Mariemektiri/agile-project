package com.agile.agile_project.strategy.moscow;

import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.MoscowPriority;
import org.springframework.stereotype.Component;


    @Component("SHOULD")
    public class ShouldPriorityStrategy implements MoscowPriorityStrategy {
        @Override
        public void apply(UserStory userStory) {
            userStory.setMoscowPriority(MoscowPriority.SHOULD);
            userStory.setPriority(2);
        }
    }


