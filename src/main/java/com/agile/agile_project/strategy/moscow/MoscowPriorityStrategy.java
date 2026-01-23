package com.agile.agile_project.strategy.moscow;

import com.agile.agile_project.model.UserStory;

public interface MoscowPriorityStrategy {
    void apply(UserStory userStory);
}
