package ua.com.alevel.db;

import ua.com.alevel.entity.Builders;
import ua.com.alevel.entity.Group;

public class GroupBd {

    private Group[] groups = new Group[10];

    public void creatTeam(Builders[] builds, String groupName) {
        Group newGroup = new Group(groupName,builds);
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] == null) {
                groups[i] = newGroup;
                break;
            }
        }
    }

    public Group[] lockAllBuildersInTeam() { return groups; }

    public void deleteTeam(String deleteGroup) {
        for(int i = 0; i < groups.length; i++){
            if(deleteGroup == groups[i].getNameGroup()){
                groups[i] = null;
                break;
            }
        }
    }
}
