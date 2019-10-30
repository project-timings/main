package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.personutil.TypicalPersonDescriptor.ALICE;
import static seedu.address.testutil.personutil.TypicalPersonDescriptor.ZACK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ModelManager;
import seedu.address.model.group.exceptions.DuplicateGroupException;
import seedu.address.model.mapping.exceptions.DuplicateMappingException;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.testutil.modelutil.TypicalModel;



class DeletePersonCommandTest {

    private ModelManager model;

    @BeforeEach
    void init() throws DuplicateMappingException, DuplicatePersonException, DuplicateGroupException {
        model = TypicalModel.generateTypicalModel();
    }

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DeletePersonCommand(null));
    }

    @Test
    void execute_success() throws CommandException {

        CommandResult actualCommandResult =
                new DeletePersonCommand(ALICE.getName()).execute(model);

        CommandResult expectedCommandResult =
                new CommandResult(String.format(DeletePersonCommand.MESSAGE_SUCCESS, ALICE.getName().toString()));

        assertTrue(actualCommandResult.equals(expectedCommandResult));
    }

    @Test
    void execute_failure() throws CommandException {

        CommandResult actualCommandResult =
                new DeletePersonCommand(ZACK.getName()).execute(model);

        CommandResult expectedCommandResult =
                new CommandResult(String.format(DeletePersonCommand.MESSAGE_FAILURE,
                        DeletePersonCommand.MESSAGE_PERSON_NOT_FOUND));

        assertTrue(actualCommandResult.equals(expectedCommandResult));
    }
}
