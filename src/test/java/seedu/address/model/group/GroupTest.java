package seedu.address.model.group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupTest {

    private Group group;

    @BeforeEach
    void init() {
        GroupDescriptor groupDescriptor = new GroupDescriptor(new GroupName("name"), new GroupRemark("remark"));
        group = new Group(groupDescriptor);
    }

    @Test
    void getGroupRemark() {
        assertEquals("remark", group.getGroupRemark().toString());
        assertNotEquals("Remark", group.getGroupRemark().toString());
    }

    @Test
    void getGroupName() {
        assertEquals("name", group.getGroupName().toString());
        assertNotEquals("Name", group.getGroupName().toString());
    }

    @Test
    void getGroupId() {
        assertNotNull(group.getGroupId());
    }
}
