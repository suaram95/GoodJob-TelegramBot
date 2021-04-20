package com.example.goodjobtelegrambot.configuration.appConfig.cache;

import com.example.goodjobtelegrambot.configuration.appConfig.BotState;
import com.example.goodjobtelegrambot.model.TeamMember;

import java.util.HashMap;
import java.util.Map;

public class UserDataCache implements DataCache {

    private Map<Long, BotState> usersBotState=new HashMap<>();
    private Map<Integer, TeamMember> teamMemberData=new HashMap<>();

    @Override
    public void setUsersCurrentBotState(long userId, BotState botState) {
        usersBotState.put(userId, botState);
    }

    @Override
    public BotState getUsersCurrentBotState(long userId) {
        BotState botState = usersBotState.get(userId);
        if (botState==null){
            botState=BotState.SEND_GOOD_JOB;
        }
        return botState;
    }

    @Override
    public TeamMember getTeamMemberData(int teamMemberId) {
        TeamMember teamMember = teamMemberData.get(teamMemberId);
        if (teamMember==null){
            teamMember=new TeamMember();
        }
        return teamMember;
    }

    @Override
    public void saveTeamMemberData(int teamMemberId, TeamMember teamMember) {
        teamMemberData.put(teamMemberId, teamMember);
    }
}
