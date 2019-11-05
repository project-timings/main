package seedu.address.model.group;

import seedu.address.model.mapping.Role;

/**
 * A group.
 */
public class Group {
    private static Integer counter = 0;
    private final GroupId groupId;

    private GroupName groupName;
    private GroupDescription groupDescription;
    private Role userRole;

    public Group(GroupDescriptor groupDescriptor) {
        this.groupName = groupDescriptor.getGroupName();
        this.groupDescription = groupDescriptor.getGroupDescription();
        this.userRole = groupDescriptor.getUserRole();
        this.groupId = new GroupId(counter);
        counter += 1;
    }

    public Group(GroupId groupId,
                 GroupName groupName,
                 GroupDescription groupDescription,
                 Role userRole) {

        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.userRole = userRole;
    }

    public static void setCounter(int i) {
        counter = i;
    }

    /**
     * Reset counter for testing purposes.
     */
    public static void counterReset() {
        counter = 0;
    }

    /**
     * Converts to String.
     *
     * @return String
     */
    public String toString() {
        String output = "";
        output += "(" + groupId.toString() + ") ";
        output += groupName.toString();
        return output;
    }

    /**
     * Prints out all details of the group.
     *
     * @return String
     */
    public String details() {
        String output = "";
        output += this.toString() + "\n";
        return output;
    }

    /**
     * Checks if other group has the same details.
     *
     * @param other group to be compared
     * @return boolean
     */
    public boolean isSameGroup(Group other) {
        if (other == null) {
            return false;
        } else if (!other.getGroupName().equals(this.groupName)) {
            return false;
        } else if (!other.getGroupDescription().equals(this.groupDescription)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if other group is same as this group.
     *
     * @param other group to be compared
     * @return boolean
     */
    public boolean equals(Group other) {
        if (other == null) {
            return false;
        } else if (!other.getGroupId().equals(this.groupId)) {
            return false;
        } else if (!this.isSameGroup(other)) {
            return false;
        } else {
            return true;
        }
    }

    public GroupName getGroupName() {
        return this.groupName;
    }

    public void setGroupName(GroupName groupName) {
        this.groupName = groupName;
    }

    public GroupDescription getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(GroupDescription groupDescription) {
        this.groupDescription = groupDescription;
    }

    public GroupId getGroupId() {
        return this.groupId;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
}
