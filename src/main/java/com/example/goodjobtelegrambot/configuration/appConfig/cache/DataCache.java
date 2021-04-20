package com.example.goodjobtelegrambot.configuration.appConfig.cache;

import com.example.goodjobtelegrambot.configuration.appConfig.BotState;
import com.example.goodjobtelegrambot.model.TeamMember;

public interface DataCache {

    void setUsersCurrentBotState(long userId, BotState botState);

    BotState getUsersCurrentBotState(long userId);

    TeamMember getTeamMemberData(int teamMemberId);

    void saveTeamMemberData(int teamMemberId, TeamMember teamMember);
}
